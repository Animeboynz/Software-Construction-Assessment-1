import java.util.List;

public class Pro extends CreateProduct{
    @Override
    public void addNewProduct()
    {

        System.out.print(StringResources.TYPE_BARCODE);
        String barcode = scanner.next();

        if (!doesProductExist(barcode))
        {
            System.out.print(StringResources.PROMPT_PRODUCT_NAME);
            scanner.nextLine(); // Consume the newline left from previous input
            String name = scanner.nextLine(); // Read the entire line, including spaces
            System.out.print(StringResources.PROMPT_PRODUCT_PRICE);
            double price = Double.parseDouble(scanner.next());


            Product newProduct = new Product(barcode, name, price);
            productslist.add(newProduct);

            System.out.println(StringResources.PRODUCT_ADD_SUCCESS);
        }
        else {
            System.out.println(StringResources.PRODUCT_BARCODE_EXISTS);
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
