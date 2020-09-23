package com.kbs.deva;

import java.util.*;

public class 소수찾기 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		소수찾기 so = new 소수찾기();
		so.solution("011");
		
	}
	public int solution(String numbers) {
        int answer = 0;
        
        HashSet<Integer> set = new HashSet<>();
        permutation("", numbers, set);
        
        int count = 0;
        
        while(set.iterator().hasNext()) {
        	int a = set.iterator().next();
        	set.remove(a);
        	
        	if ( a == 2) count++;
        	if (a%2 != 0 && isPrime(a)) {
        		count++;
        	}
        }
        
        
        answer = count;
        return answer;
    }
	
	public boolean isPrime(int n) {
		if (n == 1 || n == 0) return false;
		for (int i = 3; i < (int)Math.sqrt(n); i+=2) {
			if (n%i == 0) return false;
		}
		return true;
	}
	
	public void permutation(String prefix, String str, HashSet<Integer> set) {
		int n = str.length();
		
		if (!prefix.equals("")) set.add(Integer.valueOf(prefix));
		for (int i = 0; i < n; i++) {
			System.out.println("========  :"+str.substring(0, i));
			permutation(prefix + str.charAt(i), str.substring(0,i) + str.substring(i+1, n), set);
		}
		
	}
	
}
