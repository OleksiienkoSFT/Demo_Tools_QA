package apiTests;

import baseRequestConstructor.BaseConstructor;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.Customization;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.skyscreamer.jsonassert.comparator.CustomComparator;
import org.skyscreamer.jsonassert.comparator.JSONComparator;
import userData.FileUtils;

import java.io.File;

import static baseRequestConstructor.JsonConstructor.getLoginBodyForAccount;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static userData.TestUsers.BASE_USER_ID;

public class AuthTests extends BaseConstructor {

//    @Test
//    public void getUserBooksAfterAuth(){
//        String token = getTokenForBaseUser(); // Get token for user
//        System.out.println("INFO:" + token);
//        ExtractableResponse<Response> resp = getBooksForUser(token, BASE_USER_ID);
//        assertTrue(resp.body().jsonPath().get("books.isbn[0]").equals("9781449325862"));

//        assertThat(resp.body().jsonPath().getList("books.isbn"),
//                allOf(hasItem("9781449325862"),hasItem("9781449337711")));}

    String userName = "Stas12332154";
    String pass = "P@ssword1";

    String userId;

    @Test
    public void getUserBooksAfterAuth() throws JSONException {
        ExtractableResponse<Response> extResp =
                getBooksForUser(getTokenForBaseUser(), BASE_USER_ID);
        assertEquals(HttpStatus.SC_OK, extResp.statusCode());

        JSONObject jsonObject = new JSONObject(String.format(FileUtils.readDataFromFile(new File("src/test/resources/assertGetBooks.json")),7777));
        System.out.println("JSON INFO" + jsonObject);

        JSONAssert.assertEquals(
                jsonObject.toString(),
                extResp.asPrettyString(),
                compareBooksExceptIsbnFiled()
        );
    }

    public static JSONComparator compareBooksExceptIsbnFiled() {
        return new CustomComparator(JSONCompareMode.LENIENT,
                new Customization("books[author=Richard E. Silverman].isbn", (o1, o2) -> true),
                new Customization("books[author=Glenn Block et al.].isbn", (o1, o2) -> true)
        );
    }

    @Test
    public void createNewUserAndGetToken() {
        //Create user step
        ExtractableResponse<Response> create = createNewUser(userName, pass);
        generateToken(userName, pass);
        //Get user info after login step
        ExtractableResponse<Response> getUserInfo =
                postLoginMethod(getLoginBodyForAccount(userName, pass));

        userId = getUserInfo.jsonPath().getString("userId").toString();
        String token = getUserInfo.body().jsonPath().getString("token").toString();
        //Delete user
        ExtractableResponse<Response> deleteUser = deleteUserById(userId, token);

        //Create user assert
        assertEquals(HttpStatus.SC_CREATED, create.statusCode());
        //Get user info after login assert
        assertEquals(HttpStatus.SC_OK,getUserInfo.statusCode());
        //Delete user assert
        assertEquals(HttpStatus.SC_NO_CONTENT, deleteUser.statusCode());
    }

}
