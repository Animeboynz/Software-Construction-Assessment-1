import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CreateProduct
{
    //Enter product barcode
    //Enter name

    private List<Product> productslist;


    CreateProduct()
    {
        productslist = new ArrayList<>();
    }

    Scanner scanner = new Scanner(System.in);

    public void addNewProduct(Product p)
    {
        System.out.print("Enter product barcode: ");
        String barcode = scanner.next();
        System.out.print("Enter product name: ");
        String name = scanner.next();
        System.out.print("Enter product price: ");
        double price = Double.parseDouble(scanner.next());

        Product newProduct = new Product(barcode, name, price);
        productslist.add(newProduct);

        System.out.println("Product added successfully.");
    }

    public String toString()
    {
        return productslist.toString();
    }
}



