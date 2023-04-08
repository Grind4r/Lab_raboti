import java.io.*;
import java.util.*;
import java.util.regex.*;
/**
    * @author Pamanin
    * @version 1.0
 **/
/** На вход программы подается произвольный текстовый файл,
  необходимо извлечь из него все пароли, которые удовлетворяют условию
  - от 8 до 15 символов
  - минимум одна цифра
  - минимум одна заглавная буква
  - минимум одна строчная буква.
  Напротив каждого подходящего пароля указать число повторений. Результат сохранить в файл.**/
public class Main {
    public static void main(String[] args) {
        //Указание входных и выходных данных
        String inputFile = "D:\\Программы\\Java\\LR_4\\src\\input.txt";
        String outputFile = "D:\\Программы\\Java\\LR_4\\src\\output.txt";
        // регулярное выражение (мининмум 1 цифра, строчная и заглавная буква только английского языка)
        String regex = "(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])[a-zA-Z\\d]{8,15}";
        // Копирование рег. выражения для ускорения дальнейшего поиска
        Pattern pattern = Pattern.compile(regex);
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            //Хранение паролей и количества повторений в порядке чтения
            Map<String, Integer> passwords = new LinkedHashMap<>(); //
            String line = reader.readLine();
            //Считывание файла, запись в строку, проверка с использованием рег. выражений
            while (line != null) {
                Matcher matcher = pattern.matcher(line);
                while (matcher.find()) {
                    String password = matcher.group();
                    int count = passwords.getOrDefault(password, 0);
                    passwords.put(password, count + 1);
                }
                line = reader.readLine();
            }
            System.out.println("Поиск паролей...");
            // Вывод результатов и запись в выходной файл
            for (String password : passwords.keySet()) {
                int count = passwords.get(password);
                System.out.println("Пароль: "+ password + " . "+" Повторено "+ count +" раз");
                writer.write("Пароль: "+ password + " . "+" Повторено "+ count +" раз\n");
            }

            System.out.println("Пароли записаны в:  " + outputFile);
        } catch (IOException e) {
            System.err.println("Ошибка открытия файла: " + e.getMessage());
        }
    }
} 