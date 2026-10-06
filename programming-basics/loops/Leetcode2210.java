public class Leetcode2210 {
    public int countHillValley(int[] nums) {
        
        int countOfHillsAndValley = 0 ;
        int size = nums.length ;  
        int prevEle = nums[0] ; 

        for(int pos = 1 ; pos < size ; pos++) {
            if(nums[pos - 1] == nums[pos]) continue ;  
            
            boolean nonEqual = false ; 
            int val = -1 ; 

            for(int pos1 = pos + 1 ; pos1 < size ; pos1++)  {
                if(nums[pos] != nums[pos1]) {
                    nonEqual = true ; 
                    val = nums[pos1] ; 
                    break ; 
                }
            }

            if(nonEqual && 
                Math.min(prevEle, val) < nums[pos] && 
                Math.max(prevEle, val) > nums[pos]
            ) continue ; 

            if(nonEqual && Math.min(prevEle, val) < nums[pos]) countOfHillsAndValley++ ;
            if(nonEqual && Math.max(prevEle, val) > nums[pos]) countOfHillsAndValley++ ;

            prevEle = nums[pos] ; 
        }

        return countOfHillsAndValley ; 
    }

    public static void main(String[] args) {
        Leetcode2210 obj = new Leetcode2210();
        int[] nums = {2, 4, 1, 1, 6, 5};
        System.out.println(obj.countHillValley(nums)); 
    }
}