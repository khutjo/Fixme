import java.io.*;
import java.net.*;
import java.util.Scanner;



//************************************************************************************************
//************************************************************************************************
//                                      console input getter
//************************************************************************************************
//************************************************************************************************


class ReadConsole {

    public String that() {

        Scanner scanner = new Scanner(System.in);


            String input = scanner.nextLine();
        // scanner.close();
        return input;
    }
}


public class GreetClient {
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;
 
    public void startConnection(String ip, int port)  throws Exception{
        clientSocket = new Socket(ip, port);
        out = new PrintWriter(clientSocket.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
    }
 
    public String sendMessage(String msg)  throws Exception{
        out.println(msg);
        String resp = in.readLine();
        return resp;
    }
 
    public void stopConnection()  throws Exception{
        in.close();
        out.close();
        clientSocket.close();
    }

    public static void main(String [] argcv){
        String input = "";
        ReadConsole readline = new ReadConsole();
       try { GreetClient client = new GreetClient();
        client.startConnection("127.0.0.1", 6666);
        while (!input.equals(".")){
            input = readline.that();
            String response = client.sendMessage(input);
            System.out.println(response);
        }
       }catch(Exception e){
           System.out.println("error");
       }
   // assertEquals("hello client", response);
    }
}