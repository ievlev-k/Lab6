import core.*;

import java.util.Scanner;

public class AppClient {



    public static void main(String[] args) {
        int port = 0;
        System.out.println("Введите порт:");
        Scanner in = new Scanner(System.in);
        while (true){
            try {
                if (in.hasNextLine()){port = Integer.parseInt(in.nextLine());}else{System.exit(1);}
                if (port < 0 || port >65535) {
                    System.out.println("Неверный формат порта, повторите ввод:");
                    continue;
                }
                break;
            }catch (IllegalArgumentException e){
                System.out.println("Неверный формат порта, повторите ввод:");
            }
        }


        ClientHandler clientHandler = new ClientHandler();


        Client client = new Client("localhost",port, clientHandler);

        client.run();
        in.close();

    }
}
