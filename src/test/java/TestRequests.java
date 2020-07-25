import io.restassured.response.Response;
import org.junit.jupiter.api.*;
import pages.ParseMethods;
import utils.EndPoints;
import utils.Property;

import java.io.IOException;

import static io.restassured.RestAssured.given;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@DisplayName("API tests for news-api")
public class TestRequests extends TestInit {

    private Response response = null;

    @Test
    @Order(1)
    @DisplayName("Check first source name")
    public void checkFirstSource() throws IOException {
        response = given()
                .spec(requestSpec)
                .get(EndPoints.BASE_URL + EndPoints.SOURCES + "?" + EndPoints.API_KEY + Property.getPropertyValue("api_key"));
        Assertions.assertEquals("ABC News", ParseMethods.getFirstSourceInfo(response));
    }

    @Test
    @Order(2)
    @DisplayName("Check first source description")
    public void checkFirstSourceDescription() throws IOException {
        response = given()
                .spec(requestSpec)
                .get(EndPoints.BASE_URL + EndPoints.SOURCES + "?" + EndPoints.API_KEY + Property.getPropertyValue("api_key"));
        Assertions.assertEquals("Your trusted source for breaking news, analysis, exclusive interviews, headlines, and videos at ABCNews.com.",
                ParseMethods.getFirstSourceDescription(response));
    }

    @Test
    @Order(3)
    @DisplayName("Check first Belarus News author")
    public void checkFirstBelarusNewsAuthor() throws IOException {
        response = given()
                .spec(requestSpec)
                .get(EndPoints.BASE_URL + EndPoints.EVERYTHING + EndPoints.BELARUS_SEARCH_PARAM + EndPoints.API_KEY + Property.getPropertyValue("api_key"));
        Assertions.assertEquals("Belarus election: Hundreds protest after Lukashenko's rivals barred",
                ParseMethods.getFirstBelarusNewsTitle(response));
    }

}
