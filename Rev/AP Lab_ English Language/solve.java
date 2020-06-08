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
