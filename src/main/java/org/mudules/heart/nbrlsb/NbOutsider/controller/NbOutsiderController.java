package org.mudules.heart.nbrlsb.NbOutsider.controller;

import lombok.extern.slf4j.Slf4j;
import org.mudules.heart.nbrlsb.NbOutsider.service.INbOutsiderService;

import org.mudules.heart.nbrlsb.common.HeartbeatServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("/Outsider")
@Slf4j
public class NbOutsiderController {
    @Autowired
    private HeartbeatServer heartbeatServer;

    @GetMapping("/update/on")
    public Map<Integer, String> updateOn() {
        Map<Integer, String> map = new HashMap<>();
        Integer cmd = heartbeatServer.getCmd();
        if (cmd == 0) {
            heartbeatServer.setCmd(1);
        } else if (cmd == 1) {
            map.put(1, "下发命令目前是启动状态,请勿重复启动!");
            return map;
        }
        map.put(0, "成功启动下发命令!");
        return map;
    }

    @GetMapping("/update/off")
    public Map<Integer, String> updateOff() {
        Map<Integer, String> map = new HashMap<>();
        Integer cmd = heartbeatServer.getCmd();
        if (cmd == 1) {
            heartbeatServer.setCmd(0);
        } else if (cmd == 0) {
            map.put(1, "下发命令就是关闭状态,没法再关了!");
            return map;
        }
        map.put(0, "成功关闭下发命令了!");
        return map;
    }
}
