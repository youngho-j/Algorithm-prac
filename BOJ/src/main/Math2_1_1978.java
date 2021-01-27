package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Math2_1_1978 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int count = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int result = 0;
		
		for(int i = 0; i < count ; i++) {
			//소수 판별
			boolean isPrime = true;
			
			int num = Integer.parseInt(st.nextToken()); 
			if(num == 1) {
				continue;
			}
			// 1은 모든수의 약수가 되므로 2부터 시작, Math.sqrt -> 해당 파라미터의 루트 구하기, 음수일경우 NaN 반환 Ex) 루트 25 -> 5  
			for(int j = 2 ; j <= Math.sqrt(num) ; j++) {
				// 나누어 떨어질경우 소수가 아님
				if(num % j == 0) {
					isPrime = false;
					break;
				}
			}
			if(isPrime) {
				result++;
			}
		}
		System.out.println(result);
	}
}
/*
 * 
 * 참고 :
 * 소수 - 수의 개수가 2개뿐인 수 
 * '1과 자기 자신으로밖에 나누어 떨어지지 않고 자기 자신의 곱셈의 역수가 없는 수'
 * 소수 판별 -> 1과 자기 자신 만을 약수로 가진다. -> 나머지 (2 ~ N-1) 까지의 값을 나눴을때 약수가 아니여야한다. [기존 방법 - 시간복잡도 O(N)]
 * 판별하려는 숫자의 제곱근 이상의 수로 나눌 경우 이전에 검사한 수 중 약수인 수를 약수로 갖거나, 약수가 아닌경우 밖에 없으므로 
 * 판별하려는 숫자의 제곱근까지만 검사하면됨
 * 
 * 여기서 제곱근은 루트 숫자 정도로 생각하면 될듯 수학적으로 제곱근은 '무엇을 제곱하면 해당숫자가 되는지 정답을 구하시오'와 같은말
 * 하지만 여기서는 양수의 값만을 원하므로, 루트 숫자로 계산.. 
 * 
 */
