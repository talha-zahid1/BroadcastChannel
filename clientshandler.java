import java.io.BufferedReader;
import java.net.ServerSocket;
import java.net.Socket;

public class clientshandler {
    Socket clientsocket;
    ServerSocket serverSocket;
    BufferedReader in;
    public clientshandler(Socket clientsocket,BufferedReader in,ServerSocket serverSocket)throws Exception{
        this.clientsocket=clientsocket;
        this.serverSocket=serverSocket;
        this.in=in;
    }   
    public String Recieve()throws Exception{
        return in.readLine();
    }
    public void serverSocketclose()throws Exception{
        serverSocket.close();
    }
    public void clientclose()throws Exception{
        clientsocket.close();
    }
    
}
class MyThreads extends Thread{
    clientshandler c;
    int clientid;
    public MyThreads(clientshandler c,int clientid){
        this.c=c;
        this.clientid=clientid;
    }
    public void run(){
        String mess;
        try {
            while ((mess=c.Recieve())!=null) {
             System.out.println("Client"+clientid+" Says "+mess);   
            }
            System.out.println("Client"+clientid+" Has Left");
            c.clientclose();
            Server.Leftclients.incrementAndGet();
            if (Server.totalclients.get()==Server.Leftclients.get()) {
                c.serverSocketclose();
            }
        } catch (Exception e) {
            System.out.println("Error"+e.getMessage());
        }
        
    }
    
}
