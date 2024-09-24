import Order from "./order";
import OrderItem from "./order_item";

describe("Order unit tests", () => {
  it("Should throw error when id is empty", () => {
    expect(() => {
      let order = new Order("", "1212", []);
      console.log(order);
    }).toThrow("Id is required");
  });

  it("Should throw error when id is empty", () => {
    expect(() => {
      let order = new Order("123", "1212", []);
      console.log(order);
    }).toThrow("Item qtd must be greater zero");
  });

  it("Should calculate total", () => {
    const item = new OrderItem("11", "item 1", 1000, "p1", 2);
    const order = new Order("c1", "c1", [item]);
    const total = order.total();
    expect(total).toBe(2000);
  });

  it("Should calculate total", () => {
    const item = new OrderItem("11", "item 1", 100, "p1", 2);
    const item2 = new OrderItem("12", "item 2", 200, "p2", 2);

    const order2 = new Order("c1", "c1", [item, item2]);
    const total = order2.total();
    expect(total).toBe(600);
  });

  it("Should throw error if the item qte is less or equal zero", () => {
    expect(() => {
      const item = new OrderItem("11", "item 1", 100, "p1", 0);
      const order2 = new Order("c1", "c1", [item]);
      
    }).toThrow("Quantity must be greater than 0");
  });
});
