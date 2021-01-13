package com.xunjia.dao.impl;

import com.xunjia.utils.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public abstract class BaseAdo {
    private QueryRunner queryRunner=new QueryRunner();

    /**
     * 执行update delete insert
     * @param sql 语句
     * @param args 参数
     * @return 影响的行数
     */
    public int update(String sql,Object ... args){
        Connection conn= JdbcUtils.getConnection();
        try {
            return queryRunner.update(conn, sql, args);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JdbcUtils.close(conn);
        }

        return -1;
    }

    /**
     * 查询 返回一条数据 多个结果
     * @param type 返回的数据
     * @param sql
     * @param args
     * @param <T> 泛型
     * @return 结果
     */
    public <T> T queryForOne(Class<T> type,String sql,Object ... args){
        Connection conn=JdbcUtils.getConnection();

        try {
            return queryRunner.query(conn, sql,new BeanHandler<T>(type), args);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JdbcUtils.close(conn);
        }

        return null;
    }

    /**
     * 返回多条数据
     * @param type
     * @param sql
     * @param args
     * @param <T>
     * @return
     */
    public <T> List<T> queryForList(Class<T> type, String sql, Object ... args) {
        Connection conn=JdbcUtils.getConnection();

        try {
            return queryRunner.query(conn, sql,new BeanListHandler<T>(type), args);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JdbcUtils.close(conn);
        }

        return null;

    }

    /**
     * 返回单个结果
     * @param sql
     * @param args
     * @return
     */
    public Object queryForSingleValue(String sql, Object ... args) {
        Connection conn= JdbcUtils.getConnection();

        try {
            return queryRunner.query(conn, sql,new ScalarHandler(), args);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JdbcUtils.close(conn);
        }

        return null;

    }

}
