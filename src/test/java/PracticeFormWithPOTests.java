import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
@DisplayName("Тест на регистрацию в Practice Form")
public class PracticeFormWithPOTests extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();

    @DisplayName("Позитивный тест на регистрацию в Practice Form")
    @Tag("fullTest")
    @Test
    void fillFormTest() {
        registrationPage.openPage()
                .setFirstName("Ivan")
                .setLastName("Ivanov")
                .setEmail("iivanov@gmail.com")
                .setGender("Other")
                .setUserNumber("8800555353")
                .setDateOfBirth("28","April","1997")
                .setSubjects("Physic")
                .setHobby("Sports")
                .setPicture("test.png")
                .setAddress("Lenina street")
                .setState("NCR")
                .setCity("Gurgaon")
                .setSubmit()
                .checkResult("Student Name", "Ivan Ivanov")
                .checkResult("Gender", "Other")
                .checkResult("Mobile", "8800555353")
                .checkResult("Date of Birth", "28 April,1997")
                .checkResult("Subjects", "Physic")
                .checkResult("Hobbies", "Sports")
                .checkResult("Picture", "test.png")
                .checkResult("Address", "Lenina street")
                .checkResult("State and City", "NCR Gurgaon")
                .negativeCheckResult("Student Name", "Ivan Petrov")
                .setCloseTable();
    }
    @DisplayName("Позитивный тест на регистрацию в Practice Form с минимальными данными")
    @Test
    void minimalFormTest() {
        registrationPage.openPage()
                .setFirstName("Ivan")
                .setLastName("Ivanov")
                .setGender("Other")
                .setUserNumber("8800555353")
                .setDateOfBirth("28", "April", "1997")
                .setSubmit()
                .checkResult("Student Name", "Ivan Ivanov")
                .checkResult("Gender", "Other")
                .checkResult("Mobile", "8800555353")
                .checkResult("Date of Birth", "28 April,1997")
                .setCloseTable();
    }
    @DisplayName("Негативный тест на регистрацию в Practice Form")
    @Test
    void negativeFormTest() {
        registrationPage.openPage()
                .setSubmit()
                .negativeCheckForm();
    }
}