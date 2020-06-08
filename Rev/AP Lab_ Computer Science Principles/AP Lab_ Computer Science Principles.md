# AP Lab: Computer Science Principles 100pt(564solves)

```
This activity will ask you to reverse a basic program and solve an introductory reversing challenge. You will be given an output that is to be used in order to reconstruct the input, which is the flag.

Note: The "Student Guide" isn't needed to solve the challenges in this series.
```

与えられたファイルに書かれているコードは次のようである。

```java
import java.util.Scanner;
public class ComputerSciencePrinciples
{
  public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      String inp = sc.nextLine();
      if (inp.length()!=18) {
          System.out.println("Your input is incorrect.");
          System.exit(0);
      }
      inp=shift2(shift(inp));
      if (inp.equals("inagzgkpm)Wl&Tg&io")) {
          System.out.println("Correct. Your input is the flag.");
      }
      else {
          System.out.println("Your input is incorrect.");
      }
      System.out.println(inp);
  }
  public static String shift(String input) {
      String ret = "";
      for (int i = 0; i<input.length(); i++) {
          ret+=(char)(input.charAt(i)-i);
      }
      return ret;
  }
  public static String shift2(String input) {
      String ret = "";
      for (int i = 0; i<input.length(); i++) {
          ret+=(char)(input.charAt(i)+Integer.toString((int)input.charAt(i)).length());
      }
      return ret;
  }
}
```

このコードから、これは与えられた文字列を特定の法則で別の文字列に変換するものであるとわかる。<br>
今回は自作関数『shift』と『shift2』で入力された文字列を移動しているだけなので、上記のコードを
参考にして以下のコードを書いた。

```java
import java.util.Scanner;
public class ComputerSciencePrinciples
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String inp = sc.nextLine();

        inp=shift(shift2(inp));

        System.out.println(inp);
    }
    public static String shift(String input) {
        String ret = "";
        for (int i = 0; i<input.length(); i++) {
            ret+=(char)(input.charAt(i)+i);   //-を+に変更
        }
        return ret;
    }
    public static String shift2(String input) {
        String ret = "";
        for (int i = 0; i<input.length(); i++) {
            ret+=(char)(input.charAt(i)-Integer.toString((int)input.charAt(i)).length());
            //+を-に変更
        }
        return ret;
    }
}
```
