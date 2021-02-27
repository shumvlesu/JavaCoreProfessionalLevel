package Lessons.Lesson6;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

//Пример использования библиотеки JUnit
//При написании тестов важно помнить что тесты не должны зависеть друг от друга
class CalculatorTest {

  //можно и лог прикрутить
  private static final Logger LOG = LogManager.getLogger(CalculatorTest.class);

  private Calculator calculator;

  @BeforeEach//этот метод, с такой аннотацией, выполнится перед каждым тестом
  void init() {
    calculator = new Calculator();
  }

  //@AfterEach//этот метод, с такой аннотацией, выполнится после каждого теста
  @AfterAll// - выполнится после всех тестов класса CalculatorTest, тогда метод должен быть статичным.
  static void finalise() {
    LOG.info("Как бы удаляем ненужные объекты");
  }


  //C помощью такой аннотации мы можем передававть в параматризованые тесты наборы переменных для тестирования
  //addTest тест при запуске тестов получит наши a,b и ожидаемый резултьтат (result)
  @CsvSource({
          "4.0,6.0,10.0",
          "4,6,10",
          "3,3,6",
          "100,100,200",
          "45,56,101"
  })




  //@BeforeAll - выполнится перед всеми тестами класса CalculatorTest
  //@AfterAll - выполнится после всех тестов класса CalculatorTest

  //@Test//аннотация говорит что это тест
  //@CsvFileSource(resources = "src/main/resources/input.csv")
  @ParameterizedTest //аннотация параметризуемого теста , теперь можно написать входные параметры
  void addTest(double a, double b, double result) {
    //double a = 6;
    //double b = 4;
    //можно и лог прикрутить
    LOG.info("a={}, b={}", a, b);
    //запускаю тестируемый метод, передаю свои параметры в него
    //result = calculator.add(a, b);
    //мы ожидаем что результат сложения будет равен 10.0 с помощью класса Assertions сравниваем результат с ожидаемым значением
    Assertions.assertEquals(result,calculator.add(a, b));
  }

  @Test
  void subTest() {
    //Calculator calculator = new Calculator();
    double a = 6;
    double b = 4;
    double result = calculator.sub(a, b);
    Assertions.assertEquals(a - b, result);
  }

  //@Test
  @MethodSource("dataForMult") //указываю из какого метода брать параметры. метод источник должен быть статическим
  @ParameterizedTest
  void multTest(double a, double b, double out) {
    Assertions.assertEquals(out,calculator.mult(a, b));
  }

  static Stream<Arguments> dataForMult(){
    List<Arguments> result = new ArrayList<>();
    Random random = new Random();
    for (int i = 0; i < 100; i++) {
      double a = random.nextDouble();
      double b = random.nextDouble();
      double out = a*b;
      result.add(Arguments.arguments( a, b, out));
    }
    return result.stream();
  }


  @Test
  @Disabled //этот тест у меня провалится и я поставил аннотацию -@Disabled, что бы его отключить для выполнения
  void divTest() {
    double a = 6;
    double b = 0;
    double result = calculator.div(a, b);
    //Assertions.assertEquals(a/b,result);
    //делаем чтобы тест провалился.
    Assertions.assertEquals(-1, result);
  }

  @Test
  @Timeout(value = 3, unit = TimeUnit.SECONDS) //Тест очень долгий и такой аннотацией мы можем через 3 секунды отменить его выполнение
  void longTest() throws InterruptedException {
    Thread.sleep(5000);
  }


}