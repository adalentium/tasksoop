
import java.io.Serializable;

public class my_first_ten_tasks {
    public static void main(String[] args) { 
        System.out.println("reminder = " + reminder(6,5));
        System.out.println("triArea = " + triArea(6,5));
        System.out.println("legs = " + legs(2, 3, 5));
        System.out.println("profitableGame = " + profitableGame(0.2, 50, 9));
        System.out.println("oper = " + oper(24, 15, 9));
        System.out.println("ctoa = " + ctoa('a'));
        System.out.println("addUpTo = " + addUpTo(10));
        System.out.println("triLength= " + triLength(8, 10));
        int[] cubes = {1, 5, 9};
        System.out.println("sumCube= " + sumCube(cubes));
        System.out.println("abcmath = " + abcmath(42,5,10));
    }
    public static int reminder (int a, int b){ 
        return (a%b);
    }
    public static double triArea (int osn, int vys){
        return (0.5*osn*vys);
    }
    public static int legs (int chic, int cows, int pigs){
        return (chic*2 + cows*4 + pigs*4);
    }
    public static boolean profitableGame(double prob, double prize, double pay){
        if (prob*prize>pay){
            return true;
        }
        else {
            return false;
        }
    }
    public static String oper(int N, int a, int b){ 
        String added = "added"; 
        String subtracted = "subtracted"; 
        String divided = "divided"; 
        String multiplied = "multiplied"; 
        String none = "none"; 
        if (a + b == N){ 
            return added; } 
        else if (a - b == N){ 
            return subtracted; 
        } 
        else if (a / b == N){ 
            return divided; 
        }  
        else if (a * b == N){ return multiplied; } 
        else { 
                return none; 
        } 
    } 
    public static int triLength(int a, int b){
        return a+b-1;
    }
    public static int ctoa(char a){
        return a;
    }
    public static int addUpTo(int a){
        int count = 0;
        for (int i=1;i<=a;i++){
            count += i;
        }
        return count;
    }
    public static int sumCube(int[] elem){ 
        int Sum = 0; 
        for (int j : elem) { Sum += j * j * j; } 
        return Sum; 
    }
    public static boolean abcmath(int a, int b, int c){ 
        return a * Math.pow(2, b) % c == 0; } 
}
