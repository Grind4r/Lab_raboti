import java.util.Scanner;

/**
 * @author <strong>Pamanin Maksim</strong>
 * @version 0.0.1
 * @since 0.0.1
 */

public class main {

    /**
     * Код для запуска программы и выбора методов
     * @param args the command line arguments
     */

    public static void main(String[] args) {
        // TODO code application logic here
        tasks lab2 = new tasks();
        boolean isQuit = false;
        while (!isQuit) {
            int n;
            System.out.println("Запуск задания: \n 1 - Расчитать формулу | 2 - Сокращение записи | 3 - Количество целых чисел | 4 - Построение треугольника|\n 5 - Деление числа на 4 | 6 - Числа Пифагора | 7 - Сумма членов ряда | 8 - Расписание | 0 - Выход");
            Scanner in = new Scanner(System.in);
            n = in.nextInt();
            switch (n) {
                case 1:
                    lab2.task1();
                    break;
                case 2:
                    lab2.task2();
                    break;
                case 3:
                    lab2.task3();
                    break;
                case 4:
                    lab2.task4();
                    break;
                case 5:
                    lab2.task5();
                    break;
                case 6:
                    lab2.task6();
                    break;
                case 7:
                    lab2.task7();
                    break;
                case 8:
                    lab2.task8();
                    break;
                case 0:
                    isQuit = true;
                    System.out.print("Работа завершена!");
                    break;
                default:
                    System.out.print("Такого режима нет");
            }
        }
    }
}

