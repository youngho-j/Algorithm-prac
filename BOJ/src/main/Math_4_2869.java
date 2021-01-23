package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Math_4_2869 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		// a : 낮에 이동 거리, b : 밤에 미끄러지는 거리, v : 막대 높이, day : 일수
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int v = Integer.parseInt(st.nextToken());
		// 조건 : 낮에 이동 a 밤에 미끄러지는 b, 정상 도착시 미끄러지지 않음
		int day = (v-b) / (a-b);
		//나머지가 존재 -> 이동거리 남았음 따라서 일수에 +1
		if((v-b) % (a-b) != 0) {
			day++;
		}
		System.out.println(day);
	}
}

/*
 * 풀이 
 * 시도1 : while문 사용하여 풀이 / 결과는 맞으나, 시간초과
 * 시도2 : 높이 / 이동 - 미끄러지는 / 결과값이 다르게 나옴.. 
 * 시도3 : 실제 카운팅, 밤은 낮보다 카운팅수가 하나 더 작음, 높이 = 일수(이동-미끌)+미끌 -> 일수 = (높이-미끌)/(이동-미끌)
 * 시도1 코드
   // a : 낮에 이동 거리, b : 밤에 미끄러지는 거리, v : 막대 높이, h : 현위치, day : 일수
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int v = Integer.parseInt(st.nextToken());
		int h = 0;
		int day = 0;
		while(true) {
			// 낮에 올라가는 거리만큼 더 해주기
			h += a;
			// 정상에 올라간후에 미끄러지지 않으므로 정상에 도착한지 확인
			if(h >= v) {
				day++;
				break;
			} else {
				// 도착 못했을겨우 자는동안 미끄러진 거리를 빼줌, 그리고 하루를 카운트
				h -= b;
				day++;
			}
		}
		System.out.println(day);
 */
