
import core.ServerHandler;
import interaction.Request;
import interaction.Response;
import interaction.ResponseCode;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;


public class Executor extends Thread{
    private final Socket client;
    private final ServerHandler serverHandler;
    public Executor(Socket client, ServerHandler serverHandler){
        this.client = client;
        this.serverHandler = serverHandler;
    }

    public void run(){
        while (processClientRequest()) {}
    }

    private boolean processClientRequest(){
        Request userRequest = null;
        Response responseToUser = null;
        try(ObjectInputStream clientReader = new ObjectInputStream(client.getInputStream());
            ObjectOutputStream clientWriter = new ObjectOutputStream(client.getOutputStream())) {
            do {


                userRequest = (Request) clientReader.readObject();

                responseToUser = serverHandler.handle(userRequest);

                clientWriter.writeObject(responseToUser);
                clientWriter.flush();


            }while (responseToUser.getResponseCode() != ResponseCode.SERVER_EXIT);
            return false;
        }catch (IOException e){
            if (userRequest == null){

                System.out.println("Непредвиденный разрыв соединения с клиентом!");
                return false;
            }

            else {
                System.out.println("Клиент успешно отключен от сервера!");
                return false;
            }

        }catch (ClassNotFoundException classNotFoundException){
            System.out.println("Произошла ошибка при чтении полученных данных!");
        }
        return true;
    }

}
