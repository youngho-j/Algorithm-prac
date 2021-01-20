package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Arragement_7_4344 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		//학생 수
		int stu = 0;
		//점수 합
		int sum = 0;
		// 케이스 수
		int testCase = Integer.parseInt(br.readLine());
		//배열 
		int[] temp;
		// 배열에 들어갈 횟수 체크
		int c = 0;
		// 평균보다 점수 높은 친구들
		int rs = 0;
		
		for(int i = 0 ; i < testCase ; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			//학생 수
			stu = Integer.parseInt(st.nextToken());
			//학생 수만큼 배열 생성
			temp = new int[stu];
			
			//학생들 총점
			while (st.hasMoreTokens()) {
				temp[c] = Integer.parseInt(st.nextToken());
				sum += temp[c];
				c++;
			}
			// 평균 넘는 학생 수 
			for(int j = 0 ; j < temp.length ; j++) {
				if(temp[j] > sum/c) {
					rs++;
				}
			}
			// 평균 넘는 학생 비율 출력 - 형변환시 float, double 상관없음
//			System.out.printf("%.3f%%\n", 100.0 * rs / c);
//			sb.append(String.format("%.3f", (double) rs / c * 100)).append("%\n");
			sb.append(String.format("%.3f%%%n", (double) rs / c * 100));
			
			
			// 총점 계산 끝 초기화
			c = 0;
			sum = 0;
			rs = 0;
		}
		System.out.println(sb);
	}
}
/*
 * 원인 : decimalFormat, Math.round 사용시 틀림.. 이클립스상 가능, 제출시 틀렸습니다. 시간잡고 다시 한번 봐야할듯 / 가장 유럭한 것은 변수값 지정시 오류인듯?
 *  전에 시도한 상황과 가장 비슷한 내용 : 
 *  https://dev538.tistory.com/entry/%EB%B0%B1%EC%A4%80-JAVA4344%EB%B2%88-%ED%8F%89%EA%B7%A0%EC%9D%80-%EB%84%98%EA%B2%A0%EC%A7%80
 *  
 * 알아두기 : 
 * printf("출력 서식", 출력 내용) - 출력 후 줄바꿈 없음 \n 또는 %n 추가 필요
 *   - 출력서식 %[-][0][n][.m]지시자
 *   지시자를 제외한 나머지 생략 가능 Ex) %d 
 *   - : 전체 자리수 지정된 경우 왼쪽 정렬 후 빈칸에 공백 출력
 *   0 : 전체 자리수 지정된 경우 왼쪽 남는 자리에 0을 출력  Ex) %03d
 *   n : 출력할 전체 자리수 지정(오른쪽 정렬).  Ex) %3d, 전체자리수가 3인 정수
 *  .m : 소수점 아래 자리수 지정, 잘리는 소수점 자리수는 반올림하여 표시.  Ex)3.2f, 전체자리수가 3이고 소수점 둘째자리인 실수
 *  
 *   - 지시자 
 *   %b : boolean 형식으로 출력 
 *   %d : 정수 형식으로 출력
 *   %o : 8진수 정수의 형식으로 출력
 *   %x or %X : 16진수 정수의 형식으로 출력
 *   %f : 소수점 형식으로 출력
 *   %c : 문자형식으로 출력 
 *   %s : 문자열 형식으로 출력
 *   %n	: 줄바꿈 기능
 *   %e or %E : 지수 표현식의 형식으로 출력
 *   
 *   float 와 double의 차이
 *   - 표현가능한 실수가 얼마나 정밀한가의 차이 / double이 오차범위가 줄고 더 정밀한 계산 가능
 */
