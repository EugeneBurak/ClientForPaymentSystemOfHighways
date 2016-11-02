import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class Main {

    public static void main(String[] args) {
        int serverPort = 8080; // здесь обязательно нужно указать порт к которому привязывается сервер.
        String address = "127.0.0.1"; // это IP-адрес компьютера, где исполняется наша серверная программа. Специальный адрес называется адрес замыкания.
        String terminalNumber;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the terminal number (the numbers from 1 to 10): ");    //простые числа используются для простоты демонстрации.
        //проверка что число входит в диапазон от 1 до 10
        try {
            terminalNumber = bufferedReader.readLine();
//            bufferedReader.close();           //почему не работает с этой строчкой????????????????????????????????????
            System.out.println("The connection will be made with IP address " + address + " and port " + serverPort + "!!!");
            System.out.println("Terminal number - " + terminalNumber);

            InetAddress ipAddress = InetAddress.getByName(address); // создаем объект который отображает вышеописанный IP-адрес.

            Socket socket = new Socket(ipAddress, serverPort); // создаем сокет используя IP-адрес и порт сервера.

            // Берем входной и выходной потоки сокета, теперь можем получать и отсылать данные клиентом.
            InputStream sin = socket.getInputStream();
            OutputStream sout = socket.getOutputStream();

            // Конвертируем потоки в другой тип, чтоб легче обрабатывать текстовые сообщения.
            DataInputStream in = new DataInputStream(sin);
            DataOutputStream out = new DataOutputStream(sout);

            // Создаем поток для чтения с клавиатуры.
            BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
            String line = null;
            String messageToServer = null;
            System.out.println("Type in something and press enter. Will send it to the server.");
            System.out.println();

//            ReceivingMessage receivingMessage = new ReceivingMessage();
//            Thread thread = new Thread(receivingMessage);
//            thread.start();

            while (true) {
                System.out.println("Enter the ID of the new client (the numbers from 1 to 10):");    //простые числа используются для простоты демонстрации.
                //проверка что число входит в диапазон от 1 до 10
                line = keyboard.readLine(); // ждем пока пользователь введет что-то и нажмет кнопку Enter.
                String currentData = new java.util.Date().toString();
                messageToServer = terminalNumber + ";" + line + ";" + currentData;
                System.out.println(" <<< Sending this line to the server - " + messageToServer);
                out.writeUTF(messageToServer); // отсылаем введенную строку текста серверу.
                out.flush(); // заставляем поток закончить передачу данных.
                line = in.readUTF(); // ждем пока сервер отошлет строку текста.
                System.out.println();
                System.out.println(" >>> The server has confirmed receipt data : " + line);
                System.out.println();
            }
        } catch (Exception x) {
            x.printStackTrace();
        }
	// write your code here
    }
}
