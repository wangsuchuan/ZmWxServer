package com.zm.dao;

import com.zm.config.AbstractDaoManagement;
import com.zm.model.User;
import org.springframework.stereotype.Repository;


@Repository
public class UserExDao extends AbstractDaoManagement {

    private static final String NAME_SPACE = "UserExMapper";

    /**
     * 查询
     * @return
     */
    public User getUserExById() {
        return super.sqlSessionReadonly.selectOne(asSqlId("getUserExById"));
    }

    /**
     * 保存
     * @param user
     * @return
     */
    public int insertUserExInfo(User user) {
        return super.sqlSessionCommon.insert(asSqlId("insertUserExInfo"), user);
    }


    private String asSqlId(String sqlId) {
        return super.sqlId(NAME_SPACE, sqlId);
    }

}
