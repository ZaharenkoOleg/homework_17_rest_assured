package specs;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.with;
import static org.hamcrest.Matchers.containsString;


public class RegistrationSpec {
    public static RequestSpecification requestSpecRegistration = with()
            .basePath("/api/users")
            .log().all()
            .contentType(ContentType.JSON);

    public static ResponseSpecification responseSpecRegistration = new ResponseSpecBuilder()
            .expectStatusCode(201)
            .log(LogDetail.STATUS)
            .log(LogDetail.BODY)
            .expectBody(containsString("id"))
            .build();
}