package hotel;

import com.google.gson.JsonObject;

import java.util.Scanner;

public class Employee extends Person {
    private final String fileName = "employees";

    int salary;
    String department;

    public Employee() {
    }

    public Employee(String fName, String lName, int salary, String department, String pswd) {
        this.fName = fName;
        this.lName = lName;
        this.setId();
        this.salary = salary;
        this.department = department;
        this.password = pswd;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }


    void askForRaise() {
        String location = "storage/raise.json";
        JsonObject obj = new JsonObject();
        String sId = getId();
        obj.addProperty("name", this.getfName());
        obj.addProperty("id", sId);
        obj.addProperty("department", this.department);
        Scanner scan = new Scanner(System.in);
        System.out.println("Briefly explain why do you feel like you deserve this raise?");
        System.out.println("\n\n");
        String reason = scan.nextLine();
        obj.addProperty("reason", reason);
        FileHandling.writeRequestString(location, obj);
    }

    void askForPromo() {
        String location = "storage/promotion.json";
        JsonObject obj = new JsonObject();
        String sId = getId();
        obj.addProperty("name", this.getfName());
        obj.addProperty("id", sId);
        obj.addProperty("department", this.department);
        Scanner scan = new Scanner(System.in);
        System.out.println("Briefly explain why do you feel like you deserve this Promotion?");
        System.out.println("\n\n");
        String reason = scan.nextLine();
        obj.addProperty("reason", reason);
        FileHandling.writeRequestString(location, obj);
    }

    void askQuit() {
        String location = "storage/resignation.json";
        JsonObject obj = new JsonObject();
        String sId = getId();
        obj.addProperty("name", this.getfName());
        obj.addProperty("id", sId);
        obj.addProperty("department", this.department);
        Scanner scan = new Scanner(System.in);
        System.out.println("Why do you want to leave our company");
        System.out.println("\n\n");
        String reason = scan.nextLine();
        obj.addProperty("reason", reason);
        FileHandling.writeRequestString(location, obj);
    }

}
