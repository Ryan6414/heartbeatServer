package org.mudules.heart.nbrlsb.NbOutsider.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.mudules.heart.nbrlsb.NbOutsider.entity.NbOutsider;
import org.mudules.heart.nbrlsb.NbOutsider.mapper.NbOutsiderMapper;
import org.mudules.heart.nbrlsb.NbOutsider.service.INbOutsiderService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class NbOutsiderServiceImpl extends ServiceImpl<NbOutsiderMapper, NbOutsider> implements INbOutsiderService {



    @Override
    public List<NbOutsider> getAll() {
        return super.baseMapper.selectList(null);
    }

    @Override
    public NbOutsider getOne() {
        return super.baseMapper.getOneByUpload();
    }

    @Override
    public Boolean updateByUpLoad(String id) {

        return super.baseMapper.updateById(id);
    }


}
