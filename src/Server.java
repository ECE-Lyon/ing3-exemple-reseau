import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException, InterruptedException {
        ServerSocket ssock = new ServerSocket(10000, 5, InetAddress.getByName("192.168.2.53"));
        Socket sock = ssock.accept();
        BufferedReader br = new BufferedReader(new InputStreamReader(sock.getInputStream()));
        BufferedWriter bw = new BufferedWriter((new OutputStreamWriter(sock.getOutputStream())));

        System.out.println("client: " + br.readLine());

        Thread.sleep(3000);

        bw.write("hey salut !");
        bw.newLine();
        bw.flush();

        System.out.println("client: " + br.readLine());

        Thread.sleep(3000);

        bw.write("nestor");
        bw.newLine();
        bw.flush();
    }
}
