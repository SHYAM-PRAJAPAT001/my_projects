public class Leetcode136 {
    
    public int singleNumber(int[] nums) {

        int size = nums.length ;

        for(int pos = 0 ; pos < size ; pos++) {

            int count = 0 ; 

            for(int index = 0 ; index < size ; index++) {
                
                if(nums[pos] == nums[index]) count++ ; 
            }

            if(count == 1) return nums[pos] ; 
        }

        return -1 ; 
    }

    public static void main(String[] args) {
        Leetcode136 obj = new Leetcode136();
        int[] nums = {4, 1, 2, 1, 2};
        System.out.println(obj.singleNumber(nums)); 
    }
}