package com.tom.bbs_day0117.mapper;

import com.tom.bbs_day0117.model.Invitation;
import com.tom.bbs_day0117.vo.InvitationPageVo;
import com.tom.bbs_day0117.vo.InvitationVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface InvitationDao {
    int insert(@Param("pojo") Invitation pojo);

    int insertSelective(@Param("pojo") Invitation pojo);

    int insertList(@Param("pojos") List<Invitation> pojo);

    int update(@Param("pojo") Invitation pojo);

    List<InvitationVo> findAll(Map map);

    Long countAll();

    List<InvitationVo> findAllTest(InvitationPageVo invitationPageVo);

    InvitationVo selectByInvId(Invitation invitation);

    void deleteById(Invitation invitation);
}
