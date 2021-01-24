package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Math1_5_10250 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		/*
		 * 조건
		 * 정문에서 엘베까지 거리 무시 
		 * 인접한 두 방 사이의 거리는 1 가정
		 * 엘베 이동거리 신경x
		 * 걷는거리 같을때 아래층방 선호
		 */
		//테스트 데이터 횟수
		int count = Integer.parseInt(br.readLine());
		for(int i = 0 ; i < count ; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			// h : 층수, w : 층별 방의 수, n : 몇번째 손님인지
			int h = Integer.parseInt(st.nextToken()); 
			int w = Integer.parseInt(st.nextToken()); 
			int n = Integer.parseInt(st.nextToken()); 
			
			// 층수 결정
			if(n % h == 0) {
				sb.append((h*100) + (n/h)).append("\n");
			} else {
				sb.append(((n%h)*100) + ((n/h)+1)).append("\n");
			}			
		}
		System.out.println(sb);
	}
}

/*
 * 참고 : 굳이 출력시 roomNumber로 한자리인지 두자리인지 구분을 할 필요 없는듯.. 
 * 층수는 101, 201, 301, ..., 1201, .. 처럼 100단위로 증가
 * 기존 코드
 * // 층수 결정
			if(n % h == 0) {
				floor = h;
				roomNumber = n/h;
			} else {
				floor = n % h;
				roomNumber = (n/h)+1;
			}
			//출력
			if(roomNumber / 10 == 0) {
				sb.append(floor).append(0).append(roomNumber).append("\n");
			} else {
				sb.append(floor).append(roomNumber).append("\n");					
			}
		}
		System.out.println(sb);
 */
