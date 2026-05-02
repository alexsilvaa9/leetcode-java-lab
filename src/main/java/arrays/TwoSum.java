package arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;

        System.out.println(Arrays.toString(twoSum(nums, target)));
    }

    private static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> indicesByValue = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int needed = target - nums[i];

            if (indicesByValue.containsKey(needed)) {
                return new int[] {indicesByValue.get(needed), i};
            }

            indicesByValue.put(nums[i], i);
        }

        throw new IllegalArgumentException("No se encontró una solución válida.");
    }
}