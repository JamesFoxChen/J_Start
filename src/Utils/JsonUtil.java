package Utils;

import net.sf.json.JSONObject;
import bean.Student;

public class JsonUtil {

	public static <T> T JsonToEntity(String data,Class<T> classT) {
		try{
			Object bean;
			JSONObject jsonObject = JSONObject.fromObject(data);
			bean = JSONObject.toBean(jsonObject, classT);
			return (T)bean;
		}catch(Exception ex){
			ex.printStackTrace();
			return null;
		}
	}
	
	public static void JsonToEntity(String data) {
		JSONObject jsonObject = JSONObject.fromObject(data);
		Student bean = (Student)JSONObject.toBean(jsonObject, Student.class);
		System.out.println(bean);
	}
	
	public static String EntityToString(Student data) {
		JSONObject jsonObject = JSONObject.fromObject(data);
		String str=jsonObject.toString();
		System.out.println(str);
		return str;
	}
}
