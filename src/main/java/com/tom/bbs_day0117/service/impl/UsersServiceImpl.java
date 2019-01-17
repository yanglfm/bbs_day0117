package com.tom.bbs_day0117.service.impl;

import com.tom.bbs_day0117.service.UsersService;
import com.tom.bbs_day0117.vo.InvitationVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

import com.tom.bbs_day0117.model.Users;
import com.tom.bbs_day0117.mapper.UsersDao;

@Service
public class UsersServiceImpl implements UsersService {

    @Resource
    private UsersDao usersDao;

    public int insert(Users pojo) {
        return usersDao.insert(pojo);
    }

    public int insertSelective(Users pojo) {
        return usersDao.insertSelective(pojo);
    }

    public int insertList(List<Users> pojos) {
        return usersDao.insertList(pojos);
    }

    public int update(Users pojo) {
        return usersDao.update(pojo);
    }


    @Override
    public Users login(Users users) {
        return usersDao.selectByUsernameAndPassword(users);
    }
}
