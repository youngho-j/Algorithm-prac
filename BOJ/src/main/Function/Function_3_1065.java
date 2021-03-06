package main.Function;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Function_3_1065 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println(check(Integer.parseInt(br.readLine())));
		
	}
	public static int check(int number) {
		//한수 개수 카운팅
		int cnt = 0;
		// 1 ~ 99까지는 모두 한수
		if(number < 100) {
			return number;
		// 101 이상 부터는 검사 필요
		} else {
			// 1 ~ 99 까지 모두 한수이므로 99개로 초기화
			cnt = 99;
			// 1000을 받을 경우 어차피 한수 아님.. 또한 현재 101 ~ 999는 세자리수만 구하면 됨
			if(number == 1000) {
				number = 999;
			}
			//101부터 해당값까지 for문 반복
			for(int i = 100 ; i <= number ; i++) {
				int units = i%10;
				int tens = (i/10)%10;
				int hundreds = i/100;
				if((hundreds - tens) == (tens - units)) {
					cnt++;
				}
			}
			
		}
		return cnt;
	}
}
/*
 * 원인 : 한수 개수를 파악할때 1 ~ 99까지는 모두 한수이므로 99개를 출력했으나 
 * if(number < 101) { 이 부분에서 100이 들어올경우 한수의 개수가 100이 되므로 틀렸다고 나옴..
 * 따라서, 한수 파악을 할때 범위를 1 ~ 99 / 100 ~ 1000 (1000이 들어올경우 999로 세자리화)로 지정하여 변경
 * 
 * 참고 사항 : 등차수열은 연속하는 두 항의 차이가 모두 일정한 수열
 * 			-> 1 ~ 9 수가 하나 그 자체로 수열에 속함 / 10 ~ 99 각 자리수의 차가 공차(공통된 차이)이고 그 수 자체로 수열에 속함
			어떤 양의 정수 X의 각 자리가 등차 수열을 이룸 -> 한수
 */
