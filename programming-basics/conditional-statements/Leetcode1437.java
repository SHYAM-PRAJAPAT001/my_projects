public class Leetcode1437 {
    
    public boolean kLengthApart(int[] nums, int k) {

        int size = nums.length ; 
        int lastSeen = -(k + 1) ; 

        for(int pos = 0 ; pos < size ; pos++) {

            if(nums[pos] == 1) {
                if(pos - lastSeen <= k) return false ; 
                lastSeen = pos ; 
            }
        }

        return true ; 

    }

    public static void main(String[] args) {
        Leetcode1437 obj = new Leetcode1437();
        int[] nums = {1, 0, 0, 0, 1, 0, 0, 1};
        int k = 2;
        System.out.println(obj.kLengthApart(nums, k)); // Output: true
    }
}