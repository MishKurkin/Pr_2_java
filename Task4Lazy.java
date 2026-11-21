import java.text.SimpleDateFormat;
import java.util.Calendar;

/** Листинг 11.1 из методички: отложенный пересчёт в Calendar.set(). */
public class Task4Lazy {
    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy MMMM dd HH:mm:ss");
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, 2002);
        cal.set(Calendar.MONTH, Calendar.AUGUST);
        cal.set(Calendar.DAY_OF_MONTH, 31);
        System.out.println("Initialy set date:  " + sdf.format(cal.getTime()));
        cal.set(Calendar.MONTH, Calendar.SEPTEMBER);
        System.out.println("Month changed:      " + sdf.format(cal.getTime()));  // 31 сентября -> 1 октября
        cal.set(Calendar.DAY_OF_MONTH, 30);
        System.out.println("Day changed:        " + sdf.format(cal.getTime()));

        // Без промежуточного getTime() результат верный
        Calendar c2 = Calendar.getInstance();
        c2.set(2002, Calendar.AUGUST, 31);
        c2.set(Calendar.MONTH, Calendar.SEPTEMBER);
        c2.set(Calendar.DAY_OF_MONTH, 30);
        System.out.println("Без getTime() между set: " + sdf.format(c2.getTime()));
    }
}
