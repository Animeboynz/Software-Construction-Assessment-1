import java.util.Scanner;
import java.util.*;
public class Main
{
    public static void main(String[] args)
    {   /*
        Product p1 = new Product("9419909788", "Product 1", 99.99);
        Product p2 = new Product("1234567", "Product 2", 199.99);
        Product p3 = new Discount("987654dddddsa3", "Product 3", 299.99, 40);

        CreateProduct c1;
        c1 = new CreateProduct();
        c1.AddNewProduct(p1);
        c1.AddNewProduct(p2);
        c1.AddNewProduct(p3);
        System.out.println(c1.toString());
        */
        Scanner scanner = new Scanner(System.in);

        Initialize def = new Initialize();

        while (true)
        {
            System.out.println("Select an option:");
            System.out.println("1. List Inventory");
            System.out.println("2. Add items to inventory");
            System.out.println("3. Remove items from inventory");
            System.out.println("4. Move stock location");
            System.out.println("5. Check for stock updates");
            System.out.println("6. Config");
            System.out.println("7. Exit");

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
                    //inventoryManager.moveStockLocation();
                    break;
                case 5:
                    // Implement stock update checking
                    break;
                case 6:
                    def.options();
                    break;
                case 7:
                    System.exit(0);
																//Save all variables to file
																//def.saveandexit()
                    break;
                default:
                    System.out.println("Invalid option. Please select again.");
            }

        }
    }
}