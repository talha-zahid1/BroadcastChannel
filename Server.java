import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.atomic.*;
public class Server {
    ServerSocket serverSocket;
    Socket clientsocket;
    int portnumber=1000;
    static AtomicInteger totalclients=new AtomicInteger(0);
    static AtomicInteger Leftclients=new AtomicInteger(0);
    public Server(int portnumber)throws Exception{
        this.portnumber=portnumber;
        serverSocket=new ServerSocket(portnumber);
        System.out.println("Welcome To My BoadCast Channel");
        int i=1;
        Boolean runing=true;
        while (runing) {
            try {
            clientsocket=serverSocket.accept();
            totalclients.incrementAndGet();
            System.out.println("Client"+i+" has Joined The Chat ");
            BufferedReader in=new BufferedReader(new InputStreamReader(clientsocket.getInputStream()));
            clientshandler c=new clientshandler(clientsocket,in,serverSocket);
            MyThreads t=new MyThreads(c,i);
            t.start();
            i++;
            } catch (Exception e) {
                System.out.println("BroadCast Channel Has Been Ended Successfully");
                runing=false;
            }
        }
    }
    public static void main(String[] args)throws Exception {
        
    }
}
