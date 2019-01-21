package com.tom.bbs_day0117.controller;

import com.tom.bbs_day0117.constants.ResultEntity;
import com.tom.bbs_day0117.constants.ResultEnum;
import com.tom.bbs_day0117.model.Invitation;
import com.tom.bbs_day0117.model.Users;
import com.tom.bbs_day0117.service.InvitationService;
import com.tom.bbs_day0117.vo.InvitationVo;
import org.apache.catalina.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/invitation")
public class InvitationController {

    @Resource
    private InvitationService invitationServiceImpl;

    @RequestMapping("/findAll")
    public ResultEntity<List<InvitationVo>> findAll(Integer page, Integer limit, InvitationVo invitationVo) {
        ResultEntity<List<InvitationVo>> result = new ResultEntity<>();
        try {
            Map<String, Object> map = new HashMap<>();
            map.put("start", (page - 1) * limit);
            map.put("limit", limit);
            map.put("title", invitationVo.getTitle());
            List<InvitationVo> invitationVoList = invitationServiceImpl.findAll(map);

            for (InvitationVo vo : invitationVoList) {
                System.out.println(vo.getUsers().getUsername());
            }
            result.setData(invitationVoList);
            result.setCount(invitationServiceImpl.countAll());
            result.setCodeAndMsg(ResultEnum.SELECT_SUCCESS);
        } catch (Exception e) {
            result.setCodeAndMsg(ResultEnum.SYSTEM_INNER_ERROR);
            e.printStackTrace();
        }
        return result;
    }

    @RequestMapping("/del")
    public ResultEntity<String> del(Invitation invitation) {
        ResultEntity<String> result = new ResultEntity<>();
        try {
            invitationServiceImpl.del(invitation);
            result.setCodeAndMsg(ResultEnum.DELETE_SUCCESS_MESS);
        } catch (Exception e) {
            e.printStackTrace();
            result.setCodeAndMsg(ResultEnum.DELETE_FAILED_MESS);
        }

        return result;
    }

    @RequestMapping("/add")
    public ResultEntity<String> add(Invitation invitation, HttpSession session){
        ResultEntity<String> result=new ResultEntity<>();
        Users user = (Users) session.getAttribute("user");

        return null;
    }

}
