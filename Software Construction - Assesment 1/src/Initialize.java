import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Initialize {
    //private List<Product> products;
    private List<Location> locations;
    private Scanner scanner;

    Pro q = new Pro();
    public Initialize() {
        //products = new ArrayList<>();
        locations = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void options() {
        System.out.println("Select a config option:");
        System.out.println("1. Add new Products");
        System.out.println("2. Create new Location");

        int configOption = scanner.nextInt();
        scanner.nextLine();

        switch (configOption) {
            case 1:
                q.addNewProduct();
                break;
            case 2:
                createNewLocation();
                break;
            default:
                System.out.println("Invalid config option.");
        }
    }

    public void createNewLocation()
    {
        System.out.println("Enter a name for the new location: ");
        String option2 = scanner.nextLine();
        locations.add(new Location(option2));

    }


    private Product findProductByBarcode(String barcode) {
        //Pro p = new Pro();
        for (Product product : q.getProducts()) {
            if (product.getBarcode().equals(barcode)) {
                //System.out.println("Found");
                return product;
            }
        }
        System.out.println("Product does not exist. Add new product under options first");
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

    public String printLocations()
    {
        return "";
    }


    public void listInventory() {

        scanner.nextLine();
        System.out.println("Select your desired location.");
        for (Location location : locations) {
            System.out.println(location.getLocation());
        }

        String option = scanner.nextLine();
        Location loc = this.findLocationByName(option);
        System.out.println(loc.toString());

    }

    public void addItemsToInventory() {
        System.out.println("Select your desired location.");
        for (Location location : locations) {
            System.out.println(location.getLocation());
        }
        String loc = scanner.nextLine();

        System.out.println("Type Barcode");
        String barcode = scanner.nextLine();
        Product p = findProductByBarcode(barcode);

        if (p != null) {
            int existingIndex = findExistingProductIndex(loc, p);

            if (existingIndex != -1) {
                System.out.println("Enter Quantity to add:");
                int quantityToAdd = scanner.nextInt();
                findLocationByName(loc).getInv().updateQuantity(existingIndex, quantityToAdd, '+');
            } else {
                findLocationByName(loc).getInv().addProduct(p);
            }
        }
    }

    public void removeItemsFromInventory() {
        System.out.println("Select your desired location.");
        for (Location location : locations) {
            System.out.println(location.getLocation());
        }
        String loc = scanner.nextLine();

        System.out.println("Type Barcode");
        String barcode = scanner.nextLine();
        Product p = findProductByBarcode(barcode);

        int existingIndex = findExistingProductIndex(loc, p);

        if (existingIndex != -1) {
            System.out.println("Enter Quantity to remove:");
            int quantityToRemove = scanner.nextInt();
            findLocationByName(loc).getInv().updateQuantity(existingIndex, quantityToRemove, '-');
        } else {
            //findLocationByName(loc).getInv().addProduct(p);
        }
    }

    private int findExistingProductIndex(String location, Product product) {
        Location loc = findLocationByName(location);
        if (loc != null) {
            Inventory inv = loc.getInv();
            for (int i = 0; i < inv.getPq().size(); i++) {
                if (inv.getPq().get(i).getProduct().getBarcode().equals(product.getBarcode())) {
                    return i;
                }
            }
        }
        return -1;
    }












}
