package com.tom.bbs_day0117.service;

import com.tom.bbs_day0117.model.Invitation;
import com.tom.bbs_day0117.vo.InvitationPageVo;
import com.tom.bbs_day0117.vo.InvitationVo;

import java.util.List;
import java.util.Map;

public interface InvitationService {
    List<InvitationVo> findAll(Map map);

    Long countAll();

    List<InvitationVo> findAllTest(InvitationPageVo invitationPageVo);


    InvitationVo findByInvId(Invitation invitation);

    void del(Invitation invitation);


    void addOne(Invitation invitation);
}
