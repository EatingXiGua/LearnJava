package test;

import hot100.hash.Solution_1;

public class Test {
    public static void main(String[] args) {
        Solution_1 obj = new Solution_1();
        int[] nums = {2,7,11,15};
        int[] ints = obj.twoSum2(nums, 9);
        System.out.println(ints[0]+" "+ints[1]);
    }
}
