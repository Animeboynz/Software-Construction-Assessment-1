import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Initialize
{
    private List<Product> products;
    private List<Location> locations;
    private Scanner scanner;

    public Initialize() {
        products = new ArrayList<>();
        locations = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void options() {
        System.out.println("Select a config option:");
        System.out.println("1. Add new Products");
        System.out.println("2. Create new Location");
        int configOption = scanner.nextInt();

        switch (configOption) {
            case 1:
                //CreateProduct.addNewProduct();
                break;
            case 2:
                //createNewLocation();
                break;
            default:
                System.out.println("Invalid config option.");
        }
    }

    private Product findProductByBarcode(String barcode) {
        for (Product product : products) {
            if (product.getBarcode().equals(barcode)) {
                return product;
            }
        }
        return null;
    }

    private Location findLocationByName(String name) {
        for (Location location : locations) {
            if (location.getLocation().equals(name)) {
                return location;
            }
        }
        return null;
    }











}
