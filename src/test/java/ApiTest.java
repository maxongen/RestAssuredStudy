import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import static org.hamcrest.Matchers.equalTo;

public class ApiTest {
    @Test(description = "test")
    public void test() throws IOException {
       Response res=get("https://reqres.in/api/users");
        System.out.println(res.asString());

        String latestVersion = given().when().get("https://googlechromelabs.github.io/chrome-for-testing/LATEST_RELEASE_STABLE").
                then().statusCode(200).extract().asString().trim();
        System.out.println("latest version : "+latestVersion);
        String os ="mac-x64";
        String downloadURL=String.format("https://edgedl.me.gvt1.com/edgedl/chrome/chrome-for-testing/%s/%s/chromedriver-%s.zip",latestVersion,os,os);
        System.out.println("download URL : "+downloadURL);
        Response res1=given().when().get(downloadURL).then().statusCode(200).extract().response();
        byte[] fileBytes=res1.asByteArray();
        String filename="chromedriver-" + os + "-" + latestVersion + ".zip";
        try(FileOutputStream fos=new FileOutputStream(filename)){
            fos.write(fileBytes);
        }
        System.out.println("✅ ChromeDriver downloaded: " + filename);
    }
}
