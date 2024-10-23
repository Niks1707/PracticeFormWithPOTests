import com.codeborne.selenide.Configuration;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import utils.RandomUtils;
import java.util.Objects;
import static io.qameta.allure.Allure.step;

@DisplayName("Тест на регистрацию в Practice Form")
@Tag("Test")
public class PracticeFormWithPOTests extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    @Story("Проверка с использованием лямбда шагов через step")
    @Owner("Genkel Veronika")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "Testing", url = "https://demoqa.com/automation-practice-form")
    @DisplayName("Позитивный тест на регистрацию в Practice Form")
    void fillFormTest() {
        step("Открытие страницы Practice Form", () -> {
            registrationPage.openPage();
        });
        step("Регистрация пользователя", () -> {
            registrationPage.setFirstName("Ivan");
            registrationPage.setLastName("Ivanov");
            registrationPage.setEmail("iivanov@gmail.com");
            registrationPage.setGender("Other");
            registrationPage.setUserNumber("8800555353");
            registrationPage.setDateOfBirth("28","April","1997");
            registrationPage.setSubjects("Physic");
            registrationPage.setHobby("Sports");
            registrationPage.setPicture("test.png");
            registrationPage.setAddress("Lenina street");
            registrationPage.setState("NCR");
            registrationPage.setCity("Gurgaon");
            registrationPage.setSubmit();
        });
        step("Проверка данных", () -> {
            registrationPage.checkResult("Student Name", "Ivan Ivanov");
            registrationPage.checkResult("Gender", "Other");
            registrationPage.checkResult("Mobile", "8800555353");
            registrationPage.checkResult("Date of Birth", "28 April,1997");
            registrationPage.checkResult("Subjects", "Physic");
            registrationPage.checkResult("Hobbies", "Sports");
            registrationPage.checkResult("Picture", "test.png");
            registrationPage.checkResult("Address", "Lenina street");
            registrationPage.checkResult("State and City", "NCR Gurgaon");
            registrationPage.negativeCheckResult("Student Name", "Ivan Petrov");
        });
    }

    @Test
    @Story("Проверка с использованием лямбда шагов через step")
    @Owner("Genkel Veronika")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "Testing", url = "https://demoqa.com/automation-practice-form")
    @DisplayName("Позитивный тест на регистрацию в Practice Form с минимальными данными")

    void minimalFormTest() {

        step("Открытие страницы Practice Form", () -> {
            registrationPage.openPage();
        });
        step("Регистрация пользователя", () -> {
            registrationPage.setFirstName("Ivan");
            registrationPage.setLastName("Ivanov");
            registrationPage.setGender("Other");
            registrationPage.setUserNumber("8800555353");
            registrationPage.setDateOfBirth("28", "April", "1997");
            registrationPage.setSubmit();
        });

        step("Проверка данных", () -> {
            registrationPage.checkResult("Student Name", "Ivan Ivanov");
            registrationPage.checkResult("Gender", "Other");
            registrationPage.checkResult("Mobile", "8800555353");
            registrationPage.checkResult("Date of Birth", "28 April,1997");
        });
    }

    @Test
    @Story("Проверка с использованием лямбда шагов через step")
    @Owner("Genkel Veronika")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "Testing", url = "https://demoqa.com/automation-practice-form")
    @DisplayName("Негативный тест на регистрацию в Practice Form")
    void negativeFormTest() {
        step("Открытие страницы Practice Form", () -> {
            registrationPage.openPage();
        });

        step("Регистрация пользователя", () -> {
            registrationPage.setSubmit();
        });
        step("Проверка данных", () -> {
            registrationPage.negativeCheckForm();
        });
    }
}