import io.restassured.response.Response;
import org.softpost.ArticleApi;
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

        ArticleApi api = new ArticleApi();
        Response response = api.getArticles();
        assertEquals(200, response.getStatusCode());
        test.info("200 response got from api" + response.toString());
        // assertEquals("quidem molestiae enim", response.jsonPath().get("title"));
    }

    @Test
    public void PostRequest(){
        String payload = "{\"title\":\"foo\",\"body\":\"bar\",\"userId\":1}";
        ArticleApi api = new ArticleApi();
        Response response = api.postArticle(payload);
        assertEquals(201, response.getStatusCode());
        test.info("201 response got from api");
    }

}
