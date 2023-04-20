package hotel;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Menu {
    public static void clearScreen() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
    public static int managerMenu(){
        System.out.println("alkdjf;aldskfjafkja");return 0;}
    public static int employeeMenu(){return 0;}
    public static int servicesMenu(){
        Scanner scan = new Scanner(System.in);
        int choice;
        System.out.println("***********--Select a Service--************");
        System.out.println("1. Check In");
        System.out.println("2. Check Out");
        System.out.println("3. Use Restaurant");
        System.out.println("4. Use Spa");
        System.out.println("5. Use Swimming pool");
        System.out.println("6. Cinema");
        System.out.println("7. Game Zone");
        while (true){
            choice = scan.nextInt();
            if (!(choice == 1 || choice == 2)){
                System.out.println("please choice the appropriate number form the screen");
                continue;
            }
            break;
        }
        if (choice == 1){
            Reception rc = new Reception();
            rc.checkIn();
        } else if (choice == 2) {
            Reception rc = new Reception();
            rc.checkOut();
        } else if (choice == 3) {
            Restaurant rs = new Restaurant();
            rs.getFoodMenu();
        } else {
            Customer cust = new Customer();
        Exotics.useService(cust);
        }
        return 0;}
    public static int mainMenu(){
        Scanner scan = new Scanner(System.in);
        System.out.println("********************************************");
        System.out.println("*************WELCOME TO OUR HOTEL***********");
        System.out.println("********************************************");
        System.out.println("Please choose from the following");
        System.out.println("1. Get Services");
        System.out.println("2. Log In");

        int choice;
        while (true){
            choice = scan.nextInt();
            if (!(choice == 1 || choice == 2)){
                System.out.println("please choice the appropriate number form the screen");
                continue;
            }
            break;
        }
        switch(choice){
            case 1:
                servicesMenu();
                break;
            case 2:
                loginMenu();
                break;
        }
        return 0;}
    public static int loginMenu(){
        clearScreen();
        String logmode;
        FileReader file;
        Scanner scan = new Scanner(System.in);
        System.out.println("**************Login Page**********\n");
        while (true){
            System.out.println("enter the mode in which you are going to log in(manager, employee, customer");
            System.out.print(">>>");
            logmode = scan.nextLine();
            System.out.println("Enter your Id");
            System.out.print(">>>");
            String id = scan.nextLine();

            try {
                file = new FileReader("storage/"+ logmode + ".json");
                JsonParser parser = new JsonParser();
                JsonObject loggers = (JsonObject) parser.parse(file);

                if (loggers.keySet().contains(id)) {
                    System.out.println("Enter password: \n>>>");
                    String pas = scan.nextLine();
                    String pwd = loggers.get(id).getAsJsonObject().get("password").getAsString();

                    if (pas.equals(pwd)){
                        System.out.println("Successful Login");
                        switch (logmode.toLowerCase()) {
                            case "manager":
                                managerMenu();
                                break;
                            case "employee":
                                employeeMenu();
                            case "customer":
                                break;
                        }
                    }
                } else {
                    System.out.println("User doesn't exit or wrong user name. Try again");
                    continue;
                }
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
            break;
        }


        return 0;}

    public static void main(String[] args) {
        int a = loginMenu();
    }

}
