
import java.util.Arrays;



public class my_second_ten_tasks {
    public static void main(String[] args) { 
        System.out.println(repeat("hello", 3));
        int[] massive = {3, 5, -1, 0};
        System.out.println(differenceMaxMin(massive));
        System.out.println(isAvgWhole(massive));
        System.out.println(cumulativeSum(massive));
        System.out.println(getDecimalPlaces("40.0300"));
        System.out.println(Fibonacci(12));
        System.out.println(isValid("55525"));
        System.out.println(isStrange("root", "moor"));
        System.out.println(isPrefix("root", "roo-"));
        System.out.println(isSuffix("root", "-yot"));
        System.out.println(boxSeq(7));
    }
    
    public static String repeat(String word, int num){ 
        String word1 = new String();
        int j = 0;
        for (int i = 0; i < word.length(); i++){
            while(j<num){
                word1 = word1 + word.charAt(i);
                j++;
            }
            j = 0;
        }
        return word1;
    }
    
    
    
    public static int differenceMaxMin(int[] mass){
        int max = mass[0];
        int min = mass[0];
        for (int i:mass){
            if (i > max) {
                max = i;
            }
            if (i < min) {
                min = i;
            }
        }
        return (max-min);
    }
    
    public static boolean isAvgWhole(int[] mass){
        double c = 0;
        for (int i:mass){
            c += i;
        }
        double f = c/mass.length;
        System.out.println(f);
        return (f % 1) == 0;
    }
    
    public static String cumulativeSum(int[] mass){
        int cnt = 0;
        int[] mass2 = new int[mass.length];
        for (var i=0; i<mass.length; i++){
            cnt += mass[i];
            mass2[i] = cnt;
        }
        String S = Arrays.toString(mass2);
        return S;
    }
    
    public static int getDecimalPlaces(String num){
        String[] output = num.split("\\.");
        int cnt = 0;
        for (int i=0; i<output[1].length(); i++){
            cnt+=1;
        }
        return cnt;
    }
    public static int Fibonacci(int num){
        int i = 0;
        int fib1 = 1;
        int fib2 = 1;
        int fib_sum = 0;
        while (i < num - 1){
            fib_sum = fib1 + fib2;
            fib1 = fib2;
            fib2 = fib_sum;
            i += 1;
        }
        return fib2;
    }
    
     public static boolean isValid(String s){
         char[] s2 = s.toCharArray();
         for (int i:s2){
             if (!Character.isDigit(i)){
                 return false;
             }
         }
         if (s.length() != 5){
             return false;
         }
         return true;
     }
     
     public static boolean isStrange(String s1, String s2){
         char[] s1a = s1.toCharArray();
         char[] s2a = s2.toCharArray();
         if ((s1a[s1a.length-1] == s2a[0])&&(s1a[0] == s2a[s2a.length-1])){
             return true;
         }
         return false;
     }
     
      public static boolean isPrefix(String s1, String s2){
        char[] s1a = s1.toCharArray();
        char[] s2a = s2.toCharArray();
        int i = 0;
        while (s2a[i] != '-'){
            if (s2a[i] == s1a[i]){
                i+=1; 
            }
            else return false;
        }
        return true;
      }
      
       public static boolean isSuffix(String s1, String s2){
         char[] s1a = s1.toCharArray();
        char[] s2a = s2.toCharArray();
        int i = s1.length()-1;
        while (s2a[i] != '-'){
            if (s2a[i] == s1a[i]){
                i-=1; 
            }
            else return false;
        }
        return true;
      }

    public static int boxSeq(int num){ 
        int cnt = 0; 
        if (num == 0){
            return 0;
        }
        else if (num%2==0){
            return num;
        }
        else {
            return num+2;
        }
    }
    
}
