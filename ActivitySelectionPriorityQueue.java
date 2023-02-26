// Using a min-heap to get the activity with the minimum finish time
// min-heap can be implemented using priority-queue

//  These are the given steps to solve the problem:
//  Create a priority queue (Min-Heap) and push the activities into it.
//  Push the top of the priority queue into the answer vector and set the variable start to the start time of the first activity and end to the finish time of the activity
//  While priority is not empty do the following:
//      Take the top of the priority queue and check
//      If the start time of this activity is greater than or equal to the finish time of the last chosen activity then push this activity into the answer vector
//      Else ignore it
//  Print the activities chosen, stored in the answer vector

import java.util.ArrayList;
import java.util.PriorityQueue;

public class ActivitySelectionPriorityQueue {
    // pair class
    public static class Pair {
        public int first;
        public int second;
        public Pair(int f, int s) {
            this.first = f;
            this.second = s;
        }
    }

    public static void SelectActivities(int[] s, int[] f) {
        // vector to store results
        ArrayList<Pair> result = new ArrayList<Pair>();

        // min priority-queue to sort activities in ascending order of finishing time
        PriorityQueue<Pair> p = new PriorityQueue<>((p1, p2) -> p1.first - p2.first);

        for (int i = 0; i < s.length; i++) {
            // pushing to queue where key is f[i]
            p.add(new Pair(f[i], s[i]));
        }

        Pair it = p.poll();
        int start = it.second;
        int end = it.first;
        result.add(new Pair(start, end));

        while (!p.isEmpty()) {
            Pair itr = p.poll();
            if (itr.second >= end) {
                start = itr.second;
                end = itr.first;
                result.add(new Pair(start, end));
            }
        }
        System.out.println("Following Activities should be selected. \n");

        for (Pair itr : result) {
            System.out.println("Activity started at " + itr.first + " and ends at " + itr.second);
        }
    }

    public static void main(String[] args) {
        int[] s = { 1, 3, 0, 5, 8, 5 };
        int[] f = { 2, 4, 6, 7, 9, 9 };
        
        SelectActivities(s, f);
    }
}
