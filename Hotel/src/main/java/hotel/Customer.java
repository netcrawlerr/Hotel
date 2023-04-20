package hotel;


public class Customer extends Person{
    private String cInDays;
    private String cOutDays;
    private int room;
    private double totalTab;

    public double getTotalTab() {
        return totalTab;
    }

    public void setTotalTab(double totalTab) {
        this.totalTab = totalTab;
    }

    public Customer() {
    }

    public Customer(String fName, String lName, String cInDays, String cOutDays) {
        Room room = new Room();
        this.fName = fName;
        this.lName = lName;
        this.setId();
        this.cInDays = cInDays;
        this.cOutDays = cOutDays;
        this.room =room.getRoom(this);
    }

    public String getfName() {
        return fName;
    }

    public String getcOutDays() {
        return cOutDays;
    }

    public void setcOutDays(String dys) {
        this.cOutDays = dys;
    }

    public String getcInDays() {
        return cInDays;
    }

    public void setcInDays(String dys) {
        this.cInDays = dys;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }
    public void setlName(String lName) {
        this.lName = lName;
    }
    public int getRoom() {
        return room;
    }
    public void setRoom(int room) {
        this.room = room;
    }

    void payTab() {

    }

}
