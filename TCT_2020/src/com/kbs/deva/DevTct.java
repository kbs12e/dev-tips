package com.kbs.deva;

import java.util.*;

public class DevTct {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution so = new Solution();
		String[] pa = {"leo", "kiki", "eden"};
		String[] cp = {"kiki", "eden"};
		
		System.out.println("not completion: " + so.solution(pa, cp));
	}

}

class Solution {
    public String solution(String[] participant, String[] completion) {
    	String answer = "";
    	HashMap<String, Integer> hm = new HashMap<String, Integer>();
        
        for(String pa : participant) {
            hm.put(pa, hm.getOrDefault(pa, 0)+1);
        }
        for(String ca : completion) {
        	hm.put(ca, hm.get(ca)-1);
        }
        
        for(String key: hm.keySet()) {
        	if (hm.get(key) != 0) {
        		answer = key;
        	}
        }
        
        return answer;
    }
}

