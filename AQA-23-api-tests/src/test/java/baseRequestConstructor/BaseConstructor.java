package baseRequestConstructor;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static baseRequestConstructor.JsonConstructor.getLoginBodyForAccount;
import static baseRequestConstructor.JsonConstructor.getLoginBodyStasUser1;
import static io.restassured.RestAssured.given;
import static userData.UrlsLists.ACCOUNT_LOGON_ENDPOINT;
import static userData.UrlsLists.BASE_USER_NAME;



public class BaseConstructor {
    public String getTokenForBaseUser() {
        ExtractableResponse<Response> response =
                postLoginMethod(getLoginBodyStasUser1());
        return response.body().jsonPath().get("token").toString();
    }

    public String getTokenForAccount(String userName, String pass) {
        ExtractableResponse<Response> response =
                postLoginMethod(getLoginBodyForAccount(userName, pass));
        return response.body().jsonPath().get("token").toString();
    }

    //Add method with

    public RequestSpecification getSpecWithAuth(String bearerToken) {
        RequestSpecBuilder specBuilder = new RequestSpecBuilder();
        specBuilder.addHeader("Content-Type", "application/json");
        specBuilder.addHeader("Authorization", "Bearer " + bearerToken);
        return specBuilder.build();
    }

    public ExtractableResponse<Response> createNewUser(String userName, String pass) {
        return  given()
                .header("Content-Type", "application/json")
                .body(getLoginBodyForAccount(userName, pass))
                .log().all()
                .when().post("https://demoqa.com/Account/v1/User")
                .then().log().all().extract();
    }

    public ExtractableResponse<Response> deleteUserById(String userId, String token) {
        return given()
                .spec(getSpecWithAuth(token)) // Add specification for request like header or cookies
                .log().all()
                .when()
                .delete(BASE_USER_NAME + userId)
                .then()
                .log().all().extract();
    }

    public ExtractableResponse<Response> generateToken(String userName, String pass){
        return given()
                .header("Content-Type", "application/json")
                .body(getLoginBodyForAccount(userName, pass))
                .log()
                .all()
                .when()
                .post("https://demoqa.com/Account/v1/GenerateToken")
                .then().log().all().extract();
    }

    public ExtractableResponse<Response> postLoginMethod(String payload) {
        return given()
                .header("Content-Type", "application/json")
                .body(payload)
                .log()
                .all()
                .when()
                .post(ACCOUNT_LOGON_ENDPOINT)
                .then().log().all().extract();
    }

    public ExtractableResponse<Response> getBooksForUser(String token, String userId) {
        return given()
                .spec(getSpecWithAuth(token)) // Add specification for request like header or cookies
                .log().all()
                .when()
                .get(BASE_USER_NAME + userId)
                .then().log().all().extract();
    }

    //Get all user`s books list
//    public ExtractableResponse<Response> getBooksForUser(String token, String userId) {
//        return given()
//                .spec(getSpecWithAuth(token)) // Add specification for request like header or cookies
//                .log().all()
//                .when()
//                .get(ACCOUNT_V1_USER_ENDPOINT + userId)
//                .then()
//                .log().all().extract();}
}


