public class Leetcode3637 {
    public boolean isTrionic(int[] nums) {
        
        int size = nums.length ; 

        for(int p = 1 ; p < size ; p++)  {
            for(int q = p + 1 ; q < size - 1 ; q++) {

                boolean flag = true ; 
                // first strictly increasing part

                for(int pos = 1 ; pos <= p ; pos++) {
                    if(nums[pos - 1] >= nums[pos]) {
                        flag = false ; 
                    }
                }

                if(!flag) continue ; 

                // second strictly decreasing part

                for(int pos = p + 1 ; pos <= q ; pos++) {
                    if(nums[pos - 1] <= nums[pos]) {
                        flag = false ; 
                    }
                }

                if(!flag) continue ; 

                // third strictly increasing part

                for(int pos = q + 1 ; pos < size ; pos++) {
                    if(nums[pos - 1] >= nums[pos]) {
                        flag = false ; 
                    }
                }

                if(!flag) continue ; 

                return true ; 
            }
        }

        return false ; 
    }

    public static void main(String[] args) {
        Leetcode3637 obj = new Leetcode3637();
        int[] nums = {1,3,5,4,2,6};
        System.out.println(obj.isTrionic(nums)); 
    }
}