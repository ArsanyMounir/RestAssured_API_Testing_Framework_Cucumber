package stepDefinition;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.Test;
//import org.testng.Assert;
import resources.APIResourcesEnum;
import resources.TestDataBuild;
import resources.Utils;

import java.io.IOException;
import java.util.Optional;


import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class StepDef {
    RequestSpecification res;
    ResponseSpecification responseSepc;
    Response addResponse;
    TestDataBuild data = new TestDataBuild();
    Utils util = new Utils();
    static String  placeID;


    @Given("Add Place Payload with {string} {string} {string}")
    public void addPlacePayloadWith(String name, String language, String address) throws IOException {
        res = given().spec(util.requestSpecification()).body(data.addPlacePayload(name,language,address));
    }


    @When("user calls {string} with {string} http request")
    public void user_calls_with_http_request(String apiName, String httpMethod) {
        APIResourcesEnum endPointAPI = APIResourcesEnum.valueOf(apiName);

        responseSepc =new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
        if(httpMethod.equalsIgnoreCase("POST"))
        {
            addResponse = res.when().post(endPointAPI.getResource())
                    .then().spec(responseSepc).extract().response();
        }
        else if (httpMethod.equalsIgnoreCase("GET")){
            addResponse = res.when().get(endPointAPI.getResource())
                    .then().spec(responseSepc).extract().response();
        }
    }

    @Then("the API call is success with status code {int}")
    public void the_api_call_is_success_with_status_code(int int1) {

        assertEquals(addResponse.getStatusCode(),int1);

    }

    @Then("{string} in response body is {string}")
    public void in_response_body_is(String keyValue, String expectedValue) {
        JsonPath js = addResponse.jsonPath();
        assertEquals(js.get(keyValue),expectedValue);

    }


    @Then("verify place_Id created maps to {string} using {string}")
    public void verifyPlace_IdCreatedMapsToUsing(String expectedName, String apiName) throws IOException {
        placeID= addResponse.jsonPath().get("place_id");
        res=given().spec(util.requestSpecification()).queryParam("place_id",placeID);
        user_calls_with_http_request(apiName,"GET");
        String actualName= addResponse.jsonPath().get("name");
        assertEquals(actualName,expectedName);

    }

    @Given("DeletePlace Payload")
    public void deleteplacePayload() throws IOException {
        System.out.println(placeID);
        res = given().spec(util.requestSpecification()).body(data.deletePlacePayload(placeID));
    }
}
