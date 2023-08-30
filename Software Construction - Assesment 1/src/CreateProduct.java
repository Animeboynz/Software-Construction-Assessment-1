import java.io.FileWriter;
import java.io.*;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class CreateProduct
{
    //Enter product barcode
    //Enter name

    public List<Product> productslist = new ArrayList<>();
    //public CreateProduct = new

    private static final String FILE_PATH = "products.csv";

    /*
    CreateProduct()
    {
        productslist = new ArrayList<>();
    }*/

    Scanner scanner = new Scanner(System.in);


    public abstract void addNewProduct();



    public abstract List<Product> getProducts();


    public List<Product> getProductslist() {
        return productslist;
    }

    public String toString()
    {
        return productslist.toString();
    }

    public void saveProductsToFile() {
        try {
            PrintWriter writer = new PrintWriter(new FileWriter(FILE_PATH));
            //System.out.println("Made it Here");
            for (Product product : getProducts()) {
                writer.println(product.getBarcode() + "," + product.getName() + "," + product.getPrice());
                //System.out.println("Saving 1");
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadProductsFromFile() {
        List<Product> productList = new ArrayList<>();
        try (Scanner scanner = new Scanner(new FileReader(FILE_PATH))) {
            while (scanner.hasNextLine()) {
                String[] parts = scanner.nextLine().split(",");
                if (parts.length == 3) {
                    String barcode = parts[0];
                    String name = parts[1];
                    double price = Double.parseDouble(parts[2]);
                    productList.add(new Product(barcode, name, price));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        productslist.addAll(productList);
    }


}



