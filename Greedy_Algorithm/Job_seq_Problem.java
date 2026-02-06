package Greedy_Algorithm;

import java.util.ArrayList;
import java.util.Collections;

public class Job_seq_Problem {
    
    static class Job {
        int deadline;
        int profit;
        int id;

        public Job(int i, int p, int d){
            id = i;
            profit = p;
            deadline = d;
        }
    }
    public static void main(String[] args) {
        int jobsInfo[][] = {{4,20},{1,10},{1,40},{1,30}};
                         // [0] = deadline, [1]=profit
        ArrayList<Job> jobs = new ArrayList<>();

        for (int i = 0; i < jobsInfo.length; i++) {
            jobs.add(new Job(i, jobsInfo[i][1], jobsInfo[i][0]));
        }

        Collections.sort(jobs, (obj1, obj2) -> obj2.profit - obj1.profit );  // Descending order of profits

        ArrayList<Integer> seq = new ArrayList<>();
        int time = 0;

        for (int i = 0; i < jobs.size(); i++) {
            Job curr  = jobs.get(i);
            if (curr.deadline > time) {
                time++;
                seq.add(curr.id);
            }
        }

        System.out.println("Max jobs = " + seq.size());
        for (int i = 0; i < seq.size(); i++) {
            System.out.print(seq.get(i) + " ");
        }
    }
}
