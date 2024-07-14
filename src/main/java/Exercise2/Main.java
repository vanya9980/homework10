package Exercise2;

import java.io.IOException;
import java.util.List;

class Main {
    public static void main(String[] args) {
        String inputFilePath = "src\\main\\java\\Exercise2\\file.txt";
        String outputFilePath = "src\\main\\java\\Exercise2\\user.json";

        try {
            // Парсити файл і отримати список користувачів
            List<User> users = UserParser.parseUsers(inputFilePath);

            // Записати список користувачів у файл JSON
            UserJsonWriter.writeUsersToJson(users, outputFilePath);

            System.out.println("Users have been successfully written to " + outputFilePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
