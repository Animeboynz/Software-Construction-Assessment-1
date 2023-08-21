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


    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return inventory.toString();
    }

    public Inventory getInv()
    {
        return this.inventory;
    }

   /*
    public void setInv(Inventory i)
    {
        this.inv = inventory;
    }*/
}


