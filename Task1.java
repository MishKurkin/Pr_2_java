import java.text.SimpleDateFormat;
import java.util.Date;

/** Задание 1: фамилия разработчика, дата получения и дата сдачи задания. */
public class Task1 {
    public static void main(String[] args) throws Exception {
        String developer = args.length > 0 ? args[0] : "Иванов";
        SimpleDateFormat fmt = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");

        // дата и время получения задания зафиксированы заранее
        Date received = fmt.parse("21.11.2026 09:33:00");
        // дата и время сдачи - момент выполнения программы
        Date submitted = new Date();                       // вариант 1
        long submittedMs = System.currentTimeMillis();     // вариант 2 (тот же момент)

        System.out.println("Разработчик:            " + developer);
        System.out.println("Задание получено:       " + fmt.format(received));
        System.out.println("Задание сдано (Date):   " + fmt.format(submitted));
        System.out.println("Задание сдано (millis): " + fmt.format(new Date(submittedMs)));
        long diff = submitted.getTime() - received.getTime();
        System.out.println("Прошло с получения:     " + diff / 1000 + " с (" + diff / 60000 + " мин)");
    }
}
