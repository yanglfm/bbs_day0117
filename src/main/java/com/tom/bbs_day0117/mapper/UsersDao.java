package com.tom.bbs_day0117.mapper;

import com.tom.bbs_day0117.model.Users;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsersDao {
    int insert(@Param("pojo") Users pojo);

    int insertSelective(@Param("pojo") Users pojo);

    int insertList(@Param("pojos") List<Users> pojo);

    int update(@Param("pojo") Users pojo);

    Users selectByUsernameAndPassword(Users users);
}
