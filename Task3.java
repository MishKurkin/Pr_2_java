import java.text.SimpleDateFormat;
import java.util.Date;

/** Задание 3: демонстрация класса Student. */
public class Task3 {
    public static void main(String[] args) throws Exception {
        Date birth = new SimpleDateFormat("dd.MM.yyyy").parse("15.03.2005");
        Student s = new Student("Иванов Иван", "ИКБО-01-23", birth);

        System.out.println("toString():  " + s);
        System.out.println("SHORT:       " + s.getBirthDateString(Student.SHORT));
        System.out.println("MEDIUM:      " + s.getBirthDateString(Student.MEDIUM));
        System.out.println("LONG:        " + s.getBirthDateString(Student.LONG));
        System.out.println("FULL:        " + s.getBirthDateString(Student.FULL));
        System.out.println("Шаблон dd.MM.yyyy:      " + s.getBirthDateString("dd.MM.yyyy"));
        System.out.println("Шаблон EEEE, d MMMM yyyy 'г.': " + s.getBirthDateString("EEEE, d MMMM yyyy 'г.'"));
    }
}
