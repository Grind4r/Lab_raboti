import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import java.util.InputMismatchException;
import java.util.Scanner;
/**
 * @author <strong>Pamanin Maksim</strong>
 * @version 0.0.1
 * @since 0.0.1
 */

public class main {
    private static final Logger logger = LogManager.getLogger(main.class);

    /**
     * Код для запуска программы и выбора методов (main)
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            logger.info("Метод main начал выполнение");
            tasks lab3 = new tasks();
            boolean isQuit = false;
            while (!isQuit) {
                int n;
                System.out.println("Запуск задания: \n " +
                        "1 - Расчитать формулу | 2 - Сокращение записи | 3 - Количество целых чисел " +
                        "| 4 - Построение треугольника|\n " + "5 - Деление числа на 4 | 6 - Числа Пифагора " +
                        "| 7 - Сумма членов ряда | 8 - Расписание | 0 - Выход");
                n = in.nextInt();
                logger.debug("Выбор пользователя принят");
                switch (n) {
                    case 1:
                        logger.debug("Запуск метода task1");
                        lab3.task1();
                        break;
                    case 2:
                        logger.debug("Запуск метода task2");
                        lab3.task2();
                        break;
                    case 3:
                        logger.debug("Запуск метода task3");
                        lab3.task3();
                        break;
                    case 4:
                        logger.debug("Запуск метода task4");
                        lab3.task4();
                        break;
                    case 5:
                        logger.debug("Запуск метода task5");
                        lab3.task5();
                        break;
                    case 6:
                        logger.debug("Запуск метода task6");
                        lab3.task6();
                        break;
                    case 7:
                        logger.debug("Запуск метода task7");
                        lab3.task7();
                        break;
                    case 8:
                        logger.debug("Запуск метода task8");
                        lab3.task8();
                        break;
                    case 0:
                        isQuit = true;
                        logger.debug("Завершение работы метода main");
                        System.out.print("Работа завершена!");
                        break;
                    default:
                        logger.error("Такого режима нет. Попробуйте выбрать режим заново.");
                        System.out.print("Такого режима нет");
                }
            }
        }
        catch (InputMismatchException e)
        {
            logger.fatal("Ошибка " + e + "! Не соответствие типов данных!");
        }
    }
}

