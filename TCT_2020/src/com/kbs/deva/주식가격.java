package com.kbs.deva;

public class �ֽİ��� {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		�ֽİ��� so = new �ֽİ���();
		int[] prices = {1,2,3,2,3};
		so.solution(prices);
	}
	
	public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        
        for (int i = 0; i < prices.length; i++) {
        	for (int j = i+1; j < prices.length; j++) {
        		if (prices[i] > prices[j]) {
        			answer[i] = j-i;
        			break;
        		} else {
        			answer[i] = j-i;
        		}
        	}
        }
        
        
        return answer;
    }
}
