package hotel;

import com.google.gson.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileHandling {
    private final static String notWritable = "room.json";
    private static String root = "storage/";

    /**
     * <p> this method writes json representation of an object to a file</p>
     *
     * @param obj the Customer object to be written to the customer.json file
     * @return void
     */
    static void writeJsonString(Customer obj) {
        String file = "customer.json";
        if (file.equals(FileHandling.notWritable)) {
            System.out.println("Cannot write to the file provided");
            return;
        }
        String location = root + file;
        Gson gfile = new Gson();
        JsonParser jParse = new JsonParser();

        try {
            JsonObject jObj = (JsonObject) jParse.parse(new FileReader(location));
            if (jObj.keySet().contains(obj.getId())) {
                System.out.println("Cannot add object to file. Object already exists in the file");
                return;
            }
            jObj.add(obj.getId(), JsonParser.parseString(gfile.toJson(obj)));
            FileWriter somet = new FileWriter(location, false);
            somet.write(jObj.toString());
            somet.close();
            System.out.println(jObj);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static void writeJsonString(Employee obj) {
        String file = "employee.json";
        String location = root + file;
        Gson gfile = new Gson();
        JsonParser jParse = new JsonParser();

        try {
            JsonObject jObj = (JsonObject) jParse.parse(new FileReader(location));
            if (jObj.keySet().contains(obj.getId())) {
                System.out.println("Cannot add object to file. Object already exists in the file");
                return;
            }
            jObj.add(obj.getId(), JsonParser.parseString(gfile.toJson(obj)));
            FileWriter somet = new FileWriter(location, false);
            somet.write(jObj.toString());
            somet.close();
            System.out.println(jObj);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static void writeJsonString(Manager obj) {
        String file = "manager.json";
        if (file.equals(FileHandling.notWritable)) {
            System.out.println("Cannot write to the file provided");
            return;
        }
        String location = root + file;
        Gson gfile = new Gson();
        JsonParser jParse = new JsonParser();

        try {
            JsonObject jObj = (JsonObject) jParse.parse(new FileReader(location));
            if (jObj.keySet().contains(obj.getId())) {
                System.out.println("Cannot add object to file. Object already exists in the file");
                return;
            }
            jObj.add(obj.getId(), JsonParser.parseString(gfile.toJson(obj)));
            FileWriter somet = new FileWriter(location, false);
            somet.write(jObj.toString());
            somet.close();
            System.out.println(jObj);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static void writeRequestString(String file, JsonObject obj) {
        if (file.equals(FileHandling.notWritable)) {
            System.out.println("Cannot write to the file provided");
            return;
        }
        String location = root + file;
        Gson gfile = new Gson();
        JsonParser jParse = new JsonParser();

        try {
            JsonObject jObj = (JsonObject) jParse.parse(new FileReader(location));
            String id = obj.get("id").getAsString();
            obj.remove("id");
            jObj.add(id, JsonParser.parseString(gfile.toJson(obj)));
            FileWriter somet = new FileWriter(location, false);
            somet.write(jObj.toString());
            somet.close();
            System.out.println(jObj);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    /**
     * readJsonFile - Gives the appropriate information contained in the specified file
     *
     * @param file: file to be read from
     * @return all objects appropriate information
     */
    static JsonObject readJsonFile(String file) {
        String location = "storage/" + file;
        JsonParser parser = new JsonParser();
        try (FileReader read = new FileReader(location)) {
            JsonObject obj = (JsonObject) parser.parse(read);
            return obj;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static JsonElement returnSpecific(String file, String first, String... rest) {
        JsonParser parser = new JsonParser();
        JsonElement last;
        try {
            JsonObject parseable = (JsonObject) parser.parse(new FileReader(root + file));
            if (parseable.get(first) instanceof JsonPrimitive)
                return parseable.get(first);
            parseable = (JsonObject) parseable.get(first);
            for (int i = 0; i < rest.length - 1; i++) {
                parseable = (JsonObject) parseable.get(rest[i]);
            }
            last = (JsonElement) parseable;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return last;
    }

    static void upgradeJsonFile(String file, JsonObject obj) {
        try {
            FileWriter write = new FileWriter(root + file);
            write.write(obj.toString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }


}
