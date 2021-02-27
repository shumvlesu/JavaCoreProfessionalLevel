package Lessons.Lesson6;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.*;

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

  //@BeforeAll - выполнится перед всеми тестами класса CalculatorTest
  //@AfterAll - выполнится после всех тестов класса CalculatorTest

  @Test
//аннотация говорит что это тест
  void addTest() {
    double a = 6;
    double b = 4;
    //можно и лог прикрутить
    LOG.info("a={}, b={}", a, b);
    //запускаю тестируемый метод, передаю свои параметры в него
    double result = calculator.add(a, b);
    //мы ожидаем что результат сложения будет равен 10.0 с помощью класса Assertions сравниваем результат с ожидаемым значением
    Assertions.assertEquals(10.0, result);
  }

  @Test
  void subTest() {
    //Calculator calculator = new Calculator();
    double a = 6;
    double b = 4;
    double result = calculator.sub(a, b);
    Assertions.assertEquals(a - b, result);
  }

  @Test
  void multTest() {
    double a = 6;
    double b = 4;
    double result = calculator.mult(a, b);
    Assertions.assertEquals(a * b, result);
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
}