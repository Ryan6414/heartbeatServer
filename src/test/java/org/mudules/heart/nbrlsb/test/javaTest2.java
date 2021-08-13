package org.mudules.heart.nbrlsb.test;


import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 类描述
 *
 * @author gy.lin
 * @date 2021/8/9
 * @since
 */
class javaTest2 {
    public static void main(String[] args) {
        javaTest2 javaTest = new javaTest2();
        javaTest.init();
    }

    public void init() {
        try {
            ServerSocket serverSocket = new ServerSocket(9999);
            while (true) {
                // 一旦有堵塞, 则表示服务器与客户端获得了连接
                Socket client = serverSocket.accept();
                // 处理这次连接
                new HandlerThread(client);
            }
        } catch (Exception e) {
            System.out.println("服务器异常: " + e.getMessage());
        }
    }

    private class HandlerThread implements Runnable {
        private Socket socket;
        public HandlerThread(Socket client) {
            socket = client;
            new Thread(this).start();
        }

        public void run() {
            try {

                BufferedInputStream mInput = new BufferedInputStream(socket.getInputStream());
                BufferedOutputStream mOutInput = new BufferedOutputStream(socket.getOutputStream());

                byte[] buf = new byte[100000000];
                int read = mInput.read(buf);
                if (read > 0){
                    System.out.println("服务器收到:"+new String(buf, 0 , read));
                }

                String s = "{ " +
                        "    \"code\": 0 ," +
                        "    \"message\": \"xxxx\" ," +
                        "    \"payload\":{" +
                        "        \"params\": {" +
                        "            \"command\":0," +
                        "            \"secret\":\"xxxxxxxxx\"," +
                        "            \"ip\":\"192.168.128.96\"," +
                        "            \"port\":9999" +
                        "        }" +
                        "    }" +
                        "} ";

//                String s2 = "{\"code\": 0 ,\"message\": \"xxxx\"}";
//
//                mOutInput.write(s2.getBytes(), 0 , s.getBytes().length);
//                mOutInput.flush();
//                socket.getOutputStream().flush();
            } catch (Exception e) {
                System.out.println("服务器 run 异常: " + e.getMessage());
            } finally {

            }
        }
    }
}
