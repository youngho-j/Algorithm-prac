package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Print_8_1008 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		Double c = Double.parseDouble(st.nextToken());
		Double d = Double.parseDouble(st.nextToken());
		System.out.println(c/d);
	}
}

/*
주의사항 : 실제 정답과 출력값의 절대오차 또는 상대오차가 10 -9승 이하이면 정답이다.. 
채점시 맞았다고는 나왔는데 이게 뭔뜻인지는 잘 모르겠다.
일단 소수로 나타내야해서 Double형을 작성해주긴했는데 좀 더 알아봐야할듯..

1) 문제를 풀 때는 float보다는 double형 변수를 쓰는게 좋습니다.
double형 변수까지는 하드웨어로 계산되기 때문에 많이 느려지지 않지만, 정확도가 엄청나게 높아지기 때문입니다.

- float의 상대오차는 약 10^-7 정도
- double의 상대 오차는 약 10^-15 정도
- long double (12bit 혹은 16bit)는 소프트웨어의 도움을 받기 때문에 꽤 많이 느려지기 때문에 쓴다고 꼭 좋은 것은 아닙니다.

참고) https://www.acmicpc.net/blog/view/37
 */
