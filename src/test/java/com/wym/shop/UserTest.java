package com.wym.shop;

import com.wym.shop.dao.UserDao;
import com.wym.shop.entity.User;
import com.wym.shop.util.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;

import java.io.InputStream;

/**
 * Created by Administrator on 2016/4/15.
 */
@ContextConfiguration(locations = {"classpath*:spring-mybatis.xml"})
public class UserTest {
//    @Resource
//    private UserDao userDao;
//    @Test
//    public void getOne(){
//        System.out.print(userDao);
//        User user= userDao.getUserById(1);
//        System.out.print(user);
//    }
    @Test
    public void getUser(){
        SqlSession sqlSession = MyBatisUtils.openSession();
        UserDao userDAO = (UserDao)sqlSession.getMapper(UserDao.class);

        User user = userDAO.getUserById(1);
        System.out.println("user name is "+user.getName());
}


    @Test
    public void testUser(){
        //mybatis的配置文件
        String resource = "spring-mybatis.xml";
        //使用类加载器加载mybatis的配置文件（它也加载关联的映射文件）
        InputStream is = UserTest.class.getClassLoader().getResourceAsStream(resource);

        //构建sqlSession的工厂
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
        //使用MyBatis提供的Resources类加载mybatis的配置文件（它也加载关联的映射文件）
        //Reader reader = Resources.getResourceAsReader(resource);
        //构建sqlSession的工厂
        //SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
        //创建能执行映射文件中sql的sqlSession
        SqlSession session = sessionFactory.openSession();
        /**
         * 映射sql的标识字符串，
         * me.gacl.mapping.userMapper是userMapper.xml文件中mapper标签的namespace属性的值，
         * getUser是select标签的id属性值，通过select标签的id属性值就可以找到要执行的SQL
         */
        String statement = "com.wym.shop.mapping.getUser";//映射sql的标识字符串
        //执行查询返回一个唯一user对象的sql
        User user = session.selectOne(statement, 1);
        System.out.println(user);
    }

}
