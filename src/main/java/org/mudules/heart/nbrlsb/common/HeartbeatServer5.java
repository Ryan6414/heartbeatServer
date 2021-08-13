package org.mudules.heart.nbrlsb.common;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;
import lombok.Synchronized;
import lombok.extern.slf4j.Slf4j;
import org.mudules.heart.nbrlsb.snStatus.server.SnStatusServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

@Component
@Slf4j
@Data
@Order(value = 5)
public class HeartbeatServer5 {

    @Autowired
    private SnStatusServer statusServer;

    @Value("${listener.port5}")
    Integer port;

    @Value("${listener.start}")
    Boolean flag;

    Integer cmd = 0;

    String sn = "";

    @Value("${listener.secret}")
    String secret;

    @Value("${listener.ip}")
    String ip;

    @Value("${listener.cmdPort5}")
    Integer cmdPort;


    @PostConstruct
    public void start() {
        qd();
    }

    @Async
    public void qd() {
        new Thread(() -> {
            ServerSocket server = null;
            try {
                server = new ServerSocket(port);
                Socket client = null;
                log.info("心跳服务器5已经启动,等待设备请求...");
                while (flag) {
                    client = server.accept();
                    log.info("心跳监听5启动...");
                    socketHandle(client);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }


    @Synchronized
    public void socketHandle(Socket socket) {
        new Thread() {
            @Override
            public void run() {
                if (!socket.isClosed()) {
                    BufferedOutputStream mOutInput = null;
                    BufferedInputStream mInput = null;
                    String request = "";
                    try {
                        mInput = new BufferedInputStream(socket.getInputStream());
                        mOutInput = new BufferedOutputStream(socket.getOutputStream());
                        byte[] buf = new byte[128];
                        int read = mInput.read(buf);
                        if (read > 0) {
                            request = new String(buf, 0, read,"gb2312");
                            log.info("心跳服务器5收到的心跳:{}", request);
                        }

                        JSONObject jsonRequest = JSONObject.parseObject(request);
                        String requestSN = jsonRequest.getJSONObject("payload").getJSONObject("params").getString("sn");

                        Integer snStatus = statusServer.getSnStatus(requestSN);
                        if (snStatus == 9){
                            snStatus = 0;
                        }

                        String param = " {\"code\": 0 ,\"message\": \"xxxx\" ,\"payload\":{\"params\": {\"command\": " + snStatus + ",\"secret\":\"" + secret + "\",\"ip\":\"" + ip + "\",\"port\":" + cmdPort + " }}} ";
                        log.info("心跳服务器5响应指令:{}", param);

                        mOutInput.write(param.getBytes("gb2312"), 0, param.getBytes("gb2312").length);


                    } catch (IOException e) {
                        e.printStackTrace();
                    } finally {

                        try {
                            assert mOutInput != null;
                            mOutInput.flush();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        try {
                            mOutInput.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                        try {
                            assert mInput != null;
                            mInput.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                } else {
                    log.info("5设备已断开...");
                }
            }
        }.start();
    }
}
