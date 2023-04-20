package hotel;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.File;


public class Main extends Menu {
    public static void main(String[] args) {
        System.out.println(FileHandling.returnSpecific("room.json", "Presidential", "price"));
    }
}