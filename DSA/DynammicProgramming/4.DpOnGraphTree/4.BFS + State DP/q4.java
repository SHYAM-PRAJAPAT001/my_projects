// LeetCode 818 - Race Car

class Solution {

    public int racecar(int target) {

        Queue<int[]> q =
                new LinkedList<>();

        Set<String> vis =
                new HashSet<>();

        q.offer(new int[]{0,1});

        vis.add("0,1");

        int steps = 0;

        while(!q.isEmpty()){

            int size = q.size();

            while(size-- > 0){

                int[] cur =
                        q.poll();

                int pos = cur[0];
                int speed = cur[1];

                if(pos == target)
                    return steps;

                int np =
                        pos + speed;

                int ns =
                        speed * 2;

                String key =
                        np + "," + ns;

                if(Math.abs(np)
                   <= 2*target
                   &&
                   vis.add(key))
                    q.offer(
                            new int[]{
                                    np,
                                    ns
                            }
                    );

                np = pos;

                ns =
                        speed > 0
                                ? -1
                                : 1;

                key =
                        np + "," + ns;

                if(vis.add(key))
                    q.offer(
                            new int[]{
                                    np,
                                    ns
                            }
                    );
            }

            steps++;
        }

        return -1;
    }
}
