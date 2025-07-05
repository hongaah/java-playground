import java.io.*;

public class BufferedReaderWriterDemo {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("input.txt"))) {
          String line;
          while ((line = br.readLine()) != null) {
            System.out.println(line);
          }
        } catch (IOException e) {
          e.printStackTrace();
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("output.txt"))) {
          bw.write("Hello World!");
        } catch (IOException e) {
          e.printStackTrace();
        }
    }
}
