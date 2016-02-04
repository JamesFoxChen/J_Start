package test.java;

import java.awt.List;
import java.io.InputStream;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import bean.AdminInfo;
import utils.MyBatisUtil;

public class MybatisTest {

	// http://www.cnblogs.com/xdp-gacl/p/4261895.html
	@Test
	public void Select() {
		// mybatis的配置文件
		String resource = "conf.xml";
		// 使用类加载器加载mybatis的配置文件（它也加载关联的映射文件）
		InputStream is = this.getClass().getClassLoader().getResourceAsStream(resource);
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
		 * myBatis.adminInfoMapper是adminInfoMapper.xml文件中mapper标签的namespace属性的值，
		 * getUser是select标签的id属性值，通过select标签的id属性值就可以找到要执行的SQL
		 */
		String statement = "myBatis.adminInfoMapper.getAdminInfo";// 映射sql的标识字符串
		// 执行查询返回一个唯一user对象的sql
		AdminInfo adminInfo = session.selectOne(statement, 13);
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

	@Test
	public void SelectAll() {
	
        SqlSession sqlSession = MyBatisUtil.getSqlSession(true);

        String statement = "myBatis.adminInfoMapper.getAllAdminInfo";
        
        //执行插入操作
        List retResult = (List) sqlSession.selectList(statement);
        //手动提交事务
        //sqlSession.commit();
        //使用SqlSession执行完SQL之后需要关闭SqlSession
        sqlSession.close();
        System.out.println(retResult.getItemCount());
	}
	
	@Test
	public void Insert() {
	
        SqlSession sqlSession = MyBatisUtil.getSqlSession(true);

        String statement = "myBatis.adminInfoMapper.insertAdminInfo";
        AdminInfo adminInfo= new AdminInfo();
        adminInfo.setAdminName("MyInfo");
        
        //执行插入操作
        int retResult = sqlSession.insert(statement,adminInfo);
        //手动提交事务
        //sqlSession.commit();
        //使用SqlSession执行完SQL之后需要关闭SqlSession
        sqlSession.close();
        System.out.println(retResult);
	}
	
	@Test
	public void Update() {
	
        SqlSession sqlSession = MyBatisUtil.getSqlSession(true);

        String statement = "myBatis.adminInfoMapper.updateAdminInfo";
        AdminInfo adminInfo= new AdminInfo();
        adminInfo.setId(5);
        adminInfo.setAdminName("MyInfo2");
        
        //执行插入操作
        int retResult = sqlSession.update(statement,adminInfo);
        //手动提交事务
        //sqlSession.commit();
        //使用SqlSession执行完SQL之后需要关闭SqlSession
        sqlSession.close();
        System.out.println(retResult);
	}
	
	@Test
	public void Delete() {
	
        SqlSession sqlSession = MyBatisUtil.getSqlSession(true);

        String statement = "myBatis.adminInfoMapper.deleteAdminInfo";
        
        //执行插入操作
        int retResult = sqlSession.delete(statement,1);
        //手动提交事务
        //sqlSession.commit();
        //使用SqlSession执行完SQL之后需要关闭SqlSession
        sqlSession.close();
        System.out.println(retResult);
	}
}
