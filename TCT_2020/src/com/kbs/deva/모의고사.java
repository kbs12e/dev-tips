package com.kbs.deva;

import java.util.*;

public class 모의고사 {

	public static void main(String[] args) {
		모의고사 so = new 모의고사();
		int[] answers = {1,3,2,4,2,4,5,5,2,4,4,2,2,2,5,1,3,4};
		so.solution(answers);
		
	}
	
	public int[] solution(int[] answers) {
        int[] answer = {};
        
        int[] a = {1,2,3,4,5};
        int[] b = {2,1,2,3,2,4,2,5};
        int[] c = {3,3,1,1,2,2,4,4,5,5};
        
        int[] score = new int[3];
        
        for (int i = 0; i < answers.length; i++) {
        	if(answers[i] == a[i%a.length]) {score[0]++;}
        	if(answers[i] == b[i%b.length]) {score[1]++;}
        	if(answers[i] == c[i%c.length]) {score[2]++;}
        }
        
        int maxScore = Math.max(score[0], Math.max(score[1], score[2]));
        ArrayList<Integer> list = new ArrayList<>();
        if(maxScore == score[0]) {list.add(1);}
        if(maxScore == score[1]) {list.add(2);}
        if(maxScore == score[2]) {list.add(3);}
        
        answer = list.stream().mapToInt(i->i.intValue()).toArray();
        
        
        
        return answer;
    }
	
}
