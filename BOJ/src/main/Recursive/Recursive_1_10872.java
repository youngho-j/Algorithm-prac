package main.Recursive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Recursive_1_10872 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		System.out.println(recursive(num));
	}
	public static int recursive(int n) {
		if(n <= 1) {
			return 1;
		} else {
			return n * recursive(n-1);
		}
	}
}
