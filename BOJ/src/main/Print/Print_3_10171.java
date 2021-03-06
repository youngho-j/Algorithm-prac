package main.Print;
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
?��?�� : 공백 ?��?��
주의?��?�� : ?��?���??��?�� ?��???���? ??�? 간단?���? ?? ?�� ?��?��?��?�� 갑작?��?���? for�? 별짓기�? ?��각나?�� 
코드�? �? ?��?��긴하�?�? ?��?��?�� 코드�? ?��?��?�� ???��보았?��
�? ?��?��?�� ?��각�? 못했�?�?  BufferedReader, StringBuilder, StringBuffer �? ?��?��?��?�� ?��
?���?!
?��?���??��?�� ?��???��???
기본?��?�� 방법?���? ?��?��?�� ?�� ?��?�� 문자�? ?��?��?���? ?��?�� ?��?�� ?���?
?��?��문자 \n, \r, \t, \b / ?��?���??��?�� 문자 \', \", \\
\�? ?��?�� 붙여주면 ?��

*/

