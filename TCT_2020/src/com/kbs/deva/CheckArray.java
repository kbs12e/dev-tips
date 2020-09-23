package com.kbs.deva;

import java.util.*;

public class CheckArray {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CheckArray so = new CheckArray();
		int[] case1 = {4, 1, 3};
		
		so.solution(case1);
	}
	
	public boolean solution(int[] arr) {
		boolean answer = true;
		
		List<Integer> list = new ArrayList<Integer>();
        for (int i =1; i <= arr.length; i++) {
        	list.add(i);
        }
        
        
        
        for (int num : arr) {
        	if (list.contains(num)) {
        		list.remove(new Integer(num));
        		continue;
        	} else {
        		answer = false;
        	}
        }
		
		
        System.out.println(answer);
        
        return answer;
    }

}
