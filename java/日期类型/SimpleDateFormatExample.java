import java.text.SimpleDateFormat;
import java.util.Date;

public class SimpleDateFormatExample {
    public static void main(String[] args) throws Exception {
        String dateString = "2021-01-31";
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM");
        Date date = format.parse(dateString);
        System.out.println("Date object: " + date.toString());

        String formattedDate = format.format(date);
        System.out.println("Formatted date string: " + formattedDate);
    }
}