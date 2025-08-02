package easy;

import java.util.HashSet;

/**
 * Have the function DistinctCharacters(str) take the str parameter being passed
 * and determine if it contains at least 10 distinct characters,
 * if so, then your program should return the string true,
 * otherwise it should return the string false.
 * ---
 * For example: if str is "abc123kkmmmm?" then your program should return the string false
 * because this string contains only 9 distinct characters:
 * a, b, c, 1, 2, 3, k, m. ? adds up to 9.
 */
public class DistinctCharacters {

  /**
   * Distinct Characters function.
   *
   * @param str input string
   * @return "true" if a string contains at least 10 distinct characters.
   */
  private static String distinctCharacters(String str) {
    HashSet<Character> notDuplicatedCharacters = new HashSet<>();
    for (char ch : str.toCharArray()) {
      notDuplicatedCharacters.add(ch);
      if (notDuplicatedCharacters.size() >= 10) {
        return "true";
      }
    }

    return "false";
  }

  /**
   * Entry point.
   *
   * @param args command line arguments
   */
  public static void main(String[] args) {
    System.out.println(distinctCharacters("12334bbmma:=6")); // true(10)
    System.out.println(distinctCharacters("001122334455667788")); //false (9) 
    System.out.println(distinctCharacters("abc123kkmmmm?"));     // false (9)
    System.out.println(distinctCharacters("abcdefghij"));        // true (10)
    System.out.println(distinctCharacters("abc123kkmmmm!?@"));   // true (11)
    System.out.println(distinctCharacters("aaaaaa"));            // false (1)
    System.out.println(distinctCharacters("1234567890"));        // true (10)
  }

}
