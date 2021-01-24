package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Math1_3_1193 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 구하고자 하는 순번
		int x = Integer.parseInt(br.readLine());
		// 칸 개수를 담아줄 변수 (처음 대각선에 1/1 1개가 있으므로 초기값을 1로)
		int count = 1;
		// 칸 개수의 누적 합
		int sum = 0;
		
		// 몇번 반복해야할지 모르므로 while
		while(true) {
			if(x <= count + sum) {
				// 대각선의 개수가 짝수일경우 홀수일경우 
				if(count % 2 == 1) {
					// 대각선의 개수 홀수 > 분모가 분자보다 큰 수부터 시작 (방향 : 우상단)
					// 진행방향이 우상단 > 분자는 증가하므로, x - 누적개수 / 분모 + 분자 = 카운트 + 1
					System.out.println(((count+1)-(x-sum)) + "/" + (x-sum));
					break;
				} else {
					System.out.println((x-sum) + "/" + ((count+1)-(x-sum)));					
					break;
				}
			} else { 
				// x값이 count + sum보다 큰경우 다음 대각선의 개수와 누적 합을 더하기 위함 
				sum += count;
				count++;
			}
		}		
	}
}
/*
 *  풀이과정 :
 *  시도 1 : 처음 접근을 할때는 이중배열로 접근하였음 > 위치는 잡을수 있었으나 해당 값을 어떻게 얻어야할지 모르겠어서 다지우고 원위치
 *  시도 2 : 라인별로 증가하는 수 홀수>짝수 라인 증가시 +1 짝수>홀수 +4 이건 가망이 없었음.. ㅋㅋㅋㅋ
 *  시도 3 : 대각선으로 라인을 묶어서 홀수라인일경우 진행방향 좌하단 값은 증가, 짝수라인 진행방향 우상단 값 감소.. 위치에따른 값을 못찾아서 다시 원위치
 *  시도 4 : 대각선 갯수 증가 +1 규칙 찾음, 그래도 감이 안와서 힌트 참고.. 
 *  시도 5 : 대각선의 분자 분모의 합 짝수, 개수는 홀수 / 합 홀수, 개수 짝수 
 *  
 *  다른 사람 코드를 보면 되게 간단하게 풀린것들을 자주보는데 난 풀면 풀수록 규칙을 찾는게 힘든데 ㅠㅠ 
 *  힌트 없이도 풀 수 있도록 더 노력해야겠다.
 *  
 *  
 *    
 *  
 */
