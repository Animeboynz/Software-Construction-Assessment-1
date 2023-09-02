/*
Group Number: 90
Group Members: Maahir Hussain Shaik(ID: 21154501)
               Roshan Varughese(ID: 21137055)
Class Name: Main
Class Function: 1. Prints Available Options for the User to Choose from
                2. Allows User to Choose Options for Stock Management
 */


import java.util.List;

public class Pro extends CreateProduct{


    @Override
    public void addNewProduct(Product newProduct)
    {

        productslist.add(newProduct);
    }

    public boolean doesProductExist(String barcode) {
        for (Product product : productslist) {
            if (product.getBarcode().equals(barcode)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public List<Product> getProducts() {
       return super.productslist;
    }


}
