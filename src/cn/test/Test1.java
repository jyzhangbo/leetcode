package cn.test;

import java.util.HashMap;
import java.util.Map;

public class Test1 {
	public static void main(String[] args) {
		int[] twoSum = twoSum(new int[]{2,7,11,15},13);
		System.out.println(twoSum[0]+";"+twoSum[1]);
	}
	public static int[] twoSum(int[] nums, int target) {
		Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(target-nums[i])){
            	return new int[]{map.get(target-nums[i]),i};
            }
            map.put(nums[i], i);
        }
        return null;
    }
}
