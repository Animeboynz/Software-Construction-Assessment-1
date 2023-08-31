import java.util.ArrayList;
import java.util.List;

public class Inventory {

    private List<ProductQuantity> pq;

    public Inventory() {
        pq = new ArrayList<>();
    }

    public void addProduct(Product p, int quantity)
    {
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
            return 0;
        }
        else if (sign == '-')
        {
            if (pqToUpdate.getQuantity() > quantity)
            {
                pqToUpdate.setQuantity(pqToUpdate.getQuantity() - quantity);
                return 0;
            }
            else if (pqToUpdate.getQuantity() == quantity)
            {
                //Implement delete from inventory if quantity = 0
                this.deletePQ(index);
                return 0;
            }
            else if (pqToUpdate.getQuantity() < quantity)
            {
                return 1;
            }

        }
        return 1;
    }

    public void deletePQ(int Index)
    {
        pq.remove(Index);
    }

    public List<ProductQuantity> getPq() {
        return pq;
    }

    @Override
    public String toString() {
        StringBuilder out= new StringBuilder();
        for(ProductQuantity p : pq){
            out.append(p.toString()).append("\n");
        }
        return out.toString();
    }
}
