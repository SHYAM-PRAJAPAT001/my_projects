import java.util.* ; 
public class BinaryExponentiation {

    static long mod = (long)(1e9 + 7) ; 
    static long binaryExponentiation(long base , long exponent){

        long result = 1 ; 
        
        while(exponent > 0){

            if((exponent & 1) == 1) result = (result * base) % mod ; 
            base = (base * base) % mod ; 
            exponent >>= 1 ; 
        }

        return result ; 
    }
    public static void main(String [] args){
        
        Scanner sc = new Scanner(System.in) ;

        long base = sc.nextLong() ; 
        long exponent = sc.nextLong() ; 

        long result = binaryExponentiation(base , exponent) ;
        System.out.println(result) ; 
    }
}
