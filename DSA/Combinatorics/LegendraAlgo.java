import java.util.* ; 
public class LegendraAlgo {
    public static void main(String [] args){
        
        Scanner sc = new Scanner(System.in) ; 

        System.out.print("Enter the value of n and k : ") ; 
        long n = sc.nextLong() ; 
        long k = sc.nextLong() ; 


        long res = 0 ; 
        
        // legendra's formula 
        while(n > 0){
            res += n / k ; 
            n /= k ; 
        }

        System.out.println("Contributation of the k in n! is : " + res) ; 
        

    }
}