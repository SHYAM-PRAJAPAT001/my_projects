import java.util.Scanner;

public class ModularInverse {
    static long mod = 1000000007 ; 

    static long binaryExponentiation(long base , long exponent){

        long result = 1 ; 
        
        while(exponent > 0){

            if((exponent & 1) == 1) result = (result * base) % mod ; 
            base = (base * base) % mod ; 
            exponent >>= 1 ; 
        }

        return result ; 
    }
    static long modInverse(long a , long b ){
        return (a * binaryExponentiation(b , mod - 2)) % mod ; 
    }
    public static void main(String [] args){
        
        Scanner sc = new Scanner(System.in) ;

        long a = sc.nextLong() ; 
        long b = sc.nextLong() ; 

        long result = modInverse(a , b) ; 

        System.out.println(result) ; 
    }
}
