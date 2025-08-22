import java.util.Scanner;

public class clientconnecter2 {
    public static void main(String[] args)throws Exception {
        Scanner sc=new Scanner(System.in);
        client2 c1=new client2("localhost",9090);
        System.out.println("do you Want To Chat?(yes/no)");
        String message=sc.nextLine();
        while (!message.equalsIgnoreCase("no")) {
            System.out.print("Enter Message ");
            String tosend=sc.nextLine();
            c1.Send(tosend);
            System.out.println("do you Want To send?(yes/no)");
            message=sc.nextLine();
        }
        c1.close();
        sc.close();
    }   
}
