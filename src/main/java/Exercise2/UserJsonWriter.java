package Exercise2;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

class UserJsonWriter {
    public static void writeUsersToJson(List<User> users, String filePath) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        FileWriter writer = new FileWriter(filePath);
        gson.toJson(users, writer);
        writer.close();
    }
}
