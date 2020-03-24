package com.nero.mybatis.typehandler;

import com.nero.mybatis.typehandler.domain.SexEnum;
import com.nero.mybatis.typehandler.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        try {
            // 读取配置文件 mybatis-config.xml
            InputStream config = Resources
                    .getResourceAsStream("mybatis-config.xml");
            // 根据配置文件构建SqlSessionFactory
            SqlSessionFactory ssf = new SqlSessionFactoryBuilder()
                    .build(config);

            // 通过 SqlSessionFactory 创建 SqlSession
            SqlSession ss = ssf.openSession();
            // SqlSession执行映射文件中定义的SQL，并返回映射结果

            // 添加一个用户
            User addmu = new User();
            addmu.setId(1);
            addmu.setName("陈恒");
            addmu.setSex(SexEnum.MALE);
            //com.nero.mybatis.typehandler.mapper.UserMapper.addUser 为 UserMapper.xml中的命名空间
            ss.insert("com.nero.mybatis.typehandler.mapper.UserMapper.addUser", addmu);
            // 查询一个用户
            User mu = ss.selectOne(
                    "com.nero.mybatis.typehandler.mapper.UserMapper.getUserById", 1L);
            System.out.println(mu);

            //删除刚刚创建的用户
            ss.delete("com.nero.mybatis.typehandler.mapper.UserMapper.deleteUser", 1L);
            // 提交事务
            ss.commit();
            // 关闭 SqlSession
            ss.close();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
