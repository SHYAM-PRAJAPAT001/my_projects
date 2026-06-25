// LeetCode 752 - Open the Lock

class Solution {

    public int openLock(String[] deadends, String target) {

        Set<String> dead = new HashSet<>(Arrays.asList(deadends));

        if(dead.contains("0000"))
            return -1;

        Queue<String> q = new LinkedList<>();

        Set<String> vis = new HashSet<>();

        q.offer("0000");

        vis.add("0000");

        int steps = 0;

        while(!q.isEmpty()){

            int size = q.size();

            while(size-- > 0){

                String cur = q.poll();

                if(cur.equals(target))
                    return steps;

                for(int i=0;i<4;i++){

                    char[] arr = cur.toCharArray();

                    char ch = arr[i];

                    arr[i] = (char)((ch-'0'+1)%10+'0');

                    String next = new String(arr);

                    if(!dead.contains(next) &&
                       vis.add(next))
                        q.offer(next);

                    arr = cur.toCharArray();

                    arr[i] = (char)((ch-'0'+9)%10+'0');

                    next = new String(arr);

                    if(!dead.contains(next) &&
                       vis.add(next))
                        q.offer(next);
                }
            }

            steps++;
        }

        return -1;
    }
}
