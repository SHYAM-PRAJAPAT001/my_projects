public class Leetcode2784 {
    public boolean isGood(int[] nums) {
        
        int size = nums.length ; 
        int total = 0 ; 
        

        for(int val = 1 ; val < size ; val++) {

            int count = 0 ; 

            for(int pos = 0 ; pos < size ; pos++) {
                if(val == nums[pos]) count++ ; 
            }

            if((val < size - 1 && count != 1) || (val == size - 1 && count != 2)) return false ; 

            total += count ; 
            
        }

        return total == size ; 
    }

    public static void main(String[] args) {
        Leetcode2784 obj = new Leetcode2784();
        int[] nums = {1, 2, 3, 3};
        System.out.println(obj.isGood(nums)); 
    }
}