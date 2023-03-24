package ru.bstu.itz.cherepchenko.lab1;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import javafx.scene.control.Label;

import java.util.List;

public class Main extends Application {

    boolean tryParseFloat(String... value) {
        try {
            for (String str : value) {
                Float.parseFloat(str);
            }
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    boolean tryParseInt(String... value) {
        try {
            for (String str : value) {
                Integer.parseInt(str);
            }
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }


    static int getSchedule(int dayNumber) {
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


    @Override
    public void start(Stage primaryStage) throws Exception {
        /*Задание №1*/
        Label task1 = new Label("Задание №1");
        Label task1Label1 = new Label("Первое число");
        Label task1Label2 = new Label("Второе число");
        Label task1Label3 = new Label("Третье число");
        Label label = new Label("Ответ:\n");
        TextField task1textField1 = new TextField();
        TextField task1textField2 = new TextField();
        TextField task1textField3 = new TextField();
        task1textField1.setPrefColumnCount(17);
        Button button1 = new Button("Удвоить");
        button1.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                boolean flag = tryParseFloat(task1textField1.getText(), task1textField2.getText(), task1textField3.getText());
                if (flag) {
                    float a = Float.parseFloat(task1textField1.getText());
                    float b = Float.parseFloat(task1textField2.getText());
                    float c = Float.parseFloat(task1textField3.getText());

                    if ((a > b) && (b > c))
                        label.setText(
                                "a: " + String.format("%.2f", a * 2) + '\n' +
                                        "b: " + String.format("%.2f", b * 2) + '\n' +
                                        "c: " + String.format("%.2f", c * 2)
                        );
                    else
                        label.setText(
                                        "a: " + String.format("%.2f", Math.abs(a)) + '\n' +
                                        "b: " + String.format("%.2f", Math.abs(b)) + '\n' +
                                        "c: " + String.format("%.2f", Math.abs(c))
                        );
                } else {
                    label.setText("Поля должны быть числами!");
                }
            }
        });

        /*Задание №2*/
        Label task2 = new Label("Задание №2");
        Label task2Label1 = new Label("Введите день недели");
        TextField task2textField1 = new TextField();
        Button button2 = new Button("Посмотреть расписание");
        button2.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                String text = task2textField1.getText();
                boolean flag = tryParseInt(text);
                int dayNumber = Integer.parseInt(text);
                if (flag && ((1 <= dayNumber) && (dayNumber <= 7))) {
                    int countClasses = getSchedule(dayNumber);
                    label.setText(
                            "Количество пар: " + countClasses
                    );
                } else {
                    label.setText("Поле должно быть целым числом, от 1го до 7ми!");
                }
            }
        });

        /*Задание №3*/
        Label task3 = new Label("Задание №3");
        Button button3 = new Button("Проверить  x2 + x + 17 на 0<x<15");
        button3.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                Expression expr = new Expression(0, 15);
                final String[] result = {"Результаты расчета функции: "};

                List<Integer> numbers = expr.getAllYs();
                numbers.forEach(y -> result[0] += y + " ");


                if (expr.isSimpleList(numbers)) {
                    result[0] += "\n Все числа простые";
                } else {
                    result[0] += "\n Не все числа простые";
                }

                label.setText(result[0]);
            }
        });


        /*Задание №4*/
        Label task4 = new Label("Задание №4");
        Label task4Label2 = new Label("Введите K");
        TextField task4textField2 = new TextField();
        Label task4Label1 = new Label("Введите элементы массива");
        TextField task4textField1 = new TextField();
        Button button4 = new Button("Press");
        button4.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                boolean flagArray = tryParseInt(task4textField1.getText().split(" "));
                boolean flagK = tryParseInt(task4textField2.getText());
                if (flagArray && flagK) {
                    if (task4textField1.getText() != "") {
                        int summary = 0;

                        int k = Integer.parseInt(task4textField2.getText());
                        String[] numbersString = task4textField1.getText().split(" ");

                        for (String number : numbersString) {
                            int casted_number = Integer.parseInt(number);
                            if (casted_number % k == 0)
                                summary += casted_number;
                        }

                        label.setText("Сумма чисел кратных: " + summary);
                    }
                } else {
                    label.setText("Поля должны быть целыми числами!");
                }
            }
        });


        FlowPane root = new FlowPane(Orientation.VERTICAL, 10, 10,
                task1,
                task1Label1,
                task1textField1,
                task1Label2,
                task1textField2,
                task1Label3,
                task1textField3,
                button1,
                label
        );
        FlowPane root2 = new FlowPane(Orientation.VERTICAL, 10, 10,
                task2,
                task2Label1,
                task2textField1,
                button2);
        FlowPane root3 = new FlowPane(Orientation.VERTICAL, 10, 10,
                task3,
                button3);

        FlowPane root4 = new FlowPane(Orientation.VERTICAL, 10, 10,
                task4,
                task4Label2,
                task4textField2,
                task4Label1,
                task4textField1,
                button4);

        HBox hBox = new HBox(root, root2, root3, root4);
        hBox.setPadding(new Insets(10));
        hBox.setSpacing(30);
        hBox.setMinWidth(220);

        Scene scene = new Scene(hBox, 850, 400);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Лабораторняа №1 Черепченко Юрий Сергеевич");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
