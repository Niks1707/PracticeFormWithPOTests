package pages;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.TableResponsive;

import java.util.Objects;

import static com.codeborne.selenide.Condition.cssValue;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {

    private final SelenideElement
            firstNameInput =  $("#firstName"),
            lastNameInput =   $("#lastName"),
            emailInput =  $("#userEmail"),
            genderInput = $("#genterWrapper"),
            userNumberInput = $("#userNumber"),
            calendarInput = $("#dateOfBirthInput"),
            subjectsInput = $("#subjectsInput"),
            hobbiesInput = $("#hobbiesWrapper"),
            pictureInput = $("#uploadPicture"),
            addressCurrentInput = $("#currentAddress"),
            stateInput = $("#react-select-3-input"),
            cityInput = $("#react-select-4-input"),
            submitInput = $("#submit"),
            closeInput = $("#closeLargeModal"),
            fullNameInput = $("#userName"),
            permanentAddressInput = $("#permanentAddress");

CalendarComponent calendarComponent = new CalendarComponent();
TableResponsive tableResponsive = new TableResponsive();

    public RegistrationPage openPage() {
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    public RegistrationPage setFirstName (String value) {
        firstNameInput.scrollTo().setValue(value);
        return this;
    }
    public RegistrationPage setLastName (String value) {
        lastNameInput.scrollTo().setValue(value);
        return this;
    }
    public RegistrationPage setEmail (String value) {
        emailInput.scrollTo().setValue(value);
        return this;
    }
    public RegistrationPage setGender(String value) {
        genderInput.$(byText(value)).click();
        return this;
    }
    public RegistrationPage setUserNumber (String value) {
        userNumberInput.scrollTo().setValue(value);
        return this;
    }

    public RegistrationPage setDateOfBirth(String day,String month, String year) {
       calendarInput.scrollTo().click();
       calendarComponent.setDate(day, month, year);
       return this;
    }

    public RegistrationPage setSubjects(String value) {
        subjectsInput.scrollTo().setValue(value).pressEnter();
        return this;
    }
    public RegistrationPage setHobby(String value) {
        hobbiesInput.scrollTo().$(byText(value)).click();
        return this;
    }
    public void setPicture (String value) {
        if (!Objects.equals(Configuration.browser, "firefox")) {
            pictureInput.scrollTo().uploadFromClasspath(value);
        }
    }
    public RegistrationPage setAddress (String value) {
        addressCurrentInput.scrollTo().setValue(value);
        return this;
    }
    public RegistrationPage setState (String value) {
        stateInput.scrollTo().setValue(value).pressEnter();
        return this;
    }
    public RegistrationPage setCity (String value) {
        cityInput.scrollTo().setValue(value).pressEnter();
        return this;
    }
    public RegistrationPage setSubmit () {
        submitInput.scrollTo().click();
        return this;
    }

    public RegistrationPage checkResult(String key, String value) {
        tableResponsive.checkResult(key, value);
        return this;
    }
    public RegistrationPage negativeCheckResult(String key, String value){
        tableResponsive.negativeCheckResult(key, value);
        return this;
    }
    public RegistrationPage setCloseTable(){
        closeInput.scrollTo().click();
        return this;
    }
    public RegistrationPage negativeCheckForm() {
        firstNameInput.shouldHave(cssValue("border-color","rgb(220, 53, 69)"));
        return this;
    }
    public RegistrationPage openPageTextBox() {
        open("/text-box");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }
    public RegistrationPage setFullName (String value) {
        fullNameInput.scrollTo().setValue(value);
        return this;
    }
    public RegistrationPage setPermanentAddress (String value) {
        permanentAddressInput.scrollTo().setValue(value);
        return this;
    }
    public RegistrationPage checkResultTextBox(String key, String value) {
        tableResponsive.checkResultTextBox(key, value);
        return this;
    }
}
