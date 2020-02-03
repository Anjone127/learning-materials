package anjone.socket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

/**
 * @author anjone
 */
public class ServerThread implements Runnable {

    private Socket client = null;

    public ServerThread(Socket client) {
        this.client = client;
    }

    @Override
    public void run() {
        try {
            StreamHolder.setPrintStream(new PrintStream(client.getOutputStream()));
            StreamHolder.setBufferedReader(new BufferedReader(new InputStreamReader(client.getInputStream())));
            boolean flag = true;
            while (flag) {
                String str = StreamHolder.getBufferedReader().readLine();
                System.out.println("receiver message :" + str);
                if (str == null || "".equals(str)) {
                    flag = false;
                } else {
                    if ("bye".equals(str)) {
                        flag = false;
                    } else {
                        StreamHolder.getPrintStream().println("echo:" + str);
                    }
                }
            }
            client.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static class StreamHolder {
        private static ThreadLocal<PrintStream> printStreamThreadLocal = new ThreadLocal<>();

        private static ThreadLocal<BufferedReader> bufferedReaderThreadLocal = new ThreadLocal<>();

        static {
            printStreamThreadLocal.remove();
            bufferedReaderThreadLocal.remove();
        }

        static void setBufferedReader(BufferedReader bufferedReaderThreadLocal) {
            StreamHolder.bufferedReaderThreadLocal.set(bufferedReaderThreadLocal);
        }

        static void setPrintStream(PrintStream printStreamThreadLocal) {
            StreamHolder.printStreamThreadLocal.set(printStreamThreadLocal);
        }

        static BufferedReader getBufferedReader() {
            return bufferedReaderThreadLocal.get();
        }

        static PrintStream getPrintStream() {
            return printStreamThreadLocal.get();
        }
    }
}
