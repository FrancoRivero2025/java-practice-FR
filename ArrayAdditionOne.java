package easy;

import java.util.Arrays;

/**
 * Have the function ArrayAdditionI(arr) take the array of numbers stored in arr
 * and return the string true if any combination of numbers in the array
 * (excluding the largest number) can be added up to equal the largest number in the array,
 * otherwise return the string false.
 * ---
 * For example: if arr contains [4, 6, 23, 10, 1, 3] the output
 * should return true because 4 + 6 + 10 + 3 = 23.
 * ---
 * The array will not be empty, will not contain all the same elements,
 * and may contain negative numbers.
 */
public class ArrayAdditionOne {

  /**
   * Left pad a binary string with zeroes to match the required length.
   */
  private static String padLeft(String str, int len) {
    return String.format("%" + len + "s", str).replace(" ", "0");
  }

  /**
   * Check if any combination of elements (excluding the largest)
   * adds up to the largest value in the array.
   */
  private static String arrayAdditionOne(int[] arr) {
    Arrays.sort(arr);
    int largest = arr[arr.length - 1];

    if (canSumToTarget(Arrays.copyOf(arr, arr.length - 1), largest)) {
      return "true";
    }
    else {
      return "false";
    }
  }

  /**
   * Try all combinations of the input array to check if any subset sums to target.
   */
  private static boolean canSumToTarget(int[] nums, int target) {
    int totalCombinations = 1 << nums.length; // 2^n combinations

    for (int i = 1; i < totalCombinations; i++) { // start from 1 to skip empty set
      String binaryMask = padLeft(Integer.toBinaryString(i), nums.length);
      int subsetSum = 0;

      for (int j = 0; j < binaryMask.length(); j++) {
        if (binaryMask.charAt(j) == '1') {
          subsetSum += nums[j];
        }
      }

      if (subsetSum == target) {
        return true;
      }
    }

    return false;
  }

  /**
   * Entry point for manual test.
   */
  public static void main(String[] args) {
    System.out.println(arrayAdditionOne(new int[]{4, 6, 23, 10, 1, 3})); // true
    System.out.println(arrayAdditionOne(new int[]{2, 6, 18}));          // false
    System.out.println(arrayAdditionOne(new int[]{1, 2, 3, 7}));        // true (1+2+3=6)
    System.out.println(arrayAdditionOne(new int[]{5, -2, 3, 9, 1}));    // true (-2+3+1+5=7)
  }
}
