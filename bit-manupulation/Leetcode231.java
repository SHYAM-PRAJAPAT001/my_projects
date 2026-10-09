public class Leetcode231 {
    public boolean isPowerOfTwo(int n) {
        return (n & ( n - 1)) == 0 ; 
    }

    public static void main(String[] args) {
        Leetcode231 obj = new Leetcode231() ; 
        int n = 16 ; 
        System.out.println(obj.isPowerOfTwo(n));
    }
}
