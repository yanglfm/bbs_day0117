package com.tom.bbs_day0117.service.impl;

import com.tom.bbs_day0117.service.InvitationService;
import com.tom.bbs_day0117.vo.InvitationPageVo;
import com.tom.bbs_day0117.vo.InvitationVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

import com.tom.bbs_day0117.model.Invitation;
import com.tom.bbs_day0117.mapper.InvitationDao;

@Service
public class InvitationServiceImpl implements InvitationService {

    @Resource
    private InvitationDao invitationDao;

    public int insert(Invitation pojo) {
        return invitationDao.insert(pojo);
    }

    public int insertSelective(Invitation pojo) {
        return invitationDao.insertSelective(pojo);
    }

    public int insertList(List<Invitation> pojos) {
        return invitationDao.insertList(pojos);
    }

    public int update(Invitation pojo) {
        return invitationDao.update(pojo);
    }

    @Override
    public List<InvitationVo> findAll(Map map) {
        System.out.println(map.get("start"));
        System.out.println(map.get("limit"));
        List<InvitationVo> invitationVoList = invitationDao.findAll(map);
        System.out.println(invitationVoList);
        return invitationVoList;
    }

    @Override
    public Long countAll() {
        return invitationDao.countAll();
    }

    @Override
    public List<InvitationVo> findAllTest(InvitationPageVo invitationPageVo) {
        return invitationDao.findAllTest(invitationPageVo);
    }

    @Override
    public InvitationVo findByInvId(Invitation invitation) {
        return invitationDao.selectByInvId(invitation);
    }

    @Override
    public void del(Invitation invitation) {
        invitationDao.deleteById(invitation);
    }
}
