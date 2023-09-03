/*
Group Number: 90
Group Members: Maahir Hussain Shaik(ID: 21154501)
               Roshan Varughese(ID: 21137055)
Class Name: StringResources
Class Function:
StringResources code is to centralize and store constant string resources that are used throughout a software application.
These string resources serve various purposes, such as:

File Paths

Date & Time Format

User Error Messages.

Location Prompts

Product Prompts

Success/Failure Messages

 */

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
    public static final String INVALID_USER_INPUT_FLOAT = "Please try again with an Integer Value";
    public static final String FILE_CREATE_ERROR = "CSV Files could not be generated automatically. Please ensure this program has write privileges to the root folder.";

    //LOCATION PROMPTS
    public static final String LOCATION_NEW_NAME = "Enter a name for the new location: ";
    public static final String LOCATION_EXISTS = "A Location with the same name already exists.";
    public static final String LOCATION_NOT_EXIST = "The Entered Location does not exist";
    public static final String LOCATION_EMPTY = "The Entered Location's Inventory is Empty";
    public static final String LOCATION_SELECT = "Select your desired location.";
    public static final String LOCATION_ONLY_ONE = "You do not have enough locations, Create more to use this function";
    public static final String SOURCE_INV = "Select Source Inventory";
    public static final String DESTINATION_INV = "Select Destination Inventory";
    public static final String LOCATION_SAME = "You have chosen the same SOURCE and TARGET inventories. Try again";


    //PRODUCT PROMPTS
    public static final String PRODUCT_NOT_EXIST = "Product does not exist. Add new product under options first";
    public static final String PRODUCT_NOT_EXIST_UNDER_LOCATION = "This product does not exist in this location";
    public static final String PRODUCT_NOT_EXIST_UNDER_INV = "That product does not exist in this inventory";
    public static final String PRODUCT_ADD_SUCCESS = "Product added successfully.";
    public static final String PRODUCT_BARCODE_EXISTS = "Product with the same barcode already exists.";
    public static final String PRODUCT_BARCODE_INVALID = "No product is associated with this barcode.";//PRODUCT_NOT_EXIST
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
