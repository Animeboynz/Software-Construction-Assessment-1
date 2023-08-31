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
