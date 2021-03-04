package HomeWorks.HomeWork7;

public class Main {
  public static void main(String[] args) {
    try {
      Testing.goTests(TestSuite.class);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
