/*
Group Number: 90
Group Members: Maahir Hussain Shaik(ID: 21154501)
               Roshan Varughese(ID: 21137055)
Class Name: Product
Class Function:
The Product Class defines a new product
It contains private member variables for storing product details, including a barcode (a string), a name (a string), and a price (a double).
this Java class is designed to represent and manage product information, offering methods to set and retrieve product details and a custom string representation of a product object.
*/

// Define a class named "Product" for managing product information
public class Product {
    // Private member variables for product details
    private String barcode;
    private String name;
    private double Price;

    // Constructor to initialize product details
    public Product(String barcode, String name, double price) {
        setBarcode(barcode);
        setName(name);
        setPrice(price);
    }

    // Getter method for retrieving the barcode
    public String getBarcode() {
        return barcode;
    }

    // Setter method for setting the barcode
    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    // Getter method for retrieving the product name
    public String getName() {
        return name;
    }

    // Setter method for setting the product name
    public void setName(String name) {
        this.name = name;
    }

    // Getter method for retrieving the product price
    public double getPrice() {
        return Price;
    }

    // Setter method for setting the product price
    public void setPrice(double price) {
        this.Price = price;
    }

    // Override the toString() method to provide a string representation of the product
    @Override
    public String toString() {
        return "Barcode: " + barcode +
                ", Name: " + name +
                ", Price: " + Price;
    }
}
