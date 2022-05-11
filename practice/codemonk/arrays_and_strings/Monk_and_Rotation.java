
/**
 * @solutionTo: Monk and Rotation
 * @solutionTo: https://www.hackerearth.com/practice/codemonk/
 * @author https://www.hackerearth.com/@dalveer
 * @author https://github.com/Dalveer-Singh
 * 
 * @problem
 *          Monk loves to preform different operations on arrays, and so being
 *          the principal of Hackerearth School, he assigned a task to his new
 *          student Mishki. Mishki will be provided with an integer array A of
 *          size N and an integer K , where she needs to rotate the array in the
 *          right direction by K steps and then print the resultant array. As
 *          she is new to the school, please help her to complete the task.
 * 
 *          Sample Input
 *          1 -> testCases
 *          5 2 -> arraySize _ rotateBy
 *          1 2 3 4 5 -> array
 * 
 *          Sample Output
 *          4 5 1 2 3
 * 
 *          ***************
 *          ***************
 *          Developer Explanation
 *          ***************
 *          simply need to rotate 1D array
 *          -> Pick certain number of elements from any array from back and
 *          place them in front without changing any other order
 * 
 *          -> Trick is to not to convet String into array or any other
 *          collection, as this will consume alot of resources and increase both
 *          time and space complexity
 * 
 *          -> Solution is,
 *          -> 1. reduce rotations
 *          -> 2. find index of whitespace, where you want to break the string
 *          -> 3. print later part of substring first, then the remaining
 * 
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class TestClass {
    public static void main(String args[]) throws Exception {
        Scanner in = new Scanner(System.in);
        int testCases = Integer.parseInt(in.nextLine());
        do {
            try {
                // STEP 0: reading Input
                String values[] = in.nextLine().split(" ");
                int arrLen = Integer.parseInt(values[0]);
                int rotateBy = Integer.parseInt(values[1]);

                // STEP 1: reducde rotations
                if (rotateBy > arrLen) {
                    rotateBy = rotateBy % arrLen;
                }

                // basic checks
                String arr = in.nextLine();
                if (rotateBy == 0 || rotateBy == arrLen) {
                    System.out.println(arr);
                    continue;
                }

                // STEP 2: Find correct index Number
                int count = 0;
                int index = 0;
                while (count <= (arrLen - rotateBy - 1)) {// space count
                    index = arr.indexOf(' ', index + 1);
                    count++;
                }

                // STEP 3: Printing
                System.out.print(arr.substring(index).trim() + " ");
                System.out.println(arr.substring(0, index).trim());
            } catch (Exception e) {
                /*
                 * try-catch is to avoid "line-not-found" error, as i found that there is
                 * something wrong with website's input data
                 */
                // System.out.println(e);
            }

            testCases--;
        } while (testCases > 0);
    }

}

/**
 * Feedback requested:
 * did you find any incorrect/ inefficient coding practice?
 * 
 * @author https://www.hackerearth.com/@dalveer
 * @author https://github.com/Dalveer-Singh
 */