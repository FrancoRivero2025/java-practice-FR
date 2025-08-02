package easy;

/**
 * Have the function ExOh(str) take the str parameter being passed
 * and return the string true if there is an equal number of x's and o's,
 * otherwise return the string false. Only these two letters
 * will be entered in the string, no punctuation or numbers.
 * For example: if str is "xooxxxxooxo" then the output
 * should return false because there are 6 x's and 5 o's.
 */
public class ExOh {

  /**
   * EX OH function.
   *
   * @param str input string
   * @return "true" if there is an equal number of x's and o's
   */
  private static String exOh(String str) {
    int balance = 0;
    String[] letters = str.toLowerCase().split("");
    for (String l : letters) {
      switch (l) {
        case "x":
          balance++;
          break;
        case "o":
          balance--;
          break;
        default:
          return "-1";
      }
    }
    return balance == 0 || str.length() == 0 ? "true" : "false";
  }

  /**
   * Entry point.
   *
   * @param args command line arguments
   */
  public static void main(String[] args) {
    System.out.println(exOh("xxxooo"));
    System.out.println(exOh("xxxxxxxoooo"));
    System.out.println(exOh("xxxoo"));
    System.out.println(exOh("xxxxxxxxoooooooo"));
  }

}
