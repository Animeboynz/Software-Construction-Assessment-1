import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Product p1 = new Product("9419909788", "Product 1", 99.99);
        Product p2 = new Product("1234567", "Product 2", 199.99);
        Product p3 = new Discount("987654dddddsa3", "Product 3", 299.99, 40);

        CreateProduct c1;
        c1 = new CreateProduct();
        c1.AddNewProduct(p1);
        c1.AddNewProduct(p2);
        c1.AddNewProduct(p3);
        System.out.println(c1.toString());

        Scanner scanner = new Scanner(System.in);

        while (true)
        {
            System.out.println("Select an option:");
            System.out.println("1. List Inventory");
            System.out.println("2. Add items to inventory");
            System.out.println("3. Remove items from inventory");
            System.out.println("4. Move stock location");
            System.out.println("5. Check for stock updates");
            System.out.println("6. Config");

            int option = scanner.nextInt();

            switch (option)
            {
                case 0:
                    inventoryManager.listInventory();
                    break;
                case 1:
                    inventoryManager.addItemsToInventory();
                    break;
                case 2:
                    inventoryManager.removeItemsFromInventory();
                    break;
                case 3:
                    inventoryManager.moveStockLocation();
                    break;
                case 4:
                    // Implement stock update checking
                    break;
                case 5:
                    inventoryManager.configure();
                    break;
                default:
                    System.out.println("Invalid option. Please select again.");
            }

        }
    }
}