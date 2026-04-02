import java.util.Scanner;

public class ExtendedEuclidenAlgo {

    static long[] gcdExtended(long a, long b) {
        if (b == 0) {
            return new long[]{a, 1, 0}; 
        }

        long[] temp = gcdExtended(b, a % b);

        long gcd = temp[0];
        long x1 = temp[1];
        long y1 = temp[2];

        long x = y1;
        long y = x1 - (a / b) * y1;

        return new long[]{gcd, x, y};
    }
    public static void main(String [] args){
        
        Scanner sc = new Scanner(System.in) ;

        long a = sc.nextLong() ; 
        long b = sc.nextLong() ; 

        long [] result = gcdExtended(a , b) ; 

        System.out.println(result[1] + " " + result[2]) ; 
    }
}
