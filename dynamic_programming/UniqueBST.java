package com.uestc.gt.middle;
/**
 * author: checkermu email:guotaoleng@163.com
 * time: 2015年5月20日上午9:23:28
 * Given n, how many structurally unique BST's(binary search trees) that store values 1,...n?
 * for example, Given n=3, there are a total of 5 unique BST's
 * 1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
 *其实是卡特兰数，很多都有应用，二叉搜索树的个数，多边形分割成三角形的个数，插入括号的个数。
 *
 */
public class UniqueBST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UniqueBST ub = new UniqueBST();
		System.out.println(ub.numTrees(4));
		

	}
	
	/**
	 * 
	 * @param n
	 * @return
	 */
	public int numTrees(int n){
		if(n==0)
			return 0;
		int[] res = new int[n+1];
		res[0]=1; 
		res[1]=1;
		for(int i=2; i<=n; i++){
			for(int j=0; j<i; j++){
				res[i] += res[j]*res[i-j-1];
			}
		}
		return res[n];
	}

}
