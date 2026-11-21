import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

/** Задание 4: создание Date и Calendar по введённым <Год><Месяц><Число> <Часы><минуты>. */
public class Task4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите год месяц число (через пробел): ");
        int year = sc.nextInt(), month = sc.nextInt(), day = sc.nextInt();
        System.out.print("Введите часы минуты (через пробел): ");
        int hour = sc.nextInt(), minute = sc.nextInt();

        // Calendar: месяцы нумеруются с 0, поэтому month - 1
        Calendar cal = new GregorianCalendar();
        cal.clear();
        cal.setLenient(false); // некорректные значения вызовут исключение
        try {
            cal.set(year, month - 1, day, hour, minute, 0);
            Date date = cal.getTime(); // пересчёт происходит здесь

            // Date строим независимо - через миллисекунды от эпохи
            Date date2 = new Date(cal.getTimeInMillis());

            SimpleDateFormat f = new SimpleDateFormat("dd.MM.yyyy HH:mm");
            System.out.println("Date:      " + date);
            System.out.println("Date (fmt): " + f.format(date2));
            System.out.println("Calendar:  год=" + cal.get(Calendar.YEAR)
                    + ", месяц=" + (cal.get(Calendar.MONTH) + 1)
                    + ", день=" + cal.get(Calendar.DAY_OF_MONTH)
                    + ", часы=" + cal.get(Calendar.HOUR_OF_DAY)
                    + ", минуты=" + cal.get(Calendar.MINUTE)
                    + ", день недели=" + cal.get(Calendar.DAY_OF_WEEK)
                    + ", день года=" + cal.get(Calendar.DAY_OF_YEAR));
            System.out.println("Миллисекунды от 01.01.1970: " + cal.getTimeInMillis());
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: такой даты не существует");
        }
    }
}
