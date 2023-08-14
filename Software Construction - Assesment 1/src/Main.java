public class Main
{
    public static void main(String[] args)
    {
        Product p1 = new Product("9419909788", "Product 1", 99.99);
        Product p2 = new Product("1234567", "Product 2", 199.99);
        Product p3 = new Discount("9876543", "Product 3", 299.99, 40);

        CreateProduct c1;
        c1 = new CreateProduct();
        c1.AddNewProduct(p1);
        c1.AddNewProduct(p2);
        c1.AddNewProduct(p3);
        System.out.println(c1.toString());
    }
}