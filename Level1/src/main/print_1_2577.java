package main;
public class print_1_2577{
    public static void main(String[] args){
        System.out.print("Hello World!");
    }
}
/*
Main.java:1: error: class PrintWord is public, should be declared in a file named PrintWord.java
public class PrintWord{
        ^
1 error

원인 : 자바로 컴파일시 클래스명을 Main으로 하지 않아 컴파일 에러 발생
주의사항 : 유의사항을 조금 더 읽어본다면 여러번 시도 하지 않아도 될듯
*/