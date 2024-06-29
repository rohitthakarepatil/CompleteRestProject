package com.testing.base;

import com.testing.actions.AssertActions;
import com.testing.endpoints.APIEndpoints;
import com.testing.modules.PayloadManager;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeTest;

public class BaseTest {
    public RequestSpecification requestSpecification;
    public Response response;
    public ValidatableResponse validatableResponse;
    public PayloadManager payloadManager;
    public JsonPath jsonPath;
    public AssertActions assertActions;


@BeforeTest
    public void setUp(){
    payloadManager = new PayloadManager();
    assertActions = new AssertActions();

    requestSpecification = new RequestSpecBuilder().
            setBaseUri(APIEndpoints.BASE_URL).
            addHeader("Content-type","application/json")
            .build().log().all();

    //        requestSpecification = RestAssured.
//                given()
//                .baseUri(APIConstants.BASE_URL)
//                .contentType(ContentType.JSON)
//                .log().all();
    }

}
