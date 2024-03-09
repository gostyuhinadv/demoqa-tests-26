package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.*;
import static com.codeborne.selenide.Condition.text;

import java.io.File;

import static com.codeborne.selenide.Selenide.*;

public class TestStudentRegistrationForm {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";

    }

    @Test
    void fillFormTest() {
        open("/automation-practice-form");
        $("#firstName").setValue("Ann");
        $("#lastName").setValue("Jillian");
        $("#userEmail").setValue("JillianAnn@goole.com");
        $("[for=\"gender-radio-2\"]").click();
        $("#userNumber").setValue("8913770733");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").click();
        $("[value=\"2010\"]").click();
        $("[aria-label=\"Choose Monday, March 15th, 2010\"]").click();
        $("input#subjectsInput").setValue("m");
        $x("//*[contains(text(),'Maths')]").click();
        $("[for=hobbies-checkbox-3]").click();
        $("#submit").scrollTo();
        $("#uploadPicture").uploadFromClasspath("kek.jpg");
        $("#currentAddress").setValue("Cambridge, Massachusetts");
        $x("//*[contains(text(),'Select State')]").click();
        $x("//*[contains(text(),'NCR')]").click();
        $x("//*[contains(text(),'Select City')]").click();
        $x("//*[contains(text(),'Delhi')]").click();
        $("#submit").click();


        $$("tr").get(1).shouldHave(text("Ann Jillian"));
        $$("tr").get(2).shouldHave(text("JillianAnn@goole.com"));
        $$("tr").get(3).shouldHave(text("Female"));
        $$("tr").get(4).shouldHave(text("8913770733"));
        $$("tr").get(5).shouldHave(text("15 March,2010"));
        $$("tr").get(6).shouldHave(text("Maths"));
        $$("tr").get(7).shouldHave(text("Music"));
        $$("tr").get(8).shouldHave(text("kek.jpg"));
        $$("tr").get(9).shouldHave(text("Cambridge, Massachusetts"));
        $$("tr").get(10).shouldHave(text("NCR Delhi"));
    }
}
