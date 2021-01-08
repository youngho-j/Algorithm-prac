package Main;
public class Print_3_10171{
    public static void main(String[] args){
        for(int i = 0; i < 30 ; i++) {
			if((i == 0) || (i == 24)) {
				System.out.print((char)92);				
			} else if((i == 5) || (i == 19)) {
				System.out.print((char)47);				
			} else if(i == 6) {
				System.out.print((char)92);				
			} else if(i == 7) {
				System.out.println();
			} else if((i == 9) || (i == 28)){
				System.out.print((char)41);				
			} else if((i == 12) || (i == 16) || (i == 25)) {
				System.out.print((char)40);
			} else if(i == 14){
				System.out.print((char)39);
			} else if(i == 15){
				System.out.println((char)41);
			} else if(i == 22) {
				System.out.println((char)41);
			} else if((i == 26) || (i == 27)) {
				System.out.print((char)95);
			} else if(i == 29) {
				System.out.print((char)124);
			} else {
				System.out.print(" ");							
			}
		}	
    }
}

/*
원인 : 공백 표시
주의사항 : 이스케이프 시퀀스로 풀면 간단하게 풀 수 있었으나 갑작스럽게 for문 별짓기가 생각나서 
코드가 좀 더럽긴하지만 아스키 코드를 활용해 풀어보았음
그 외에도 생각은 못했지만  BufferedReader, StringBuilder, StringBuffer 를 사용해도 됨
정리!
이스케이프 시퀀스란?
기본적인 방법으로 입력할 수 없는 문자를 입력하기 위해 사용 되며
제어문자 \n, \r, \t, \b / 이스케이프 문자 \', \", \\
\를 앞에 붙여주면 됨

*/

