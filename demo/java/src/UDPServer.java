import java.io.IOException;
import java.net.*;

public class UDPServer {
   // final static int RECEIVE_LENGTH = 1024;

    static String multicastHost="224.0.0.1";

    static int localPort = 9998;

    static class UDPrevice{

        public int length;
        public int port;
        public String host;
        public String clienNumber;
        UDPrevice(int length,int port,String host,String clienNumber){
            this.length = length;
            this.port = port;
            this.host = host;
            this.clienNumber = clienNumber;
        }
        public void revice(){
            try{
                InetAddress address = InetAddress.getByName(multicastHost);
                if(!address.isMulticastAddress()){
                    throw  new Exception("不是一个多播地址");
                }
                final MulticastSocket receiveMulticast = new MulticastSocket(localPort);

                receiveMulticast.joinGroup(address);

                final DatagramPacket dp = new DatagramPacket(new byte[length], length);
                new Thread(new Runnable() {
                    public void run() {
                        while(true) {
                            try {
                                receiveMulticast.receive(dp);

                                System.out.println(clienNumber + "接收到的数据:" + new String(dp.getData()).trim());
                            }catch (Exception e){

                            }
                        }
                    }
                }).start();

            }catch (Exception e){

            }
        }
    }

    public static void main(String[] args) throws Exception {
        UDPrevice revice1 = new UDPrevice(1024,localPort,multicastHost,"客户端1");
        UDPrevice revice2 = new UDPrevice(1024,localPort,multicastHost,"客户端2");
        UDPrevice revice3 = new UDPrevice(1024,localPort,multicastHost,"客户端3");
        UDPrevice revice4 = new UDPrevice(1024,localPort,multicastHost,"客户端4");
        revice1.revice();
        revice2.revice();
        revice3.revice();
        revice4.revice();
    }
}
