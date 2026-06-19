// LeetCode 1298 - Maximum Candies You Can Get from Boxes

class Solution {

    public int maxCandies(
            int[] status,
            int[] candies,
            int[][] keys,
            int[][] containedBoxes,
            int[] initialBoxes) {

        int n=status.length;

        Queue<Integer> q=
                new LinkedList<>();

        boolean[] haveBox=
                new boolean[n];

        boolean[] opened=
                new boolean[n];

        for(int box:
                initialBoxes){

            haveBox[box]=true;

            if(status[box]==1)
                q.offer(box);
        }

        int ans=0;

        while(!q.isEmpty()){

            int box=q.poll();

            if(opened[box])
                continue;

            opened[box]=true;

            ans+=candies[box];

            for(int key:
                    keys[box]){

                status[key]=1;

                if(haveBox[key])
                    q.offer(key);
            }

            for(int nxt:
                    containedBoxes[box]){

                haveBox[nxt]=true;

                if(status[nxt]==1)
                    q.offer(nxt);
            }
        }

        return ans;
    }
}
