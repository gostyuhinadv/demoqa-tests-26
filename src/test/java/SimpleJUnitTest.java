import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SimpleJUnitTest {

    int result;

    @BeforeAll
    static void beforAll() {

    }

    @BeforeEach
    void beforEach() {
        System.out.println("###    beforEach()");
        result = getResult();
    }

    @AfterEach
    void afterEach() {
        System.out.println("###    afterEach()");
        result = 0;
    }

    @AfterAll
    static void afterAll() {

    }

    @Test
    void firsthTest() {
        System.out.println("###    firsthTest()");
        Assertions.assertTrue(result > 2);
    }

    @Test
    void secondTest() {
        System.out.println("###    secondTest()");
        Assertions.assertTrue(result > 2);
    }

    private int getResult() {
        return 3;
    }
}
