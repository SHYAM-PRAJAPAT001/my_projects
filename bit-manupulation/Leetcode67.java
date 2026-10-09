public class Leetcode67 {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder() ;
        int carry = 0 ; 
        if(a.length() > b.length()){
            String temp  = a ; 
            a = b ; 
            b =temp ; 
        }
        int i = a.length() -1; 
        int j = b.length() - 1; 
        while(i != -1 || j != -1 || carry != 0){
            int sum = carry ; 
            if(i != -1){
                sum += a.charAt(i) - '0' ; 
                i--; 
            }
            if(j != -1){
                sum += b.charAt(j) - '0' ;
                j-- ; 
            }
            carry = sum / 2 ;
            sum = sum % 2 ; 
            sb.append(sum) ; 

        }
        return sb.reverse().toString() ; 
    }

    public static void main(String[] args) {
        Leetcode67 obj = new Leetcode67() ; 
        String a = "11" ; 
        String b = "1" ; 
        System.out.println(obj.addBinary(a, b));
    }
}
