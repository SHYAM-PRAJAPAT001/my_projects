public class Leetcode414 {

    private long MAX = Long.MIN_VALUE ; 
    public int thirdMax(int[] nums) {
        
        long firstMax = MAX ; 
        long secondMax = MAX ; 
        long thirdMax = MAX ; 
        int size = nums.length ; 

        for(int pos = 0 ; pos < size ; pos++) {

            if(firstMax < nums[pos]) {
                thirdMax = secondMax ; 
                secondMax = firstMax ; 
                firstMax = nums[pos] ; 
            } else if(secondMax < nums[pos] && nums[pos] < firstMax) {
                thirdMax = secondMax ; 
                secondMax = nums[pos] ; 
            } else if(thirdMax < nums[pos] && nums[pos] < secondMax) {
                thirdMax = nums[pos] ; 
            }
        }

        if(thirdMax == MAX) return (int)firstMax ; 

        return (int)thirdMax ; 
    }

    public static void main(String[] args) {
        Leetcode414 obj = new Leetcode414();
        int[] nums = {3, 2, 1};
        System.out.println(obj.thirdMax(nums)); // Output: 1
    }
}