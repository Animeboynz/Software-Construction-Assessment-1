public class Product
{
    private String barcode;
    private String name;
    private double Price;





    private int quantity;


    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double price) {
        this.Price = price;
    }

    public Product(String barcode, String name, double price) {
        setBarcode(barcode);
        setName(name);
        setPrice(price);
        //setQuantity(0);
    }

    @Override
    public String toString() {
        return "Product{" +
                "barcode='" + barcode + '\'' +
                ", name='" + name + '\'' +
                ", Price=" + Price +
                '}';
    }
}
