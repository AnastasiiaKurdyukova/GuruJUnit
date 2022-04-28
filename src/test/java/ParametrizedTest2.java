
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;


    public class ParametrizedTest2 {
        @BeforeAll
        static void beforeAll(){
            Configuration.browserSize = "1920x1080";
        }
        @BeforeEach
        void precondition(){
            open("https://demoqa.com/text-box");
        }
        @AfterEach
        void closeBrowser(){
            Selenide.closeWebDriver();
        }
        @ValueSource(strings = {"QA", "Guru"})
        @ParameterizedTest(name = "Форма text-box  {0}")

        void parameterizedTest(String testData){


            $("#userName").setValue(testData);
            $("#userEmail").setValue(testData + "qa@guru.qa");
            $("#currentAddress").setValue("23 book street");
            $("#permanentAddress").setValue("street book 123");
            $("#submit").click();
            $("#output").shouldHave(text(testData))
                    .shouldHave(text(testData + "qa@guru.qa"))
                    .shouldHave(text("23 book street"))
                    .shouldHave(text("street book 123"));

        }

        @CsvSource(value = {
                "Qa/ qa@guru.qa/ Address, address Moscow/ Address, address Saint Petersburg",
                "Guru/ qa@guru.qa/ Address 1 Guru/ Address 2 Guru"
        },
                delimiter = '/')
        @ParameterizedTest(name = "Форма text-box {0}")

        void parameterizedCvTest(String testData, String email, String address, String curaddress){

            //заполнить поля
            $("#userName").setValue(testData);
            $("#userEmail").setValue(email);
            $("#currentAddress").setValue(address);
            $("#permanentAddress").setValue(curaddress);

            //кликнуть Submit
            $("#submit").click();
            //проверить значение в поле
            $("#output").shouldHave(text(testData))
                    .shouldHave(text(email))
                    .shouldHave(text(address))
                    .shouldHave(text(curaddress));

        }
        static Stream<Arguments> argumentsForThirdTest(){
            return Stream.of(
                    Arguments.of("qa@guru.qa"),
                    Arguments.of("guru@qa.guru")

            );
        }
        @MethodSource(value = "argumentsForThirdTest")
        @ParameterizedTest(name = "Валидация почты")
        void validationEmailTest (String login){
            $("#userEmail").setValue(login);
            $("#submit").click();

        }

    }