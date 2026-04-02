import java.util.Scanner;

public class BionomialCofficient {

    static final int mod = 1000000007;
    static final int max = 1000000;
    static long[] fact = new long[max + 1];
    static long[] invFact = new long[max + 1];

    static long power(long a, long b) {
        long res = 1;
        while (b > 0) {
            if ((b & 1) == 1) res = (res * a) % mod;
            a = (a * a) % mod;
            b >>= 1;
        }
        return res;
    }

    static void precompute() {

        fact[0] = 1L ;
        for (int i = 1; i <= max; i++) {
            fact[i] = (fact[i - 1] * i) % mod;
        }

        invFact[max] = power(fact[max], mod - 2);

        for (int i = max - 1; i >= 0; i--) {
            invFact[i] = (invFact[i + 1] * (i + 1)) % mod;
        }

    }

    static long nCr(int n, int r) {
        if (r > n) return 0;
        return (fact[n] * invFact[r] % mod * invFact[n - r] % mod) % mod;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in) ; 

        int n = sc.nextInt() ; 
        int r = sc.nextInt() ; 

        precompute();

        System.out.println(nCr(n , r)) ; 

    }
}
