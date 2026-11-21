import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/** Класс Student с датой рождения (задание 3). */
public class Student {
    public static final int SHORT  = DateFormat.SHORT;
    public static final int MEDIUM = DateFormat.MEDIUM;
    public static final int LONG   = DateFormat.LONG;
    public static final int FULL   = DateFormat.FULL;

    private String name;
    private String group;
    private Date birthDate;

    public Student(String name, String group, Date birthDate) {
        this.name = name;
        this.group = group;
        this.birthDate = birthDate;
    }

    public String getName() { return name; }
    public String getGroup() { return group; }
    public Date getBirthDate() { return birthDate; }
    public void setBirthDate(Date birthDate) { this.birthDate = birthDate; }

    /** Дата рождения в одном из стандартных стилей: SHORT, MEDIUM, LONG, FULL. */
    public String getBirthDateString(int style) {
        return DateFormat.getDateInstance(style, Locale.forLanguageTag("ru")).format(birthDate);
    }

    /** Дата рождения по произвольному шаблону, например "dd.MM.yyyy". */
    public String getBirthDateString(String pattern) {
        return new SimpleDateFormat(pattern, Locale.forLanguageTag("ru")).format(birthDate);
    }

    @Override
    public String toString() {
        return "Student{name='" + name + "', group='" + group
                + "', birthDate=" + getBirthDateString(MEDIUM) + "}";
    }
}
