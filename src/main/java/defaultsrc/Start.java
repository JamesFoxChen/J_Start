package defaultsrc;
import java.io.IOException;

import annotationDemo.DescBean;

public class Start {

	public static void main(String[] args) throws IOException {

		DescBean descBean = new DescBean();
		descBean.OutputAnnotation();
		// System.out.println("Hello, world");

		// String result = "";

		// RabbitMQUtil.SendGet("http://localhost:15672/api/overview");
		// String
		// msg="{\"properties\":{},\"routing_key\":\"logs\",\"payload\":\"my body\",\"payload_encoding\":\"string\"}";
		// RabbitMQUtil.SendPost("http://localhost:15672/api/exchanges/%2F/logs/publish",msg);
		// String url="http://localhost:10083/v2/bizvouchers/getlist?nosign=1";
		// HttpUtil.HttpPost(url);
		// String result=StringUtils.AppendCurrentDate("Hello");
		// System.out.println(result);

		// result=RedisTest.Simple();
		// System.out.println(result);
		// MongoTest.Simple();

		// try {
		// PropertiesUtil p = new PropertiesUtil();
		// result = p.readValue("username");
		// System.out.print(result);
		//
		// System.out.println();
		// p.setValue("username123", "James123m");
		// result = p.readValue("username123");
		// System.out.print(result);
		//
		// System.out.println();
		// p.updateValue("username123", "James333");
		// result = p.readValue("username123");
		// System.out.print(result);
		// } catch (IOException e) {
		// e.printStackTrace();
		// }

	}

}
