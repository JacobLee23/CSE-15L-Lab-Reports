/**
 * 
 */


/**
 * 
 */
public class ArrayExamples {

  /**
   * 
   * 
   * @param arr
   */
  static void reverseInPlace(int[] arr) {
    for(int i = 0; i < arr.length; i += 1) {
      arr[i] = arr[arr.length - i - 1];
    }
  }

  /**
   * 
   * 
   * @param arr
   * @return
   */
  static int[] reversed(int[] arr) {
    int[] temp = new int[arr.length];

    for(int i = 0; i < arr.length; i += 1) {
      temp[i] = arr[arr.length - i - 1];
    }

    return temp;
  }

  /**
   * 
   * 
   * @param arr
   * @return
   */
  static double averageWithoutLowest(double[] arr) {
    if (arr.length < 2) {
      return 0.0;
    }

    double lowest = arr[0];
    double sum = 0;
    for (double num: arr) {
      lowest = (num < lowest ? num : lowest);
      sum += num;
    }

    return (sum - lowest) / (arr.length - 1);
  }


}

