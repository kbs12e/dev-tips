package com.kbs.deva;

import java.util.*;

public class Palindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution1 so1 = new Solution1();
		so1.solution(1, 100);
		
		
		
		
		
		//Solution4 so4 = new Solution4();
		
		//so4.solution("abcdcba");
		//so4.solution("abacda");
		
	}

}

class Solution1 {
	public int solution(int n, int m) {
		int answer = 0;
		
		for ( int i = n; i <= m ; i++) {
			
			String temp = Integer.toString(i);
			StringBuilder sbTemp = new StringBuilder();
			sbTemp.append(temp);
			
			if (temp.length() < 2) {
				answer++;
				continue;
			} else {
				if (temp.equals(sbTemp.reverse().toString())) {
					answer++;
					continue;
				}
			}
			
		}
		
		System.out.println("count: "+ answer);
		
		
		return answer;
	}
}



class Solution4 {
	public int solution(String s) {
		int answer = 0;
		
		 char[] T = new char[s.length()*2 + 3];
	        T[0] = '$';
	        T[s.length()*2 + 2] = '@';
	        for (int i = 0; i < s.length(); i++) {
	            T[2*i + 1] = '#';
	            T[2*i + 2] = s.charAt(i);
	        }
	        T[s.length()*2 + 1] = '#';


	        int[]  P = new int[T.length];
	        int center = 0, right = 0;

	        for (int i = 1; i < T.length-1; i++) {
	            int mirr = 2*center - i;

	            if (i < right)
	                P[i] = Math.min(right - i, P[mirr]);

	            while (T[i + (1 + P[i])] == T[i - (1 + P[i])])
	                P[i]++;

	            if (i + P[i] > right) {
	                center = i;
	                right = i + P[i];
	            }
	        }

	        int length = 0;   // length of longest palindromic substring
	        center = 0;   // center of longest palindromic substring
	        for (int i = 1; i < P.length-1; i++) {
	            if (P[i] > length) {
	                length = P[i];
	                center = i;
	            }
	        }
	        
	        String result = s.substring((center - 1 - length) / 2, (center - 1 + length) / 2);
	        System.out.println(s.substring((center - 1 - length) / 2, (center - 1 + length) / 2));
	        answer = result.length();
	    
		
		return answer;
	}
}
