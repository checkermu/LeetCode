package com.uestc.gt.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * author: checkermu email:guotaoleng@163.com
 * time: 2015年6月22日下午4:22:43
 * leetcode中常见的 k-sum 问题， 比如two-sum; three-sum; four-sum
 */
public class KSum {

	private int[] num;
	private int total_length;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		KSum ksum = new KSum();
		int[] nums = {-1, 0, 1, 2, -1, -4};
//		ksum.threeSum(nums);
		ksum.threeSum_new(nums);
	}

	
	/**
	 * 最基础的two-sum问题解决方案，用的是hash
	 * @param target
	 * @param num
	 * @param start_index
	 * @return
	 */
	public List<List<Integer>> twoSum(int target, int[] num, int start_index){
		HashSet set = new HashSet();
		List<List<Integer>> rt = new LinkedList<List<Integer>>();
		
		for(int i=start_index; i<num.length; i++){
			if(set.contains(target - num[i])){
				List tmp = new LinkedList();
				tmp.add(target-num[i]);
				tmp.add(num[i]);
				rt.add(tmp);
				set.remove(num[i]);
				set.remove(target-num[i]);
			}
			else {
				if((i>start_index) && (num[i-1]==num[i])){
					continue;
				}
				set.add(num[i]);
			}
		}
 		return rt;
	}
	
	public List<List<Integer>> threeSum(int[] num){
		Arrays.sort(num);
		/*用set 存放结果list，为了避免重复*/
		Set<List<Integer>> result = new HashSet<List<Integer>>();
		
		for(int i=0; i<num.length; i++){
			/*当前的num[i]已经使用了， 因此 start_index是从i+1开始 */
			for(List<Integer> l : twoSum(0-num[i], num, i+1)){
				if(l.get(0) + l.get(1) + num[i] == 0){
					l.add(0, num[i]);
					result.add(l);
				}
			}
		}
		return new ArrayList<List<Integer>>(result);
	}
	
	public List<List<Integer>> kSum( int length, int target, int start_index){
		List<List<Integer>> result = new LinkedList<List<Integer>>();
		if(length==0){
			if(target==0){
				//if we find the target, open an entry to store the whole path
				result.add(new LinkedList());
			}
		}
		
		for(int i=start_index; i<total_length - length+1; i++){
			if((i>start_index)&&(num[i]==num[i-1])){
				continue;
			}
			for(List<Integer> partial_result: kSum( length-1, target-num[i], i+1)){
				partial_result.add(0, num[i]);
				result.add(partial_result);
			}
		}
		return result;
	}
	
	public List<List<Integer>> threeSum_new(int[] num){
		Arrays.sort(num);
		this.num=num;
		this.total_length = num.length;
		return kSum(3, 0, 0);
		
	}
	
}
