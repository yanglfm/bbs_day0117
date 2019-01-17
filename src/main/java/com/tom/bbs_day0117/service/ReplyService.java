package com.tom.bbs_day0117.service;

import com.tom.bbs_day0117.model.Reply;
import com.tom.bbs_day0117.vo.ReplyVo;

import java.util.List;
import java.util.Map;

public interface ReplyService {

    List<ReplyVo> selectByInvId(Reply reply);

    void insertReply(Reply reply);

    List<ReplyVo> selectByInvIdPage(Map map);

    Long countAll(Reply reply);

    List<ReplyVo> selectByReIdPage(Map map);

    Long countAllReId(Reply reply);

    ReplyVo selectByReId(Reply reply);

    List<ReplyVo> findAll(Reply reply);
}
