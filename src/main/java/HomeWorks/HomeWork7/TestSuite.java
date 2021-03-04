package HomeWorks.HomeWork7;

public class TestSuite {

  @BeforeSuite
  public void beforeSuite() {
    System.out.println("Выполняем - Before Suite тест");
  }

  @Test(priority = 1)
  public void test1() {
    System.out.println("Тест1 с приоритетом - 1");
  }

  @Test(priority = 3)
  public void test2() {
    System.out.println("Тест2 с приоритетом - 3");
  }

  @Test(priority = 2)
  public void test3() {
    System.out.println("Тест3 с приоритетом - 2");
  }

  @Test(priority = 2)
  public void test4() {
    System.out.println("Тест4 с приоритетом - 2");
  }

  @AfterSuite
  public void afterSuite() {
    System.out.println("Выполняем - After Suite тест");
  }

}
