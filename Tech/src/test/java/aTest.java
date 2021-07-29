import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.junit.Assert;
import org.junit.Test;

import javax.xml.ws.Response;
import java.io.IOException;
import java.util.Map;

public class aTest {

    @Test
    public void getUserTest() throws IOException {
      String userEndpoint="https://reqres.in/api/users/2";
        HttpClient httpClient= HttpClientBuilder.create().build();
        HttpGet httpGet=new HttpGet(userEndpoint);
        HttpResponse response=httpClient.execute(httpGet);

        Assert.assertEquals(200, response.getStatusLine().getStatusCode());
        ObjectMapper objectMapper=new ObjectMapper();
        Map < String, Map < String, Object >> parsedResponce =objectMapper.readValue(response.getEntity().getContent(), new TypeReference<Map < String, Map < String, Object >>>() {
        } );
        System.out.println(parsedResponce.get("data").get("email"));
    }
}
