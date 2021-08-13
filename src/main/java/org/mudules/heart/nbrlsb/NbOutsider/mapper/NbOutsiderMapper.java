package org.mudules.heart.nbrlsb.NbOutsider.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.mudules.heart.nbrlsb.NbOutsider.entity.NbOutsider;



public interface NbOutsiderMapper extends BaseMapper<NbOutsider> {

    @Select("select * from nb_outsider where upload = 0 limit 1")
    NbOutsider getOneByUpload();

    @Update("update nb_outsider  set upload = 1 where id = #{id}" )
    Boolean updateById(String id);
}
