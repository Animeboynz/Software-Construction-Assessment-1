import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Inventory {

    //private List<Product> products;
    //private List<Integer> quantity;

    private List<ProductQuantity> pq;
    private Scanner scanner = new Scanner(System.in);

    public Inventory() {
        pq = new ArrayList<>();
        //products = new ArrayList<>();
    }

    public void addProduct(Product p)
    {
        System.out.println("Enter Quantity");
        int quantity = scanner.nextInt();
        pq.add(new ProductQuantity(p, quantity));
    }

    @Override
    public String toString() {
        String out= "";
        for(ProductQuantity p : pq){
            out += p.toString() + "\n";
        }
        return out;
    }
}
