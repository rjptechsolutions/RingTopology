import java.net.DatagramSocket;
import java.net.DatagramPacket;
import java.net.InetAddress;

public class user {

    public static void main(String[] args) throws Exception {
        DatagramSocket ds = new DatagramSocket(9998);

        // recive
        byte b[] = new byte[1024];
        DatagramPacket dp = new DatagramPacket(b, b.length);
        ds.receive(dp);
        String str = new String(dp.getData(), 0, dp.getLength());
        System.out.println("Code is " + str);
        int num = 2341;
        InetAddress ia = InetAddress.getLocalHost();
        byte[] b2 = String.valueOf(str + " " + num).getBytes();
        DatagramPacket dp1 = new DatagramPacket(b2, b2.length, ia, 9997);
        ds.send(dp1);
    }
}