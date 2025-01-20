import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class PipedInputStreamExample {
  public static void main(String[] args) throws IOException {
    try (PipedInputStream pipedInputStream = new PipedInputStream();
          PipedOutputStream pipedOutputStream = new PipedOutputStream()) {
      // 将 pipedOutputStream 与 pipedInputStream 连接起来 
      pipedInputStream.connect(pipedOutputStream);
      byte[] bytes = {11, 21, 3, 40, 5};
      pipedOutputStream.write(bytes);
      int data = pipedInputStream.read();
      while (data != -1) {
        System.out.print(data + " ");
        data = pipedInputStream.read();
      }
    }
  }
}