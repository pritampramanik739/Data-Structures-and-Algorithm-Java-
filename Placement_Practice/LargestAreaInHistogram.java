import java.util.*;
public class LargestAreaInHistogram {
    public static void main(String[] args) {
        
    }

    //largest rectangle in a histogram................

    public static int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) {  //int[] a = null; // This is allowed
            return 0;                                  
        }
        
       //Then a.length would throw a NullPointerException, so you check a == null first.

        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        int n = heights.length;

        for (int i = 0; i <= n; i++) {
            int h = (i == n) ? 0 : heights[i];

            while (!stack.isEmpty() && h < heights[stack.peek()]) {
                int top = stack.pop();
                int area = heights[top] * (stack.isEmpty() ? i : i - 1 - stack.peek());
                maxArea = Math.max(maxArea, area);
            }
            stack.push(i);
        }

        return maxArea;
    }
}