/*
Group Number: 90
Group Members: Maahir Hussain Shaik(ID: 21154501)
               Roshan Varughese(ID: 21137055)
Class Name: ProductQuantity
Class Function: ProductQuantity that represents a product with its stock quantity. It has methods to set and retrieve quantity, access product details, and generate a formatted string representation.
 */

public class ProductQuantity {

    // Private instance variables to store product information and quantity
    private Product products;
    private int Quantity;

    // Constructor to initialize the ProductQuantity object with a Product and quantity
    public ProductQuantity(Product products, int Quantity){
        this.products = products;
        this.Quantity = Quantity;
    }

    // Setter method to set the quantity of the product
    public void setQuantity(int quantity) {
        Quantity = quantity;
    }

    // Getter method to retrieve the quantity of the product
    public int getQuantity() {
        return Quantity;
    }

    // Getter method to retrieve the associated product
    public Product getProduct() {
        return products;
    }

    // Override the toString method to provide a formatted string representation of the object
    @Override
    public String toString() {
        return "Barcode: " + products.getBarcode() +
                ", Name: " + products.getName() +
                ", Price: " + products.getPrice() +
                ", Quantity: " + Quantity;
    }
}
