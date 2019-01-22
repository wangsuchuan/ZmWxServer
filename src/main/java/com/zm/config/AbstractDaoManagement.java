package com.zm.config;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * 一些通用的Dao配置
 *
 * @author Jail Hu (Confucius)
 * @copyright (c) 2017, Lianjia Group All Rights Reserved.
 */
public abstract class AbstractDaoManagement {
  @Autowired
  @Qualifier(DataSourceConfig.BEANNAME_SQLSESSION_COMMON)
  protected SqlSession sqlSessionCommon;

  @Autowired
  @Qualifier(DataSourceConfig.BEANNAME_SQLSESSION_READONLY)
  protected SqlSession sqlSessionReadonly;

  /**
   * 构造一个全限定名称的SQL ID
   *
   * @param namespace 命名空间，推荐不超过20个的英文字符
   * @param sqlId mybatis配置文件中的sqlId，推荐不超过40个应为字符
   */
  protected String sqlId(String namespace, String sqlId) {
    return new StringBuilder(61).append(namespace).append('.').append(sqlId).toString();
  }
}
