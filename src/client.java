import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class client {

    public static void main(String[] args) throws Exception {
        DatagramSocket ds = new DatagramSocket(9997);
        // sending
        int i = 4586;
        byte[] b = String.valueOf(i).getBytes();
        InetAddress ia = InetAddress.getLocalHost();
        DatagramPacket dp = new DatagramPacket(b, b.length, ia, 9999);
        ds.send(dp);

        // reciving
        byte[] b1 = new byte[1024];
        DatagramPacket dp1 = new DatagramPacket(b1, b1.length);
        ds.receive(dp1);

        // Printing
        String str = new String(dp1.getData(), 0, dp1.getLength());
        System.out.println("Result is " + str);
    }
}