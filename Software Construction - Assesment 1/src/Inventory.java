import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Inventory {
    private List<Product> products;

    public Inventory() {
        products = new ArrayList<>();
    }

    public void addProduct(Product p)
    {
        products.add(p);
    }

    @Override
    public String toString() {
        String output = "";
        for(Product p: products){
            output+=p + "\n ";
        }
        return output;
    }
}
