import Product from "../entity/product";
import ProductService from "./product.serivce";

describe("Product service unit tests", () =>{
    it("should change the prices of all products", () => {
        const productOne = new Product("productOne", "Product 1",10);
        const productTwo = new Product("productTwo", "Product 2",20);
        const products = [productOne, productTwo];
        ProductService.increasePrice(products, 100);

        expect(productOne.price).toBe(20);
        expect(productTwo.price).toBe(40);
    });
})