package main.Backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Backtracking_8_14889_retry {
	/*
		N명이서 축구 - N명은 짝수
		팀을 두개로 나눔 - 스타트와 링크
		S ij는 팀을 합했을때 능력치
		능력치 차이 최소 
	*/
	// 팀 조합 점수를 담을 배열
	static int team[][];
	static boolean select[];
	static int N;
	static int differ = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException{
		// 의문점 - input 구현방식에 따른 속도는 어떤 차이가 있을까?
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 참가 인원수 - 반드시 짝수이다.
		N = Integer.parseInt(br.readLine());
		
		// 배열 크기 초기화
		team = new int[N][N];
		select = new boolean[N];
		// 의문점 - 문자열 분리시 split과 차이는 무엇인가?
		
		// stat 입력
		for(int i = 0 ; i < N ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0 ; j < N ; j++) {
				team[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dfs(0,0);
		System.out.println(differ);
	}
	
	public static void dfs(int idx, int depth) {
		if(depth == N/2) {
			diffStats();
			return;
		}
		for(int i = idx ; i < select.length ; i++) {
			if(!select[i]) {
				select[i] = true;
				dfs(i + 1, depth + 1);
				select[i] = false;
			}
		}
	}
	
	public static void diffStats() {
		int start = 0;
		int link = 0;
		
		for(int i = 0 ; i < N - 1 ; i++) {
			for(int j = i+1 ; j < N ; j++) {
				if(select[i] == true && select[j] == true) {
					start += team[i][j];
					start += team[j][i];
				} else if(select[i] == false && select[j] == false) {
					link += team[i][j];
					link += team[j][i];
				}
			}
		}
		int diff = Math.abs(start - link);
		
		if(diff == 0) {
			System.out.println(diff);
			System.exit(0);
		}
		differ = Math.min(diff, differ);
	}
}
