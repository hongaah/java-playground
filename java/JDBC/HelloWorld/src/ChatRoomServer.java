import java.io.*;
import java.net.*;
import java.util.*;

public class ChatRoomServer {

    // 保存在线用户列表
    private static List<Socket> socketList = new ArrayList<>();

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8888);
            System.out.println("服务器已开启，等待客户端连接...");

            while (true) {
                // 等待客户端连接
                Socket socket = serverSocket.accept();
                System.out.println("有客户端连接上来了：" + socket);

                // 将客户端加入在线列表
                socketList.add(socket);

                // 启动一个新线程处理该客户端的消息
                new ChatHandler(socket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 聊天处理线程
    static class ChatHandler extends Thread {
        private Socket socket;

        public ChatHandler(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            try {
                BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String msg = null;
                while ((msg = br.readLine()) != null) {
                    // 收到客户端消息后，转发给其他客户端
                    System.out.println("收到客户端消息：" + msg);
                    for (Socket s : socketList) {
                        if (!s.equals(socket)) {
                            PrintWriter pw = new PrintWriter(s.getOutputStream());
                            pw.println(msg);
                            pw.flush();
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                // 客户端下线，从在线列表移除该客户端连接
                socketList.remove(socket);
            }
        }
    }
}
