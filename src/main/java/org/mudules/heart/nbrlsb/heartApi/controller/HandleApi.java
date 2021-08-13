package org.mudules.heart.nbrlsb.heartApi.controller;

import lombok.extern.slf4j.Slf4j;
import org.mudules.heart.nbrlsb.snStatus.server.SnStatusServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/heart")
@Slf4j
public class HandleApi {

//    @Autowired
//    private SnStatusServer statusServer;
//
//    @PostMapping("/on")
//    public Map<Integer, String> on(@RequestParam("sn") String sn) {
//        Map<Integer, String> map = new HashMap<>();
//        Integer snStatus = statusServer.getSnStatus(sn);
//        if (snStatus == 0 ){
//            map.put(0, "启动成功!");
//        }else {
//            map.put(1,"设备已全部上传完成!");
//        }
//        return map;
//    }


}
