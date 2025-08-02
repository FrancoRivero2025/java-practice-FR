package easy;

/**
 * Have the function DashInsert(str) insert dashes ('-')
 * between each two odd numbers in str. For example:
 * if str is 454793 the output should be 4547-9-3.
 * Don't count zero as an odd number.
 */
public class DashInsert {

  /**
   * Returns true if the digit character is odd.
   */
  private static boolean isOdd(char c) {
    int digit = Character.getNumericValue(c);
    return digit % 2 == 1;
  }

  /**
   * Dash Insert function.
   *
   * @param str input string
   * @return a string with dashes between each two odd numbers
   */
  private static String dashInsert(String str) {
    StringBuilder result = new StringBuilder();
    int length = str.length();

    for (int i = 0; i < length - 1; i++) {
      char current = str.charAt(i);
      char next = str.charAt(i + 1);

      result.append(current);

      if (isOdd(current) && isOdd(next)) {
        result.append("-");
      }
    }

    result.append(str.charAt(length - 1)); // Append last digit
    return result.toString();
  }

  /**
   * Entry point.
   *
   * @param args command line arguments
   */
  public static void main(String[] args) {
    System.out.println(dashInsert("454793"));    // 4547-9-3
    System.out.println(dashInsert("25928"));     // 25-928 
    System.out.println(dashInsert("123456789")); // 1234567-89
    System.out.println(dashInsert("13579"));     // 1-3-5-7-9
    System.out.println(dashInsert("24680"));     // 24680 (no cambios)
    System.out.println(dashInsert("9071"));      // 907-1
  }

}
