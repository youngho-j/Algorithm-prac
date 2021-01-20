package main;
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
?›?¸ : ê³µë°± ?‘œ?‹œ
ì£¼ì˜?‚¬?•­ : ?´?Š¤ì¼??´?”„ ?‹œ???Š¤ë¡? ??ë©? ê°„ë‹¨?•˜ê²? ?? ?ˆ˜ ?žˆ?—ˆ?œ¼?‚˜ ê°‘ìž‘?Š¤?Ÿ½ê²? forë¬? ë³„ì§“ê¸°ê? ?ƒê°ë‚˜?„œ 
ì½”ë“œê°? ì¢? ?”?Ÿ½ê¸´í•˜ì§?ë§? ?•„?Š¤?‚¤ ì½”ë“œë¥? ?™œ?š©?•´ ???–´ë³´ì•˜?Œ
ê·? ?™¸?—?„ ?ƒê°ì? ëª»í–ˆì§?ë§?  BufferedReader, StringBuilder, StringBuffer ë¥? ?‚¬?š©?•´?„ ?¨
? •ë¦?!
?´?Š¤ì¼??´?”„ ?‹œ???Š¤???
ê¸°ë³¸? ?¸ ë°©ë²•?œ¼ë¡? ?ž…? ¥?•  ?ˆ˜ ?—†?Š” ë¬¸ìžë¥? ?ž…? ¥?•˜ê¸? ?œ„?•´ ?‚¬?š© ?˜ë©?
? œ?–´ë¬¸ìž \n, \r, \t, \b / ?´?Š¤ì¼??´?”„ ë¬¸ìž \', \", \\
\ë¥? ?•ž?— ë¶™ì—¬ì£¼ë©´ ?¨

*/

