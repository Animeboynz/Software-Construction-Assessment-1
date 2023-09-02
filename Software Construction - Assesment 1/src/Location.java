/*
Group Number: 90
Group Members: Maahir Hussain Shaik(ID: 21154501)
               Roshan Varughese(ID: 21137055)
Class Name: Location
Class Function:This class represents a location and is associated with an inventory. It allows for retrieving
the location's name, the associated inventory, and provides a formatted string representation of the inventory.

 */

// Definition of the 'Location' class
public class Location {

    // Private instance variables to store location name and an associated inventory
    private String location;
    Inventory inventory; // Presumably, there's an 'Inventory' class used here

    // Constructor to initialize a 'Location' object with a name and create an associated inventory
    public Location(String location) {
        this.location = location;
        this.inventory = new Inventory(); // Assuming 'Inventory' class exists
    }

    // Getter method to retrieve the location's name
    public String getLocation() {
        return location;
    }

    // Override the 'toString' method to provide a formatted string representation
    @Override
    public String toString() {
        return inventory.toString();
    }

    // Getter method to retrieve the associated inventory
    public Inventory getInv() {
        return this.inventory;
    }
}
