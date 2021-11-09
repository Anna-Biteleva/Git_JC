package Lesson_7.project;
import java.io.IOException;
import java.util.Scanner;

public class UserInterfaceView {
    private Controller controller = new Controller();

    public void runInterface() throws NumberFormatException {
        Scanner scanner = new Scanner(System.in);

        while (true) {

            System.out.println("Введите 1 для получения погоды на сегодня;" +
                    "Введите 5 для прогноза на 5 дней;  Для выхода введите 0:");

            String command = scanner.nextLine();

            //TODO* Сделать метод валидации пользовательского ввода
            if (command.equals("0")) break;

            else if (!(command.equals("1") || command.equals("5"))) {
                System.out.println("Введено некорректное значение");
                continue;}

            System.out.println("Введите название города: ");
            String city = scanner.nextLine();


                try {
                    controller.getWeather(city, command);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

