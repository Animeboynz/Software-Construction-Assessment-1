/*
Group Number: 90
Group Members: Maahir Hussain Shaik(ID: 21154501)
               Roshan Varughese(ID: 21137055)
Class Name: Initialize
Class Function:
The addNewProduct method allows users to add new products to the system. It collects information like barcode, name, and price, and checks for duplicates.
The createNewLocation method enables users to create new stock locations.
The program supports listing inventory for a selected location (listInventory) and adding items to inventory (addItemsToInventory).
Items can be added silently using the addItemsToInventorySilent method.
Users can move stock items from one location to another (moveStockLocation).
Stock movement is logged.
The program allows users to save all data, including products, inventory, and logs, and exit the program (saveAndExit).
Data is saved to files and loaded from files for persistence between program runs (saveProductsAndInventories and loadProductsAndInventories).


*/

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Initialize {
    private List<Location> locations; // List to store locations
    private Scanner scanner; // Scanner for user input
    Pro productManagement = new Pro(); // Pro class instance for product management
    Log log = new Log(); // Log class instance for logging operations

    // Constructor to initialize locations and scanner
    public Initialize() {
        locations = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    // Displays options for stock management
    public void options() {
        System.out.println("Select a config option:");
        System.out.println("1. Add new Products");
        System.out.println("2. Create new Location");

        int configOption = scanner.nextInt();
        scanner.nextLine();

        switch (configOption) {
            case 1:
                addNewProduct();
                break;
            case 2:
                createNewLocation();
                break;
            default:
                System.out.println(StringResources.INVALID_USER_OPTION_SELECT_NR);
        }
    }

    // Allows adding a new product
    public void addNewProduct() {
        System.out.print(StringResources.TYPE_BARCODE);
        String barcode = scanner.next();

        if (!productManagement.doesProductExist(barcode)) {
            System.out.print(StringResources.PROMPT_PRODUCT_NAME);
            scanner.nextLine(); // Consume the newline left from previous input
            String name = scanner.nextLine(); // Read the entire line, including spaces
            System.out.print(StringResources.PROMPT_PRODUCT_PRICE);

            double price = 0;
            try {
                price = Double.parseDouble(scanner.next());
                scanner.nextLine();
                productManagement.addNewProduct(new Product(barcode, name, price));
                log.logData("Created New Product \"" + name + "\"(" + barcode + ") with price $" + price);
                System.out.println(StringResources.PRODUCT_ADD_SUCCESS);
            } catch (Exception e) {
                System.out.println(StringResources.INVALID_USER_INPUT_FLOAT);

            }
        } else {
            System.out.println(StringResources.PRODUCT_BARCODE_EXISTS);
        }
    }

    // Allows creating a new location
    public void createNewLocation() {
        System.out.println(StringResources.LOCATION_NEW_NAME);
        String option2 = scanner.nextLine();
        int result = createNewSilentLocation(option2);
        if (result == 1) {
            System.out.println(StringResources.LOCATION_EXISTS);
        }
        else {
            log.logData("Created New Location \"" + option2 + "\"");
        }
    }

    // Creates a new location (silent version, without logging)
    public int createNewSilentLocation(String newLocationName) {
        if (findLocationByName(newLocationName) == null) {
            locations.add(new Location(newLocationName));
            return 0;
        }
        return 1;
    }

    //Start of Partially ChatGPT Generated Code
    // Finds a product by its barcode
    private Product findProductByBarcode(String barcode) {
        for (Product product : productManagement.getProducts()) {
            if (product.getBarcode().equals(barcode)) {
                return product;
            }
        }
        System.out.println(StringResources.PRODUCT_BARCODE_INVALID);
        return null;
    }

    // Finds a location by its name
    private Location findLocationByName(String name) {
        for (Location location : locations) {
            if (location.getLocation().equalsIgnoreCase(name)) {
                return location;
            }
        }
        return null;
    }
    //End of Partially ChatGPT Generated Code

    // Lists inventory for a selected location
    public void listInventory() {
        System.out.println(StringResources.LOCATION_SELECT);
        for (Location location : locations) {
            System.out.println(location.getLocation());
        }

        String option = scanner.nextLine();
        Location loc = this.findLocationByName(option);
        if (loc != null)
        {
            if (loc.getInv().getInventory().size() > 0) {
                System.out.println(loc);
            }
            else {
                System.out.println(StringResources.LOCATION_EMPTY);
            }
        }
        else
        {
            System.out.println(StringResources.LOCATION_NOT_EXIST);
        }
    }

    // Adds items to inventory for a selected location
    public void addItemsToInventory() {
        System.out.println(StringResources.LOCATION_SELECT);
        for (Location location : locations) {
            System.out.println(location.getLocation());
        }
        String loc = scanner.nextLine();
        Location checkIfExists = findLocationByName(loc);
        if (checkIfExists == null)
        {
            System.out.println(StringResources.LOCATION_NOT_EXIST);
            return;
        }
        System.out.println(StringResources.TYPE_BARCODE);
        String barcode = scanner.nextLine();
        Product p = findProductByBarcode(barcode);

        if (p != null) {
            int existingIndex = findExistingProductIndex(loc, p);

            if (existingIndex != -1) {
                System.out.println(StringResources.PROMPT_QUANTITY_TO_ADD);

                try {
                    int quantityToAdd = Integer.parseInt(scanner.nextLine());
                    //scanner.nextLine(); // Consume the newline
                    findLocationByName(loc).getInv().updateQuantity(existingIndex, quantityToAdd, '+');
                    log.logData("Added \"" + p.getName() + "\"(" + p.getBarcode() + ")x" + quantityToAdd + " to " + loc);
                }
                catch (Exception e) {
                    System.out.println(StringResources.INVALID_USER_INPUT_FLOAT);
                    return;
                }
            } else {
                try {
                    System.out.println(StringResources.PROMPT_QUANTITY_TO_ADD);
                    int quantity = scanner.nextInt();
                    //scanner.nextLine(); // Consume the newline
                    findLocationByName(loc).getInv().addProduct(p, quantity);
                    log.logData("Added \"" + p.getName() + "\"(" + p.getBarcode() + ")x" + quantity + " to " + loc);
                }
                catch (Exception e) {
                    System.out.println(StringResources.INVALID_USER_INPUT_FLOAT);
                    return;
                }
            }
        }
    }

    // Adds items to inventory silently (without user interaction)
    public void addItemsToInventorySilent(String loc, String barcode, int quantityToAdd) {
        Product p = findProductByBarcode(barcode);

        if (p != null) {
            int existingIndex = findExistingProductIndex(loc, p);

            if (existingIndex != -1) {
                findLocationByName(loc).getInv().updateQuantity(existingIndex, quantityToAdd, '+');
            } else {
                findLocationByName(loc).getInv().addProduct(p, quantityToAdd);
            }
        }
    }

    // Removes items from inventory for a selected location
    public void removeItemsFromInventory() {
        System.out.println(StringResources.LOCATION_SELECT);
        for (Location location : locations) {
            System.out.println(location.getLocation());
        }
        String loc = scanner.nextLine();

        Location checkIfExists = findLocationByName(loc);
        if (checkIfExists == null)
        {
            System.out.println(StringResources.LOCATION_NOT_EXIST);
            return;
        }

        System.out.println(StringResources.TYPE_BARCODE);
        String barcode = scanner.nextLine();
        Product p = findProductByBarcode(barcode);

        if (p != null)
        {
            int existingIndex = findExistingProductIndex(loc, p);

            if (existingIndex != -1) {
                System.out.println(StringResources.PROMPT_QUANTITY_TO_REMOVE);

                int removeStatus;
                int quantityToRemove;
                try {
                    quantityToRemove = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline
                    removeStatus = findLocationByName(loc).getInv().updateQuantity(existingIndex, quantityToRemove, '-');
                } catch (Exception e) {
                    System.out.println(StringResources.INVALID_USER_INPUT_FLOAT);
                    return;
                }

                if (removeStatus == 0) {
                    System.out.println(StringResources.PRODUCT_REMOVE_SUCCESS);
                    log.logData("Removed \"" + p.getName() + "\"(" + p.getBarcode() + ")x" + quantityToRemove + " from " + loc);
                }
                if (removeStatus == 1) {
                    System.out.println(StringResources.PRODUCT_REMOVE_FAIL);
                }
            }
                else 
                {
                    System.out.println(StringResources.PRODUCT_NOT_EXIST_UNDER_INV);
                }
        }
    }

    //Start of Partially ChatGPT Generated Code
    // Finds the index of an existing product in a location's inventory
    private int findExistingProductIndex(String location, Product product) {
        Location loc = findLocationByName(location);
        if (loc != null) {
            Inventory inv = loc.getInv();
            for (int i = 0; i < inv.getInventory().size(); i++) {
                if (inv.getInventory().get(i).getProduct().getBarcode().equals(product.getBarcode())) {
                    return i;
                }
            }
        }
        return -1;
    }
    //End of Partially ChatGPT Generated Code

    // Moves stock from one location to another
    public void moveStockLocation() {
        if (locations.size() == 1) {
            System.out.println(StringResources.LOCATION_ONLY_ONE);
        } else {
            System.out.println(StringResources.SOURCE_INV);
            for (Location location : locations) {
                System.out.println(location.getLocation());
            }
            String source = scanner.nextLine();
            System.out.println(StringResources.DESTINATION_INV);
            for (Location location : locations) {
                if (!location.getLocation().equals(source)) {
                    System.out.println(location.getLocation());
                }
            }
            String target = scanner.nextLine();
            if (findLocationByName(source) == findLocationByName(target))
            {
                System.out.println(StringResources.LOCATION_SAME);
                return;
            }
            System.out.println(StringResources.TYPE_BARCODE);
            String barcode = scanner.nextLine();

            Product p = findProductByBarcode(barcode);
            if (p == null)
            {
                return;
            }
            int existingIndex = findExistingProductIndex(source, p);

            if (existingIndex != -1) {
                System.out.println(StringResources.PROMPT_QUANTITY_TO_MOVE);
                int quantityToMove;

                try {
                    quantityToMove = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline
                }
                catch (Exception e) {
                    System.out.println(StringResources.INVALID_USER_INPUT_FLOAT);
                    return;
                }

                if (quantityToMove < findLocationByName(source).getInv().getInventory().get(existingIndex).getQuantity())
                {
                    // Move Product
                    findLocationByName(source).getInv().updateQuantity(existingIndex, quantityToMove, '-');
                    addItemsToInventorySilent(target, barcode, quantityToMove);
                    log.logData("Moved \"" + p.getName() + "\"(" + p.getBarcode() + ")x" + quantityToMove + " from " + source + " to " + target);
                }
                else if (quantityToMove == findLocationByName(source).getInv().getInventory().get(existingIndex).getQuantity())
                {
                    findLocationByName(source).getInv().deletePQ(existingIndex);
                    addItemsToInventorySilent(target, barcode, quantityToMove);
                    log.logData("Moved \"" + p.getName() + "\"(" + p.getBarcode() + ")x" + quantityToMove + " from " + source + " to " + target);
                }
                else
                {
                    System.out.println(StringResources.PRODUCT_MOVE_FAIL);
                }
            } else {
                System.out.println(StringResources.PRODUCT_NOT_EXIST_UNDER_LOCATION);
            }
        }
    }

    // Saves all data and exits the program
    public void saveAndExit() {
        productManagement.saveMasterProductsList();
        saveProductsAndInventories();
        log.saveLog();
    }

    // Saves products and inventories to a file
    public void saveProductsAndInventories() {
        String FILE_PATH = StringResources.FILE_PATH_2;
        try {
            PrintWriter writer = new PrintWriter(new FileWriter(FILE_PATH));
            writer.println("Inventory, Quantity, Barcode, Name, Price");

            for (int i = 0; i < locations.size(); i++) {
                // Check if the inner list has elements before accessing them
                if (!locations.get(i).getInv().getInventory().isEmpty()) {
                    for (int j = 0; j < locations.get(i).getInv().getInventory().size(); j++) {
                        String writeToFile = locations.get(i).getLocation() + ","
                                + locations.get(i).getInv().getInventory().get(j).getQuantity() + ","
                                + locations.get(i).getInv().getInventory().get(j).getProduct().getBarcode() + ","
                                + locations.get(i).getInv().getInventory().get(j).getProduct().getName() + ","
                                + locations.get(i).getInv().getInventory().get(j).getProduct().getPrice();

                        writer.println(writeToFile);
                    }
                } else {
                    String writeToFile = locations.get(i).getLocation() + ",NULL,NULL,NULL,NULL";
                    writer.println(writeToFile);
                }
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Loads products and inventories from a file
    public void loadProductsAndInventories() {
        try {

            String FILE_PATH = StringResources.FILE_PATH_2;
            Scanner scanner = new Scanner(new FileReader(FILE_PATH));
            scanner.nextLine(); // Skip the header line
            while (scanner.hasNextLine()) {
                String[] parts = scanner.nextLine().split(",");
                if (parts.length == 5) {
                    String location = parts[0];
                    String barcode = parts[2];
                    String name = parts[3];
                    createNewSilentLocation(location);
                    if (!barcode.equals("NULL")) {
                        findLocationByName(location).getInv().addSilentProduct(new Product(barcode, name, Double.parseDouble(parts[4])), Integer.parseInt(parts[1]));
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
