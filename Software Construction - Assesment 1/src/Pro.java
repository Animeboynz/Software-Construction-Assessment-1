/*
Group Number: 90
Group Members: Maahir Hussain Shaik(ID: 21154501)
               Roshan Varughese(ID: 21137055)
Class Name: Pro
Class Function:
Pro is a Subclass of CreateProduct
The purpose of this class is to manage a list of products.
It overrides methods from the parent class to add new products to a list
and check if a product with a specific barcode exists in the list.
 */

// Importing necessary libraries
import java.util.List;

// Definition of the 'Pro' class, extending 'CreateProduct'
public class Pro extends CreateProduct {

    // Override of the 'addNewProduct' method from 'CreateProduct'
    @Override
    public void addNewProduct(Product newProduct) {
        // Adding a new product to the 'productslist'(defined in the 'CreateProduct' class)
        productslist.add(newProduct);
    }

    // Method to check if a product with a given barcode exists in the 'productslist'
    public boolean doesProductExist(String barcode) {
        for (Product product : productslist) {
            if (product.getBarcode().equals(barcode)) {
                return true; // Return true if a matching product is found
            }
        }
        return false; // Return false if no matching product is found
    }

    // Override of the 'getProducts' method to retrieve the list of products
    @Override
    public List<Product> getProducts() {
        return super.productslist; // Return the 'productslist' from the parent class
    }
}
