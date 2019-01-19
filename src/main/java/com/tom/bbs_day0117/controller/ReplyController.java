package com.tom.bbs_day0117.controller;

import com.tom.bbs_day0117.constants.ResultEntity;
import com.tom.bbs_day0117.constants.ResultEnum;
import com.tom.bbs_day0117.model.Reply;
import com.tom.bbs_day0117.model.Users;
import com.tom.bbs_day0117.service.ReplyService;
import com.tom.bbs_day0117.vo.ReplyVo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/reply")
public class ReplyController {

    @Resource
    private ReplyService replyServiceImpl;

    @RequestMapping("/addReply")
    public ResultEntity<String> addReply(Reply reply, HttpSession session, Integer parentid, String content, @RequestParam(defaultValue = "") String choice) {
        ResultEntity<String> result = new ResultEntity<>();
        System.out.println("parentid----------------------------------------------------" + parentid);
        System.out.println("content----------------------------------------------------" + content);
        try {
            Users user = (Users) session.getAttribute("user");
            reply.setUser_id(user.getUser_id());
            if (!choice.equals("")) {//choice:on的情况下，匿名，设置为-1
                reply.setNoread(-1);
            } else {
                reply.setNoread(1);//不匿名，设置为1
            }
            replyServiceImpl.insertReply(reply);
            result.setCodeAndMsg(ResultEnum.INSERT_SUCCESS_MESS);
        } catch (Exception e) {
            result.setCodeAndMsg(ResultEnum.INSERT_FAILED_MESS);
            e.printStackTrace();
        }
        return result;
    }

    @RequestMapping("/findReplyPage")
    public ResultEntity<List<ReplyVo>> findReplyPage(Reply reply, Integer page, Integer limit) {
        ResultEntity<List<ReplyVo>> result = new ResultEntity<>();
        Map<String, Integer> map = getMap(page, limit);
        map.put("inv_id", reply.getInv_id());
        try {
            List<ReplyVo> replyVos = replyServiceImpl.selectByInvIdPage(map);
            result.setData(replyVos);
            result.setCount(replyServiceImpl.countAll(reply));
            result.setCodeAndMsg(ResultEnum.SELECT_SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            result.setCodeAndMsg(ResultEnum.SELECT_FAILED);
        }
        return result;
    }

    @RequestMapping("/findReplyByReIdPage")
    public ResultEntity<List<ReplyVo>> findReplyByReIdPage(Reply reply, Integer page, Integer limit) {
        ResultEntity<List<ReplyVo>> result = new ResultEntity<>();
        Map<String, Integer> map = getMap(page, limit);
        map.put("re_id", reply.getRe_id());
        try {
            List<ReplyVo> replyVos = replyServiceImpl.selectByReIdPage(map);
            result.setData(replyVos);
            result.setCount(replyServiceImpl.countAllReId(reply));
            result.setCodeAndMsg(ResultEnum.SELECT_SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            result.setCodeAndMsg(ResultEnum.SELECT_FAILED);
        }
        return result;
    }


    private Map<String, Integer> getMap(Integer page, Integer limit) {
        Map<String, Integer> map = new HashMap<>();
        map.put("start", (page - 1) * limit);
        map.put("limit", limit);
        return map;
    }

    @RequestMapping("/testFindAll")
    public ResultEntity<List<ReplyVo>> testFindAll(Reply reply) {
        ResultEntity<List<ReplyVo>> result = new ResultEntity<>();

        try {
            List<ReplyVo> replyVoList = replyServiceImpl.findAll(reply);
            result.setData(replyVoList);
            result.setCodeAndMsg(ResultEnum.SELECT_SUCCESS);
            result.setCount(11L);
        } catch (Exception e) {
            e.printStackTrace();
            result.setCodeAndMsg(ResultEnum.SELECT_FAILED);
        }

        return result;
    }
}
