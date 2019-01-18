package com.tom.bbs_day0117.controller;

import com.tom.bbs_day0117.model.Invitation;
import com.tom.bbs_day0117.model.Reply;
import com.tom.bbs_day0117.service.InvitationService;
import com.tom.bbs_day0117.service.ReplyService;
import com.tom.bbs_day0117.vo.InvitationVo;
import com.tom.bbs_day0117.vo.ReplyVo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class HrefController {

    @Resource
    private ReplyService replyServiceImpl;
    @Resource
    private InvitationService invitationServiceImpl;

    @RequestMapping("/index")
    public String index() {
        return "index";
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    /*  @RequestMapping("/info")
      public ModelAndView info(Reply reply) {
          ModelAndView mv = new ModelAndView("info");//之前的跳转
  //        ModelAndView mv = new ModelAndView("test6");
          System.out.println(reply.getInv_id());
          Invitation invitation = new Invitation();
          invitation.setInv_id(reply.getInv_id());
          InvitationVo byInvId = invitationServiceImpl.findByInvId(invitation);
          mv.addObject("byInvId", byInvId);
          List<ReplyVo> replyVos = replyServiceImpl.selectByInvId(reply);
          mv.addObject("replyVos", replyVos);
          return mv;
      } */
    @RequestMapping("/info")
    public ModelAndView info(Reply reply) {
        ModelAndView mv = new ModelAndView("test6");
        System.out.println(reply.getInv_id());
        Invitation invitation = new Invitation();
        invitation.setInv_id(reply.getInv_id());
        InvitationVo byInvId = invitationServiceImpl.findByInvId(invitation);
        mv.addObject("byInvId", byInvId);
        List<ReplyVo> replyVos = replyServiceImpl.selectReplyVosReplyVos(reply);
        mv.addObject("replyVos", replyVos);
        return mv;
    }

    @RequestMapping("/editReply")
    public ModelAndView editReply(Reply reply) {
        ModelAndView mv = new ModelAndView("editReply");
        mv.addObject("reply", reply);
        return mv;
    }

    @RequestMapping("/replyInfo")
    public ModelAndView replyInfo(Reply reply) {
        ModelAndView mv = new ModelAndView("replyInfo");
        ReplyVo replyVo = replyServiceImpl.selectByReId(reply);
        mv.addObject("replyVo", replyVo);
        return mv;
    }

    @RequestMapping("/replyAdd")
    public String replyAdd(Reply reply, Model model) {
        ReplyVo replyVo = replyServiceImpl.selectByReId(reply);
        model.addAttribute("replyVo", replyVo);
        return "replyAdd";
    }

    @RequestMapping("/test")
    public String test() {
        return "test6";
    }

    @RequestMapping("/testReply")
    public String testReply() {
        return "test_reply";
    }

    @RequestMapping("/test_last")
    public String test7() {
        return "test8";
    }

    @RequestMapping("/testFrame")
    public String testFrame() {
        return "testFrame";
    }


}
