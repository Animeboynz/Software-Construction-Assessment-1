import java.util.List;

public class ProductQuantity {

    private Product products;
    private int Quantity;

    public ProductQuantity(Product products, int Quantity){
        this.products = products;
        this.Quantity = Quantity;
    }

    public void addProducts(Product products) {
        this.products = products;
        Quantity = 0;
    }

    @Override
    public String toString() {
        return "barcode='" + products.getBarcode() + '\'' +
                ", name='" + products.getName() + '\'' +
                ", Price=" + products.getPrice() +
                ", Quantity=" + Quantity;
    }


}
