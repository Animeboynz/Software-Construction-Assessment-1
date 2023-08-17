import java.util.Random;
import java.util.Scanner;

public class Configuration
{
    private Scanner scanner;

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
}
