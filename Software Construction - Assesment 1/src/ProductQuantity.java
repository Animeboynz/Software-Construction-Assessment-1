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

    public void setQuantity(int quantity) {
        Quantity = quantity;
    }

    public int getQuantity() {
        return Quantity;
    }

    public Product getProduct() {
        return products;
    }

    public void updateAddQuantity(int quantity)
    {
        this.setQuantity(this.Quantity + quantity);
    }

    @Override
    public String toString() {
        return "barcode='" + products.getBarcode() + '\'' +
                ", name='" + products.getName() + '\'' +
                ", Price=" + products.getPrice() +
                ", Quantity=" + Quantity;
    }


}
