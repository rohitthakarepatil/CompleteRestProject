package com.testing.tests.CRUD;

import com.testing.base.BaseTest;
import com.testing.endpoints.APIEndpoints;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class TestCreateBookingPost extends BaseTest {

    @Test
    @Description("Simple POST request to create booking")
    @Owner("Rohit")
    @Severity(SeverityLevel.NORMAL)
    public void testCreateBookingPost() {
        // Create a new booking
        // Verify that the booking was created successfully

        requestSpecification.basePath(APIEndpoints.CREATE_UPDATE_BOOKING_URL);

       response = RestAssured.given(requestSpecification)
                .when().body(payloadManager.createPayloadBookingAsString()).post();

       validatableResponse = response.then().log().all();


        //ASSERTIONS

      validatableResponse.statusCode(200);

      validatableResponse.extract().response().prettyPrint();
        System.out.println(validatableResponse.extract().response().prettyPrint());
    }
}
