public class Leetcode136 {
    public int singleNumber(int[] nums) {
        int ans = 0 ; 
        for(int i = 0 ; i < nums.length ; i++){
            ans ^= nums[i] ; 
        }
        return ans ; 
    }

    public static void main(String[] args) {
        Leetcode136 obj = new Leetcode136() ; 
        int[] nums = {4,1,2,1,2} ; 
        System.out.println(obj.singleNumber(nums));
    }
}
