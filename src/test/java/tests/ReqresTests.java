package tests;

import io.restassured.RestAssured;
import models.Lombok.RegistrationBodyLombokModel;
import models.Lombok.RegistrationResponseLombokModel;
import models.Lombok.SingleUserBody;
import models.pojo.LoginBodyPojoModel;
import models.pojo.LoginResponsePojoModel;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static specs.DeleteUserSpec.requestSpecDelete;
import static specs.DeleteUserSpec.responseSpecDelete;
import static specs.RegistrationSpec.requestSpecRegistration;
import static specs.RegistrationSpec.responseSpecRegistration;
import static specs.SingleUserSpec.requestSpecSingleUser;
import static specs.SingleUserSpec.responseSpecSingleUser;

public class ReqresTests {
    @BeforeAll
    public static void beforeAll() {
        RestAssured.baseURI = "https://reqres.in";
    }

    @Test
    void RegistrationWithPojoModelsTest() {
        RegistrationBodyLombokModel body = new RegistrationBodyLombokModel();
        body.setName("morpheus");
        body.setJob("leader");
        RegistrationResponseLombokModel response = given()
                .spec(requestSpecRegistration)
                .body(body)
                .when()
                .post()
                .then()
                .spec(responseSpecRegistration)
                .extract().as(RegistrationResponseLombokModel.class);
        assertEquals("morpheus", response.getName());
        assertEquals("leader", response.getJob());
        assertNotNull(response.getId());
    }

    @Test
    void loginWithPojoModelsTest() {
        LoginBodyPojoModel body = new LoginBodyPojoModel();
        body.setEmail("eve.holt@reqres.in");
        body.setPassword("cityslicka");

        LoginResponsePojoModel response = given()
                .contentType(JSON)
                .body(body)
                .when()
                .post("/api/login")
                .then()
                .statusCode(200)
                .extract().as(LoginResponsePojoModel.class);
        assertEquals("QpwL5tke4Pnpja7X4", response.getToken());

    }

    @Test
    void singleUserWithLombokModel() {
        SingleUserBody response = given()
                .spec(requestSpecSingleUser)
                .when()
                .get()
                .then()
                .spec(responseSpecSingleUser)
                .extract().as(SingleUserBody.class);
        assertEquals(2, response.getResponse().getId());
    }

    @Test
    void deleteUser() {
        given()
                .spec(requestSpecDelete)
                .when()
                .delete()
                .then()
                .spec(responseSpecDelete);
    }
}
