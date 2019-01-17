package com.tom.bbs_day0117.vo;

import com.tom.bbs_day0117.model.Reply;
import com.tom.bbs_day0117.model.Users;

public class ReplyVo extends Reply {
    private Users users;

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }
}
