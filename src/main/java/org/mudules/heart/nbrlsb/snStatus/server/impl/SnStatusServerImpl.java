package org.mudules.heart.nbrlsb.snStatus.server.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;


import org.mudules.heart.nbrlsb.snStatus.entity.SnStatus;
import org.mudules.heart.nbrlsb.snStatus.mapper.SnStatusMapper;
import org.mudules.heart.nbrlsb.snStatus.server.SnStatusServer;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class SnStatusServerImpl extends ServiceImpl<SnStatusMapper, SnStatus> implements SnStatusServer {


    @Override
    public Boolean updateSnStatus(Integer status, String sn) {
        return super.baseMapper.updateSnStatus(status,sn);
    }

    @Override
    public Integer getSnStatus(String sn) {
        return super.baseMapper.getSnStatus(sn);
    }
}
