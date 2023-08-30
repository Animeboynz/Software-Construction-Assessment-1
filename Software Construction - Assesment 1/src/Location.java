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


