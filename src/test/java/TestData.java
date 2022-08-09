import com.github.javafaker.Faker;

import java.util.Random;

public class TestData {

    Faker faker = new Faker();
    String firstName = faker.address().firstName(),
            lastName = faker.address().lastName(),
            newEmail = faker.internet().emailAddress(),
            newPassword = faker.internet().password(),
            gender = randomGender();
    public static String randomGender() {

        String[] gender = {"Male", "Female"};
        return (gender[new Random().nextInt(gender.length)]);
    }
}