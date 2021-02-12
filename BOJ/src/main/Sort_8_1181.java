package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Sort_8_1181 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		
		String[] list = new String[N];
		
		for(int i = 0 ; i < N ; i++) {
			list[i] = br.readLine();
		}
//		익명 클래스를 사용했기때문에 컴파일 시 (외부클래스명)$(숫자).class 형식의 파일 생성 됨
		Arrays.sort(list, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
//				단어 길이가 같을때
				if(o1.length() == o2.length()) {
//					사전 순으로(오름차순)
					return o1.compareTo(o2);
				} else {
//					길이가 짧은 것부터 출력(길이 오름차순)
					return o1.length() - o2.length();
				}
			}
		});
//		중복 단어는 출력하지 않음
		sb.append(list[0] + "\n");
		
		for(int i = 1 ; i < N ; i++) {
			if(!list[i].equals(list[i-1])) {
				sb.append(list[i] + "\n");				
			}
		}
		System.out.println(sb);
	}
}
