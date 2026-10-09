public class Leetcode371 {

    public int getSum(int a, int b) {
      int c; 
      while(b !=0 ) {
        c = (a&b);
        a = a ^ b;
        b = (c)<<1;
      }
      return a;
    }

    public static void main(String[] args) {
        Leetcode371 obj = new Leetcode371();
        System.out.println(obj.getSum(5, 3));
    }
}