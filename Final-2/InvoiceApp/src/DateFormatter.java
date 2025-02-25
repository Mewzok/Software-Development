import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatter {
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy EEE");

    public static String formatDate(Date date) {
        return (date != null) ? dateFormat.format(date) : "N/A";
    }
}
