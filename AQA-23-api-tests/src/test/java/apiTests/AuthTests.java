package apiTests;

import baseRequestConstructor.BaseConstructor;
import org.junit.jupiter.api.Test;

public class AuthTests extends BaseConstructor {
    @Test
    public void getUserBooksAfterAuth(){
        String token = getTokenForBaseUser();
        System.out.println("INFO:" + token);
    }
}
