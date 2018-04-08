package com.ques;

import java.util.LinkedList;

class NodeS{
	int val;
	NodeS next;
}

public class RemoveDuplicateLinkedList {
public static void main(String[] args) {

	NodeS n4=new NodeS();
	n4.val = 2;
	n4.next= null;
	
	NodeS n3=new NodeS();
	n3.val = 2;
	n3.next= n4;
		
	NodeS n2=new NodeS();
	n2.val = 2;
	n2.next= n3;
	
	NodeS n1=new NodeS();
	n1.val = 1;
	n1.next= n2;
	
	removeDuplicateFromList(n1);
	println(n1);
	
}


static void println(NodeS node){
	while(node!=null){
		System.out.println(node.val);
		node=node.next;
	}
}

static void removeDuplicateFromList(NodeS list){
	while(list.next!=null){
		if(list.val != list.next.val)
		{
			list = list.next;
		}else{
			list.next = list.next.next;
		}
	}
}

}
