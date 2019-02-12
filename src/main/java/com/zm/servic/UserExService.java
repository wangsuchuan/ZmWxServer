package com.zm.servic;

import com.zm.dao.UserExDao;
import com.zm.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserExService {

    @Autowired
    private UserExDao userExDao;

    /**
     * 查询
     * @param id
     * @return
     */
    public User getUserExById(Integer id) {
        return userExDao.getUserExById();
    }

    /**
     * 新增
     * @return
     */
    public Long insertUserExInfo() {
        User userEx = new User();
        userEx.setName("测试");
        userExDao.insertUserExInfo(userEx);
        return userEx.getId();
    }

    /**
     * 新增
     * @return
     */
    public Long insertWeiXin(String name) {
        User userEx = new User();
        userEx.setName(name);
        userExDao.insertUserExInfo(userEx);
        return userEx.getId();
    }

}
