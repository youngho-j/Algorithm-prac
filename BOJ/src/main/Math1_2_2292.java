package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Math1_2_2292 {
	public static void main(String[] args) throws IOException{
//		지나간 방 : 1 - 1 [1]
//		지나간 방 : 2 - 2 ~ 7 [6]
//		지나간 방 : 3 - 8 ~ 19 [12]
//		지나간 방 : 4 - 20 ~ 37 [18]
//		지나간 방 : 5 - 38 ~ 61 [24] 
//		지나간 방 : 6 - 62 ~ 91 [30]
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 주어진 방 번호
		int result = Integer.parseInt(br.readLine());
		// 지나간 최소 방의 개수에 해당하는 방들
		int size = 1;
		// 지나간 최소 방의 개수
		int count = 0;
		
		// 몇번째 방이 나올지 모르므로 while(true) 사용
		while(true) {
			//주어진 방이 중앙의 방인 경우 
			if(result == 1) {
				count++;
				break;
			//중앙의 방이 아닌경우
			} else {
				//1번방을 지나왔으므로
				count++;
				//입력된 방번호가 해당반 번호에 맞는지 확인하기 위해 
				size += 6*count;
				if(result <= size) {
					//맞을 경우 해당 방을 포함해야하므로 
					count++;
					break; 
				 }
			}
		}
		System.out.println(count);
	}
}
/*
 * 주의사항 : 시작과 끝을 포함하여라는 조건을 빼먹지 않기
 * 문제만 보고 어렵겠다 생각하지 말고, 일단 가지고 있는 조건부터 나열해보면서 조합하기.. 
 * 시간은 생각보다 좀 오래걸리긴했지만 나름 해결하고 나니 편안 ㅎㅎ
 */
