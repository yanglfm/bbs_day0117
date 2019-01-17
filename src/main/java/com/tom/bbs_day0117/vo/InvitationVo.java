package com.tom.bbs_day0117.vo;

import com.tom.bbs_day0117.model.Invitation;
import com.tom.bbs_day0117.model.Users;

public class InvitationVo extends Invitation {
    private Users users;

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }
}
