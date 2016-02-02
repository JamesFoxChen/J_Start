package test;

import org.junit.Test;

import bean.AdminInfo;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisTest {

	// http://www.cnblogs.com/xdp-gacl/p/4261895.html
	@Test
	public void Select() {
		// mybatis的配置文件
		String resource = "conf.xml";
		// 使用类加载器加载mybatis的配置文件（它也加载关联的映射文件）
		InputStream is = MybatisTest.class.getClassLoader().getResourceAsStream(resource);
		// 构建sqlSession的工厂
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
		// 使用MyBatis提供的Resources类加载mybatis的配置文件（它也加载关联的映射文件）
		// Reader reader = Resources.getResourceAsReader(resource);
		// 构建sqlSession的工厂
		// SqlSessionFactory sessionFactory = new
		// SqlSessionFactoryBuilder().build(reader);
		// 创建能执行映射文件中sql的sqlSession
		SqlSession session = sessionFactory.openSession();
		/**
		 * 映射sql的标识字符串，
		 * MyBatis.userMapper是userMapper.xml文件中mapper标签的namespace属性的值，
		 * getUser是select标签的id属性值，通过select标签的id属性值就可以找到要执行的SQL
		 */
		String statement = "MyBatis.userMapper.getAdminInfo";// 映射sql的标识字符串
		// 执行查询返回一个唯一user对象的sql
		AdminInfo adminInfo = session.selectOne(statement, 3);
		System.out.println("-------------------------");
		if (adminInfo != null) {
			System.out.println(adminInfo.getId());
			System.out.println(adminInfo.getAdminName());
			System.out.println(adminInfo);
			System.out.println(ReflectionToStringBuilder.toString(adminInfo));
		}
		else
		{
			System.out.println("返回参数为null");
		}
		System.out.println("-------------------------");
	}

}
