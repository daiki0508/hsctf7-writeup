# Recursion Reverse 100pt(309solves)

```
Jimmy needs some help figuring out how computers process text, help him out!
```

そして今回与えられたプログラムに記述されているコードは次の通りです。

```java
import java.util.Scanner;
public class AscII {
	static int num = 0;
	
	public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
		 System.out.print("Enter your  guess: ");
		 String guess = sc.nextLine();
		 
		 if (guess.length()!= 12) 
			 System.out.println("Sorry, thats wrong.");
		 else {
			 if(flagTransformed(guess).equals("I$N]=6YiVwC")) 
				 System.out.println("Yup the flag is flag{" + guess + "}");			 
			 else 
				 System.out.println("nope"); 
		 }
	}
	
	public static String flagTransformed(String guess) {
		char[] transformed = new char[12];
		
		for(int i = 0; i < 12; i++) {
			num = 1;
			transformed[i] = (char)(((int)guess.charAt(i) + pickNum(i + 1)) % 127);	
			// 127はASCII印字可能範囲を示している
		}
		
		char[] temp = new char[12];		
		for(int i = 11; i >= 0; i--) 
			temp[11-i] = transformed[i];
			
		return new String(temp);	
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
```

このコードから、入力した値に特定の処理をして暗号化するプログラムだと分かる。<br>
そこで全く逆の処理を行うプログラムを上記のコードを参考にして作成してデコード処理を行う。

```java
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
```
