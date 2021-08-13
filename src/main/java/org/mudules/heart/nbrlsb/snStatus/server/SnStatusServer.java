package org.mudules.heart.nbrlsb.snStatus.server;

import com.baomidou.mybatisplus.extension.service.IService;
import org.mudules.heart.nbrlsb.snStatus.entity.SnStatus;

import java.util.Map;

public interface SnStatusServer  extends IService<SnStatus> {
    Boolean updateSnStatus(Integer status, String sn);

    Integer getSnStatus(String sn);
}
