public class Leetcode1848 {
    public int getMinDistance(int[] nums, int target, int start) {
        
        int min = Integer.MAX_VALUE ; 
        int size = nums.length ; 

        for(int pos = 0 ; pos < size ; pos++) {
            if(nums[pos] == target) min = Math.min(min, Math.abs(pos - start)) ; 
        }

        return min ; 
    }

    public static void main(String[] args) {
        Leetcode1848 obj = new Leetcode1848();
        int[] nums = {1, 2, 3, 4, 5};
        int target = 5;
        int start = 3;
        System.out.println(obj.getMinDistance(nums, target, start)); 
    }
}