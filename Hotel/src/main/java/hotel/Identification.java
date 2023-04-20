package hotel;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class Identification {
    public static int getId() {
        JsonParser parser = new JsonParser();
        int current;
        // read the next available id that is going to be given to the next object with person type
        try(FileReader file = new FileReader("storage/id.json")){
            JsonObject obj = (JsonObject) parser.parse(file);
            current = FileHandling.returnSpecific("id.json", "id").getAsInt();
            //update the id in the file
            obj.remove("id");
            obj.addProperty("id", current + 1);
            FileWriter writer = new FileWriter("storage/id.json");
            writer.write(obj.toString());
            writer.close();

        }catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return current;
    }

    public static void main(String[] args) {
        System.out.println(getId());
    }
}
