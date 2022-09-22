package application;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Program {
	public static void main(String[] args) throws ParseException {
		Scanner scanner = new Scanner(System.in);

		List<Product> list = new ArrayList<>();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

		System.out.print("Enter the number of products: ");
		int n = scanner.nextInt();

		for (int i = 0; i < n; i++) {
			scanner.nextLine();
			System.out.println("Product data:");
			System.out.print("Common, used or imported product? (c/u/i) ");
			char answer = scanner.next().charAt(0);
			scanner.nextLine();

			if (answer == 'c') {
				System.out.print("Name: ");
				String name = scanner.nextLine();

				System.out.print("Price: ");
				double price = scanner.nextDouble();

				Product product = new Product(name, price);
				list.add(product);
			}
			else if (answer == 'u') {
				System.out.print("Name: ");
				String name = scanner.nextLine();

				System.out.print("Price: ");
				double price = scanner.nextDouble();

				System.out.print("Manufacture date (dd/mm/yyyy): ");
				Date manufactureDate = simpleDateFormat.parse(scanner.next());

				Product product = new UsedProduct(name, price, manufactureDate);
				list.add(product);
			}
			else {
				System.out.print("Name: ");
				String name = scanner.nextLine();

				System.out.print("Price: ");
				double price = scanner.nextDouble();
				scanner.nextLine();

				System.out.print("Custom fee: ");
				double customFee = scanner.nextDouble();

				Product product = new ImportedProduct(name, price, customFee);
				list.add(product);
			}
		}

		System.out.println("Price tags:");

		for (Product product : list) {
			System.out.println(product.priceTag());
		}

		scanner.close();
	}
}
