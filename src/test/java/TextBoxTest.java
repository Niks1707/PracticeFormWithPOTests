import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

public class TextBoxTest extends TestBase{
    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    public void textBoxTest(){
        registrationPage.openPageTextBox()
                .setFullName("Ivan Ivanov")
                .setEmail("iivanov@gmail.com")
                .setAddress("Lenina street")
                .setPermanentAddress("Lenina street, Moscow")
                .setSubmit()
                .checkResultTextBox("Name:", "Ivan Ivanov")
                .checkResultTextBox("Email:", "iivanov@gmail.com")
                .checkResultTextBox("Current Address :", "Lenina street")
                .checkResultTextBox("Permananet Address :", "Lenina street, Moscow");
    }
}
