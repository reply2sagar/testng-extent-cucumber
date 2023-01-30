package org.softpost;

import com.aventstack.extentreports.ExtentReports;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import models.Address;
import models.Person;

import java.util.ArrayList;

import static org.testng.Assert.assertEquals;

public class MyStepdefs{
    CucumberContext context;
    Response response;
    ArticleApi api;
    String tokenName;
    static ExtentReports extent;
    public MyStepdefs(CucumberContext context){
        this.context = context;
        extent = context.getExtent();
    }
    @Given("I have entered {int} into the calculator")
    public void iHaveEnteredIntoTheCalculator(int arg0) {
        context.getTest().info("Running step" + arg0);

    }

    @When("I press add")
    public void iPressAdd() {
    }

    @Then("the result should be {int} on the screen")
    public void theResultShouldBeOnTheScreen(int arg0) {
    }


    @Given("I send the request to auth api to get token")
    public void iSendTheRequestToAuthApiToGetToken() {
        api = new ArticleApi();
        response = api.getArticles();
        assertEquals(200, response.getStatusCode());
        //context.getTest().info("Response " +response.prettyPrint());
        context.map.put("o1",new Person("Sagar"));
        JsonPath js = new JsonPath(response.getBody().asString());
        //context.getTest().info(js.getString("title"));

    }

    @Then("the token should be sent in the response")
    public void theTokenShouldBeSentInTheResponse() {
        assertEquals(200, response.getStatusCode());

        JsonPath jsonPath= response.jsonPath();
        Integer name = jsonPath.get("[0].userId");
        context.getTest().info("User Id is " + name);


        //Person p2 = (Person) context.map.get("o1");
        context.getTest().info("Response " + response.prettyPrint());

        //extract token and assign it to tokenValue
        //tokenValue =
    }

    @Given("I send the post request")
    public void iSendThePostRequest() throws Exception{

//        Post post = new Post();
//        post.setBody("Hello");
//        post.setTitle("Title");
//        post.setUserId("2");


        /*

        {
        name: "xyz",
        Addresses : [
            {city:"sds",postcode:4300},
            {}
        ]
        }


         */

        Address address1 = new Address();
        address1.setCity("Pune");
        Address address2 = new Address();
        address2.setCity("Brisbane");

        Person p1 = new Person("Amol");
        ArrayList<Address> addresses = new ArrayList<>();
        addresses.add(address1);
        addresses.add(address2);
        p1.setAddressList(addresses);

        ObjectMapper mapper = new ObjectMapper();
        String payload = mapper.writeValueAsString(p1);
        context.getTest().info("Payload " + payload);

        ArticleApi api = new ArticleApi();
        response = api.postArticle(payload);

    }

    @Then("new record should be created and id should be in the response")
    public void newRecordShouldBeCreatedAndIdShouldBeInTheResponse() {
        //String rawRequest = r
        //String rawResponse = response.asString();

        //System.out.println("REQUEST IN SOUT " + response.then().extract());
        //context.getTest().info("Raw Response " + response.then().log().all());
        assertEquals(201, response.getStatusCode());

        //context.getTest().info("Response Payload " + response.headers().toString());

    }
}
