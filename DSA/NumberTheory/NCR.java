import java.util.Scanner;

public class NCR {

    static long mod = (long)(1e9 + 7) ; 
    static long factorial[] ; 
    static long inverseFactorial[] ; 
    static int max = 1000000 ;

    static long binaryExponentiation(long base , long exponent){

        long result = 1 ; 
        
        while(exponent > 0){
            if((exponent & 1) == 1) result = (result * base) % mod ; 
            base = (base * base) % mod ; 
            exponent >>= 1 ; 
        }

        return result ; 
    }

    static void preComputeFactorials(){

        factorial = new long[max + 1] ;
        inverseFactorial = new long[max + 1] ; 

        factorial[0] = 1L ; 

        for(int i = 1 ; i <= max ; i++){
            factorial[i] = (factorial[i - 1] * i) % mod ; 
        }

        inverseFactorial[max] = binaryExponentiation(factorial[max] , mod - 2) ; 

        for(int i = max - 1 ; i >= 0 ; i--){
            inverseFactorial[i] = (inverseFactorial[i + 1] * (i + 1)) % mod ;
        }
    }

    static long nCr( int n , int r){
        if(r > n ) return 0 ; 
        return factorial[n] * inverseFactorial[r] % mod * inverseFactorial[n - r] % mod ; 
    }
    public static void main(String [] args){
        
        Scanner sc = new Scanner(System.in) ;

        int n = sc.nextInt() ; 
        int r = sc.nextInt() ; 
        preComputeFactorials() ;
        System.out.println(nCr(n , r)) ; 
    }
}
