package org.mudules.heart.nbrlsb.snStatus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.mudules.heart.nbrlsb.snStatus.entity.SnStatus;

import java.util.Map;

public interface SnStatusMapper extends BaseMapper<SnStatus> {

    // 查询外来人员设备上传状态
    @Select("Select status from nb_sending_status where sn = #{sn}")
    Integer getSnStatus(@Param("sn") String sn);


    @Update("update nb_sending_status set status = #{status} where sn = #{sn}")
    Boolean updateSnStatus(Integer status, String sn);
}
