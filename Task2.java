import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/** Задание 2: сравнение введённой пользователем даты с текущим системным временем. */
public class Task2 {
    public static void main(String[] args) {
        SimpleDateFormat fmt = new SimpleDateFormat("dd.MM.yyyy HH:mm");
        fmt.setLenient(false); // запрещаем "31.02.2026"
        Scanner sc = new Scanner(System.in);
        Date now = new Date();
        Date user = null;
        while (user == null) {
            System.out.print("Введите дату и время (дд.мм.гггг чч:мм): ");
            if (!sc.hasNextLine()) return;
            try {
                user = fmt.parse(sc.nextLine().trim());
            } catch (ParseException e) {
                System.out.println("Неверный формат, повторите ввод.");
            }
        }
        System.out.println("Текущее время:   " + fmt.format(now));
        System.out.println("Введённая дата:  " + fmt.format(user));

        int cmp = user.compareTo(now);
        if (user.before(now))      System.out.println("Результат: введённая дата РАНЬШЕ текущей (before = true), compareTo = " + cmp);
        else if (user.after(now))  System.out.println("Результат: введённая дата ПОЗЖЕ текущей (after = true), compareTo = " + cmp);
        else                       System.out.println("Результат: даты совпадают, compareTo = " + cmp);

        long diff = Math.abs(user.getTime() - now.getTime());
        long days = diff / 86_400_000L, hours = diff / 3_600_000L % 24, min = diff / 60_000L % 60;
        System.out.println("Разница: " + days + " дн. " + hours + " ч. " + min + " мин.");
    }
}
