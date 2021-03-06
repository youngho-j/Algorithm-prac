package main.Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Math1_9_1011 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		int testCase = Integer.parseInt(br.readLine());
		
		for(int i = 0 ; i < testCase ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int dis = y-x;
			int max = (int)Math.sqrt(dis);
			
			if(max == Math.sqrt(dis)) {
				sb.append(2 * max - 1).append("\n");
			} else if(dis <= max * max + max) {
				sb.append(2 * max).append("\n");
			} else {
				sb.append(2 * max + 1).append("\n");
			}
		}
		System.out.println(sb);
	}
}

/*
 * 조건 :
 * 1. 전 작동시기에 k 거리 이동시 다음 이동은 k-1, k, k+1 거리만큼만 이동 가능
 * 2. 처음 이동시는 무조건 1 이동
 * 3. y 지점 도착 직전 이동거리는 무조건 1 이동해야함 -> 도착 직전 전의 거리 이동은 1, 2로 제한됨(0은 이동한게 없으므로 제외)
 * 
 * 주의사항 : 확실히 암산보다는 손으로 끄적여보는게 도움이 많이 된다.
 * 처음 시도는 거리를 구할때 해당 y-x 가 아닌 어차피 처음과 끝은 1로 거리이동이 고정되어 있어 (y-1)-(x+1)로 풀었는데 이게 
 * 거리가 1일경우와 도착 직전 전의 거리이동의 거리가 3이상 나오는 경우도 있어 직전 거리이동이 1이 되지 않아 식을 갈아엎음.. ㅠ 
 * |dis|count|maxDis|moveDis|
*/
