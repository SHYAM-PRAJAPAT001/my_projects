import java.util.Scanner;

public class EuclidDivisionAlgo {

    static long gcd(long a , long b){
        if(b == 0) return a; 
        return gcd(b , a % b) ; 
    }
    public static void main(String [] args){
        
        Scanner sc = new Scanner(System.in) ;

        long a = sc.nextLong() ; 
        long b = sc.nextLong() ; 

        long gcdResult = gcd(a , b) ;
        long lcmResult = (a * b) / gcdResult ; 
        
        System.out.println("GCD : " + gcdResult) ; 
        System.out.println("LCM : " + lcmResult) ; 
    }
}
