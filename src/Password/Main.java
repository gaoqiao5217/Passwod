package Password;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        while (true) {
            PasswordChecker passwordChecker = new PasswordChecker();
            Scanner s = new Scanner(System.in);
            System.out.print("Введите мин. длину пароля: ");

            try {
                int min = Integer.parseInt(s.nextLine());
                passwordChecker.setMinLength(min);
            } catch (NumberFormatException e) {
                System.out.println("Вы ввели не число!");
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("Вы ввели недопустимое значение!!");
                break;
            }
            System.out.println();
            System.out.print("Введите макс. допустимое количество повторений символа подряд: ");
            try {
                int max = Integer.parseInt(s.nextLine());
                passwordChecker.setMaxRepeats(max);
            } catch (NumberFormatException e) {
                System.out.println("Вы ввели не число!");
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("Вы ввели недопустимое значение!!");
                break;
            }
            System.out.println();
            while (true) {
                System.out.print("Введите пароль или end: ");
                String password = s.nextLine();
                if (password.equalsIgnoreCase("end")) {
                    break;
                }
                if (passwordChecker.verify(password)) {
                    System.out.println("Подходит!");
                } else {
                    System.out.println("Не подходит!");
                }
                System.out.println();
            }
            System.out.println("\nПрограмма завершена");
            s.close();
            break;
        }
    }
}
