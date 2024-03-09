package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.*;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class TestStudentRegistrationForm {

    @BeforeAll
    static void beforAll() {
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
        $("input#uploadPicture").uploadFile(new File("/Users/daria/IdeaProjects/qa_guru/demoqa-tests-26/kek.jpg"));
        $("#currentAddress").setValue("Cambridge, Massachusetts");
        $x("//*[contains(text(),'Select State')]").click();
        $x("//*[contains(text(),'NCR')]").click();
        $x("//*[contains(text(),'Select City')]").click();
        $x("//*[contains(text(),'Delhi')]").click();
        $("#submit").click();

        
        $x("//*[contains(text(),'Thanks for submitting the form')]");
        $x("//*[contains(text(),'Student Name')]/..*[2]");
    }
}
