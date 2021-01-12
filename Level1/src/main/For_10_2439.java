package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class For_10_2439 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int a = Integer.parseInt(br.readLine());
		
		//층수 결정
		for(int i = 1 ; i <= a ; i++) {
			//출력 결정
			for(int j = a ; j > 0 ; j--) {
				//j가 클경우 공백 아닌경우 * 출력
				if(j > i) {
					sb.append(" ");
				} else {
					sb.append("*");
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}

/*
 * 원인 : 범위 설정 / 감소식 사용시 조건부분 주의 할 것!
 * 보통 최대 값에서 감소, 그 경우 조건은 최소값보다 커야함
 * 
 * 참고사항 : 기본별찍기의 뒤집었을때 모양 우측에 별을 하나찍기 위해서는 공백이 4칸 필요함 
 * 그 아래층의 경우 공백 3칸 필요 즉, 층이 내려갈때마다 공백이 한칸씩 줄어듬
 * 
 * 
 */