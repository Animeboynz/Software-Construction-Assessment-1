import java.util.List;

public class Pro extends CreateProduct{
    @Override
    public void addNewProduct()
    {

        System.out.print("Enter product barcode: ");
        String barcode = scanner.next();

        if (!doesProductExist(barcode))
        {
            System.out.print("Enter product name: ");
            scanner.nextLine(); // Consume the newline left from previous input
            String name = scanner.nextLine(); // Read the entire line, including spaces
            System.out.print("Enter product price: ");
            double price = Double.parseDouble(scanner.next());


            Product newProduct = new Product(barcode, name, price);
            productslist.add(newProduct);

            System.out.println("Product added successfully.");
        }
        else {
            System.out.println("Product with the same barcode already exists.");
        }
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
