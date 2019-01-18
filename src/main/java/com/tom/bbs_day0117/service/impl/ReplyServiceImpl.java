package com.tom.bbs_day0117.service.impl;

import com.tom.bbs_day0117.model.Reply;
import com.tom.bbs_day0117.service.ReplyService;
import com.tom.bbs_day0117.vo.ReplyVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

import com.tom.bbs_day0117.mapper.ReplyDao;

@Service
public class ReplyServiceImpl implements ReplyService {

    @Resource
    private ReplyDao replyDao;

    public int insert(Reply pojo) {
        return replyDao.insert(pojo);
    }

    public int insertSelective(Reply pojo) {
        return replyDao.insertSelective(pojo);
    }

    public int insertList(List<Reply> pojos) {
        return replyDao.insertList(pojos);
    }

    public int update(Reply pojo) {
        return replyDao.update(pojo);
    }

    @Override
    public List<ReplyVo> selectByInvId(Reply reply) {
        return replyDao.selectByInvId(reply);
    }

    @Override
    public void insertReply(Reply reply) {
        replyDao.insertReply(reply);
    }

    @Override
    public List<ReplyVo> selectByInvIdPage(Map map) {
        return replyDao.selectByInvIdPage(map);
    }

    @Override
    public Long countAll(Reply reply) {
        return replyDao.countAll(reply);
    }

    @Override
    public List<ReplyVo> selectByReIdPage(Map map) {
        return replyDao.selectByReIdPage(map);
    }

    @Override
    public Long countAllReId(Reply reply) {
        return replyDao.countAllReId(reply);
    }

    @Override
    public ReplyVo selectByReId(Reply reply) {
        return replyDao.selectByReId(reply);
    }

    @Override
    public List<ReplyVo> findAll(Reply reply) {
        return replyDao.findAll();
    }

    @Override
    public List<ReplyVo> selectReplyVosReplyVos(Reply reply) {
        return replyDao.selectReplyVosReplyVos(reply);
    }
}
