/*
Group Number: 90
Group Members: Maahir Hussain Shaik(ID: 21154501)
               Roshan Varughese(ID: 21137055)
Class Name: Main
Class Function: 1. Prints Available Options for the User to Choose from
                2. Allows User to Choose Options for Stock Management
 */




public class Location {

    private String location;
    Inventory inventory;


    public Location(String location) {
        this.location = location;
        this.inventory = new Inventory();
    }

    public String getLocation() {
        return location;
    }

    @Override
    public String toString() {
        return inventory.toString();
    }

    public Inventory getInv()
    {
        return this.inventory;
    }

}


