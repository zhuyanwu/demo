package com.example.demo.websocket;

import org.springframework.stereotype.Component;

import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;

@ServerEndpoint(value = "/zhuyanwu")
@Component
public class SkillWebsocket {

    private static ConcurrentHashMap<String, SkillWebsocket> webSocketMap = new ConcurrentHashMap<>();

    private Session session;

    @OnOpen
    public void onOpen(Session session, @PathParam("stamp") String stamp){
        this.session = session;
        System.out.println("open......");
        this.send("zhuyanwu 已连接");
    }

    @OnMessage
    public void onMessage(String message){
        this.send("服务器返回：" + message);
    }

    public void send(String message){
        try {
            this.session.getBasicRemote().sendText(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
