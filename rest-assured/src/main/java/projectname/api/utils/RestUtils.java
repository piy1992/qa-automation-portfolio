package projectname.api.utils;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import projectname.api.config.ConfigManager;

public class RestUtils {
    ConfigManager cm = new ConfigManager();

    private RequestSpecification getRequestSpec(){
        return new RequestSpecBuilder().setBaseUri(cm.getEnvConfigProperty("BASE_URL"))
        .setContentType(ContentType.JSON)
        .addFilter(new RequestLoggingFilter()).
        addFilter(new ResponseLoggingFilter()).build();
    }

    public Response performGetRequest(String endpoint, String authToken){
        return RestAssured.given().spec(getRequestSpec())
        .header("Authroization", "Bearer" + authToken)
        .when()
        .get(endpoint)
        .then()
        .extract()
        .response();
    }
    public Response performPostRequest(String endpoint, String authToken, Object payload){
        return RestAssured.given().spec(getRequestSpec())
        .header("Authroization", "Bearer" + authToken)
        .body(payload)
        .when()
        .post(endpoint)
        .then()
        .extract()
        .response();
    }
}
