import java.io.IOException;

public class Start {

    public static void main(String[] args) throws IOException {
        //System.out.println("Hello, world");

        String result = "";
//       RabbitMQUtil.SendGet("http://localhost:15672/api/overview");
        String body="{\"properties\":{},\"routing_key\":\"logs\",\"payload\":\"my body\",\"payload_encoding\":\"string\"}";
       RabbitMQUtil.SendPost("http://localhost:15672/api/exchanges/%2F/logs/publish",body);
//		String url="http://localhost:10083/v2/bizvouchers/getlist?nosign=1";
//		HttpUtil.HttpPost(url);
//		result=StringUtils.AppendCurrentDate("Hello");
//		System.out.println(result);

//		result=RedisTest.Simple();
//	    System.out.println(result);
//		MongoTest.Simple();

//        try {
//            PropertiesUtil p = new PropertiesUtil();
//            result = p.readValue("username");
//            System.out.print(result);
//
//            System.out.println();
//            p.setValue("username123", "James123m");
//            result = p.readValue("username123");
//            System.out.print(result);
//
//            System.out.println();
//            p.updateValue("username123", "James333");
//            result = p.readValue("username123");
//            System.out.print(result);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

    }

}
