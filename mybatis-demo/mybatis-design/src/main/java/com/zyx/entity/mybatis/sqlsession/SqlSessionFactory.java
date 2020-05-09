package com.zyx.entity.mybatis.sqlsession;

/**
 * @Author zhengyongxian
 * @Date 2020/5/9
 */
public interface SqlSessionFactory {

    /**
     * 用于打开一个新的SqlSession对象
     * @return
     */
    SqlSession openSession();
}
