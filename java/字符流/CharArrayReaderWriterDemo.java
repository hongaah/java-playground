
import java.io.CharArrayReader;
import java.io.CharArrayWriter;
import java.io.IOException;

public class CharArrayReaderWriterDemo {

  public static void main(String[] args) {
    char[] charArray = {'H', 'e', 'l', 'l', 'o'};
    char[] newCharArray = new char[charArray.length];

    try (CharArrayReader reader = new CharArrayReader(charArray);
          CharArrayWriter writer = new CharArrayWriter())
    {
      int c;
      while ((c = reader.read()) != -1) {
          writer.write(c);
      }
      newCharArray = writer.toCharArray();
      System.out.println(newCharArray);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
