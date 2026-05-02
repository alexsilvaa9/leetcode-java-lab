package dynamicprogramming;

public class MinCostClimbingStairs {
    public static void main(String[] args) {
        int[] cost = {10, 15, 20, 0, 5, 10};

        System.out.println(minCostClimbingStairs(cost));
    }

    private static int minCostClimbingStairs(int[] cost) {
        int prevTwo = 0;
        int prevOne = 0;

        for (int stepCost : cost) {
            int current = stepCost + Math.min(prevOne, prevTwo);
            prevTwo = prevOne;
            prevOne = current;
        }

        return Math.min(prevOne, prevTwo);
    }
}