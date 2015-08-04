package com.uestc.gt.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * author: checkermu email:guotaoleng@163.com
 * time: 2015年6月23日下午4:25:48
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 * ~Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
 * ~The solution set must not contain duplicate triplets.
 * For example, given array S = {-1 0 1 2 -1 -4},
 * A solution set is:
    (-1, 0, 1)
    (-1, -1, 2)
 */
public class ThreeSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ThreeSum ts = new ThreeSum();
		int[] nums = {-1, 0, 1, 2, -1, -4};
		ts.nativeThreeSum(nums);

	}
	
	/**
	 * 暴力解法，不要求下标索引
	 * @param nums
	 * @return
	 */
	public List<List<Integer>> nativeThreeSum(int[] nums){
		Arrays.sort(nums);
		List<List<Integer>>  result = new ArrayList<List<Integer>>();
		
		int length = nums.length;
		
		for(int i=0; i<length; i++){
			if(nums[i]>0)
				break;//因为已经排过序了
			for(int j=i+1; j<length; j++){
				if((nums[i]+nums[j]>0)&&(nums[j]>0))
					break;
				for(int k=j+1; k<length; k++){
					
					if(nums[i]+nums[j]+nums[k]==0){
						List<Integer> tmp = new ArrayList<Integer>();
						tmp.add(nums[i]);
						tmp.add(nums[j]);
						tmp.add(nums[k]);
						result.add(tmp);
					}
				}
			}
		}
			
		return result;
	}

}
