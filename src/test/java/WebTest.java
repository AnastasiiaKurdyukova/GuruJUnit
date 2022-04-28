//import com.codeborne.selenide.Condition;
//import com.codeborne.selenide.Selenide;
//import com.codeborne.selenide.WebDriverRunner;
//import domain.MenuItem;
//import org.junit.jupiter.api.*;
//import org.junit.jupiter.params.ParameterizedTest;
//import org.junit.jupiter.params.provider.*;
//
//import java.util.List;
//import java.util.stream.Stream;
//
//import static com.codeborne.selenide.Condition.visible;
//import static com.codeborne.selenide.Selenide.$;
//import static com.codeborne.selenide.Selenide.$$;
//
//public class WebTest {
//
//    @ValueSource(strings = {
//            "Selenide",
//            "JUnit"
//    })
//    @DisplayName("Поиск в Яндексе по слову Selenide")
//    @ParameterizedTest(name = "Проверка поиска в яндексе по слову {0}")
//    void selenideSearchTest(String testData) {
//// Предусловия
//        Selenide.open("https://ya.ru/");
//        //Шаги
//        $("#text").setValue(testData);
//        $("button[type='submit']").click();
//
////  Ожидаемый результат:
//        $$(".serp-item").find(Condition.text(testData)).shouldBe(visible);
//    }
//    @CsvSource(value = {
//            "Selenide, is an open source library for test",
//            "JUnit, Support JUnit"
//    })
//
//    @ParameterizedTest(name = "Проверка поиска в яндексе по слову {0}, ожидаем результат: {1}")
//
//    void jUnitSearchTest(String testData, String expectedResult) {
//// Предусловия
//        Selenide.open("https://ya.ru/");
//        //Шаги
//        $("#text").setValue(testData);
//        $("button[type='submit']").click();
//
////  Ожидаемый результат:
//        $$(".serp-item").find(Condition.text(testData)).shouldBe(visible);
//    }
//    static Stream<Arguments> methodSourceExampleTest() {
//        return Stream.of(
//                Arguments.of("first string", List.of(42, 13)),
//                Arguments.of("second string", List.of(1, 2))
//        );
//    }
//
//    @MethodSource("methodSourceExampleTest")
//    @ParameterizedTest
//    void methodSourceExampleTest(String first, List<Integer> second) {
//        System.out.println(first + " and list: " + second);
//    }
//
//    @EnumSource(MenuItem.class)
//    @ParameterizedTest()
//    void yaSearchMenuTest(MenuItem testData){
//        Selenide.open("https://ya.ru/");
//        //Шаги
//        $("#text").setValue("Allure TestOps");
//        $("button[type='submit']").click();
//
////  Ожидаемый результат:
//        $$(".navigation__item")
//                .find(Condition.text(testData.rusName))
//                .click();
//
//
//    System.out.println(MenuItem.IMG.rusName);
//
//        Assertions.assertEquals(
//                2,
//                WebDriverRunner.getWebDriver().getWindowHandles().size()
//        );
//}
//
//    @AfterEach
//    void close() {
//        Selenide.closeWebDriver();
//    }
//
//    @Override
//    public String toString() {
//        return "WebTest{}";
//    }
//
//    @DisplayName("Класс с демонстрационными тестами")
//    public static class SimpleTest {
//
//        @Disabled("CODETOOLS-7902347")
//        @DisplayName("Демонстрационный тест")
//        @Test
//        void firstTest() {
//            // Вот тут проверим ...
//            Assertions.assertTrue(3 > 2);
//            Assertions.assertFalse(3 < 2);
//            Assertions.assertEquals("Foo", "Foo");
//            Assertions.assertAll(
//                    () -> Assertions.assertTrue(3 < 2),
//                    () -> Assertions.assertTrue(3 > 2)
//            );
//        }
//
//        @DisplayName("Демонстрационный тест № 2")
//        @Test
//        void secondTest() {
//            Assertions.assertTrue(3 < 2);
//        }
//    }
//}
//
//
