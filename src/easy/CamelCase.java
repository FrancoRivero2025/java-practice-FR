package easy;

import java.util.Arrays;

/**
 * Have the function CamelCase(str) take the str parameter being passed
 * and return it in proper camel case format where the first letter
 * of each word is capitalized (excluding the first letter).
 * ---
 * The string will only contain letters and some combination of delimiter
 * punctuation characters separating each word.
 * For example: if str is "BOB loves-coding" then your program
 * should return the string bobLovesCoding.
 */
public class CamelCase {

  /**
   * Camel Case function.
   *
   * @param str input string
   * @return a string in proper camel case format
   */
  private static String camelCase(String str) {
    StringBuilder camel = new StringBuilder();
    String[] words_without_filter = str.split("[^a-zA-Z]+");
    
    String[] words = Arrays.stream(words_without_filter)
                              .filter(s -> !s.isEmpty())
                              .toArray(String[]::new);
    camel.append(words[0].toLowerCase());
    for (int i = 1; i < words.length; i++) {
      String word = words[i].toLowerCase();
      camel.append(Character.toUpperCase(word.charAt(0)))
              .append(word.substring(1));
    }
    return camel.toString();
  }

  /**
   * Entry point.
   *
   * @param args command line arguments
   */
  public static void main(String[] args) {
    System.out.println(camelCase("_good_looking_blues_"));      // goodLookingBlues
    System.out.println(camelCase("-=last-night-on-earth=-"));   // lastNightOnEarth
    System.out.println(camelCase("BOB loves-coding"));          // bobLovesCoding
    System.out.println(camelCase("java_script-isAwesome"));     // javaScriptIsAwesome
    System.out.println(camelCase("HELLO world"));               // helloWorld
    System.out.println(camelCase("react-native_app"));          // reactNativeApp
    System.out.println(camelCase("TESTING"));                   // testing
    System.out.println(camelCase("camel--Case__test"));         // camelCaseTes

  }

}
