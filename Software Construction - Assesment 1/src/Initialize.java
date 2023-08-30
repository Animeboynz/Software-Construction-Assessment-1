import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
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
        q.loadProductsFromFile();
        loadProductsFromFile();
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
        int result = createNewSilentLocation(option2);
        if (result == 1)
        {
            System.out.println("A Location with the same name already exists.");
        }
    }

    public int createNewSilentLocation(String newLocationName)
    {
        if (findLocationByName(newLocationName) == null)
        {
            locations.add(new Location(newLocationName));
            return 0;
        }
        return 1;
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
            int removeStatus = findLocationByName(loc).getInv().updateQuantity(existingIndex, quantityToRemove, '-');
            if (removeStatus == 0)
            {
                System.out.println("Removed Items from Inventory Successfully");
            }
            if (removeStatus == 1)
            {
                System.out.println("Error! Check if you are removing more than what exists in the inventory");
            }
        } else {
            System.out.println("That product does not exist in this inventory");
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

    public void saveandexit()
    {
        String FILE_PATH = "save.csv";
        q.saveProductsToFile();
        //System.out.println("Saving to File");


        try {
            PrintWriter writer = new PrintWriter(new FileWriter(FILE_PATH));
            System.out.println("Made it Here");

            for (int i = 0; i < locations.size(); i++) {
                System.out.println("Writing Name of Location");

                // Check if the inner list has elements before accessing them
                if (!locations.get(i).getInv().getPq().isEmpty()) {
                    for (int j = 0; j < locations.get(i).getInv().getPq().size(); j++) {
                        String writeToFile = locations.get(i).getLocation() + ","
                                + locations.get(i).getInv().getPq().get(j).getQuantity() + ","
                                + locations.get(i).getInv().getPq().get(j).getProduct().getBarcode() + ","
                                + locations.get(i).getInv().getPq().get(j).getProduct().getName() + ","
                                + locations.get(i).getInv().getPq().get(j).getProduct().getPrice();

                        writer.println(writeToFile);
                        System.out.println(writeToFile);
                    }
                }else {
                    String writeToFile = locations.get(i).getLocation() + ",NULL,NULL,NULL,NULL";
                    writer.println(writeToFile);
                    System.out.println(writeToFile);
                }
            }

            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        /*
        locations.get(0).getLocation();//Location Name
        locations.get(0).getInv().getPq().get(0).getQuantity();//Quantity of Certain Product
        locations.get(0).getInv().getPq().get(0).getProduct().getBarcode();
        locations.get(0).getInv().getPq().get(0).getProduct().getName();
        locations.get(0).getInv().getPq().get(0).getProduct().getPrice();
         */
    }



    public void loadProductsFromFile() {
        String FILE_PATH = "save.csv";
        List<Product> productList = new ArrayList<>();

        try (Scanner scanner = new Scanner(new FileReader(FILE_PATH))) {
            while (scanner.hasNextLine()) {
                String[] parts = scanner.nextLine().split(",");
                if (parts.length == 5) {
                    String location = parts[0];
                    //int quantity = Integer.parseInt(parts[1]);
                    String barcode = parts[2];
                    String name = parts[3];
                    //double price = Double.parseDouble(parts[4]);
                    //productList.add(new Product(barcode, name, price));
                    createNewSilentLocation(location);
                    if (!barcode.equals("NULL"))
                    {
                        findLocationByName(location).getInv().addSilentProduct(new Product(barcode, name, Double.parseDouble(parts[4])), Integer.parseInt(parts[1]));
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        //productslist.addAll(productList);
    }







}
