package Utils;

import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcUtil {

	static String sql = null;
	static DBHelper db1 = null;
	static ResultSet ret = null;
	static Boolean b = false;

	public static void Select() {
		sql = "select *from admininfo";// SQL语句
		db1 = new DBHelper(sql);// 创建DBHelper对象

		try {
			ret = db1.pst.executeQuery();// 执行语句，得到结果集
			while (ret.next()) {
				String id = ret.getString(1);
				String adminName = ret.getString(2);
				System.out.println("id:" + id + "\t" + "adminName:" + adminName);
			} // 显示数据
			ret.close();
			db1.close();// 关闭连接
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static boolean Insert() {
		sql = "insert into admininfo(adminName) values('James')";// SQL语句
		db1 = new DBHelper(sql);// 创建DBHelper对象

		try {
			b = db1.pst.execute();// 执行语句，得到结果集
			ret.close();
			db1.close();// 关闭连接
		} catch (SQLException e) {
			e.printStackTrace();
			b=false;
		}
		
		return b;
	}

	public static boolean Update() {
		sql = "update admininfo"+
				" set adminName='chen'"+
				" where id=4";
		db1 = new DBHelper(sql);// 创建DBHelper对象

		try {
			b = db1.pst.execute();// 执行语句，得到结果集
			ret.close();
			db1.close();// 关闭连接
		} catch (SQLException e) {
			e.printStackTrace();
			b=false;
		}
		
		return b;
	}

	public static boolean Delete() {
		sql = "delete from admininfo where id=4";// SQL语句
		db1 = new DBHelper(sql);// 创建DBHelper对象

		try {
			b = db1.pst.execute();// 执行语句，得到结果集
			ret.close();
			db1.close();// 关闭连接
		} catch (SQLException e) {
			e.printStackTrace();
			b=false;
		}
		
		return b;
	}
}
