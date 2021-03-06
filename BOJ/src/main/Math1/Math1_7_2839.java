package main.Math1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Math1_7_2839 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int sugar = Integer.parseInt(br.readLine());
		// 설탕 최대 값
		int temp1 = 5000;
		// 5kg 봉지가 많아야 더 적은 봉지로 배달 가능
		for(int i = 0 ; i <= (sugar/5) ; i++) {
			int remaining = sugar - (5*i);
			if(remaining % 3 == 0) {
				if((i + (remaining/3)) < temp1) {
					temp1 = i + (remaining/3);					
				}
			} 
		}
		//5kg + 3kg 조합이 안될경우
		if(temp1 == 5000) {
			temp1 = -1;					
		}
		System.out.println(temp1);
	}
}
/*
	시도 1. if문 분기로 해결 -> 실패
	시도 2. for문을 통해 최소봉지를 구하기 위해 5로 나눈 뒤 3kg로 채우는 방식 else문 위치 때문에 틀림 
	
	참고사항 : 규칙찾기(골드바흐의 추측)
	"두 소수의 합으로 표현 가능한 모든 정수는, 
	모든 항이 1이 될 때까지 원하는 만큼 얼마든지 많은 개수의 소수의 합으로 분해할 수 있다."
	-> 현재 "2보다 큰 모든 짝수는 두 소수의 합으로 표현가능하다." (강한 골드바흐의 추측)
	
	일단 컴퓨터로 10^18 까지는 참인 것이 밝혀졌고 여러 증명들이 있으나,
	어디까지나 약한 골드바흐의 추측의 증명일 뿐 강한 골드바흐의 추측이 증명된 것은 아니다.
	그러나 사실상 참이라고 보고는 있다.
	
	그렇기 때문에 8 이상의 값에서 3과 5로 구성되지 못하는 수는 0에 가깝다고 한 것이다.
	Reference : https://st-lab.tistory.com/72?category=841870
	
*/
// 시도 1. 코드
//if(sugar % 5 != 0) {
//	temp1 = sugar/5;
//	if((sugar % 5) % 3 != 0) {
//		temp1 = -1;
//	} else {
//		temp1 += (sugar % 5) / 3;
//	}
//} else {
//	
//}

//시도 2. 코드
//int temp1 = 5000;
//for(int i = 0 ; i <= (sugar/5) ; i++) {
//	int remaining = sugar - (5*i);
//	if(remaining % 3 == 0) {
//		if((i + (remaining/3)) < temp1) {
//			temp1 = i + (remaining/3);					
//		}
//	} else {
//		if(temp1 == 5000) {
//			temp1 = -1;					
//		}
//	}
//}
//System.out.println(temp1);