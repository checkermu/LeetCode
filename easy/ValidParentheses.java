package com.uestc.gt.easy;

import java.util.Stack;

/**
 * author: checkermu email:guotaoleng@163.com
 * time: 2015年5月14日下午3:12:01
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 * 
 * 这是个非常简单的匹配问题，这类问题用栈非常好解决
 */
public class ValidParentheses {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ValidParentheses vp = new ValidParentheses();
		String s = "({{[]()}})";
		s = "(({{[]}})";
		s = "]()";
		System.out.println(vp.checkValid(s));
	}
	
	/**
	 * 挨个检查,注意开始和结尾栈空非空小问题
	 * @param parentheses
	 * @return
	 */
	public boolean checkValid(String parentheses){
		char[] arrChar = parentheses.toCharArray();
		int flag = 0;
		Stack<Character> stack = new Stack<Character>();
		int n=arrChar.length;
		for (int i=0; i<n; i++){
			char tmp = arrChar[i];
			if(tmp=='('||tmp=='{'||tmp=='['){
				stack.push(tmp);
			}else{
				if(stack.empty()){
					flag=1;
					break;
				}
				switch (tmp){
				case ')':
					if(stack.pop()=='('){}
					else{
						flag=1;
					}
					break;
				case '}':
					if(stack.pop()=='{'){}
					else{
						flag=1;
					}
					break;
				case ']':
					if(stack.pop()=='['){}
					else{
						flag=1;
					}
					break;
				default: flag =1;
				}
			}
			if(flag==1){
				break;
			}
		}
		if(!stack.empty()||flag==1){
			return false;
		}else{
			return true;
		}
	}

}
