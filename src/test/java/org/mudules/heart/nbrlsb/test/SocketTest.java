package org.mudules.heart.nbrlsb.test;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.mudules.heart.nbrlsb.utilTools.common.Base64Jx;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;


@Slf4j
public class SocketTest {

    /**
     * scoket测试
     */
    @Test
    public void su() {
        ServerSocket serverSocket = null;
        try {
            String j1 = "{\"code\":0,\"message\":\"xxxx\",\"payload\":{\"params\":{\"command\":0,\"secret\":\"XXXXXXXX\",\"ip\":\"192.168.128.96\",\"port\":19998}}}";

            String j2 = "{\"code\": 0 ,\"message\": \"xxxx\"}";

            serverSocket = new ServerSocket(18000);

            while (!serverSocket.isClosed()) {
                long start = System.currentTimeMillis();
                Socket socket = serverSocket.accept();

                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                StringBuilder sb = new StringBuilder(reader.readLine().toString());
                log.info("线程:{}--> 输出:{}", Thread.currentThread().getName(), sb.toString());

              //  PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

              //  JSONObject json = JSON.parseObject(j1);
              //  writer.println(j1);

                bw.write(j1);
                bw.flush();
                bw.close();
                System.out.println("发送成功!");
               long  end = System.currentTimeMillis();
                System.out.println("程序运行时间：" + (end- start) /1000 + "ms"); //输出程序运行时间
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     *  图片转 base64代码
     */
    @Test
    void getBase(){
        String url = "C:\\opt\\tp\\temp\\1628126096183_1628126096385.jpg";
        String base64Code = Base64Jx.getBase64Code(url);
        System.out.println(base64Code);
    }

}



