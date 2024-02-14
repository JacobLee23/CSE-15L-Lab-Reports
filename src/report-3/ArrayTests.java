/**
 * 
 */

import static org.junit.Assert.*;
import org.junit.*;


/**
 * 
 */
public class ArrayTests {

  /* */
  int[] input0 = {};
  int[] input1 = { 1 };
  int[] input2 = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
  int[] input3 = { 1, 1, 2, 3, 5, 8 };
  int[][] input = { input0, input1, input2, input3 };

  /* */
  int[] output0 = {};
  int[] output1 = { 1 };
  int[] output2 = { 9, 8, 7, 6, 5, 4, 3, 2, 1 };
  int[] output3 = { 8, 5, 3, 2, 1, 1 };
  int[][] output = { output0, output1, output2, output3 };

  /**
   * 
   */
	@Test 
	public void testReverseInPlace() {
    for (int i = 0; i < this.input.length; ++i) {
      ArrayExamples.reverseInPlace(this.input[i]);
      assertArrayEquals(this.output[i], this.input[i]);
    }
	}

  /**
   * 
   */
  @Test
  public void testReversed() {
    for (int i = 0; i < this.input.length; ++i) {
      assertArrayEquals(this.output[i], ArrayExamples.reversed(this.input[i]));
    }
  }

  /**
   * 
   */
  @Test
  public void testAverageWithoutLowest() {
    this.helpAverageWithoutLowest(this.input0, 0.0);
    this.helpAverageWithoutLowest(this.input1, 0.0);
    this.helpAverageWithoutLowest(this.input2, 5.5);
    this.helpAverageWithoutLowest(this.input3, 3.8);

    this.helpAverageWithoutLowest(this.output0, 0.0);
    this.helpAverageWithoutLowest(this.output1, 0.0);
    this.helpAverageWithoutLowest(this.output2, 5.5);
    this.helpAverageWithoutLowest(this.output3, 3.8);
  }

  /**
   * 
   * 
   * @param array
   * @param expected
   */
  public void helpAverageWithoutLowest(int[] array, double expected) {
    double[] temp = new double[array.length];
    for (int i = 0; i < array.length; ++i) {
      temp[i] = (double) array[i];
    }

    assertEquals(expected, ArrayExamples.averageWithoutLowest(temp), 0.0);
  }
}
