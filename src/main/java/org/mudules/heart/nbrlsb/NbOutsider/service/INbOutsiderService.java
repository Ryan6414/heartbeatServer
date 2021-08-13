package org.mudules.heart.nbrlsb.NbOutsider.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.mudules.heart.nbrlsb.NbOutsider.entity.NbOutsider;

import java.util.List;

/**
 * @Description: nb_outsider
 * @Author: jeecg-boot
 * @Date:   2021-07-15
 * @Version: V1.0
 */
public interface INbOutsiderService extends IService<NbOutsider> {

   List<NbOutsider> getAll();


   NbOutsider getOne();

   Boolean updateByUpLoad(String id);
}
