# AP Lab: English Language 100pt(425solves)

```
The AP English Language activity will ask you to reverse a program about manipulating strings and arrays.
Again, an output will be given where you have to reconstruct an input.
```

与えられたファイルのコードは以下のとおりである。

```java
import java.util.Scanner;
public class EnglishLanguage
{
   public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       String inp = sc.nextLine();
       if (inp.length()!=23) {
           System.out.println("Your input is incorrect.");
           System.exit(0);
       }
       for (int i = 0; i<3; i++) {
           inp=transpose(inp);
           inp=xor(inp);
       }
       if (inp.equals("1dd3|y_3tttb5g`q]^dhn3j")) {
           System.out.println("Correct. Your input is the flag.");
       }
       else {
           System.out.println("Your input is incorrect.");
       }
   }
   public static String transpose(String input) {
       int[] transpose = {11,18,15,19,8,17,5,2,12,6,21,0,22,7,13,14,4,16,20,1,3,10,9};
       String ret = "";
       for (int i: transpose) {
           ret+=input.charAt(i);
       }
       return ret;
   }
   public static String xor(String input) {
       int[] xor = {4,1,3,1,2,1,3,0,1,4,3,1,2,0,1,4,1,2,3,2,1,0,3};
       String ret = "";
       for (int i = 0; i<input.length(); i++) {
           ret+=(char)(input.charAt(i)^xor[i]) ;
       }
       return ret;
   }
}
```

入力された値に自作関数『transpose』と『xor』を適用してそれが指定の文字列と等しいかを確認する
プログラムである。<br><br>
そこで、上のコードを参考にしてデコードするプログラムコードは以下のようになる。

```java
import java.util.Scanner;
public class EnglishLanguage
{
   public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       String inp = sc.nextLine();

       for (int i = 0; i<3; i++) {
           inp=xor(inp);      //xorとtransposeの実行順序を入れ替える
           inp=transpose(inp);
       }
        System.out.println(inp);
   }
   public static String transpose(String input) {
       int[] transpose = {11,19,7,20,16,6,9,13,4,22,21,0,8,14,15,2,17,5,1,3,18,10,12};
       String ret = "";
       for (int i: transpose) {
           ret+=input.charAt(i);
       }
       return ret;
   }
   public static String xor(String input) {
       int[] xor = {4,1,3,1,2,1,3,0,1,4,3,1,2,0,1,4,1,2,3,2,1,0,3};
       String ret = "";
       for (int i = 0; i<input.length(); i++) {
           ret+=(char)(input.charAt(i)^xor[i]) ;
       }
       return ret;
   }
}
```
上記のプログラムはxorされた値に再度xorを行うと元の値に戻るという特性を利用している。
