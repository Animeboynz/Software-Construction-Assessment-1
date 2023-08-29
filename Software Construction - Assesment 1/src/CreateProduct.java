import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class CreateProduct
{
    //Enter product barcode
    //Enter name

    public List<Product> productslist = new ArrayList<>();

    /*
    CreateProduct()
    {
        productslist = new ArrayList<>();
    }*/

    Scanner scanner = new Scanner(System.in);


    public abstract void addNewProduct();



    public abstract List<Product> getProducts();


    public List<Product> getProductslist() {
        return productslist;
    }

    public String toString()
    {
        return productslist.toString();
    }

}



