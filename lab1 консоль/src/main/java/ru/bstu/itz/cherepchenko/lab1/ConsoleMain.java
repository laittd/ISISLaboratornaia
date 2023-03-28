package ru.bstu.itz.cherepchenko.lab1;

import java.io.*;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class ConsoleMain {

    public static float[] inputABC() {
        float a, b, c;
        System.out.print("Введите 1 число: ");
        a = getFloat();
        System.out.print("Введите 2 число: ");
        b = getFloat();
        System.out.print("Введите 4 число: ");
        c = getFloat();

        return new float[]{a, b, c};
    }

    public static float[] readFromFile(String path) {
        try {
            File file = new File(path);
            if (!file.exists()) {
                file.createNewFile();
                PrintWriter printWriter = new PrintWriter(file);
                printWriter.println("3 4 5");
                printWriter.close();
            }
            Scanner scanner = new Scanner(file);
            String string = "";
            while (scanner.hasNextLine()) {
                string = scanner.nextLine();
            }
            String[] numbersString = string.split(" ");
            float numbers[] = new float[numbersString.length];
            for (int i = 0; i < numbersString.length; i++) {
                numbers[i] = Float.parseFloat(numbersString[i]);
            }
            return numbers;

        } catch (IOException e) {
            return new float[0];
        }
    }


    static int inputKey() {
        System.out.println("Введите 1, для ввод с клавиатуры, для ввода с файла введите 2... ");
        return getNum();
    }

    static void firstTask() {
        int choice = inputKey();
        float[] abc;
        switch (choice) {
            case 1: {
                abc = inputABC();
            }
            break;
            case 2: {
                abc = readFromFile("notes1.txt");
                ;
            }
            break;
            default:
                return;
        }
        float a = abc[0];
        float b = abc[1];
        float c = abc[2];

        if ((a > b) && (b > c)) {
            System.out.println(
                    "a: " + String.format("%.2f", a * 2) + '\n' +
                            "b: " + String.format("%.2f", b * 2) + '\n' +
                            "c: " + String.format("%.2f", c * 2)
            );
        } else {
            System.out.println(
                    "a: " + String.format("%.2f", Math.abs(a)) + '\n' +
                            "b: " + String.format("%.2f", Math.abs(b)) + '\n' +
                            "c: " + String.format("%.2f", Math.abs(c))

            );
        }
    }

    static int inputDay() {
        System.out.print("Введите день недели: ");
        return getNum();
    }


    private int getSchedule(int dayNumber) {
        switch (dayNumber) {
            case 1:
            case 7: {
                return 0;
            }
            case 2: {
                return 1;
            }
            case 3: {
                return 2;
            }
            case 4:
            case 6: {
                return 3;
            }
            case 5: {
                return 4;
            }
            default:
                return 0;
        }
    }


    private void secondTask() {
        int choice = inputKey();
        int day;
        switch (choice) {
            case 1: {
                day = inputDay();
            }
            break;
            case 2: {
                day = (int) readFromFile("notes2.txt")[0];
            }
            break;
            default:
                return;
        }
        if ((1 <= day) && (day <= 7)) {
            int countClasses = getSchedule(day);
            System.out.printf(
                    "Количество пар: " + countClasses + "\n"
            );
        } else {
            System.out.print("Поле должно быть целым числом, от 1го до 7ми!\n");
        }
    }

    static void thirdTask() {
        Expression expr = new Expression(0, 15);
        final String[] result = {"Результаты расчета функции: "};

        List<Integer> numbers = expr.getAllYs();
        numbers.forEach(y -> result[0] += y + " ");


        if (expr.isSimpleList(numbers)) {
            result[0] += "\n Все числа простые\n";
        } else {
            result[0] += "\n Не все числа простые\n";
        }

        System.out.printf(result[0]);
    }

    static float[] arrayInitialization(int n) {
        if (n > 0) {
            float nums[] = new float[n];
            for (int i = 0; i < nums.length; i++) {
                System.out.print("Введите " + i + " элемент: ");
                nums[i] = getFloat();
            }
            return nums;
        } else {
            System.out.println("Размерность массива не может быть отрицательной!");
            return new float[0];
        }
    }

    static void fourthTask() {
        int choice = inputKey();
        int k;
        float [] arr;
        switch (choice) {
            case 1: {
                System.out.print("Введите K: ");
                k = getNum();
                System.out.print("Введите размерность массива: ");
                int n = getNum();
                arr = arrayInitialization(n);
            }
            break;
            case 2: {
                System.out.print("Введите K: ");
                k = getNum();
                arr = readFromFile("notes4.txt");
            }
            break;
            default:
                return;
        }
        int summary = 0;

        for (float number : arr) {
            if (number % k == 0)
                summary += number;
        }

        System.out.printf("Сумма чисел кратных: " + summary + '\n');
    }

    public static int getNum() {
        Scanner sc = new Scanner(System.in);
        while (!sc.hasNextInt()) {
            System.out.println("Введенно некоректное значение!");
            System.out.print("Введите значение повторно: ");
            sc.next();
        }
        return sc.nextInt();
    }

    public static float getFloat() {
        Scanner sc = new Scanner(System.in);
        while (!sc.hasNextFloat()) {
            System.out.println("Введенно некоректное значение!");
            System.out.print("Введите значение повторно: ");
            sc.next();
        }
        return sc.nextFloat();
    }

    private void tasks() {
        System.out.print("Задача №1  - 1 \nЗадача №2  - 2 \nЗадача №3  - 3 \nЗадача №4  - 4 \nдля выхода нажмите 0 \n");
        boolean run = true;
        while (run) {
            System.out.print("Введите номер задания: ");
            int choice = getNum();
            switch (choice) {
                case 1: {
                    System.out.println("Первое задание.");
                    firstTask();
                }
                break;

                case 2: {
                    System.out.println("Второе задание.");
                    secondTask();
                }
                break;

                case 3: {
                    System.out.println("Третье задание.");
                    thirdTask();
                }
                break;

                case 4: {
                    System.out.println("Четвертое задание.");
                    fourthTask();
                }
                break;
                default: {
                    System.out.println("Введенно неверное значение! Внесение изминений");
                }
                break;

                case 0: {
                    run = false;
                }
            }
        }
    }

    public static void main(String[] args) {
        new ConsoleMain().tasks();
    }
}
