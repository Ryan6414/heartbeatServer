package org.mudules.heart.nbrlsb.test;


import org.junit.jupiter.api.Test;
import org.mudules.heart.nbrlsb.NbOutsider.entity.NbOutsider;
import org.mudules.heart.nbrlsb.NbOutsider.mapper.NbOutsiderMapper;
import org.mudules.heart.nbrlsb.NbOutsider.service.INbOutsiderService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class Outsider {
    @Autowired
    private INbOutsiderService iNbOutsiderServicel;


    @Autowired
    private NbOutsiderMapper nbOutsiderMapper;
    @Test
    public void su(){
        List<NbOutsider> nbOutsiders = nbOutsiderMapper.selectList(null);
        System.out.println(nbOutsiders.toString());
    }
}
