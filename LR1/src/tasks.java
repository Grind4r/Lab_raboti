public class tasks {
    import java.util.Scanner;
    /**
     * @author PamaninM
     * @version 11010000.10011111.11010000.10110000.11010000.10111100.11010000.10110000.11010000.10111101.11010000.10111000.11010000.10111101
     */
    public class Main {
        public static void main(String args[]) {
            System.out.print(prim_1(0, 500));
            System.out.print(prim_2("make","install"));
            System.out.print(prim_3(""));
            System.out.print("\nПример 4\nФакториал 5 = \n"+prim_4(5)+"\nПример 4 завершен");
            System.out.print(iz(0,0,0));
        }
        /**@param – а и b передают границы работы функции, где а - начало ряда, а b - конец ряда;
         * @return – Возвращает строку сообщение о завершении операции;
         * Программа, в которой перебираются числа от 1 до 500 и выводятся на экран.
         * Если число делится на 5, то вместо него выводится слово fizz, если на 7, то buzz*/
        public static String prim_1(int a, int b) {
            System.out.println("Пример 1");
            while (++a <= b) {
                if (a % 5 != 0 && a % 7 != 0) {
                    System.out.print(a);
                } else {
                    if (a % 5 == 0)
                        System.out.print("Fizz");
                    if (a % 7 == 0)
                        System.out.print("Buzz");
                }
                System.out.println();
            }
            String s="Пример 1 завершен\n";
            return s;
        }
        /**@param – а1 и b1 передают дефолтные значения (как в условии) на случай если ничего не ввели;
         * @return – Возвращает строку сообщение о завершении операции;
        Программа, в которой все переданные во входную строку аргументы выводятся на экран в обратной порядке.
        Например, если было передано 2 аргумента – make install, то на экран должно вывестись llatsni ekam. * */
        public static String prim_2(String a1,String b1) {
            System.out.println();
            System.out.println("Пример 2");
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите 1е слово");
            String a = scanner.nextLine();
            System.out.println("Введите 2е слово");
            String b = scanner.nextLine();
            if (a=="")
            {a=a1;}
            if (b=="")
            {b=b1;}
            String vhs = a+" "+b;
            System.out.println("Входная строка: " + vhs);
            char simv;
            String vihs="";
            for (int i=0; i<vhs.length(); i++)
            {
                simv= vhs.charAt(i);
                vihs= simv+vihs;
            }
            System.out.println("Выходная строка: " + vihs);
            String s="Пример 2 завершен\n";
            return s;
        }
        /**@return – Возвращает строку сообщение о завершении операции;
         *  Создайте программу, вычисляющую числа Фибоначчи. Размер ряда вводит пользователь*/
        public static String prim_3(String a) {
            System.out.println();
            System.out.println("Пример 3");
            int c=0;
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите размер ряда");
            if(scanner.hasNextInt()) { // возвращает истинну если с потока ввода можно считать целое число
                c = scanner.nextInt(); // считывает целое число с потока ввода и сохраняем в переменную
            } else {
                System.out.println("Вы ввели не целое число");
            }
            int n0 = 1;
            int n1 = 1;
            int n2;
            System.out.print(n0+" "+n1+" ");
            for(int i = 3; i <= c; i++){
                n2=n0+n1;
                System.out.print(n2+" ");
                n0=n1;
                n1=n2;
            }
            System.out.println();
            String s="Пример 3 завершен\n";
            return s;
        }
        /**@param – f передает число, факториал которого нужно найти (для примера 5);
         * @return – возвращает значение числа(-1) обратно в функцию (рекурсия);
         * Программа вычисляющая факторипл числа, для примера 5, число передается в main*/
        public static int prim_4(int f) {

            if (f <= 1) {
                return 1;
            }
            else {
                return f * prim_4(f - 1);
            }
        }
        /**@return – Возвращает строку сообщение о завершении операции;
         *  Ввести с консоли 3 целых числа. На консоль вывести: Если их значения упорядочены по возрастанию,
         *  то удвоить их; в противном случае заменить значение каждой переменной на противоположное. */
        public static String iz(int a1,int b2, int c3) {
            int a=0;int b=0;int c=0;
            System.out.println();
            System.out.println("Индивидуальное задание: ");
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите 1е число");
            if(scanner.hasNextInt()) { // возвращает истинну если с потока ввода можно считать целое число
                a = scanner.nextInt();
                System.out.println("Введите 2е число");
                if(scanner.hasNextInt()) { // возвращает истинну если с потока ввода можно считать целое число
                    b = scanner.nextInt(); // считывает целое число с потока ввода и сохраняем в переменную
                    System.out.println("Введите 3е число");
                    if (scanner.hasNextInt()) { // возвращает истинну если с потока ввода можно считать целое число
                        c = scanner.nextInt();
                        System.out.println("Входной ряд: " + a + " " + b + " " + c);
                        if (a < b && b < c) {
                            a = a * 2;
                            b = b * 2;
                            c = c * 2;
                            System.out.println("Выходной ряд: " + a + " " + b + " " + c);
                        } else {
                            a = -a;
                            b = -b;
                            c = -c;
                            System.out.println("Выходной ряд: " + a + " " + b + " " + c);
                        } // считывает целое число с потока ввода и сохраняем в переменную
                    }
                    else {
                        System.out.println("Вы ввели не целое число (3e)");
                    }
                }
                else {
                    System.out.println("Вы ввели не целое число (2e)");
                }
            }
            else {
                System.out.println("Вы ввели не целое число (1e)");
            }

            System.out.println();
            String s="Индивидуальное задание завершенo\n";
            return s;
        }
    }

}
