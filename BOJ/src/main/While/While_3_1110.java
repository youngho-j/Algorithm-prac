package main.While;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class While_3_1110 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 반복횟수 체크
		int count = 0;
		// 맨처음 받은 수를 담은 변수
		int input = Integer.parseInt(br.readLine());
		// 비교하기 위해 받은 수를 복사한 변수
		int copy = input;

		while (true) {
			input = ((input % 10) * 10) + (((input / 10) + (input % 10)) % 10);
			count++;
			if (copy == input)
				break;
		}
		System.out.println(count);
	}
}

/*
 * 주의사항 : 문제를 볼때 한번에 생각하려고 하지 말것!
 * 부분으로 나눠서 규칙을 찾아보기!!
 * 해당 문제의 조건 입력받은 수가 한자리수 or 두자리수
 * 한자리수의 경우 십의 자리에 0을 붙여서 합한뒤 오른쪽으로 넘겨주고, 왼쪽의 일의 자리수를 오른쪽의 십의자리수로 오른쪽의 일의자리수를 합친수로 변환
 * 두자리수의 경우 십의 자리와 일의자리를 합한뒤 오른쪽으로 넘겨주고, 왼쪽의 일의 자리수를 오른쪽의 십의자리수로 오른쪽의 일의자리수를 합친수로 변환
 * 
 * 따라서, 좌측에서 일의 자리수를 구하기 위해서는 입력받은 값의 나머지를 구함 -> input%10
 * 이 수는 우측의 십의자리로 변환 -> (input%10)*10
 * 
 * 우측의 일의 자리수를 구하기 위해서는 자리수값을 없앤 값을 더해줘야함, 십의자리일경우 /10을 하고, 일의자리일경우 %10을 통해 나머지값을 보면 알수있음
 * -> (input/10 + input%10)
 * 더한 값을 구했을때 이 값이 두자리일수도 있고, 한자리일수도 있으므로 %10을 통해 우측 일의 자리수를 나타냄 -> (input/10 + input%10)%10
 * 
 * 이렇게 값을 구했을 떄 한 사이클 따라서 while문 밖에 선언해놓은 count 변수에 ++을 통해 횟수 추가
 * 
 * 이러한 과정은 처음받은 수와 변환된 수가 같을때까지 반복되야하므로 if문을 사용하여 복사한 변수와 변경된값이 같을때 while문을 빠져나올 수 있도록 함
 */
