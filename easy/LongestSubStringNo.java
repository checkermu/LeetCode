package com.uestc.gt.easy;
/**
 * author: checkermu email:guotaoleng@163.com
 * time: 2015年6月17日下午7:47:27
 * Given a string, find the length of the longest substring without repeating characters. 
 * For example, the longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3.
 * For "bbbbb" the longest substring is "b", with the length of 1.
 */
public class LongestSubStringNo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LongestSubStringNo ls = new LongestSubStringNo();
		String s = "hello world";
		//		String s = "dvdf";
		System.out.println(ls.longestSubNew(s));
		System.out.println(ls.func(s));
	}
	
	/**
	 * from internet
	 * @param s
	 * @return
	 */
	public int lengthOfLongestSubstring(String s) {  
        int res = 0, left = 0;  
        int prev[] = new int[300];  
  
        // init prev array  
        for (int i = 0; i < 300; ++i)  
            prev[i] = -1;  
  
        for (int i = 0; i < s.length(); ++i) {  
            if (prev[s.charAt(i)] >= left)  
                left = prev[s.charAt(i)] + 1;  
            prev[s.charAt(i)] = i;  
            if (res < i - left + 1)  
                res = i - left + 1;  
        }  
        return res;  
    }  
	
	/**
	 * hash table的用法，用重复的进行比较，
	 * 每次进行重复的比较，数组当前字符ascii下标位置存放的是当前字符在String的下标，
	 * 如果一直没有重复字符，那就最后的下标j减去0再1就是最长的字符，这个没问题。
	 * 如果有重复的，start就变为这个重复的下标索引再加1，后面的j一直减去这个start，和一开始最大的max长度比较。
	 * 在没碰到这个重复之前有个最长的，碰到了之后会一直变化，进行比较。
	 * @param s
	 * @return
	 */
	public int func(String s){
		int[] count = new int[256];
		for (int i=0; i<256; i++)
			count[i]=-1;
		int max =1;
		int start = 0;
		for(int j=0; j<s.length(); j++){
			if(count[s.charAt(j)]>=start)
				start = count[s.charAt(j)]+1;
			count[s.charAt(j)] = j;
			max = Math.max(max, j-start+1);
		}
		return max;
	}

	
	/**
	 * 修改后正确，但是时间超时
	 * 思想：采用动态规划思想，发现这里不能用动态规划思想，因为最优解的子解不是子解的最优解,如dvdf，最优解是 vdf,而并不是,发现是动态规划思想
	 * 这个是考虑连续的最长串，当前字符在与之前的没有重复则之前的length+1，有重复则重置为1.
	 * 需要注意的是如果有重复重置为1的话，后面的字符的比较子串会发生变化,这个版本有错，如 dvdf，输出应该是3，但是实际却是2
	 * 旧版本，思想比较简单，遇到dvdf这种情况输出2，而不是3
	 * @param s
	 * @return
	 * //超时了！！！
	 */
	public int longestSubNew(String s){
		if(s.equals("")||s.equals(null))
			return 0;
		else{
			char[] charArr = s.toCharArray();
			int[] length = new int[charArr.length];
			length[0]=1;
			int max = 1;
			int tmp=0;
			for(int i=1; i<charArr.length; i++){
				String sTmp = s.substring(tmp, i);
				if(sTmp.indexOf(charArr[i])==-1)
					length[i]=length[i-1]+1;
				else{
					//与之前的区别，在tmp的指定和有问题i的length[i]认定上重新计算
					tmp=s.substring(0, i).lastIndexOf(charArr[i])+1;	
					length[i]=i-tmp+1;
				}
				if(length[i]>max)
					max=length[i];
			}
			return max;
		}
	}
	
	/**
	 * 错误版本，
	 * @param s
	 * @return
	 */
	public int longestSub(String s){
		if(s.equals("")||s.equals(null))
			return 0;
		else{
			char[] charArr = s.toCharArray();
			int[] length = new int[charArr.length];
			length[0]=1;
			int max = 1;
			int tmp=0;
			for(int i=1; i<charArr.length; i++){
				length[i]=1;
				for(int j=i-1; j>=tmp; j--){
					if(charArr[j]!=charArr[i])
						length[i]++;
					else{
						tmp=j+1;
						break;
					}
				}
				if(length[i]>max)
					max=length[i];
			}
			return max;
		}
	}

}
