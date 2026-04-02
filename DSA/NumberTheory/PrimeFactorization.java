import java.util.* ; 
public class PrimeFactorization {
    static List<Pair> primeFactors(int n) {

        List<Pair> factors = new ArrayList<>() ; 

        for (int i = 2; i * i <= n; i++) {
            int power = 0;
            while (n % i == 0) {
                n /= i;
                power++ ; 
            }
            if(power > 0 ) factors.add(new Pair(i , power)) ; 
        }
        if (n > 1) factors.add(new Pair(n , 1)) ; 

        return factors ; 
    }
    public static void main(String [] args){
        
        Scanner sc = new Scanner(System.in) ; 
        int n = sc.nextInt() ; 

        List<Pair> primeFactors = primeFactors(n);

        for(Pair factors : primeFactors){
            System.out.println(factors.prime + " ^ " + factors.power) ; 
        }
    }

    static class Pair{
        int prime ; 
        int power ; 

        Pair(int prime , int power ){
            this.prime = prime ; 
            this.power = power ; 
        }
    }
}
