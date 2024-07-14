package Exercise1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

class PhoneNumberValidator {

    // Метод для перевірки валідності номера телефону
    public static boolean isValidPhoneNumber(String phoneNumber) {
        // Регулярні вирази для заданих форматів
        String regex1 = "\\(\\d{3}\\) \\d{3}-\\d{4}";
        String regex2 = "\\d{3}-\\d{3}-\\d{4}";

        // Компіляція регулярних виразів
        Pattern pattern1 = Pattern.compile(regex1);
        Pattern pattern2 = Pattern.compile(regex2);

        // Створення матчера для перевірки номеру телефону
        Matcher matcher1 = pattern1.matcher(phoneNumber);
        Matcher matcher2 = pattern2.matcher(phoneNumber);

        // Перевірка чи номер відповідає одному з форматів
        return matcher1.matches() || matcher2.matches();
    }

    // Метод для читання файлу і виводу валідних номерів телефонів
    public static void printValidPhoneNumbers(String fileName) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Видаляємо зайві пробіли на початку та в кінці рядка
                line = line.trim();
                // Перевірка валідності номеру телефону
                if (isValidPhoneNumber(line)) {
                    System.out.println(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // Назва файлу
        String fileName = "src\\main\\java\\Exercise1\\file.txt";
        // Виклик методу для виводу валідних номерів телефонів
        printValidPhoneNumbers(fileName);
    }
}