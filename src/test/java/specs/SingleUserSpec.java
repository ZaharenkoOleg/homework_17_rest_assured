package specs;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.with;

public class SingleUserSpec {
    public static RequestSpecification requestSpecSingleUser = with()
            .basePath("/api/users/2")
            .log().all()
            .contentType(ContentType.JSON);

    public static ResponseSpecification responseSpecSingleUser = new ResponseSpecBuilder()
            .expectStatusCode(200)
            .log(LogDetail.STATUS)
            .log(LogDetail.BODY)
            .build();
}
