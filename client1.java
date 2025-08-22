import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class client1{
    Socket socket;
    String IpAdd="127.0.0.1";
    int portnumber=1000;
    public client1(String IpAdd,int portnumber)throws Exception{
          this.IpAdd=IpAdd;
          this.portnumber=portnumber;
          socket=new Socket(this.IpAdd,this.portnumber);
    }
    public void Send(String message)throws Exception{
         PrintWriter out=new PrintWriter(socket.getOutputStream(),true);
         out.println(message);
    }
    public String Recieve()throws Exception{
        BufferedReader in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
        return in.readLine();
    }
    public void close()throws Exception{
        socket.close();
    }
    public static void main(String[] args)throws Exception {

    }   
}