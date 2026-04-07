import java.util.*;

public class LucasTheorem {

    static long[] fact;
    static long[] invFact;

    static long power(long a, long b, int mod) {
        long res = 1;
        a %= mod;
        while (b > 0) {
            if ((b & 1) == 1) res = (res * a) % mod;
            a = (a * a) % mod;
            b >>= 1;
        }
        return res;
    }

    static void precompute(int p) {
        fact = new long[p];
        invFact = new long[p];

        fact[0] = 1;
        for (int i = 1; i < p; i++) {
            fact[i] = (fact[i - 1] * i) % p;
        }

        invFact[p - 1] = power(fact[p - 1], p - 2, p);

        for (int i = p - 2; i >= 0; i--) {
            invFact[i] = (invFact[i + 1] * (i + 1)) % p;
        }
    }

    static long nCrModp(int n, int r, int p) {
        if (r > n) return 0;
        return (fact[n] * invFact[r] % p * invFact[n - r] % p) % p;
    }

    static long lucas(long n, long r, int p) {
        long result = 1;

        while (n > 0 || r > 0) {
            int ni = (int)(n % p);
            int ri = (int)(r % p);

            if (ri > ni) return 0;

            result = (result * nCrModp(ni, ri, p)) % p;

            n /= p;
            r /= p;
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long n = sc.nextLong();
        long r = sc.nextLong();
        int p = sc.nextInt();

        precompute(p);

        System.out.println(lucas(n, r, p));

        sc.close();
    }
}
