import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ApiTest extends BaseTest{

    @Test
    public void testMethod() {
        test.info("Simple number test");
        assertEquals(2,2,"Same?");
    }

    @Test
    public void getUserPost() {
        PostApi api = new PostApi();
        Response response = api.getPosts();
        assertEquals(200, response.getStatusCode());
        test.info("200 response got from api" + response.toString());
        // assertEquals("quidem molestiae enim", response.jsonPath().get("title"));
    }

    @Test
    public void PostRequest(){
        String payload = "{\"title\":\"foo\",\"body\":\"bar\",\"userId\":1}";
        PostApi api = new PostApi();
        Response response = api.submitPost(payload);
        assertEquals(201, response.getStatusCode());
        test.info("201 response got from api");
    }

}
