package tests;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.junit.jupiter.api.Test;

class LeetCodeTests {
    @Test
    void testTwoSum() throws Exception {
        int[] result = invokeIntArray(
                "arrays.TwoSum",
                "twoSum",
                new Class<?>[] {int[].class, int.class},
                new int[] {2, 7, 11, 15},
                9);

        assertArrayEquals(new int[] {0, 1}, result);

        int[] resultTwo = invokeIntArray(
                "arrays.TwoSum",
                "twoSum",
                new Class<?>[] {int[].class, int.class},
                new int[] {3, 2, 4},
                6);

        assertArrayEquals(new int[] {1, 2}, resultTwo);
    }

    @Test
    void testBestTimeToBuyAndSellStock() throws Exception {
        int result = invokeInt(
                "arrays.BestTimeToBuyAndSellStock",
                "maxProfit",
                new Class<?>[] {int[].class},
                (Object) new int[] {7, 1, 5, 3, 6, 4});

        assertEquals(5, result);

        int zeroProfit = invokeInt(
                "arrays.BestTimeToBuyAndSellStock",
                "maxProfit",
                new Class<?>[] {int[].class},
                (Object) new int[] {7, 6, 4, 3, 1});

        assertEquals(0, zeroProfit);
    }

    @Test
    void testContainsDuplicate() throws Exception {
        boolean result = invokeBoolean(
                "arrays.ContainsDuplicate",
                "containsDuplicate",
                new Class<?>[] {int[].class},
                (Object) new int[] {1, 2, 3, 1});

        assertTrue(result);

        boolean noDuplicate = invokeBoolean(
                "arrays.ContainsDuplicate",
                "containsDuplicate",
                new Class<?>[] {int[].class},
                (Object) new int[] {1, 2, 3, 4});

        assertFalse(noDuplicate);
    }

    @Test
    void testValidPalindrome() throws Exception {
        boolean result = invokeBoolean(
                "strings.ValidPalindrome",
                "isPalindrome",
                new Class<?>[] {String.class},
                "A man, a plan, a canal: Panama");

        assertTrue(result);

        boolean notPalindrome = invokeBoolean(
                "strings.ValidPalindrome",
                "isPalindrome",
                new Class<?>[] {String.class},
                "race a car");

        assertFalse(notPalindrome);
    }

    @Test
    void testLongestSubstringWithoutRepeatingCharacters() throws Exception {
        int result = invokeInt(
                "strings.LongestSubstringWithoutRepeatingCharacters",
                "lengthOfLongestSubstring",
                new Class<?>[] {String.class},
                "abcabcbb");

        assertEquals(3, result);

        int resultTwo = invokeInt(
                "strings.LongestSubstringWithoutRepeatingCharacters",
                "lengthOfLongestSubstring",
                new Class<?>[] {String.class},
                "pwwkew");

        assertEquals(3, resultTwo);
    }

    @Test
    void testMaximumDepthOfBinaryTree() throws Exception {
        Class<?> nodeClass = Class.forName("trees.MaximumDepthOfBinaryTree$TreeNode");
        Object root = newInstance(nodeClass, new Class<?>[] {});
        Object left = newInstance(nodeClass, new Class<?>[] {int.class}, 2);
        Object right = newInstance(nodeClass, new Class<?>[] {int.class}, 3);

        setField(root, "left", left);
        setField(root, "right", right);

        int depth = invokeInt(
                "trees.MaximumDepthOfBinaryTree",
                "maxDepth",
                new Class<?>[] {nodeClass},
                root);

        assertEquals(2, depth);
    }

    @Test
    void testSameTree() throws Exception {
        Class<?> nodeClass = Class.forName("trees.SameTree$TreeNode");
        Object first = createBinaryTree(nodeClass, 1, 2, 3);
        Object second = createBinaryTree(nodeClass, 1, 2, 3);
        Object different = createBinaryTree(nodeClass, 1, 2, 4);

        boolean same = invokeBoolean(
                "trees.SameTree",
                "isSameTree",
                new Class<?>[] {nodeClass, nodeClass},
                first,
                second);

        assertTrue(same);

        boolean notSame = invokeBoolean(
                "trees.SameTree",
                "isSameTree",
                new Class<?>[] {nodeClass, nodeClass},
                first,
                different);

        assertFalse(notSame);
    }

    @Test
    void testMinCostClimbingStairs() throws Exception {
        int result = invokeInt(
                "dynamicprogramming.MinCostClimbingStairs",
                "minCostClimbingStairs",
                new Class<?>[] {int[].class},
                (Object) new int[] {10, 15, 20});

        assertEquals(15, result);

        int resultTwo = invokeInt(
                "dynamicprogramming.MinCostClimbingStairs",
                "minCostClimbingStairs",
                new Class<?>[] {int[].class},
                (Object) new int[] {1, 100, 1, 1, 1, 100, 1, 1, 100, 1});

        assertEquals(6, resultTwo);
    }

    @Test
    void testNumberOfIslands() throws Exception {
        int result = invokeInt(
                "graphs.NumberOfIslands",
                "numIslands",
                new Class<?>[] {int[][].class},
                (Object) new int[][] {
                    {1, 1, 0, 0},
                    {1, 1, 0, 0},
                    {0, 0, 1, 0},
                    {0, 0, 0, 1}
                });

        assertEquals(3, result);

        int singleIsland = invokeInt(
                "graphs.NumberOfIslands",
                "numIslands",
                new Class<?>[] {int[][].class},
                (Object) new int[][] {
                    {1, 1, 1},
                    {0, 1, 0},
                    {1, 1, 1}
                });

        assertEquals(1, singleIsland);
    }

    private static Object createBinaryTree(Class<?> nodeClass, int rootValue, int leftValue, int rightValue) throws Exception {
        Object root = newInstance(nodeClass, new Class<?>[] {int.class}, rootValue);
        Object left = newInstance(nodeClass, new Class<?>[] {int.class}, leftValue);
        Object right = newInstance(nodeClass, new Class<?>[] {int.class}, rightValue);

        setField(root, "left", left);
        setField(root, "right", right);
        return root;
    }

    private static Object invoke(String className, String methodName, Class<?>[] parameterTypes, Object... args) throws Exception {
        Class<?> targetClass = Class.forName(className);
        Method method = targetClass.getDeclaredMethod(methodName, parameterTypes);
        method.setAccessible(true);
        return method.invoke(null, args);
    }

    private static int invokeInt(String className, String methodName, Class<?>[] parameterTypes, Object... args) throws Exception {
        return ((Number) invoke(className, methodName, parameterTypes, args)).intValue();
    }

    private static int[] invokeIntArray(String className, String methodName, Class<?>[] parameterTypes, Object... args) throws Exception {
        return (int[]) invoke(className, methodName, parameterTypes, args);
    }

    private static boolean invokeBoolean(String className, String methodName, Class<?>[] parameterTypes, Object... args) throws Exception {
        return (boolean) invoke(className, methodName, parameterTypes, args);
    }

    private static Object newInstance(Class<?> targetClass, Class<?>[] parameterTypes, Object... args) throws Exception {
        Constructor<?> constructor = targetClass.getDeclaredConstructor(parameterTypes);
        constructor.setAccessible(true);
        return constructor.newInstance(args);
    }

    private static void setField(Object target, String fieldName, Object value) throws Exception {
        Field field = target.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(target, value);
    }
}