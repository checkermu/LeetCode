package com.uestc.gt.easy;

import java.util.Arrays;
import java.util.HashMap;

/**
 * author: checkermu email:guotaoleng@163.com
 * time: 2015年3月23日下午9:26:49
 * 
 */
public class TwoSum {

	
	public static void main(String[] args) {
		TwoSum tw = new TwoSum();
		// TODO Auto-generated method stub
		int[] numbers=new int[]{1, 2, 9, 3, 8};
		int target=12;
		long startTime = System.currentTimeMillis();
		tw.twoSum(numbers, target);
		long endTime = System.currentTimeMillis();
		System.out.println("The program running time is "+(endTime-startTime)+"ms");
	}

	/**
	 * two sum 解法1，夹逼方法，两边进行
	 */
	public void doubleSide(int[] numbers, int target){
		int length = numbers.length;
		int[] sortedNum = new int[length];
		System.arraycopy(numbers, 0, sortedNum, 0, length);
		//sort the array
		Arrays.sort(sortedNum);
		int left=0;
		int right=length-1;
		int sum=0;
		//run the double side method
		while( left<right){
			 sum= sortedNum[left] + sortedNum[right];
			if(sum<target){
				left++;
				continue;
			}else if (sum>target) {
				right--;
				continue;
			}else
				break;
		}
		
		int number1=sortedNum[left];
		int number2=sortedNum[right];
		int index1=-1, index2=-1;
		for(int i=0; i<length; i++){
			if((numbers[i]==number1)||(numbers[i]==number2)){
				if(index1==-1){
					index1=i+1;
				}else
					index2=i+1;
			}
		}
		
		int[] resultIndex = new int[]{index1, index2};
		Arrays.sort(resultIndex);
		
		System.out.println("number1="+number1+"number2="+number2+"index1:="+resultIndex[0]+"  index2:="+resultIndex[1]);
	}
	
	/**
	 * 一个类似于无赖的hash算法
	 * @param numbers
	 * @param target
	 * @return
	 */
	public int[] twoSum(int[] numbers, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		int n = numbers.length;
		int[] result = new int[2];
		for (int i = 0; i < numbers.length; i++)
        {
            if (map.containsKey(target - numbers[i]))
            {
                result[0] = map.get(target-numbers[i]) + 1;
                result[1] = i + 1;
                break;
            }
            else
            {
                map.put(numbers[i], i);
            }
        }
		System.out.println( "index1:="+result[0]+"  index2:="+result[1]);

		return result;
        
    }
}
