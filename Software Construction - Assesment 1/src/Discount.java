public class Discount extends Product
{
    private double discount;

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    @Override
    public double getPrice()
    {
        return super.getPrice() * discount;
    }

    public Discount(String barcode, String name,double price, double discount) {
        super(barcode,name, price);
        setDiscount(discount);
    }

    @Override
    public String toString() {
        return super.toString() + ", Discount: " + discount;
    }
}

