package com.kbs.deva;

import java.util.*;

public class Phonebook {
	
	
	public boolean solution(String[] phone_book) {
        boolean answer = true;
        
        
        
        Arrays.sort(phone_book);
        
        for(int i =0; i < phone_book.length-1; i++) {
        	if (phone_book[i+1].contains(phone_book[i])) {
        		answer = false;
        		break;
        	}
        }
        
        System.out.println(answer);
        
        return answer;
    }
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Phonebook pb = new Phonebook();
		
		String[] case1 = {"119", "97674223", "1195524421"};
		String[] case2 = {"123", "456", "789"};
		
		pb.solution(case1);
		pb.solution(case2);
	}

}
