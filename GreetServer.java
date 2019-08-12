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

public class GreetServer {
    private ServerSocket serverSocket;
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;
 
    public void start(int port) throws Exception{
        ReadConsole readline = new ReadConsole();
        serverSocket = new ServerSocket(port);
        clientSocket = serverSocket.accept();
        out = new PrintWriter(clientSocket.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
         
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
         System.out.println(inputLine);
            if (".".equals(inputLine)) {
                out.println("good bye");
                System.out.println("good bye");
                break;
            }else {
        out.println(readline.that());
        }
    }
    }
 
    public void stop() throws Exception{
        in.close();
        out.close();
        clientSocket.close();
        serverSocket.close();
    }
    public static void main(String[] args) {
        try {GreetServer server=new GreetServer();
        server.start(6666);
        }catch (Exception e ){
            System.out.println("error");
        }
    }
}