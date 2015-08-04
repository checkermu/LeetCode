package com.uestc.gt.easy;
/**
 * author: checkermu email:guotaoleng@163.com
 * time: 2015年6月18日下午7:34:40
 * 将字符串转换为整数实现  atoi函数
 * Implement atoi to convert a string to an integer.

 *	Hint: Carefully consider all possible input cases. If you want a challenge, please do not see below and ask yourself what are the possible input cases.

 *	Notes: It is intended for this problem to be specified vaguely (ie, no given input specs). You are responsible to gather all the input requirements up front.
 */
public class StringToInteger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringToInteger stt = new StringToInteger();
		String s = "    10522545459";
		System.out.println(stt.strToInt(s));
		
	}
	
	/**
	 * 将字符数转换为整数，从头到尾，去掉空格，注意正负号，小数点，字符
	 * @param str
	 * @return
	 */
	public int strToInt(String str){
		
		double res =0;
		boolean flag = true;
		if(null==str||str.length()<1)
			return 0;
		str = str.trim();
		int i=0;
		if(str.charAt(0)=='-'){
			flag=false;
			i++;
		} else if(str.charAt(0)=='+'){
			i++;
		}
		for(; i<str.length(); i++){
			if(str.charAt(i)<'0'||str.charAt(i)>'9')
				break;
			res = res*10 + (int)str.charAt(i)-(int)'0';
		}
		if(flag){
			if(res>Integer.MAX_VALUE)
				return Integer.MAX_VALUE;
			else
				return (int)res;
		}else {
			if(res>Integer.MAX_VALUE)
				return Integer.MIN_VALUE;
			else
				return -(int)res;
		}
		
			
	}
	
	/**
	 * 测试有问题 +-2， 2-2；
	 * @param str
	 * @return
	 */
	public int myAtoi(String str) {
        int res =0;
		boolean flag = true;
		if(null==str||str.equals(""))
			return res;
		else{
			for(int i=0; i<str.length();i++){
				if(str.charAt(i)==' ')
					continue;
				else if(str.charAt(i)=='-')
					flag = false;
				else if(str.charAt(i)=='+')
					flag = true;
				else{
					if(str.charAt(i)>='0'&&str.charAt(i)<='9')
						res = res*10 + (int)str.charAt(i)-(int)'0';
					else if(str.charAt(i)=='.')
						break;
					else
						return 0;
				}
			}
			if(flag)
				if(res>0)
					return res;
				else
					return Integer.MAX_VALUE;
			else
				if(res>0)
					return -res;
				else
					return Integer.MIN_VALUE;
		}
    }

	public void testString_StringBuffer(){
		String s = new String("construction");
		StringBuffer sb = new StringBuffer("stringBuffer_Construction");
		sb.append("append1");
		StringBuilder sbd = new StringBuilder("stringBuilder_Construction");
		sbd.append("append2");
	}
	
	
}
