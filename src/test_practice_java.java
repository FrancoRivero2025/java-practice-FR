import java.util.*;

class Main {

  public static String ArrayCouples(int[] arr) {
    // code goes here
    ArrayList<String> invalid_couples = new ArrayList<>();
    boolean[] used = new boolean[arr.length];

    for (int i = 0; i < arr.length; i+=2) {
      int a = arr[i];
      int b = arr[i+1];

      boolean found = false;
      for (int j = 0; j < arr.length; j+=2) {
        if (j == i || used[j]) {
          continue;
        }
        if (arr[j] == b && arr[j+1] == a) {
          used[j] = true;
          found = true;
          break;
        }
        if (!found) {
          invalid_couples.add(String.valueOf(a));
          invalid_couples.add(String.valueOf(b));
        }
      }
    }
    if (invalid_couples.isEmpty()) {
      return "yes";
    } else {
      String couples = String.join(",", invalid_couples);
      return couples;
    }
  }

  public static void main (String[] args) {  
    // keep this function call here
    int test[] = {1,2,3,4,5,6,7};
    System.out.print(ArrayCouples(test)); 
  }

}