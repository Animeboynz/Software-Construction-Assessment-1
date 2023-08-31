import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Initialize {
    private List<Location> locations;
    private Scanner scanner;
    Pro q = new Pro();
    Log log = new Log();

    public Initialize() {
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
                addNewProduct();
                break;
            case 2:
                createNewLocation();
                break;
            default:
                System.out.println(StringResources.INVALID_USER_OPTION_SELECT_NR);
        }
    }

    public void addNewProduct()
    {
        System.out.print(StringResources.TYPE_BARCODE);
        String barcode = scanner.next();

        if (!q.doesProductExist(barcode))
        {
            System.out.print(StringResources.PROMPT_PRODUCT_NAME);
            scanner.nextLine(); // Consume the newline left from previous input
            String name = scanner.nextLine(); // Read the entire line, including spaces
            System.out.print(StringResources.PROMPT_PRODUCT_PRICE);
            double price = Double.parseDouble(scanner.next());

            q.addNewProduct(new Product(barcode, name, price));
            log.logData("Created New Product \"" + name + "\"(" + barcode + ") with price $" + price);
            System.out.println(StringResources.PRODUCT_ADD_SUCCESS);
        }
        else {
            System.out.println(StringResources.PRODUCT_BARCODE_EXISTS);
        }
    }

    public void createNewLocation()
    {
        System.out.println(StringResources.LOCATION_NEW_NAME);
        String option2 = scanner.nextLine();
        int result = createNewSilentLocation(option2);
        log.logData("Created New Location \"" + option2 + "\"");
        if (result == 1)
        {
            System.out.println(StringResources.LOCATION_EXISTS);
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
        for (Product product : q.getProducts()) {
            if (product.getBarcode().equals(barcode)) {
                return product;
            }
        }
        System.out.println(StringResources.PRODUCT_NOT_EXIST);
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

    public void listInventory() {

        scanner.nextLine();
        System.out.println(StringResources.LOCATION_SELECT);
        for (Location location : locations) {
            System.out.println(location.getLocation());
        }

        String option = scanner.nextLine();
        Location loc = this.findLocationByName(option);
        System.out.println(loc.toString());

    }

    public void addItemsToInventory() {
        System.out.println(StringResources.LOCATION_SELECT);
        for (Location location : locations) {
            System.out.println(location.getLocation());
        }
        String loc = scanner.nextLine();

        System.out.println(StringResources.TYPE_BARCODE);
        String barcode = scanner.nextLine();
        Product p = findProductByBarcode(barcode);

        if (p != null) {
            int existingIndex = findExistingProductIndex(loc, p);

            if (existingIndex != -1) {
                System.out.println(StringResources.PROMPT_QUANTITY_TO_ADD);
                int quantityToAdd = scanner.nextInt();
                findLocationByName(loc).getInv().updateQuantity(existingIndex, quantityToAdd, '+');
                log.logData("Added \"" + p.getName() + "\"(" + p.getBarcode() + ")x" + quantityToAdd + " to " + loc);

            } else {
                System.out.println(StringResources.PROMPT_QUANTITY_TO_ADD);
                int quantity = scanner.nextInt();
                findLocationByName(loc).getInv().addProduct(p, quantity);
                log.logData("Added \"" + p.getName() + "\"(" + p.getBarcode() + ")x" + quantity + " to " + loc);
            }
        }
    }

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

    public void removeItemsFromInventory() {
        System.out.println(StringResources.LOCATION_SELECT);
        for (Location location : locations) {
            System.out.println(location.getLocation());
        }
        String loc = scanner.nextLine();

        System.out.println(StringResources.TYPE_BARCODE);
        String barcode = scanner.nextLine();
        Product p = findProductByBarcode(barcode);

        int existingIndex = findExistingProductIndex(loc, p);

        if (existingIndex != -1) {
            System.out.println(StringResources.PROMPT_QUANTITY_TO_REMOVE);
            int quantityToRemove = scanner.nextInt();
            int removeStatus = findLocationByName(loc).getInv().updateQuantity(existingIndex, quantityToRemove, '-');
            log.logData("Removed \"" + p.getName() + "\"(" + p.getBarcode() + ")x" + quantityToRemove + " from " + loc);
            if (removeStatus == 0)
            {
                System.out.println(StringResources.PRODUCT_REMOVE_SUCCESS);
            }
            if (removeStatus == 1)
            {
                System.out.println(StringResources.PRODUCT_REMOVE_FAIL);
            }
        } else {
            System.out.println(StringResources.PRODUCT_NOT_EXIST_UNDER_INV);
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

    public void moveStockLocation()
    {
        if (locations.size() == 1)
        {
            System.out.println(StringResources.LOCATION_ONLY_ONE);
        }
        else {
            System.out.println(StringResources.SOURCE_INV);
            for (Location location : locations) {
                System.out.println(location.getLocation());
            }
            String source = scanner.nextLine();
            System.out.println(StringResources.DESTINATION_INV);
            for (Location location : locations) {
                if (!location.getLocation().equals(source))
                {
                    System.out.println(location.getLocation());
                }
            }
            String target = scanner.nextLine();
            System.out.println(StringResources.TYPE_BARCODE);
            String barcode = scanner.nextLine();

            Product p = findProductByBarcode(barcode);
            int existingIndex = findExistingProductIndex(source, p);

            if (existingIndex != -1)//If product exists in inventory
            {
                System.out.println(StringResources.PROMPT_QUANTITY_TO_MOVE);
                int quantityToMove = Integer.parseInt(scanner.nextLine());
                if (quantityToMove < findLocationByName(source).getInv().getPq().get(existingIndex).getQuantity())//If quantityToMove <= quantity of that product in source
                {
                    //Move Product
                    findLocationByName(source).getInv().updateQuantity(existingIndex, quantityToMove, '-');
                    addItemsToInventorySilent(target, barcode, quantityToMove);
                    ///////////
                    log.logData("Moved \"" + p.getName() + "\"(" + p.getBarcode() + ")x" + quantityToMove + " from " + source + " to " + target);
                } else if (quantityToMove == findLocationByName(source).getInv().getPq().get(existingIndex).getQuantity()) {
                    findLocationByName(source).getInv().deletePQ(existingIndex);
                    addItemsToInventorySilent(target, barcode, quantityToMove);
                    ///////////
                    log.logData("Moved \"" + p.getName() + "\"(" + p.getBarcode() + ")x" + quantityToMove + " from " + source + " to " + target);
                } else {
                    System.out.println(StringResources.PRODUCT_MOVE_FAIL);
                }
            }
            else {
                System.out.println(StringResources.PRODUCT_NOT_EXIST_UNDER_LOCATION);
            }
        }
    }

    public void saveAndExit()
    {
        q.saveMasterProductsList();
        saveProductsAndInventories();
        log.saveLog();

    }

    public void saveProductsAndInventories()
    {
        String FILE_PATH = StringResources.FILE_PATH_2;
        try {
            PrintWriter writer = new PrintWriter(new FileWriter(FILE_PATH));
            writer.println("Inventory, Quantity, Barcode, Name, Price");

            for (int i = 0; i < locations.size(); i++) {

                // Check if the inner list has elements before accessing them
                if (!locations.get(i).getInv().getPq().isEmpty()) {
                    for (int j = 0; j < locations.get(i).getInv().getPq().size(); j++) {
                        String writeToFile = locations.get(i).getLocation() + ","
                                + locations.get(i).getInv().getPq().get(j).getQuantity() + ","
                                + locations.get(i).getInv().getPq().get(j).getProduct().getBarcode() + ","
                                + locations.get(i).getInv().getPq().get(j).getProduct().getName() + ","
                                + locations.get(i).getInv().getPq().get(j).getProduct().getPrice();

                        writer.println(writeToFile);
                        //System.out.println(writeToFile);
                    }
                }else {
                    String writeToFile = locations.get(i).getLocation() + ",NULL,NULL,NULL,NULL";
                    writer.println(writeToFile);
                    //System.out.println(writeToFile);
                }
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadProductsAndInventories() {
        String FILE_PATH = StringResources.FILE_PATH_2;
        try (Scanner scanner = new Scanner(new FileReader(FILE_PATH))) {
            scanner.nextLine();
            while (scanner.hasNextLine()) {
                String[] parts = scanner.nextLine().split(",");
                if (parts.length == 5) {
                    String location = parts[0];
                    String barcode = parts[2];
                    String name = parts[3];
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
    }
}
