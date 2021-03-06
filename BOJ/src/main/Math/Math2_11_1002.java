package main.Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.StringTokenizer;

public class Math2_11_1002 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int testCase = Integer.parseInt(br.readLine());
		for(int i = 0 ; i < testCase ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int r1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int r2 = Integer.parseInt(st.nextToken());
			BigDecimal distancePow2 = BigDecimal.valueOf(x2-x1).pow(2).add(BigDecimal.valueOf(y2-y1).pow(2));
			
			// 만나는 점의 개수에 따라 원이 일치하여 교점이 무한 
			if(x1 == x2 && y1 == y2 && r1 == r2) {
				sb.append(-1).append("\n");
			// 원이 외부에서 만나지 않는 경우
			} else if(distancePow2.compareTo(BigDecimal.valueOf(r1+r2).pow(2)) == 1) {
				sb.append(0).append("\n");				
			// 원이 내부에서 만나지 않는 경우
			} else if(distancePow2.compareTo(BigDecimal.valueOf(r1-r2).pow(2)) == -1) {
				sb.append(0).append("\n");								
			// 원이 내부에서 한점에 접할때
			} else if(distancePow2.compareTo(BigDecimal.valueOf(r1+r2).pow(2)) == 0) {
				sb.append(1).append("\n");												
			// 원이 외부에서 한점에 접할때
			} else if(distancePow2.compareTo(BigDecimal.valueOf(r1-r2).pow(2)) == 0) {
				sb.append(1).append("\n");																
			// 그외 나머지 두점 접할때
			} else {
				sb.append(2).append("\n");																				
			}
		}
		System.out.println(sb);
	}
}

// double distance = Math.sqrt(Math.pow(x1-x2, 2) + Math.pow(y1-y2, 2));
// 좌표 비교시 double형(float형)의 경우 약간의 오차 발생 가능 
// -> 부동 소수점 타입은 근사치로 처리하기 때문에 오차 발생시 두 실수는 같지 않을 수 있음
// 따라서, 정확한 계산을 할때는 BigDecimal을 사용
// 기존 정답 코드
//  double distancePow = Math.pow(x2-x1, 2) + Math.pow(y2-y1, 2);
//	if(x1 == x2 && y1 == y2 && r1 == r2) {
//		sb.append(-1).append("\n");
//	} else if(distancePow > Math.pow(r1+r2, 2)) {
//		sb.append(0).append("\n");				
//	} else if(distancePow < Math.pow(r1-r2, 2)) {
//		sb.append(0).append("\n");								
//	} else if(distancePow == Math.pow(r1+r2, 2)) {
//		sb.append(1).append("\n");												
//	} else if(distancePow == Math.pow(r1-r2, 2)) {
//		sb.append(1).append("\n");																
//	} else {
//		sb.append(2).append("\n");																				
//}

