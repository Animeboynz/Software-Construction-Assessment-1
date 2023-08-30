
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
        return "barcode='" + products.getBarcode() + '\'' +
                ", name='" + products.getName() + '\'' +
                ", Price=" + products.getPrice() +
                ", Quantity=" + Quantity;
    }


}
