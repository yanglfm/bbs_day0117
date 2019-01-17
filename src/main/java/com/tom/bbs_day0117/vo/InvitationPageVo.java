package com.tom.bbs_day0117.vo;

import com.tom.bbs_day0117.model.Invitation;

public class InvitationPageVo extends Invitation {
    private Integer start;
    private Integer limit;

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }
}
