package main;

public class Function_2_4673 {
	//주어진 수 <=10000
	public static void main(String[] args) {
		int[] arr = new int[10001];
		StringBuilder sb = new StringBuilder();
		for(int i = 1 ; i <= 10000 ; i++) {
			int n = d(i);
			if(n > 10000) {
				continue;
			}
			//생성자의 갯수
			arr[n] += 1;
		}
		for(int j = 1 ; j < arr.length ; j++) {
			//셀프넘버인경우 
			if(arr[j] == 0) {
				sb.append(j).append("\n");
			}
		}
		System.out.println(sb);
	}
	//셀프 넘버 구하는 함수
	public static int d(int number) {
		// 파라미터로 넘어온 값을 다음수에 더하기
		int sum = number;
		// 각자리수를 구하기 위해 while문 반복 / 파라미터가 0이 되면 반복종료
		while(number != 0) {
			// 각자리수를 더함, 순서는 1의자리 부터 위로 올라감
			sum = sum + (number % 10);
			// 다음 자리수를 구하기 위해 나누기 10을 함
			number = number / 10;
		}
		return sum;
	}
}
/*
 * 원인 : 숫자를 순서대로 배열에 넣기 위해 배열 길이 10001로 설정 해놓고 범위를 넘는 10001까지 포함해서 에러
 * StringBuilder에 값을 넣을때 숫자를 넣어야하는데 배열에 들어가있는 값을 넣어서 틀림
 * 
 * 주의 : 조건 설정시 신경쓰기 !
 */
