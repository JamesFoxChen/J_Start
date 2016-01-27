package Utils;
import java.net.URI;

import net.sf.json.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

public class HttpUtil {

	public static String Post(String url,String data) {
		String response ="";
				
		try (CloseableHttpClient httpClient = HttpClientBuilder.create()
				.build()) {

			HttpPost request = new HttpPost(url);
			request.addHeader("content-type", "application/json");
			request.addHeader("Authorization",
					"Bearer a62247ad4a6756aa2e1c74e58fc5405e");
			request.addHeader("ClientId",
					"jwjb_6adf2af64a9e460aa96e4ac631ed16d1");

//			GetVoucherListMessage requsetParams=new GetVoucherListMessage();
//			requsetParams.setBid(1);
//			requsetParams.setIsSend(999);
//			JSONObject jsonObject = JSONObject.fromObject(requsetParams);
			
			HttpEntity entity = new StringEntity(data);
			
			request.setEntity(entity);

			HttpResponse result = httpClient.execute(request);
			response = EntityUtils.toString(result.getEntity(), "UTF-8");

			//System.out.println(response);
		} 
		catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		
		return response;
	}
	
	public static String Get(String url) {
		String response ="";
				
		try (CloseableHttpClient httpClient = HttpClientBuilder.create()
				.build()) {

			HttpGet request = new HttpGet(url);
			request.setURI(new URI(url));  

			HttpResponse result = httpClient.execute(request);
			response = EntityUtils.toString(result.getEntity(), "UTF-8");

			//System.out.println(response);
		} 
		catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		
		return response;
	}
}
