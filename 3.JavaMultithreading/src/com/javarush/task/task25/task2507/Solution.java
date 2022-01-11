package com.javarush.task.task25.task2507;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
/* 
Работать в поте лица!
*/
public class Solution extends Thread {
    private static final int BUFFER_SIZE = 2000;    //2000 bytes
    private final Socket socket;
    private final InputStream in;

    public Solution(Socket socket) throws IOException {
        this.socket = socket;
        this.in = socket.getInputStream();
    }

    public void interrupt() {//должен прерывать трэд предварительно закрыв используемые ресурсы.
        try {
            socket.close(); //Closing this socket will also close the socket's InputStream and OutputStrea
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            super.interrupt();//мы переопределили метод interrupt(), super.interrupt() это вызов метода "настоящего",
            // который находится в классe Thread, от которого мы наследуемся.  super.interrupt() выставляет флаг что поток прерван
        }

    }

    public void run() {
        try {
            byte[] buf = new byte[BUFFER_SIZE];
            while (true) {
                int count = in.read(buf);
                if (count < 0) {
                    break;
                } else {
                    if (count > 0) {
                        //process buffer here
                    }
                }
            }
        } catch (IOException ignored) {
        }
    }

    public static void main(String[] args) {
    }
}
