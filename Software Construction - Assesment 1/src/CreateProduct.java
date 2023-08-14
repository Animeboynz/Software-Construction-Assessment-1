import java.util.ArrayList;
import java.util.List;

public class CreateProduct
{
    //Enter product barcode
    //Enter name

    private List<Product> productslist;


    CreateProduct()
    {
        productslist = new ArrayList<>();
    }

    public void AddNewProduct(Product p)
    {
        productslist.add(p);
    }

    public String toString()
    {
        return productslist.toString();
    }
}



