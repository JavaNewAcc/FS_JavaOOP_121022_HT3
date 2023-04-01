package video.practice;

public class Main {

	public static void main(String[] args) {
		Product product1 = new Product("Телефон Samsung", 100, 1);
		Product product2 = new Product("Телефон iPhone", 200, 2);
		Product product3 = new Product("Телефон Sony", 90, 3);
		Product product4 = new Product("Ноутбук Asus", 1500, 4);
		Product product5 = new Product("Ноутбук Dell", 2000, 5);
		Product product6 = new Product("Ноутбук Acer", 12000, 6);
		Product product7 = new Product("Телевізор Samsung", 10000, 7);

		Order order1 = new Order();

		order1.addProduct(product1);
		order1.addProduct(product2);
		order1.addProduct(product3);
		order1.addProduct(product4);
		order1.addProduct(product5);
		order1.addProduct(product6);
		order1.addProduct(product7);
		System.out.println(order1);

		try {
			System.out.println(order1.searchProductById(6));
		} catch (ProductNotFoundException e) {
			e.printStackTrace();
		}

		System.out.println(order1.removeProductById(7));

		System.out.println(order1);
	}
}