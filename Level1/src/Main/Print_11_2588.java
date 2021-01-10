package Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Print_11_2588 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int a = Integer.parseInt(br.readLine());
		String b = br.readLine();
		char[] sp = b.toCharArray();
		
		for(int i = b.length()-1 ; i >= 0  ; i--) {
			System.out.println(a * (sp[i]-'0'));
		}
		System.out.println(a * Integer.parseInt(b));
	}
}
/*
	원인 : 출력순서, 1자리부터 했어야했는데 큰자리수부터 출력을 해서 
	참고사항 : String 문자열을 charAt 메소드로 하나씩 나눠 담을 필요 없음 / toCharArray 메소드 사용하면 빠름.
	for문 감소식 사용시 부등호 기호 꼭 확인할것.. 자꾸 바꾸는거 빼먹네 주의!!
	처음 시도했을때는 for문에서 String을 charAt() 메소드를 사용하여 배열에 담고 temp에 모두 합한 값을 출력하려고 했었는데 너무 코드가 길어짐..

	char -> int 변환
	1. Character.getNumericValue(char 타입 변수)
	2. char 타입 변수 - '0'을 하는 방법이 있음!! 
	기억해 두자!
 */
