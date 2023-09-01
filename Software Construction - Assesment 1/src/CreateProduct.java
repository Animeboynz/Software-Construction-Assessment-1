import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class CreateProduct
{
    public List<Product> productslist = new ArrayList<>();

    Scanner scanner = new Scanner(System.in);

    public abstract void addNewProduct(Product newProduct);

    public abstract List<Product> getProducts();

    public String toString()
    {
        return productslist.toString();
    }

    public void saveMasterProductsList() {
        try {
            PrintWriter writer = new PrintWriter(new FileWriter(StringResources.FILE_PATH_1));
            writer.println("Barcode, Name, Price");
            for (Product product : getProducts()) {
                writer.println(product.getBarcode() + "," + product.getName() + "," + product.getPrice());
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadMasterProductsList() {
        List<Product> productList = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(new FileReader(StringResources.FILE_PATH_1));
            scanner.nextLine();
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



