import java.io.*;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException, InterruptedException {
        Socket sock = new Socket("192.168.2.53", 10000);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(sock.getOutputStream()));
        BufferedReader br = new BufferedReader(new InputStreamReader(sock.getInputStream()));

        Thread.sleep(3000);

        bw.write("coucou");
        bw.newLine();
        bw.flush();

        System.out.println("server: " + br.readLine());

        Thread.sleep(3000);

        bw.write("comment tu t'appelles ?");
        bw.newLine();
        bw.flush();

        System.out.println("server: " + br.readLine());
    }
}
