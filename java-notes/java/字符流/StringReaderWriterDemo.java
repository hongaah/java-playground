
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;


public class StringReaderWriterDemo {

    public static void main(String[] args) {
        String str = "Hello World!";
        StringBuilder builder = new StringBuilder();

        try (StringReader reader = new StringReader(str);
             StringWriter writer = new StringWriter()) {
            int c;
            while ((c = reader.read()) != -1) {
                writer.write(c);
            }
            builder.append(writer);
            System.out.println(builder);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
