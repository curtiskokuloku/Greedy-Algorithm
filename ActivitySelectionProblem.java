// An optimization problem solved using Greedy algorithm
// If a Greedy Algorithm can solve a problem, then it generally becomes
// the best method to solve that problem as the Greedy algorithms are
// in general more efficient than other techniques like Dynamic Programming.

public class ActivitySelectionProblem {
    // Given n activities with their start and finish times,
    // Select the maximum number of activities that can be performed by
    // a single person, assuming that a person can only work on a single
    // activity at a time.

    //  Input: start[]  =  {1, 3, 0, 5, 8, 5}, finish[] =  {2, 4, 6, 7, 9, 9};
    //  Output: 0 1 3 4
    //  Explanation: A person can perform at most four activities. The
    //  maximum set of activities that can be executed
    //  is {0, 1, 3, 4} [ These are indexes in start[] and finish[]

    // The greedy choice is to always pick the next activity whose finish
    // time is the least among the remaining activities and the start time
    // is more than or equal to the finish time of the previously selected
    // activity

    public static void maxActivities(int[] s, int[] f, int n) {
        int i, j;

        System.out.println("Following activities are selected");

        // the first activity always gets selected
        i = 0;
        System.out.println(i + " ");

        // consider rest of the activities
        for (j = 1; j < n; j++) {
            // if this activity has start time greater than or equal to
            // the finish time of previously selected activity, select it
            if (s[j] >= f[i]) {
                System.out.println(j + " ");
                i= j;
            }
        }
    }
    // the algorithm has a time complexity of O(n), and a space complexity of O(1)

    public static void main(String[] args) {
        int[] start = { 1, 3, 0, 5, 8, 5 };
        int[] finish = { 2, 4, 6, 7, 9, 9 };
        int n = start.length;

        maxActivities(start, finish, n);
    }
}
