
import java.io.*;

public class StreamReaderWriterDemo {
  public static void main(String[] args) {
    try (
        InputStreamReader isr = new InputStreamReader(System.in);
        OutputStreamWriter osw = new OutputStreamWriter(System.out);
    ) {
      osw.write("Please input something: \n");
      osw.flush();
      char[] buffer = new char[20];
      isr.read(buffer);
      osw.write("You input is: ");
      osw.write(buffer);
      osw.flush();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
