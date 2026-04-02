import java.util.Scanner;

public class ModuloArithmetic {
    static long mod = (long)(1e9 + 7); 
    public static void main(String [] args){
        
        Scanner sc = new Scanner(System.in) ;

        long a = sc.nextLong() ; 
        long b = sc.nextLong() ; 

        long addition = (a + b) % mod ; 
        long subtraction = (a - b + mod) % mod ; 
        long multiplication = (a  * b ) % mod ; 

        System.out.println(addition);
        System.out.println(subtraction);
        System.out.println(multiplication);

    }
}
