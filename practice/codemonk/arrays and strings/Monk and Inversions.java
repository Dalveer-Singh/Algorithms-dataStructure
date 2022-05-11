
/**
 * solution to: https://www.hackerearth.com/practice/codemonk/
 * 
 * Monk's best friend Micro, who happen to be an awesome programmer, got him an
 * integer matrix M of size for his birthday. Monk is taking coding classes from
 * Micro. They have just completed array inversions and Monk was successful in
 * writing a program to count the number of inversions in an array. Now, Micro
 * has asked Monk to find out the number of inversion in the matrix M. Number of
 * inversions, in a matrix is defined as the number of unordered pairs of cells
 * such that .
 * Monk is facing a little trouble with this task and since you did not got him
 * any birthday gift, you need to help him with this task.
 * 
 * Sample Input
 * 2 -> no of test cases
 * 3 -> Array Size N*N
 * 1 2 3
 * 4 5 6
 * 7 8 9
 * 2 -> Array Size
 * 4 3
 * 1 4
 * 
 * Sample Output
 * 0
 * 2
 ** ************
 ** ************
 ** ************ Developer Explanation
 ** ************
 ** Compare each element with all previous elements of same and previous rows
 ** Example:
 * [00 01 02]
 * [10 11 12]
 * [20 21 22]
 * 
 * CONDITIONS to check
 * -> if(01>00) -> if(02>01) -> if(02>00)
 * -> if(11>10) -> if(12>11) -> if(12>10) ->-> if(11>00) -> if(12>02)->
 * if(12>01)-> if(12>00)
 * 
 * **** other words
 * Assuming we are on element '11'
 * -> then we need to compare it with 10, 01 and 00.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.IntStream;

class TestClass {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static public int count = 0;

    public static void main(String args[]) {
        try {
            int testCase = Integer.parseInt(br.readLine());
            // call method as per number of testcases.
            IntStream.range(0, testCase).forEach(i -> System.out.println(findCount()));
        } catch (Exception e) {
            System.out.println("error: " + e);
        }
    }

    public static int findCount() {
        count = 0;
        try {
            int N = Integer.parseInt(br.readLine());
            int[][] arr = new int[N][N];
            IntStream.range(0, N).forEach(row -> {
                String[] s = new String[N];
                try {
                    s = br.readLine().split(" ");
                } catch (Exception ee) {
                }
                for (int i = 0; i < N; i++) {
                    arr[row][i] = Integer.parseInt(s[i]);

                    for (int trow = row; trow >= 0; trow--) {
                        for (int ti = i; ti >= 0; ti--) {
                            if (arr[trow][ti] > arr[row][i]) {
                                count++;
                            }
                        }
                    }
                }
            });

        } catch (Exception e) {
            System.out.println(e);
        }
        return count;
    }
}
