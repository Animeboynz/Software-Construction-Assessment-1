/*
Group Number: 90
Group Members: Maahir Hussain Shaik(ID: 21154501)
               Roshan Varughese(ID: )
Class Name: Inventory
Class Function: 1. Creates an Inventory with Products
                2. Has Methods to add products to the Inventory
 */


import java.util.ArrayList;
import java.util.List;

// The Inventory class represents a list of products and their quantities
public class Inventory {

    // Private field to store a list of ProductQuantity objects
    private List<ProductQuantity> pq;

    // Constructor to initialize the inventory as an empty list
    public Inventory() {
        pq = new ArrayList<>();
    }

    // Method to add a product with a specified quantity to the inventory
    public void addProduct(Product p, int quantity)
    {
        pq.add(new ProductQuantity(p, quantity));
    }

    // Method to add a product with a specified quantity to the inventory without generating any output
    public void addSilentProduct(Product p, int quantity)
    {
        pq.add(new ProductQuantity(p, quantity));
    }

    // Method to update the quantity of a product in the inventory
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
                // Implement delete from inventory if quantity = 0
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

    // Method to delete a ProductQuantity object from the inventory
    public void deletePQ(int Index)
    {
        pq.remove(Index);
    }

    // Getter method to retrieve the list of ProductQuantity objects
    public List<ProductQuantity> getInventory() {
        return pq;
    }

    // Override the toString() method to provide a string representation of the inventory
    @Override
    public String toString() {
        StringBuilder out = new StringBuilder();
        for(ProductQuantity p : pq){
            out.append(p.toString()).append("\n");
        }
        return out.toString();
    }
}
