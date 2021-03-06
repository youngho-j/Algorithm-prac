package main.Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sort_4_2108 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
/*
 * 0 ~ 3999 -> -4000 ~ -1 4000 -> 0 4001 ~ 8000 -> 1 ~ 4000
 */
		int[] list = new int[8001];
/*
 * sum = 누적합 min = 최솟값 max = 최댓값 most = 최빈값 middle = 중앙값
 */		
		int sum = 0;
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		int mode = 0;
		int middle = 0;
		
		for(int i = 0 ; i < N ; i++) {
			int num = Integer.parseInt(br.readLine());
			sum += num;
			list[num + 4000]++;
			
			if(max < num) {
				max = num;
			}
			if(min > num) {
				min = num;
			}
		}
		int count = 0;
		int mode_max = 0;
//		최빈값 조건을 만족시키기 위한 변수
		boolean check = false;
//		최소값과 최대값 사이에 나머지 수가 존재 하므로 +4000하여 그 범위 내에서 찾음
		for(int i = min + 4000 ; i <= max + 4000 ; i++) {
			//입력받은 수 일 경우
			if(list[i] > 0) {
//				중앙값 찾기 -> 해당 수의 누적 개수를 count에 합하여 전체 길이의 절반에 못 미칠때까지 누적 
				if(count < (N+1)/2) {
					count += list[i];
					middle = i - 4000;
				}
//				최빈값 찾기 -> 해당 수의 누적 개수가 mode_max 보다 클 경우 mode_max에 넣어 검사
//				조건, 여러 개 있을 때에는 최빈값 중 두 번째로 작은 값을 출력
				if(mode_max < list[i]) {
					mode_max = list[i];
					mode = i - 4000;
					check = true;
				} else if(mode_max == list[i] && check == true) {
					mode = i - 4000;
					//조건상 두 번째로 작은 값 이후는 필요없으므로
					check = false;
				}
			}
		}
//		산술평균, 중앙값, 최빈값, 범위 순 출력
		System.out.println((int)Math.round((double)sum/N));
		System.out.println(middle);
		System.out.println(mode);
		System.out.println(max - min);
	}
}
