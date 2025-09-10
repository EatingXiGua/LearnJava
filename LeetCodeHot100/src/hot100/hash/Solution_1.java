package hot100.hash;

import java.util.HashMap;
import java.util.Map;

public class Solution_1 {
    public int[] twoSum(int[] nums, int target) {
        int[] reslut = new int[2];
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    reslut[0] = i;
                    reslut[1] = j;
                }
            }
        }
        return reslut;
    }

    public int[] twoSum2(int[] nums, int target) {
        Map<Integer,Integer> hashmap = new HashMap<Integer,Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (hashmap.containsKey(target - nums[i])) {
                return new int[]{hashmap.get(target - nums[i]), i};
            }
            hashmap.put(nums[i],i);
        }
        return new int[0];
    }
}
