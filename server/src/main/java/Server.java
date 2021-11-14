
import core.*;

import java.io.IOException;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import commands.*;

public class Server {
    private int port;
    private int timeOut;
    private ServerSocket serverSocket;
    private ServerHandler serverHandler;

    public Server(int port, int timeOut, ServerHandler serverHandler){
        this.port = port;
        this.timeOut = timeOut;
        this.serverHandler = serverHandler;
    }

    private void openServerSocket() {
        try{
            serverSocket = new ServerSocket(port);

        }catch (IOException e){
            try {
                serverSocket.close();
            }catch (IOException exception){
                System.out.println("Не получилось освободить socket!");
            }catch (NullPointerException exception){
                System.out.println("Не получилось освободить socket!");
            }

            System.out.println("Не получилось открыть socket!");
        }
    }


    private Socket connectToClient() {

        try{
            Socket clientSocket = serverSocket.accept();
            System.out.println("Клиент успешно подключился!");
            return clientSocket;
        }catch (IOException e){
            System.out.println("Произошла ошибка при соединении с клиентом!");
            return  null;
        }
    }

    public void start(){

        openServerSocket();
        while (true){
            Socket client = connectToClient();
            if (client != null){
                new Executor(client, serverHandler).start();
            }

        }
    }






}




