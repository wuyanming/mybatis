package com.wym.shop.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;

public class MyBatisUtils {
   private static SqlSessionFactory sqlSessionFactory;
   
   static{
	    try {
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsReader("mybatis-config.xml"));
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("Mybatis 初始胡出现异常 ");
		}   
   }
   
   public static SqlSession openSession(){
	   return sqlSessionFactory.openSession();
   }
   
   
  
}
