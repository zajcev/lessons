package Java_Lvl_2.Lesson_3;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordRegExp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Login: ");
        scanner.nextLine();
        System.out.print("Password: ");
        String pass = scanner.nextLine();
        while (!checkPass(pass)) {
            System.out.println("Пароль не прошёл проверку. Попробуйте ещё раз");
            System.out.print("Password: ");
            String password = scanner.nextLine();
            pass = password;
        }
        System.out.println("Пароль прошёл проверку ");
    }
static boolean checkPass(String password){
    String regexp = "(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9]).{8,}";
    Pattern pattern = Pattern.compile(regexp);
    Matcher matcher = pattern.matcher(password);
        return matcher.matches();
}
}
