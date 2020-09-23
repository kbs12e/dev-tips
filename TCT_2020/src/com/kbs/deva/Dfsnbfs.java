package com.kbs.deva;

import java.util.*;

public class Dfsnbfs {
	
	public int solution(int[] numbers, int target) {
		int answer = 0;
		
		answer = dfs(numbers, target, 0, 0);
		System.out.println("count: "+ answer);
		
		
		return answer;
	}
	
	
	public int dfs(int[] numbers, int target, int index,  int num) {
		if (index == numbers.length) {
			return num == target ? 1 : 0;
		} else {
			return dfs(numbers, target, index+1, num + numbers[index]) + 
					dfs(numbers, target, index+1, num - numbers[index]);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Dfsnbfs so = new Dfsnbfs();
		int [] numbers = {1, 1, 1, 1, 1};
		so.solution(numbers, 3);
	}

}

