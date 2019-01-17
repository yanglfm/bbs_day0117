package com.tom.bbs_day0117.mapper;

import com.tom.bbs_day0117.model.Reply;
import com.tom.bbs_day0117.vo.ReplyVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface ReplyDao {
    int insert(@Param("pojo") Reply pojo);

    int insertSelective(@Param("pojo") Reply pojo);

    int insertList(@Param("pojos") List<Reply> pojo);

    int update(@Param("pojo") Reply pojo);

    List<ReplyVo> selectByInvId(Reply reply);

    void insertReply(Reply reply);

    List<ReplyVo> selectByInvIdPage(Map map);

    Long countAll(Reply reply);

    List<ReplyVo> selectByReIdPage(Map map);

    Long countAllReId(Reply reply);

    ReplyVo selectByReId(Reply reply);

    List<ReplyVo> findAll();
}
