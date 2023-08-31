public class StringResources {

    //PERSISTENT SAVE LOCATIONS
    public static final String FILE_PATH_1 = "products.csv";//Master Products List
    public static final String FILE_PATH_2 = "save.csv";//Products and Locations
    public static final String FILE_PATH_3 = "log.csv";//Log

    //LOG DATE & TIME FORMAT
    public static final String LOG_DATE_TIME_FORMAT = "dd/MM/yyyy HH:mm:ss";

    //USER ERROR
    public static final String INVALID_USER_OPTION_SELECT = "Invalid option. Please select again."; //With auto Retry
    public static final String INVALID_USER_OPTION_SELECT_NR = "Invalid config option.";

    //LOCATION PROMPTS
    public static final String LOCATION_NEW_NAME = "Enter a name for the new location: ";
    public static final String LOCATION_EXISTS = "A Location with the same name already exists.";
    public static final String LOCATION_SELECT = "Select your desired location.";
    public static final String LOCATION_ONLY_ONE = "You only have 1 location, Create more to use this function";
    public static final String SOURCE_INV = "Select Source Inventory";
    public static final String DESTINATION_INV = "Select Destination Inventory";

    //PRODUCT PROMPTS
    public static final String PRODUCT_NOT_EXIST = "Product does not exist. Add new product under options first";
    public static final String PRODUCT_NOT_EXIST_UNDER_LOCATION = "This product does not exist in this location";
    public static final String PRODUCT_NOT_EXIST_UNDER_INV = "That product does not exist in this inventory";
    public static final String PRODUCT_ADD_SUCCESS = "Product added successfully.";
    public static final String PRODUCT_BARCODE_EXISTS = "Product with the same barcode already exists.";
    public static final String TYPE_BARCODE = "Enter product barcode: ";
    public static final String PROMPT_PRODUCT_NAME = "Enter product name: ";
    public static final String PROMPT_PRODUCT_PRICE = "Enter product price: ";
    public static final String PROMPT_QUANTITY_TO_ADD = "Enter Quantity to add:";
    public static final String PROMPT_QUANTITY_TO_REMOVE = "Enter Quantity to remove:";
    public static final String PROMPT_QUANTITY_TO_MOVE = "Enter Quantity to Move:";

    public static final String PRODUCT_REMOVE_SUCCESS = "Removed Items from Inventory Successfully";
    public static final String PRODUCT_REMOVE_FAIL = "Error! Check if you are removing more than what exists in the inventory";
    public static final String PRODUCT_MOVE_FAIL = "The quantity you have entered is larger than what exists in the Source Inventory";



    /*
    public static String getString(String stringResourceId)
    {
        return switch (stringResourceId)
        {
            case "R.string.pref_category_display" -> PREF_CATEGORY_DISPLAY;
            default -> "";
        };
    }
     */
}
