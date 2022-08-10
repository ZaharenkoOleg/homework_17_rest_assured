import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Cookie;
import pages.RegistrationPage;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static helpers.CustomApiListener.withCustomTemplates;
import static io.restassured.RestAssured.given;

public class DemowebshopTests extends TestBase {

    TestData testData = new TestData();
    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    @Tag("DemoWebShop")
    @DisplayName("User registration tests")
    void RegistrationTest() {
        registrationPage.openRegistrationForm()
                .setGender(testData.gender)
                .setFirstName(testData.firstName)
                .setUserLastName(testData.lastName)
                .setUserEmail(testData.newEmail)
                .setUserPassword(testData.newPassword)
                .setConfirmUserPassword(testData.newPassword)
                .setUserRegister()
                .checkResult();
    }


    @Test
    @Tag("DemoWebShop")
    @DisplayName("Edit user account tests")
    void updateFistNameTest() {
        String authorizationCookieValue = given()
                .filter(withCustomTemplates())
                .contentType("application/x-www-form-urlencoded; charset=UTF-8")
                .formParam("Email", email)
                .formParam("Password", password)
                .when()
                .post("http://demowebshop.tricentis.com/login")
                .then()
                .statusCode(302)
                .extract().cookie("NOPCOMMERCE.AUTH");

        open("");
        Cookie authCookie = new Cookie("NOPCOMMERCE.AUTH", authorizationCookieValue);
        getWebDriver().manage().addCookie(authCookie);
        open("/customer/info");
        $("#FirstName").setValue(testData.firstName);
        $("[name='save-info-button']").click();
        $("#FirstName").shouldHave(Condition.value(testData.firstName));
    }
}

