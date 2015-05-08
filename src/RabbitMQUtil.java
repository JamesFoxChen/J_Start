import net.sf.json.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.AuthCache;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.protocol.ClientContext;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.auth.BasicScheme;
import org.apache.http.impl.client.*;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;


public class RabbitMQUtil    {
    private static HttpHost targetHost = new HttpHost("127.0.0.1", 15672, "http");
    private static CredentialsProvider credsProvider = new BasicCredentialsProvider();
    //按下面的方法设置Credentials无效
//        credsProvider.setCredentials(
//                new AuthScope(targetHost.getHostName(), targetHost.getPort()),
//                new UsernamePasswordCredentials("guest", "guest"));


    //    RabbitMQUtil.SendGet("http://localhost:15672/api/overview");
    //发送Get请求
    public  static  void SendGet(String url) throws IOException {
        credsProvider.setCredentials(AuthScope.ANY, new UsernamePasswordCredentials("guest:guest"));

        try (CloseableHttpClient httpClient = HttpClients.custom()
                                                .setDefaultCredentialsProvider(credsProvider)
                                                .build()) {
            HttpGet request = new HttpGet(url);
//            request.addHeader("content-type", "application/json");

            HttpResponse result = httpClient.execute(request);
            String json = EntityUtils.toString(result.getEntity(), "UTF-8");

            System.out.println(json);

        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

        public static void SendPost(String url,String body) {
            credsProvider.setCredentials(AuthScope.ANY, new UsernamePasswordCredentials("guest:guest"));

            try (CloseableHttpClient httpClient = HttpClients.custom()
                                                    .setDefaultCredentialsProvider(credsProvider)
                                                    .build()) {

                HttpPost request = new HttpPost(url);
                request.addHeader("content-type", "application/json");

                JSONObject jsonObject = JSONObject.fromObject(body);
                HttpEntity entity = new StringEntity(jsonObject.toString());
                request.setEntity(entity);

                HttpResponse result = httpClient.execute(request);
                String json = EntityUtils.toString(result.getEntity(), "UTF-8");

                System.out.println(json);
            }
            catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
//        DefaultHttpClient httpClient = new DefaultHttpClient();
//        HttpHost targetHost = new HttpHost("127.0.0.1", 15672, "http");
//
//        HttpGet request = new HttpGet(
//                "/api/overview");
//
//        httpClient.getCredentialsProvider().setCredentials(
//                new AuthScope(targetHost.getHostName(), targetHost.getPort()),
//                new UsernamePasswordCredentials("guest", "guest"));
//
//        AuthCache authCache = new BasicAuthCache();
//        BasicScheme basicAuth = new BasicScheme();
//        authCache.put(targetHost, basicAuth);
//        BasicHttpContext localcontext = new BasicHttpContext();
//        localcontext.setAttribute(ClientContext.AUTH_CACHE, authCache);
//
//        request.addHeader("Content-Type", "application/json");
//
////        StringEntity input = new StringEntity("{\"vhost\":\"/\",\"durable\":\"false\",\"auto_delete\":\"false\",\"arguments\":{}}");
////        request.setEntity(input);
//
//        HttpResponse response = httpClient.execute(targetHost, request, localcontext);



}
