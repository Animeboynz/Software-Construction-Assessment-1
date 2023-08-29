import java.util.List;

public class Pro extends CreateProduct{
    @Override
    public void addNewProduct()
    {
        System.out.print("Enter product barcode: ");
        String barcode = scanner.next();
        System.out.print("Enter product name: ");
        String name = scanner.next();
        System.out.print("Enter product price: ");
        double price = Double.parseDouble(scanner.next());


        Product newProduct = new Product(barcode, name, price);
        productslist.add(newProduct);

        System.out.println("Product added successfully.");
    }

    @Override
    public List<Product> getProducts() {
       return super.productslist;
    }


}
