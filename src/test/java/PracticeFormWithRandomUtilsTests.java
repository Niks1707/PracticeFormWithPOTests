import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import utils.RandomUtils;

public class PracticeFormWithRandomUtilsTests extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();
    RandomUtils randomUtils = new RandomUtils();
    @Test
    void fillFormTest() {

        String firstName = randomUtils.getFirstName;
        String lastName = randomUtils.getLastName;
        String userEmail = randomUtils.getUserEmail;
        String gender= randomUtils.getRandomGender();
        String userNumber = randomUtils.getUserNumber;
        String day = String.valueOf(randomUtils.getDay());
        String months = randomUtils.getMonths();
        String year = randomUtils.getYear;
        String subjects = randomUtils.getSubjects();
        String hobbies = randomUtils.getHobbies();
        String picture = randomUtils.getRandomFile();
        String currentAddress = randomUtils.getCurrentAddress;
        String state = randomUtils.getState();
        String city = randomUtils.getCity(state);


        registrationPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(userEmail)
                .setGender(gender)
                .setUserNumber(userNumber)
                .setDateOfBirth(day,months,year)
                .setSubjects(subjects)
                .setHobby(hobbies)
                .setPicture(picture)
                .setAddress(currentAddress)
                .setState(state)
                .setCity(city)
                .setSubmit()
                .checkResult("Student Name", firstName+" "+lastName)
                .checkResult("Student Email", userEmail)
                .checkResult("Gender", gender)
                .checkResult("Mobile", userNumber)
                .checkResult("Date of Birth", day+" "+months+","+year)
                .checkResult("Subjects", subjects)
                .checkResult("Hobbies", hobbies)
                .checkResult("Picture", picture)
                .checkResult("Address", currentAddress)
                .checkResult("State and City", state+" "+city)
                .setCloseTable();
    }

}