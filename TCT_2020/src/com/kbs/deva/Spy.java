package com.kbs.deva;

import java.util.*;

public class Spy {
	public int solution(String[][] clothes) {
		int answer = 1;

        HashMap<String, Integer> list = new HashMap<String, Integer>();
        for(String[] c : clothes) {
        	String kind = c[1];
        	int cnt = 0;
        	if (list.containsKey(kind)) {
        		cnt = list.get(kind);
        	}
        	list.put(kind, cnt + 1);
        }
        
        //int combine = 1;
        
        for (String key : list.keySet()) {
        	answer *= list.get(key) + 1;
        }
        
        answer--;
        
        System.out.println(answer);
        
        return answer;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Spy so = new Spy();
		String [][] case1 = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
		
		so.solution(case1);
	}

}
