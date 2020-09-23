package com.kbs.deva;

import java.util.ArrayList;
import java.util.List;

public class PreSkill {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PreSkill so = new PreSkill();
		String [] case1 = {"BACDE", "CBADF", "AECB", "BDA"};
		so.solution("CBD", case1);
	}
	
	public int solution(String skill, String[] skill_trees) {
		int answer = 0;
		
		int pos = -1;
		boolean isOk = false;
		int notFindIndex = -1;
		
		for (String tree : skill_trees) {
			for (int i = 0; i < skill.length(); i++) {
				int curPos = tree.indexOf(String.valueOf(skill.charAt(i)));
				
				if (curPos > -1) {
					if (curPos > pos && curPos > notFindIndex) {
						isOk = true;
						pos = curPos;
						
						continue;
					} else {
						isOk = false;
						break;
					}
				} else {
					notFindIndex = i;
				}
			}
			
			pos = -1;
			
			if (!isOk) {
				continue;
			}
			
			if (isOk){
				answer++;
				isOk = false;
				continue;
			}
		}
		
        System.out.println(answer);
        
        return answer;
    }
}
