import java.io.*;
import java.net.*;
import java.util.Scanner;

public class ChatRoomClient {

    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 8888);
            System.out.println("成功连接上服务器");

            // 从服务器接收消息
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            new Thread(new Runnable() {
                @Override
                public void run() {
                    String msg = null;
                    try {
                        while ((msg = br.readLine()) != null) {
                            System.out.println("收到服务器消息：" + msg);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
;
            // 向服务器发送消息
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            Scanner scanner = new Scanner(System.in);
            String line = null;
            while ((line = scanner.nextLine()) != null) {
                bw.write(line);
                bw.newLine();
                bw.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
