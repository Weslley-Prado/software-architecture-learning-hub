import Order from "../../../../domain/checkout/entity/order";
import OrderItemModel from "./order-item.model";
import OrderModel from "./order.model";
import OrderItem from "../../../../domain/checkout/entity/order_item";
import OrderRepositoryInterface from "../../../../domain/checkout/repository/order-repository.interface";

export default class OrderRepository implements OrderRepositoryInterface {

  async create(order: Order): Promise<void> {
    const orderData = await OrderModel.create({
      id: order.id,
      customer_id: order.customerId,
      total: order.items.reduce((acc, item) => acc + item.price * item.quantity, 0), // cálculo correto do total
      items: order.items.map(item => ({
        id: item.id,
        product_id: item.productId,
        name: item.name,
        price: item.price,
        quantity: item.quantity,
        total: item.price * item.quantity // garantir que o total do item esteja correto
      }))
    }, {
      include: ["items"]
    });
  }
  

  async update(entity: Order): Promise<void> {
    await OrderModel.update(
      {
        customer_id: entity.customerId,
        total: entity.total(),
      },
      {
        where: { id: entity.id },
      }
    );

    // Atualiza os itens associados ao pedido
    await OrderItemModel.destroy({ where: { order_id: entity.id } });
    await OrderItemModel.bulkCreate(
      entity.items.map((item) => ({
        id: item.id,
        name: item.name,
        price: item.price,
        product_id: item.productId,
        quantity: item.quantity,
        order_id: entity.id,
      }))
    );
  }

  async find(id: string): Promise<Order | null> {
    const orderData = await OrderModel.findOne({
      where: { id },
      include: ["items"],
    });
  
    if (!orderData) {
      return null;
    }
  
    // Mapeando para instâncias de OrderItem
    const items = orderData.items.map((item: any) => 
      new OrderItem(item.id, item.product_id, item.name, item.price, item.quantity)
    );
  
    return new Order(orderData.id, orderData.customer_id, items);
  }
  
  async findAll(): Promise<Order[]> {
    const ordersData = await OrderModel.findAll({
      include: ["items"],
    });
  
    return ordersData.map((orderData) => {
      // Mapeando para instâncias de OrderItem
      const items = orderData.items.map((item: any) =>
        new OrderItem(item.id, item.product_id, item.name, item.price, item.quantity)
      );
  
      return new Order(orderData.id, orderData.customer_id, items);
    });
  }
  

  async delete(id: string): Promise<void> {
    await OrderModel.destroy({ where: { id } });
  }
}
