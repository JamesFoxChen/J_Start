import java.io.IOException;
import java.util.ArrayList;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

public class HttpUtil {

	public static void HttpPost(String url) {

		//ArrayList<FileInformation> dataFromService = new ArrayList<FileInformation>();
		try (CloseableHttpClient httpClient = HttpClientBuilder.create()
				.build()) {

			HttpPost request = new HttpPost(url);
			request.addHeader("content-type", "application/json");
			request.addHeader("Authorization",
					"Bearer a62247ad4a6756aa2e1c74e58fc5405e");
			request.addHeader("ClientId",
					"jwjb_6adf2af64a9e460aa96e4ac631ed16d1");

			HttpEntity entity = new StringEntity(
					"{\"ID\":1,\"Name\":\"James\"}", "UTF-8");
			request.setEntity(entity);

			HttpResponse result = httpClient.execute(request);
			String json = EntityUtils.toString(result.getEntity(), "UTF-8");

			System.out.println(json);
			// com.google.gson.Gson gson = new com.google.gson.Gson();
			// FileInformation[] response = gson.fromJson(json,
			// FileInformation[].class);

			// System.out.println(response.length);
			// for(FileInformation file : response)
			// {
			// dataFromService.add(file);
			// System.out.println(file.toString());
			// }

		} 
		catch (IOException ex) {
		}
//		return dataFromService;
	}

}
