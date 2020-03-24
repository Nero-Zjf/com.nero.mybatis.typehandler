package com.nero.mybatis.typehandler.handler;

import com.nero.mybatis.typehandler.domain.SexEnum;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 枚举类SexEnum的类型处理器
 */
public class SexEnumHandler implements TypeHandler<SexEnum> {
    //当类型为SexEnum的值要转换为SQL语句的参数时执行
    public void setParameter(PreparedStatement ps, int i, SexEnum parameter, JdbcType jdbcType) throws SQLException {
        ps.setInt(i, parameter.getId());
    }

    //当SQL语句返回的结果集转换为SexEnum类型时执行
    public SexEnum getResult(ResultSet rs, String columnName) throws SQLException {
        return SexEnum.getSexEnumById(rs.getInt(columnName));
    }

    //当SQL语句返回的结果集转换为SexEnum类型时执行
    public SexEnum getResult(ResultSet rs, int columnIndex) throws SQLException {
        return SexEnum.getSexEnumById(rs.getInt(columnIndex));
    }

    //当SQL语句返回的结果集转换为SexEnum类型时执行
    public SexEnum getResult(CallableStatement cs, int columnIndex) throws SQLException {
        return SexEnum.getSexEnumById(cs.getInt(columnIndex));
    }
}
