package hotel;

public class Person {

    protected String lName;
    protected String fName;
    protected int id;
    protected String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setId() {
        this.id = Identification.getId();
    }

    public String getId() {
        return Integer.toString(id);
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }
}
