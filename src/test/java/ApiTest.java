import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.equalTo;

public class ApiTest {
    @Test(description = "test")
    public void test(){
       Response res= RestAssured.get("https://reqres.in/api/users");
        System.out.println(res.asString());
    }
}
