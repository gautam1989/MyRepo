package com.priorityQ.test;

import java.util.PriorityQueue;


class Employee implements Comparable<Employee> {

	int value;

	
	public Employee(int value) {
	this.value=value;
	}
	@Override
	public int compareTo(Employee o) {
		// TODO Auto-generated method stub
		return  (this.value - o.value);
	}
	@Override
	public String toString() {
		return "Employee [value=" + value + "]";
	}





	
	
}
public class PriorityQTest {
	private static PriorityQueue<Employee> pQueue;
public static void main(String[] args) {
	pQueue =new PriorityQueue<>();
	Employee e1 =new Employee(10);
	Employee e2 =new Employee(20);
	pQueue.add(e2);
	pQueue.add(e1);
	
	while(!pQueue.isEmpty()){
		System.out.println(pQueue.poll());
	}
}
}
