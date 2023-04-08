import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static java.lang.Math.*;
public class tasks {
    Scanner in = new Scanner(System.in);
    // построчное считывание файла
    /**
     * Метод ReadFile, для считывания данных из файла
     * Этот метод вернет нужную строку из файла.
     * @param position желаемый номер строки.
     * @return word - нужная нам строка.
     */
    public static String ReadFile(int position){
        String word="";
        int i=0;
        Scanner sc;

        try {
            sc = new Scanner(new File("D:/Программы/Java/LR3dates.txt"));

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        while (i!=position) {
            i++;
            sc.nextLine();
            if(i==position){
                word=sc.nextLine();
            }
        }
        return word;
    }
    /**
     Метод записывает переменные из строки в массив
     * @param word требуемый номер строки.
     * @param count количество нужных переменных.
     * Переменные @return - массив переменных.
     */
    public static float[] split(String word, int count){
        float[] variables = new float[count];
        String[] arrSplit = word.split(" ");
        for (int i=0; i<count; i++) variables[i] = Float.parseFloat(arrSplit[i]);
        return variables;
    }
    /**Вычислить значения выражения по формуле*/
    public void task1(){
        float x=0;
        float y=0;
        double result;
        System.out.println();
        System.out.println("Задание 1");
        System.out.println("Выберите ввод: 1 - из файла 2 - с клавиатуры");
        int n = in.nextInt();
        switch (n) {
            case 1:{
                float [] variables = new float[2];
                variables=split(ReadFile(1), 2);
                System.out.println("x = "+variables[0]);
                System.out.println("y = "+variables[1]);
                x= variables[0];y = +variables[1];
            }
            ;break;
            case 2: {
                System.out.println("Введите x");
                x = in.nextFloat();
                System.out.println("Введите y");
                y = in.nextFloat();
                break;
            }
            default: System.out.println("Такого режима нет");
                return;
        }
        result= x*log(x)+y/(cos(x)-(x/3));
        System.out.println("Результат выполнения: " + result);
        System.out.println("Задание 1 завершено\n");
    }
    /**Дано действительное число x.
     Не пользуясь никакими другими арифметическими операциями, кроме умножения, сложения и вычитания,
     вычислить за минимальное число операций 2x4 - Зх3 + 4x2 – 5х + 6*/
    public void task2(){
        float x=0;
        double result;
        System.out.println();
        System.out.println("Задание 2");
        System.out.println("Выберите ввод: 1 - из файла 2 - с клавиатуры");
        int n = in.nextInt();
        switch (n) {
            case 1:{
                x = Float.parseFloat(ReadFile(2));
                System.out.println("x = "+x);}
            break;
            case 2: {
                System.out.println("Введите x");
                x = in.nextFloat();
            }
            break;
            default: System.out.println("Такого режима нет");
                return;
        }
        result= 2*x+6;
        System.out.println("Результат сокращения (2x4 - Зх3 + 4x2 – 5х + 6) выполнения: " + result);
        System.out.println("Задание 2 завершено\n");
    }
    /**Подсчитать количество целых чисел среди чисел a, b, с.*/
    public void task3(){
        float []a = new float [3];
        double result;
        int k=0;
        System.out.println();
        System.out.println("Задание 3");
        System.out.println("Выберите ввод: 1 - из файла 2 - с клавиатуры");
        int n = in.nextInt();
        switch (n) {
            case 1:{
                a=split(ReadFile(3), 3);
                System.out.println("a = "+a[0]);
                System.out.println("b = "+a[1]);
                System.out.println("c = "+a[2]);
            }
            break;
            case 2: {
                System.out.println("Введите a");
                a[0] = in.nextFloat();
                System.out.println("Введите b");
                a[1] = in.nextFloat();
                System.out.println("Введите c");
                a[2] = in.nextFloat();
            }break;
            default: System.out.println("Такого режима нет");
                return;
        }
        for (int i =0;i<3;i++){
            if (a[i] % 1 == 0){ /*проверка числа на целостность*/
                k++;
            }
        }
        System.out.println("Количество целых чисел : " + k);
        System.out.println("Задание 3 завершено\n");
    }
    /**Даны три положительных числа.
     Определить, можно ли построить треугольник с длинами сторон, равным этим числам.
     Если можно, то ответить на вопрос, является ли он остроугольным.*/
    public void task4() {
        float a=0;
        float b=0;
        float c=0;
        boolean possible = false;
        System.out.println();
        System.out.println("Задание 4");
        System.out.println("Выберите ввод: 1 - из файла 2 - с клавиатуры");
        int n = in.nextInt();
        switch (n) {
            case 1: {
                float[] variables = new float[3];
                variables = split(ReadFile(4), 3);
                a = variables[0];
                b = variables[1];
                c = variables[2];
                System.out.println("a = " + a);
                System.out.println("b = " + b);
                System.out.println("c = " + c);
            }
            break;
            case 2: {
                System.out.println("Введите a");
                a = in.nextFloat();
                System.out.println("Введите b");
                b = in.nextFloat();
                System.out.println("Введите c");
                c = in.nextFloat();
            } break;
            default: System.out.println("Такого режима нет");
                return;
        }
        if (a + b > c && a + c > b && b + c > a) {
            possible = true; /*Переменная обозначающая возможность построения трекгольника*/
            System.out.println("Построение возможно");
        } else {
            System.out.println("Построение не возможно");
        }
        if (possible == true) {
            if (pow(a, 2) + pow(b, 2) > pow(c, 2)
            ) {
                System.out.println("Треугольник остроугольный");
            }
            if (pow(a, 2) + pow(b, 2) == pow(c, 2)) {
                System.out.println("Треугольник прямоугольный");
            }
            if (pow(a, 2) + pow(b, 2) < pow(c, 2)) {
                System.out.println("Треугольник тупоугольный");
            }
        }
        System.out.println("Задание 4 завершено\n");
    }

    /**Дано натуральное число N. Если оно делится на 4,
     вывести на экран ответ N = 4k (где k — соответствующее частное); если остаток от деления на 4 равен 1,
     N = 4k + 1; если остаток от деления на 4 равен 2, N = 4k + 2; если остаток от деления на 4 равен 3,
     N = 4k + 3. Например, 12 = 43, 22 = 45 + 2.(switch) */
    public void task5(){
        int n=0;
        float res=0;
        float chastn=0;
        int variant=0;
        System.out.println();
        System.out.println("Задание 5");
        System.out.println("Выберите ввод: 1 - из файла 2 - с клавиатуры");
        int k = in.nextInt();
        switch (k) {
            case 1:{
                n = Integer.parseInt(ReadFile(5));
                System.out.println("n = "+n);
            }break;
            case 2: {
                System.out.println("Введите N");
                n = in.nextInt();
                break;
            }
            default: System.out.println("Такого режима нет");
                return;
        }
        chastn=n/4;
        switch (n%4) {
            case 0:
                System.out.println("Результат : 4" + chastn);
                break;
            case 1:
                System.out.println("Результат : 4" + chastn+"1");
                break;
            case 2:
                System.out.println("Результат : 4" + chastn + "+2");
                break;
            case 3:
                System.out.println("Результат : 4" + chastn + "+3");
                break;
        }
        System.out.println("Задание 5 завершено\n");
    }
    /** Натуральные числа a, b, с называются числами Пифагора,
     если выполняется условие а2 + b2 = с2. Напечатать все числа Пифагора, меньшие N */
    public void task6(){
        int N=0;
        int a;
        int b;
        int c;
        System.out.println();
        System.out.println("Задание 6");
        System.out.println("Выберите ввод: 1 - из файла 2 - с клавиатуры");
        int k = in.nextInt();
        switch (k) {
            case 1:{
                N = Integer.parseInt(ReadFile(6));
                System.out.println("N = "+N);}
            break;
            case 2: {
                System.out.println("Введите N");
                N = in.nextInt();
            }break;
            default: System.out.println("Такого режима нет");
                return;
        }
        for (a=1;a<N;a++){
            for (b=1;b<N;b++){
                for (c=1;c<N;c++){
                    if (pow(a,2)+pow(b,2)==pow(c,2)){ /*Условие для подбора чисел, удовлетворяющих условию чисел Пифагора*/
                        System.out.println("Числа Пифагора : "+a+", "+b+", "+c);
                    }
                }
            }
        }
        System.out.println("Задание 6 завершено\n");
    }//Дублирования catch (IOException e)
    /**Функция вычисляющая факториал.
     * @param – f передает число, факториал которого нужно найти;
     * @return – возвращает значение числа f (-1) обратно в функцию (рекурсия);
     */
    public static float fact(float f) {

        if (f <= 1) {
            return 1;
        }
        else {
            return f * fact(f - 1);
        }
    }
    /**Дано натуральное число n и действительное x. Найти сумму n членов ряда*/
    public void task7(){
        float n=0;
        float x=0;
        double s=0;
        double res=0;
        float [] variables = new float[2];
        System.out.println();
        System.out.println("Задание 7");
        System.out.println("Выберите ввод: 1 - из файла 2 - с клавиатуры");
        int k = in.nextInt();
        switch (k) {
            case 1:{
                variables=split(ReadFile(7), 2);
                System.out.println("N = "+variables[0]);n=variables[0];
                System.out.println("x = "+variables[1]);x=variables[1];
            };break;
            case 2: {
                System.out.println("Введите n");
                n = in.nextInt();
                System.out.println("Введите x");
                x = in.nextFloat();
            }break;
            default: System.out.println("Такого режима нет");
                return;
        }
        for (int i =1;i<n;i++){
            s=pow((-1),(n-1))*((pow(x,(2*n-1)))/fact(2*n-1));
            res= res+s;
        }
        System.out.println("Cумма членов ряда : "+res);
        System.out.println("Задание 7 завершено\n");
    }//Дублирования catch (IOException e)
    /** В учебном заведении задается начало учебного дня, продолжительность «пары» или урока,
     продолжительность обычного и большого перерывов (и их «место» в расписании), количество пар (уроков).
     Получить расписание звонков на весь учебный день. */
    public void task8(){
        System.out.println("Задание 8");
        float statrhours=0;
        float startminutes=0;
        float duration=0;
        float smallinterval=0;
        float bigllinterval=0;
        float count=0;
        float bigintervalposition=0;
        System.out.println("Выберите ввод: 1 - из файла 2 - с клавиатуры");
        int n = in.nextInt();
        switch (n) {
            case 1:{
                float [] variables = new float[7];
                variables=split(ReadFile(8), 7);
                System.out.println("Время начала уроков: "+variables[0]+":"+variables[1]);
                statrhours = variables[0];startminutes = variables[1];
                System.out.println("Длительность урока : "+variables[2]);
                duration=variables[2];
                System.out.println("Длительность обычной перемены: "+variables[3]);
                smallinterval =variables[3];
                System.out.println("Длительность большой перемены: "+variables[4]);
                smallinterval =variables[4];
                System.out.println("Позиция большой перемены: "+variables[5]);
                bigintervalposition=variables[6];
                System.out.println("Kоличество уроков: "+variables[6]);
                count=variables[6];
            };break;
            case 2: {
                System.out.println("Введите время начала уроков: ");
                statrhours = in.nextInt();System.out.print(" : ");startminutes = in.nextInt();
                System.out.println("Введите длительность урока : ");
                duration = in.nextInt();
                System.out.println("Введите длительность обычной перемены: ");
                smallinterval = in.nextInt();
                System.out.println("Введите длительность большой перемены: ");
                bigllinterval = in.nextInt();
                System.out.println("Введите позицию большой перемены: ");
                bigintervalposition= in.nextInt();
                System.out.println("Введите количество уроков: ");
                count = in.nextInt();
            }
            break;
            default: System.out.println("Такого режима нет");
                return;
        }
        if (count<bigintervalposition)
        {
            System.out.println("Ошибка в расположении перемены"); /*Так как большая перемена не может быть дальше, чем общее количество уроков*/
            return;
        }
        float minutes = startminutes;
        for (int i=1;i<=count;i++){
            System.out.println("");
            System.out.println(i+" -я пара: ");
            System.out.println(statrhours+" : "+minutes+" - ");
            minutes = minutes+duration;
            if (minutes>=60){ /*Перевод минут в часы*/
                float hours= minutes/60; /*Вычисление целых часов*/
                minutes=minutes-hours*60; /*Вычисления остатка минут*/
                statrhours+=hours;/*Подсчет общих часов уроков*/
            }
            System.out.println(statrhours+" : "+minutes+" - ");
            if (i==bigintervalposition){
                minutes +=bigllinterval;
                if (minutes>=60){/*Перевод минут в часы*/
                    float hours= minutes/60;/*Вычисление целых часов*/
                    minutes=minutes-hours*60;/*Вычисления остатка минут*/
                    statrhours+=hours;/*Подсчет общих часов уроков*/
                }
                System.out.println("Перерыв");
            }
            else{
                minutes +=smallinterval;
                if (minutes>=60){/*Перевод минут в часы*/
                    float hours= minutes/60;/*Вычисление целых часов*/
                    minutes=minutes-hours*60;/*Вычисления остатка минут*/
                    statrhours+=hours; /*Подсчет общих часов уроков*/
                }

                System.out.println("Перерыв");
            }
            System.out.println("Задание 8 завершено\n");//Дублирования catch (IOException e)
        }}}
