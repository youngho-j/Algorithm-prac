package main.Arrangement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Arrangement_5_1546 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		//시험 과목의 개수
		int count = Integer.parseInt(br.readLine());
		
		//시험 과목점수를 넣기 위한 배열
		int[] subArr = new int[count];
		
		//배열에 넣기위한 변수
		int a = 0;
		
		//최대 점수를 구하기 위한 변수
		int max = 0;
		
		int sum = 0;
		
		//세준이 현재 성적
		st = new StringTokenizer(br.readLine(), " ");		
		
		do {
			subArr[a] = Integer.parseInt(st.nextToken());
			//최대 점수를 구하기 위함
			if(max < subArr[a]) {
				max = subArr[a];
			}
			sum += subArr[a];
			a++;
		} while (st.hasMoreTokens());
		// a 초기화
		a = 0;
		Double avg = (double)sum/max*100/count;
		System.out.println(avg);
	}
}

/*
 * 주의사항 - 형변환시 큰 타입에서 작은 타입으로 변환시 원본 데이터 손실 가능 주의(데이터의 값이 큰 경우, 타입의 특성상 손실)!
 * byte >> short/char >> int >> long >> float >> double / double형이 가장 큼
 * 
 */
// 처음 시도!
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st;
//		//시험 과목의 개수
//		int count = Integer.parseInt(br.readLine());
//		
//		//시험 과목점수를 넣기 위한 변수
//		Double[] subArr = new Double[count];
//		
//		//배열에 넣기위한 변수
//		int a = 0;
//		
//		//최대 점수를 구하기 위한 변수
//		Double max = 0.0;
//		
//		Double sum = 0.0;
//		
//		//세준이 현재 성적
//		st = new StringTokenizer(br.readLine(), " ");		
//		
//		do {
//			subArr[a] = Double.parseDouble(st.nextToken());
//			//최대 점수를 구하기 위함
//			if(max < subArr[a]) {
//				max = subArr[a];
//			}
//			a++;
//		} while (st.hasMoreTokens());
//		a = 0;
//		
//		
//		// 점수 수정
//		for(int i = 0 ; i < subArr.length ; i++) {
//			sum += ((subArr[i]/max)*100);
//		}
//		System.out.println(sum/count);
