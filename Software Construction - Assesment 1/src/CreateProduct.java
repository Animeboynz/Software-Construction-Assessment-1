/*
Group Number: 90
Group Members: Maahir Hussain Shaik(ID: 21154501)
               Roshan Varughese(ID: 21137055)
Class Name: Main
Class Function:
The class declares two abstract methods:
 It includes methods for saving and loading product data from a file
addNewProduct(Product newProduct): Subclasses must implement this method to add a new product to the list.
getProducts(): Subclasses must implement this method to retrieve the list of products.
Other Methods:
saveMasterProductsList(): Saves the list of products to a file specified by StringResources.FILE_PATH_1. It writes the products' barcode, name, and price to the file.
loadMasterProductsList(): Loads the list of products from the same file, parsing the barcode, name, and price information. It skips the file's header and adds the products to the productslist.

*/

// Import necessary libraries
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Create an abstract class named CreateProduct
public abstract class CreateProduct
{
    // Create a list to store products
    public List<Product> productslist = new ArrayList<>();

    // Create a scanner object to read user input
    Scanner scanner = new Scanner(System.in);

    // Abstract method to add a new product
    public abstract void addNewProduct(Product newProduct);

    // Abstract method to get the list of products
    public abstract List<Product> getProducts();

    // Override the toString() method to return a string representation of the product list
    public String toString()
    {
        return productslist.toString();
    }

    // Method to save the list of products to a file
    public void saveMasterProductsList() {
        try {
            // Create a PrintWriter to write to a file
            PrintWriter writer = new PrintWriter(new FileWriter(StringResources.FILE_PATH_1));

            // Write header
            writer.println("Barcode, Name, Price");

            // Iterate through products and write them to the file
            for (Product product : getProducts()) {
                writer.println(product.getBarcode() + "," + product.getName() + "," + product.getPrice());
            }

            // Close the writer
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method to load the list of products from a file
    public void loadMasterProductsList() {
        List<Product> productList = new ArrayList<>();
        try {
            // Create a scanner to read from the file
            Scanner scanner = new Scanner(new FileReader(StringResources.FILE_PATH_1));

            // Skip the header line
            scanner.nextLine();

            // Read and parse product information from the file
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

        // Add the loaded products to the productslist
        productslist.addAll(productList);
    }
}
