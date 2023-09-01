/*
Group Number: 90
Group Members: Maahir Hussain Shaik(ID: 21154501)
               Roshan Varughese(ID: 21137055)
Class Name: Main
Class Function: 1. Prints Available Options for the User to Choose from
                2. Allows User to Choose Options for Stock Management
 */



// Importing the Scanner class for user input
import java.util.Scanner;

// The main class for the stock management program
public class Main
{
    public static void main(String[] args)
    {
        // Creating a Scanner object for user input
        Scanner scanner = new Scanner(System.in);

        Initialize def = new Initialize();

        def.q.loadMasterProductsList();
        def.loadProductsAndInventories();
        def.log.loadLog();

        // Creating an instance of the Initialize class to initialize components and data
        Initialize main_Menu = new Initialize();

        // Loading the master product list, products, and inventories
        main_Menu.q.loadMasterProductsList();
        main_Menu.loadProductsAndInventories();

        // Loading the log
        main_Menu.log.loadLog();

        // Main program loop
        while (true)
        {
            // Displaying the menu options for the user
            System.out.println("Select an option:");
            System.out.println("1. List Inventory");
            System.out.println("2. Add items to inventory");
            System.out.println("3. Remove items from inventory");
            System.out.println("4. Move stock location");
            System.out.println("5. Check for stock updates"); // Placeholder
            System.out.println("6. View Log");
            System.out.println("7. Config");
            System.out.println("8. Exit");

            String option = scanner.nextLine();
            // Reading the user's choice
            int option = scanner.nextInt();

            // Handling the user's choice with a switch statement
            switch (option)
            {
                case "1":
                    def.listInventory();
                    break;
                case "2":
                    def.addItemsToInventory();
                    break;
                case "3":
                    def.removeItemsFromInventory();
                    break;
                case "4":
                    def.moveStockLocation();
                    break;
                case "5":
                    // Implement stock update checking
                    break;
                case "6":
                    def.log.printLog();
                    break;
                case "7":
                    def.options();
                    break;
                case "8":
                    //Save all variables to file & exit
                    def.saveAndExit();
                    System.exit(0);
                case 1:
                    main_Menu.listInventory(); // Call a method to list inventory
                    break;
                case 2:
                    main_Menu.addItemsToInventory(); // Call a method to add items to inventory
                    break;
                case 3:
                    main_Menu.removeItemsFromInventory(); // Call a method to remove items from inventory
                    break;
                case 4:
                    main_Menu.moveStockLocation(); // Call a method to move stock location
                    break;
                case 5:
                    // Implement stock update checking (Placeholder)
                    break;
                case 6:
                    main_Menu.log.printLog(); // Call a method to view the log
                    break;
                case 7:
                    main_Menu.options(); // Call a method to configure options
                    break;
                case 8:
                    // Save all variables to file & exit
                    main_Menu.saveAndExit(); // Call a method to save data and exit
                    System.exit(0); // Exit the program
                    break;
                default:
                    System.out.println(StringResources.INVALID_USER_OPTION_SELECT); // Display error for invalid input
            }
        }
    }
}
