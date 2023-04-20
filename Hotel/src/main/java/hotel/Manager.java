package hotel;

import com.google.gson.JsonObject;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class Manager extends Employee {
    public Manager(){}
    public Manager(String fName, String lName, int salary, String pswd) {
        super(fName, lName, salary, "Manager",pswd);
    }

    void fireEmp(String id) {
        JsonObject obj;
        obj = FileHandling.readJsonFile("employee.json");
        if (!obj.keySet().contains(id)) {
            System.out.println("The entered employee with id=" + id + " does not exit");
            return;
        }
        obj.remove(id);
        try (FileWriter writer = new FileWriter("storage/employee.json")) {
            writer.write(obj.toString());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    void payEmp() {
        JsonObject objE, objB;
        objE = FileHandling.readJsonFile("employee.json");
        objB = FileHandling.readJsonFile("budget.json");
        int budg = objB.get("budget").getAsInt();
        String fname, lname;
        int salary;
        for (String i : objE.keySet()) {
            fname = objE.get(i).getAsJsonObject().get("fName").getAsString();
            lname = objE.get(i).getAsJsonObject().get("lName").getAsString();
            salary = objE.get(i).getAsJsonObject().get("salary").getAsInt();
            System.out.println("Paid Employee " + fname + " " + lname + " with amount " + salary);
            budg -= salary;
        }
        objB.remove("budget");
        objB.addProperty("budget", budg);
    }

    void payEmp(String id) {
        JsonObject objE, objB;
        objE = FileHandling.readJsonFile("employee.json");
        objB = FileHandling.readJsonFile("budget.json");
        int budg = objB.get("budget").getAsInt();
        String fname, lname;
        int salary;
        for (String i : objE.keySet()) {
            if (id.equals(i)) {
                fname = objE.get(i).getAsJsonObject().get("fName").getAsString();
                lname = objE.get(i).getAsJsonObject().get("lName").getAsString();
                salary = objE.get(i).getAsJsonObject().get("salary").getAsInt();
                System.out.println("Paid Employee " + fname + " " + lname + " with amount " + salary);
                budg -= salary;
            }
        }
        objB.remove("budget");
        objB.addProperty("budget", budg);
    }

    void getEmpInfo(String id, String fName) {
        JsonObject objE = FileHandling.readJsonFile("employee.json");
        for (String i : objE.keySet()) {
            System.out.println("First Name: " + objE.get(i).getAsJsonObject().get("fName"));
            System.out.println("Last Name: " + objE.get(i).getAsJsonObject().get("lName"));
            System.out.println("Id: " + objE.get(i).getAsJsonObject().get("id"));
            System.out.println("Salary: " + objE.get(i).getAsJsonObject().get("salary"));
            System.out.println("Department: " + objE.get(i).getAsJsonObject().get("department"));
        }
    }

    void getEmpInfo(String fname) {
        JsonObject objE = FileHandling.readJsonFile("employee.json");
        for (String i : objE.keySet()) {
            if (objE.get(i).getAsJsonObject().get("fName").getAsString().equals(fname)) {
                System.out.println("First Name: " + objE.get(i).getAsJsonObject().get("fName"));
                System.out.println("Last Name: " + objE.get(i).getAsJsonObject().get("lName"));
                System.out.println("Id: " + objE.get(i).getAsJsonObject().get("id"));
                System.out.println("Salary: " + objE.get(i).getAsJsonObject().get("salary"));
                System.out.println("Department: " + objE.get(i).getAsJsonObject().get("department"));
            }
        }
    }
    void getEmpInfo(int id) {
        JsonObject objE = FileHandling.readJsonFile("employee.json");
        for (String i : objE.keySet()) {
            if (objE.get(i).getAsJsonObject().get("id").getAsInt() == id) {
                System.out.println("First Name: " + objE.get(i).getAsJsonObject().get("fName"));
                System.out.println("Last Name: " + objE.get(i).getAsJsonObject().get("lName"));
                System.out.println("Id: " + objE.get(i).getAsJsonObject().get("id"));
                System.out.println("Salary: " + objE.get(i).getAsJsonObject().get("salary"));
                System.out.println("Department: " + objE.get(i).getAsJsonObject().get("department"));
            }
        }
    }

}
