package com.uestc.gt.easy;

import com.uestc.gt.util.ListNode;

/**
 * author: checkermu email:guotaoleng@163.com
 * time: 2015年6月3日上午9:09:32
 * You are given two linked lists representing two non-negative numbers. 
 * The digits are stored in reverse order and each of their nodes contain a single digit. 
 * Add the two numbers and return it as a linked list.
 *
 *	Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 *	Output: 7 -> 0 -> 8
 */
public class AddTwoNumbers {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AddTwoNumbers add = new AddTwoNumbers();
		add.test();
	}
	
	public void test(){
		ListNode three=new ListNode(8);
		ListNode decate=new ListNode(2);
		ListNode hundreds=new ListNode(3);
		three.next=decate;
//		decate.next=hundreds;
		
		ListNode two = new ListNode(2);
		two.next=new ListNode(4);
		
		ListNode re=addTwoNumbers(three, two);
		
		System.out.println(re);
	}
	
	public ListNode addTwoNumbers(ListNode l1, ListNode l2){
		ListNode newHead = new ListNode(-1);
		ListNode l3=newHead;
		
		boolean flag=false;
		while(l1!=null && l2!=null){
			int tmp = l1.val+l2.val;
			if(flag){
				tmp++;
				flag=false;
			}
			ListNode tmpNode=new ListNode(0);
			if(tmp>=10){
				tmp=tmp%10;
				flag=true;
			}
			tmpNode.val=tmp;
			if(l3==null){
				l3=tmpNode;
			}else{
				l3.next=tmpNode;
			}
			l3=l3.next;
				
			l1=l1.next; l2=l2.next;
		}
		
		while(l1!=null){
			int tmp = l1.val;
			if(flag){
				tmp++;
				flag=false;
			}
			ListNode tmpNode=new ListNode(0);
			if(tmp>=10){
				tmp=tmp%10;
				flag=true;
			}
			tmpNode.val=tmp;
			l3.next=tmpNode;
			l3=l3.next;
			l1=l1.next;
		}
		
		while(l2!=null){
			int tmp = l2.val;
			if(flag){
				tmp++;
				flag=false;
			}
			ListNode tmpNode=new ListNode(0);
			if(tmp>=10){
				tmp=tmp%10;
				flag=true;
			}
			tmpNode.val=tmp;
			l3.next=tmpNode;
			l3=l3.next;
			l2=l2.next;
		}
		if(flag){
			ListNode tmpNode=new ListNode(1);
			l3.next=tmpNode;
		}
			
		return newHead.next;
	}


}
