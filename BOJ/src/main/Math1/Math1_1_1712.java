package main.Math1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Math1_1_1712 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		// 고정비용
		int fixed = Integer.parseInt(st.nextToken());
		// 가변비용 - 1대 생산 
		int variable = Integer.parseInt(st.nextToken());
		// 판매가격 - 1대 판매가격
		int selling = Integer.parseInt(st.nextToken());
		
		if(variable >= selling) {
			System.out.println(-1);
		} else {
			System.out.println((fixed/(selling-variable))+1);
		}
	}
}
/*
 * 원인 : 일반적인 값들이 들어올경우 특히, 예제는 결과값이 잘 도출되나 실패라고 뜸..
 * 로직처리상 작은 값을 넣었을때는 문제가 없었음.
 * 문제 내 A,B,C는 21억 이하의 자연수이다. 라는 말이 있어서 2000000000을 넣고 테스트시 1이 출력됨
 * int 범위가 초과되어 해당 문제가 틀렸다고 출력되는 것 같음
 * 
 * 주의 사항 : n * selling = fixed + (n * variable) = 손익분기점
 * 이익이나는 지점을 찾아야하므로 +1을 해주어야함! (빼먹으면 틀림.. 좋다고 올렸다가 이거때문에 또 틀림.. ㅠ)
 * 
 * 처음 푼 코드
 * 	public static int breakPoint(String str) {
		StringTokenizer st = new StringTokenizer(str, " ");
		// 고정비용
		int fixed = Integer.parseInt(st.nextToken());
		// 가변비용 - 1대 생산 
		int variable = Integer.parseInt(st.nextToken());
		// 총비용 - 고정비용 + 가변비용(생산비) 
		int total = fixed;
		// 판매가격 - 1대 판매가격
		int selling = Integer.parseInt(st.nextToken());
		// 총수입 
		int revenue = 0;
		// 손익분기점
		int count = 0;
		
		while(revenue <= total) {
			if(variable >= selling) {
				count = -1;
				break;
			} else {
				total += variable;
				revenue += selling;
				count++;				
			}
		}
		return count;
	}
 */
