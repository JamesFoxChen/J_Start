package utils;

import java.util.ArrayList;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import bean.Student;

public class JsonUtil {

	public static <T> ArrayList<T> JsonToEntityList(String data, Class<T> classT) {

		//http://blog.sina.com.cn/s/blog_4ca658400100u6ax.html
		try {
			JSONArray jsonArray2 = JSONArray.fromObject(data);

			ArrayList<T> list = (ArrayList<T>) JSONArray.toList(jsonArray2,
					classT);

			return list;

		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public static <T> T JsonToEntity(String data, Class<T> classT) {
		try {
			Object bean;
			JSONObject jsonObject = JSONObject.fromObject(data);
			bean = JSONObject.toBean(jsonObject, classT);
			return (T) bean;
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public static void JsonToEntity(String data) {
		JSONObject jsonObject = JSONObject.fromObject(data);
		Student bean = (Student) JSONObject.toBean(jsonObject, Student.class);
		System.out.println(bean);
	}

	// <editor-fold defaultstate="" desc="">
	public static String EntityToString(Student data) {
		JSONObject jsonObject = JSONObject.fromObject(data);
		String str = jsonObject.toString();
		System.out.println(str);
		return str;
	}

	public static <T> String EntityToStringGeneric(T data) {
		JSONObject jsonObject = JSONObject.fromObject(data);
		String str = jsonObject.toString();
		System.out.println(str);
		return str;
	}

	public static <T> String EntityToStringGenericList(T data) {
		JSONArray jsonObject = JSONArray.fromObject(data);
		String str = jsonObject.toString();
		System.out.println(str);
		return str;
	}
	// </editor-fold>
}
