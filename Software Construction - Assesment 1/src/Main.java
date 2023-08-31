import java.util.Scanner;
public class Main
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        Initialize def = new Initialize();
        def.q.loadMasterProductsList();
        def.loadProductsAndInventories();

        while (true)
        {
            System.out.println("Select an option:");
            System.out.println("1. List Inventory");
            System.out.println("2. Add items to inventory");
            System.out.println("3. Remove items from inventory");
            System.out.println("4. Move stock location");
            System.out.println("5. Check for stock updates");
            System.out.println("6. View Log");
            System.out.println("7. Config");
            System.out.println("8. Exit");

            int option = scanner.nextInt();

            switch (option)
            {
                case 1:
                    def.listInventory();
                    break;
                case 2:
                    def.addItemsToInventory();
                    break;
                case 3:
                    def.removeItemsFromInventory();
                    break;
                case 4:
                    def.moveStockLocation();
                    break;
                case 5:
                    // Implement stock update checking
                    break;
                case 6:
                    def.log.printLog();
                    break;
                case 7:
                    def.options();
                    break;
                case 8:
                    //Save all variables to file & exit
                    def.saveandexit();
                    System.exit(0);
                    break;
                default:
                    System.out.println(StringResources.INVALID_USER_OPTION_SELECT);
            }
        }
    }
}