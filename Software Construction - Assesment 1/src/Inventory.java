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

    public void addSilentProduct(Product p, int quantity)
    {
        pq.add(new ProductQuantity(p, quantity));
    }

    public int updateQuantity(int index, int quantity, char sign) {
        ProductQuantity pqToUpdate = pq.get(index);
        if (sign == '+')
        {
            pqToUpdate.setQuantity(pqToUpdate.getQuantity() + quantity);
            //return 0;
        }
        else if (sign == '-')
        {
            if (pqToUpdate.getQuantity() > quantity)
            {
                pqToUpdate.setQuantity(pqToUpdate.getQuantity() - quantity);
            }
            else if (pqToUpdate.getQuantity() == quantity)
            {
                //Implement delete from inventory if quantity = 0
                return 1;
            }
            else if (pqToUpdate.getQuantity() < quantity)
            {
                return 1;
            }

        }
        return 1;
    }

    public List<ProductQuantity> getPq() {
        return pq;
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
