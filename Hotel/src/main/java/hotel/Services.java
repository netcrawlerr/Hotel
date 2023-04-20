package hotel;

import com.google.gson.JsonObject;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

class Reception {
    private static double profit = 0.25;
    private static double VAT = 0.15;

    public Reception() {
    }

    void checkIn() {
        Scanner scan = new Scanner(System.in);
        Customer newcust = new Customer();
        Room room = new Room();
        while (true) {
            System.out.println("Enter your First Name");
            try {
                newcust.setfName(scan.next());
            } catch (IllegalArgumentException e) {
                System.out.println("Enter a correct value");
                continue;
            }
            break;
        }
        while (true) {
            System.out.println("Enter your Last Name");
            try {
                newcust.setlName(scan.next());
            } catch (IllegalArgumentException e) {
                System.out.println("Enter a correct value");
                continue;
            }
            break;
        }
        while (true) {
            System.out.println("Enter your Check In Date");
            try {
                newcust.setcInDays(scan.next());
            } catch (IllegalArgumentException e) {
                System.out.println("Enter a correct value");
                continue;
            }
            break;
        }
        while (true) {
            System.out.println("Enter your Check Out date");
            try {
                newcust.setcOutDays(scan.next());
            } catch (IllegalArgumentException e) {
                System.out.println("Enter a correct value");
                continue;
            }
            break;
        }
        newcust.setId();
        int ro = room.getRoom(newcust);
        newcust.setRoom(ro);
        FileHandling.writeJsonString(newcust);
    }

    void checkOut() {

    }
}

class Restaurant {
    private static double profit = 0.25;
    private static double VAT = 0.15;

    public Restaurant() {
    }

    private String[] headChef = new String[2];
    private String[] sueChef = new String[2];
    private static HashMap<String, Integer> foodMenu = new HashMap<>();

    void foods(Customer cust) {
        JsonObject obj = FileHandling.readJsonFile("customer.json");
        if (!obj.keySet().contains(cust.getId())) {
            System.out.println("Enter a Valid Customer");
            return;
        }
        String choice = getFoodMenu();
        int price = foodMenu.get(choice);
        double tab = obj.get("id").getAsJsonObject().get("totalTab").getAsDouble();
        tab += price;
        obj.get("id").getAsJsonObject().remove("totalTab");
        obj.get("id").getAsJsonObject().addProperty("totalTab", tab);


    }

    public static void setFoodMenu() {
        foodMenu.put("Doro Wet", 300);
        foodMenu.put("Siga Firfir", 200);
        foodMenu.put("Agelgil", 400);
        foodMenu.put("Tibs", 300);
    }

    public String getFoodMenu() {
        System.out.println("Choose from the following Menu");
        String input;
        foodMenu.keySet().forEach(i -> {
            System.out.println("Food: " + i + " -> " + foodMenu.get(i));
        });
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter Here -> ");
        input = scan.nextLine();
        scan.close();
        return input;
    }

    public String getHeadChef() {
        return "Name: Head Chef " + this.headChef[0] + " " + this.headChef[1];
    }

    public void setHeadChef(String[] headChef) {
        this.headChef = headChef;
    }

    public String getSueChef() {
        return "Name: Sue Chef " + this.sueChef[0] + " " + this.sueChef[1];
    }

    public void setSueChef(String[] sueChef) {
        this.sueChef = sueChef;
    }

    void restock(String type, int amount) {

    }

}

class Exotics {
    private static double profit = 0.25;
    private static double VAT = 0.15;
    private HashMap<Integer, String> services = new HashMap<>();
    private static HashMap<Integer, Integer> servicePrices = new HashMap<>();

    public Exotics() {
        services.put(1, "Spa");
        services.put(2, "Swimming Pool");
        services.put(3, "Cinema");
        services.put(4, "Gaming Center");
        servicePrices.put(1, 500);
        servicePrices.put(2, 750);
        servicePrices.put(3, 350);
        servicePrices.put(4, 245);
    }

    static void useService(Customer cust) {
        int i = 1;
        System.out.println("\t\t Select from the following services.");
        Exotics serve = new Exotics();
        for (int key : serve.services.keySet()) {
            System.out.println(key + ". " + serve.services.get(key) + ": Birr " + serve.servicePrices.get(key));
        }
        Scanner scan = new Scanner(System.in);
        i = scan.nextInt();
        if (i > 4 || i < 1) {
            System.out.println("Exiting Transaction because of incorrect input");
            return;
        }
        /* here we will add to the price tab of the customer in the file*/
        JsonObject all = FileHandling.readJsonFile("customer.json");
        double total = all.get(cust.getId()).getAsJsonObject().get("totalTab").getAsDouble();
        total += servicePrices.get(i);
        all.get(cust.getId()).getAsJsonObject().remove("totalTab");
        all.get(cust.getId()).getAsJsonObject().addProperty("totalTab", total);
        try (FileWriter writer = new FileWriter("storage/customer.json")) {
            writer.write(all.toString());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
//    void useService() {
//        int i = 1;
//        System.out.println("\t\t Select from the following services.");
//        Exotics serve = new Exotics();
//        for (int key : serve.services.keySet()) {
//            System.out.println(key + ". " + serve.services.get(key) + ": Birr " + serve.servicePrices.get(key));
//        }
//        Scanner scan = new Scanner(System.in);
//        i = scan.nextInt();
//        if (i > 4 || i < 1) {
//            System.out.println("Exiting Transaction because of incorrect input");
//            return;
//        }
//        /* here we will add to the price tab of the customer in the file*/
//        JsonObject all = FileHandling.readJsonFile("customer.json");
//        double total = all.get(cust.getId()).getAsJsonObject().get("totalTab").getAsDouble();
//        total += servicePrices.get(i);
//        all.get(cust.getId()).getAsJsonObject().remove("totalTab");
//        all.get(cust.getId()).getAsJsonObject().addProperty("totalTab", total);
//        try (FileWriter writer = new FileWriter("storage/customer.json")) {
//            writer.write(all.toString());
//        } catch (FileNotFoundException e) {
//            throw new RuntimeException(e);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//
//    }
    
}

