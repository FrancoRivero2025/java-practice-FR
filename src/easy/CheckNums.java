package easy;

/**
 * Have the function CheckNums(num1,num2) take both parameters
 * being passed and return the string true if num2 is greater
 * than num1, otherwise return the string false.
 * If the parameter values are equal to each other, then return the string -1.
 */
public class CheckNums {

  /**
   * Check Nums function.
   *
   * @param num1 first number to compare
   * @param num2 second number to compare
   * @return result of the comparison
   */
  private static String checkNums(int num1, int num2) {
    if (num1 == num2) {
      return "-1";
    } else if(num2 > num1) {
      return "true";
    } else {
      return "false";
    }
  }

  /**
   * Entry point.
   *
   * @param args command line arguments
   */
  public static void main(String[] args) {
    System.out.println(checkNums(63, 16)); 
    System.out.println(checkNums(50, 50));
    System.out.println(checkNums(70, 60));
    System.out.println(checkNums(50, 60));
  }

}
