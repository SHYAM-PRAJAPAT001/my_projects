public class Leetcode1346 {
    public boolean checkIfExist(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j && arr[i] == 2 * arr[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Leetcode1346 obj = new Leetcode1346();
        int[] arr = {10, 2, 5, 3};
        System.out.println(obj.checkIfExist(arr)); // Output: true
    }
}