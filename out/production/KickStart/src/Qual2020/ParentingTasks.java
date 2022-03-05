package Qual2020;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class ParentingTasks {
    public static void main(String[] args) {

        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        Scanner sc = new Scanner(reader);
        int nTestCases = sc.nextInt();

        for (int i = 0; i < nTestCases; i++) {
            int n = sc.nextInt();
            Set<TaskPair> taskList = new TreeSet<>();
            for(int j=0; j<n; j++){
                int start = sc.nextInt();
                int end = sc.nextInt();
                taskList.add(new TaskPair(start,end));

            }

            boolean cWorking = false;
            int cStart = 0;
            int cEnd = 0;

            boolean jWorking = false;
            int jStart = 0;
            int jEnd = 0;

            StringBuilder output = new StringBuilder("");
            boolean possible = true;

            for(TaskPair task : taskList){
                if(cWorking && cEnd <= task.start){
                    cWorking = false;
                }
                if(jWorking && jEnd <= task.start){
                    jWorking = false;
                }

                if(!cWorking){
                    cWorking = true;
                    cStart = task.start;
                    cEnd = task.end;
                    output.append('C');
                } else if(!jWorking){
                    jWorking = true;
                    jStart = task.start;
                    jEnd = task.end;
                    output.append('J');
                } else {
                    possible = false;
                }
            }

            if(possible)
                System.out.println("Case #"+ (i+1) + ": " + output );
            else
                System.out.println("Case #"+ (i+1) + ": " + "IMPOSSIBLE" );
        }
    }

    public static class TaskPair implements Comparable {
        public int start;
        public int end;

        public TaskPair(int x, int y) {
            this.start = x;
            this.end = y;
        }

        public int compareTo(Object o) {
            TaskPair p = (TaskPair) o;
            return start - p.start;
        }
    }
}


