package apiTests;

import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class AuthTest {

    @Test
    public void simpleTestStatusCode (){
        given()
                .when()
                .get("https://demoqa.com/BookStore/v1/Books")
                .then().log().body()
                .assertThat().statusCode(HttpStatus.SC_OK);
    }
    @Test
    public void simpleTest1 (){
        given()
                .when()
                .get("https://demoqa.com/BookStore/v1/Books")
                .then().log().body()

                .assertThat().body("books.isbn[1]", equalTo("9781449331818"));
    }
    @Test
    public void simpleTest2 (){
        given()
                .when()
                .get("https://demoqa.com/BookStore/v1/Books")
                .then().log().body()
                .assertThat().body("books.title[2]", equalTo("Designing Evolvable Web APIs with ASP.NET"));
    }

    @Test
    public void simpleTest3 (){
        given()
                .when()
                .get("https://demoqa.com/BookStore/v1/Books")
                .then().log().body()
                .assertThat().body("books.author[3]", equalTo("Axel Rauschmayer"));
    }

    @Test
    public void simpleTest4 (){
        given()
                .when()
                .get("https://demoqa.com/BookStore/v1/Books")
                .then().log().body()
                .assertThat()
                    .body("books.pages[0]", equalTo(234))


                    .body("books.subTitle[0]", equalTo("A Working Introduction"))
                    .body("books.publisher[0]", equalTo("O'Reilly Media"));
    }
}
