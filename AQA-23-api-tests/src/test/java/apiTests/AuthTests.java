package apiTests;

import baseRequestConstructor.BaseConstructor;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static junit.framework.Assert.assertTrue;
import static userData.TestUsers.BASE_USER_ID;

public class AuthTests extends BaseConstructor {
    @Test
    public void getUserBooksAfterAuth(){
        String token = getTokenForBaseUser(); // Get token for user
        System.out.println("INFO:" + token);
        ExtractableResponse<Response> resp = getBooksForUser(token, BASE_USER_ID);
        assertTrue(resp.body().jsonPath().get("books.isbn[0]").equals("9781449325862"));
        assertThat(resp.body().jsonPath().getList("books.isbn"),
                allOf(hasItem("9781449325862"),hasItem("9781449337711")));
    }
}
