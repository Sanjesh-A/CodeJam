package Qual2020;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class NewParentingTask {
    public static void main(String[] args) {

         class TaskPair implements Comparable {
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

        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        Scanner sc = new Scanner(reader);
        int nTestCases = sc.nextInt();

        for (int i = 0; i < nTestCases; i++) {
            int n = sc.nextInt();
            List<TaskPair> taskList = new ArrayList<>();
            for(int j=0; j<n; j++){
                int start = sc.nextInt();
                int end = sc.nextInt();
                taskList.add(new TaskPair(start,end));

            }

            Collections.sort(taskList);

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
                System.out.println("Case #"+ (i+1) + ": " + output.toString() );
            else
                System.out.println("Case #"+ (i+1) + ": " + "IMPOSSIBLE" );
        }
    }


}


