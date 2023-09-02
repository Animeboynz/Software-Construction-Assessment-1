/*
Group Number: 90
Group Members: Maahir Hussain Shaik(ID: 21154501)
               Roshan Varughese(ID: 21137055)
Class Name: Main
Class Function: 1. Prints Available Options for the User to Choose from
                2. Allows User to Choose Options for Stock Management
 */


public class ProductQuantity {

    private Product products;
    private int Quantity;

    public ProductQuantity(Product products, int Quantity){
        this.products = products;
        this.Quantity = Quantity;
    }

    public void setQuantity(int quantity) {
        Quantity = quantity;
    }

    public int getQuantity() {
        return Quantity;
    }

    public Product getProduct() {
        return products;
    }

    @Override
    public String toString() {
        return "Barcode: " + products.getBarcode() +
                ", Name: " + products.getName() +
                ", Price: " + products.getPrice() +
                ", Quantity: " + Quantity;
    }


}
