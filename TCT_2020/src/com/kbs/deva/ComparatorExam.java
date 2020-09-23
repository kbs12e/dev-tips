package com.kbs.deva;

import java.util.*;

public class ComparatorExam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ComparatorExam so = new ComparatorExam();
		
		String[] names = {"abc", "alice", "kbs"};
		int[][] dist = {{2,3},{4,3},{3,4}};
		double[] grades = {3.41, 4.62, 4.21};
		
		// 학점이 높은 순, 학점 앞자리가 같으면, 거리가 먼순, 거리가 같으면, 이름순
		so.solution(names, dist, grades);
		String dir = "ULURRDLLU";
		String dir1 = "LULLLLLLU";
		//so.solution2(dir1);
		
		int[] nums1 = {1, 2, 3, 4}; //1
		int[] nums2 = {1, 2, 7, 6, 4}; //4
		//so.solution3(nums1);
	}
	
	public int[] solution(String[] names, int[][] dist, double[] grade) {
		int[] answer = new int[names.length];
		
		
		List<Student> list = new ArrayList<Student>();
		
		int[] distChange = new int[dist.length];
		
		for (int i = 0; i < dist.length; i++) {
			System.out.println(dist[i][0]);
			distChange[i] = (int)Math.pow(new Double(dist[i][0]), 2) + (int)Math.pow(new Double(dist[i][1]), 2);
		}
		
		
		for (int i = 0; i < names.length; i++) {
			Student st = new Student(names[i], distChange[i], grade[i]);
			list.add(st);
		}
		
		
		Collections.sort(list, new Comparator<Student>() {
			@Override
			public int compare(Student o1, Student o2) {
				// TODO Auto-generated method stub
				
				if ((int)o2.getGrade() == (int)o1.getGrade()) {
					if (o2.getDist() == o1.getDist()) {
						return o1.getName().compareTo(o2.getName());
					}
					return Integer.compare(o2.getDist(), o1.getDist());
				}
				return Integer.compare((int)o2.getGrade(), (int)o1.getGrade());
				
//				if ((int)o1.getGrade() > (int)o2.getGrade()) {
//					return -1;
//				} else if ((int)o1.getGrade() < (int)o2.getGrade()) {
//					return 1;
//				} else {
//					if (o1.getDist() > o2.getDist()) {
//						return -1;
//					} else if (o1.getDist() < o2.getDist()) {
//						return 1;
//					} else {
//						return o1.getName().compareTo(o2.getName());
//					}
//				}
			}	
		});
		
        
		for (int i =0 ; i < names.length; i++) {
			for (int j =0; j < list.size(); j++) {
				if (names[i].equals(list.get(j).getName())) {
					answer[i] = j;
				}
			}
		}
		
		
		System.out.println(answer);
		
        
        return answer;
    }
	
	public class Student {
		String name;
		int dist;
		double grade;
		
		Student(String name, int dist, double grade) {
			this.name = name;
			this.dist = dist;
			this.grade = grade;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getDist() {
			return dist;
		}

		public void setDist(int dist) {
			this.dist = dist;
		}

		public double getGrade() {
			return grade;
		}

		public void setGrade(double grade) {
			this.grade = grade;
		}
		
		
	}
	
	
	public String changeAxis(String st, char ch) {
		
		//String yAxis = String.valueOf(st.charAt(1));
		//String xAxis = String.valueOf(st.charAt(0));
		int yAxisVal;
		int xAxisVal;
		
		if (st.length() == 3) {
			if (st.charAt(0) == '-') {
				xAxisVal = Integer.parseInt(String.valueOf(st.charAt(1)))*-1;
				yAxisVal = Integer.parseInt(String.valueOf(st.charAt(2)));
			} else {
				xAxisVal = Integer.parseInt(String.valueOf(st.charAt(0)));
				yAxisVal = Integer.parseInt(String.valueOf(st.charAt(2)))*-1;
			}
		} else if (st.length() == 4) {
			xAxisVal = Integer.parseInt(String.valueOf(st.charAt(1)))*-1;
			yAxisVal = Integer.parseInt(String.valueOf(st.charAt(3)))*-1;
		} else {
			xAxisVal = Integer.parseInt(String.valueOf(st.charAt(0)));
			yAxisVal = Integer.parseInt(String.valueOf(st.charAt(1)));
		}
		
		if (ch == 'U') {
			yAxisVal++;
		}
		
		if (ch == 'D') {
			yAxisVal--;
		}
		
		if (ch == 'L') {
			xAxisVal--;
		}
		
		if (ch == 'R') {
			xAxisVal++;
		}
		
		String result = String.valueOf(xAxisVal).concat(String.valueOf(yAxisVal));
		
		return result;
	}
	
    public int solution2(String dir) {
    	int answer = 0;
    	
    	String axis = "00";
    	
    	Map<String, Integer> map = new HashMap<String, Integer>();
    	
    	for(int i=0; i < dir.length(); i++) {
    		String route = this.changeAxis(axis, dir.charAt(i));
    		String checker = route.replace("-", "");
    		
    		if (Math.abs(Integer.parseInt(String.valueOf(checker.charAt(0)))) > 5
    				|| Math.abs(Integer.parseInt(String.valueOf(checker.charAt(1)))) > 5) {
    			map.put(route, 0);
    			continue;
    		} else {
    			axis = route;
    			if (map.get(route) == null) {
        			map.put(route, 1);
        		} else {
        			map.put(route, map.get(route)+1);
        		}
    			continue;
    		}
    	}
    	
    	int redunt = 0;
    	
    	for(String key : map.keySet()) {
    		System.out.println(key);
    		if (map.get(key) == 1) {
    			answer++;
    		}
    		
    		if (map.get(key) == 2) {
    			if (redunt == 0) {
    				redunt++;
    			}
    			answer++;
    		}
    	}
    	
    	answer += redunt;
    	System.out.println(answer);
    	return answer;
    }
    
    
    public void perm(int[] arr, int[] output, boolean[] visited, int depth, int n, int r) {
        if (depth == r) {
            print(output, r);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (visited[i] != true) {
                visited[i] = true;
                output[depth] = arr[i];
                perm(arr, output, visited, depth + 1, n, r);
                visited[i] = false;
                ;
            }
        }
    }
    
    public void print(int[] arr, int r) {
        for (int i = 0; i < r; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
    
    public int solution3(int[] nums) {
    	int answer = -1;
    	
    	int n  =4;
        int[] arr = {1, 2, 3, 4};
        int[] output = new int[n];
        boolean[] visited = new boolean[n];
        
        perm(arr, output, visited, 0, n, 3);
        
        
    	
        
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	System.out.println(answer);
    	
    	
    	
    	return answer;
    }
}


