package com.tom.bbs_day0117.vo;

import com.tom.bbs_day0117.model.Reply;
import com.tom.bbs_day0117.model.Users;

import java.util.List;

public class ReplyVo extends Reply {
    private Users users;
    private List<ReplyVo> replyVos;

    public List<ReplyVo> getReplyVos() {
        return replyVos;
    }

    public void setReplyVos(List<ReplyVo> replyVos) {
        this.replyVos = replyVos;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }
}
