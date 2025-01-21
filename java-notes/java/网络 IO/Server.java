import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
  public static void main(String[] args) throws IOException {
    ServerSocket serverSocket = new ServerSocket(8888);

    // 这里会一直处于堵塞状态
    // 这个代码中的 accept 函数调用处，当外界没有任何连接建立的时候，是不会返回Socket对象的，会让程序长时间处于阻塞状态。
    Socket socket = serverSocket.accept();
    InputStream inputStream = socket.getInputStream();
    byte[] bytes = new byte[1024];

    // 当连接建立后，如果连接的另一端没有发送数据的话，在调用 read 函数的时候，也是不会返回任何内容的，这样的设计也会导致程序长时间处于堵塞状态。
    int len = inputStream.read(bytes);
    System.out.println(new String(bytes, 0, len));

    inputStream.close();
    socket.close();
    serverSocket.close();
  }
}
