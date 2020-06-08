import java.util.*;

public class Main {
   
   static int num = 0;
   
   public static void main(String[] args) {
		 String guess = "I$N]=6YiVwC";		//この文字列を符合するとflagになる
		 guess = flagTransformed(guess);
		 System.out.println(guess);
	}
   
   public static String flagTransformed(String guess) {
// ここから処理の流れが逆 temp変数で処理が複雑になっている

		char[] temp = new char[12];		
		for(int i = 11; i >= 0; i--) 
			temp[11-i] = guess.charAt(i);
		
		char[] transformed = new char[12];		
		for(int i = 0; i < 12; i++) {
			num = 1;
			int j = 0;
			int pick =  pickNum(i + 1);
			while(true) {
			    int k = j*127 + (int)temp[i] - pick;
			    if(k > 0){
			        transformed[i] = (char)k;
			        break;
			    } 
			    j++;
			}
		}
			
		return new String(transformed);		//処理の流れが逆なので最後がtransformedになる
	}
	
	private static int pickNum(int i) {
		
		for(int x = 0; x <= i; x++)
			num+=x;
		
		if(num % 2 == 0)
			return num;
		else 
			num = pickNum(num);
		
		return num;		
	}
}
