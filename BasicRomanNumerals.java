package easy;

import java.util.HashMap;

/**
 * Have the function BasicRomanNumerals(str) read str which will be a string of Roman numerals.
 * The numerals being used are: I for 1, V for 5, X for 10, L for 50,
 * C for 100, D for 500 and M for 1000.
 * In Roman numerals, to create a number like 11 you simply add a 1 after the 10,
 * so you get XI. But to create a number like 19, you use the subtraction notation
 * which is to add I before an X or V (or add an X before an L or C).
 * So 19 in Roman numerals is XIX.
 * ---
 * The goal of your program is to return the decimal equivalent of the Roman numeral given.
 * For example: if str is "XXIV" your program should return 24
 */
public class BasicRomanNumerals {
  private enum RomanNumeral {
    M(1000),
    D(500),
    C(100),
    L(50),
    X(10),
    V(5),
    I(1);

    private final int value;

    RomanNumeral(int value) {
      this.value = value;
    }

    public int getValue() {
      return value;
    }

    public static RomanNumeral fromSymbol(String symbol) {
      try {
        return RomanNumeral.valueOf(symbol);
      } catch (IllegalArgumentException e) {
        throw new IllegalArgumentException("Invalid Roman numeral symbol: " + symbol);
      }
    }
}

  /**
   * Basic Roman Numerals function.
   *
   * @param str input string
   * @return the decimal equivalent of the Roman numeral given
   */
  private static int basicRomanNumerals(String str) {
    // reversing the string makes the parsing easier
    char[] reversed = new StringBuilder(str).reverse().toString().toCharArray();
    int result = 0;
    int prevValue = 0;
    for (char cr : reversed) {
      int thisValue = RomanNumeral.fromSymbol(Character.toString(cr)).getValue();
      if (thisValue < prevValue) {
        result -= thisValue;
      } else {
        result += thisValue;
      }
      prevValue = thisValue;
    }
    return result;
  }

  /**
   * Entry point.
   *
   * @param args command line arguments
   */
  public static void main(String[] args) {
    System.out.println(basicRomanNumerals("XXIV"));   // 24
    System.out.println(basicRomanNumerals("XLVI"));   // 46

    // Casos básicos
    System.out.println(basicRomanNumerals("I"));      // 1
    System.out.println(basicRomanNumerals("V"));      // 5
    System.out.println(basicRomanNumerals("X"));      // 10
    System.out.println(basicRomanNumerals("L"));      // 50
    System.out.println(basicRomanNumerals("C"));      // 100
    System.out.println(basicRomanNumerals("D"));      // 500
    System.out.println(basicRomanNumerals("M"));      // 1000

    // Casos con notación de resta
    System.out.println(basicRomanNumerals("IV"));     // 4
    System.out.println(basicRomanNumerals("IX"));     // 9
    System.out.println(basicRomanNumerals("XL"));     // 40
    System.out.println(basicRomanNumerals("XC"));     // 90
    System.out.println(basicRomanNumerals("CD"));     // 400
    System.out.println(basicRomanNumerals("CM"));     // 900

    // Casos compuestos más largos
    System.out.println(basicRomanNumerals("XIX"));    // 19
    System.out.println(basicRomanNumerals("LXXX"));   // 80
    System.out.println(basicRomanNumerals("XCIX"));   // 99
    System.out.println(basicRomanNumerals("CXLIV"));  // 144
    System.out.println(basicRomanNumerals("CDXLIV")); // 444
    System.out.println(basicRomanNumerals("DCCCXC")); // 890
    System.out.println(basicRomanNumerals("MCMXC"));  // 1990
    System.out.println(basicRomanNumerals("MMXXIV")); // 2024
}


}
