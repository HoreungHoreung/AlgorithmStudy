import java.util.*;
class Solution {
    static int timeChange(String time) {
        String[] hm = time.split(":");
        int h = Integer.parseInt(hm[0]) * 60;
        int m = Integer.parseInt(hm[1]);
        return h + m;
    }
    static class Plan{
        String name;
        int time;
        int rest;
        public Plan(String name, String time, String rest) {
            this.name = name;
            this.time = timeChange(time);
            this.rest = Integer.parseInt(rest);
        }
    }
    
    public String[] solution(String[][] plans) {
        String[] answer = {};
        Arrays.sort(plans, new Comparator<String[]>(){
            @Override
            public int compare(String[] s1, String[] s2) {
                return s1[1].compareTo(s2[1]);
            }
        });
        
        Deque<Plan> paused = new ArrayDeque<>();
        List<String> done = new ArrayList<>();
        
        for(int i = 0; i < plans.length - 1; i++) {
            Plan curr = new Plan(plans[i][0], plans[i][1], plans[i][2]);
            Plan next = new Plan(plans[i + 1][0], plans[i + 1][1], plans[i + 1][2]);
            
            int currEnd = curr.time + curr.rest;
            int nextStart = next.time;
            int interval = next.time - curr.time;
            
            if(currEnd <= nextStart) { //다 끝낼 수 있다면
                done.add(curr.name);
                
                int spare = nextStart - currEnd;
                while(!paused.isEmpty() && spare > 0) {
                    Plan pausedPlan = paused.pollLast();
                    if(pausedPlan.rest <= spare) {
                        spare -= pausedPlan.rest;
                        done.add(pausedPlan.name);
                    } else {
                        pausedPlan.rest -= spare;
                        spare = 0;
                        paused.offerLast(pausedPlan);
                    }
                }
            } else { //다 끝내지 못하면 -> 남은 시간 계산하고 stack에 추가
                curr.rest -= (nextStart - curr.time);
                paused.offerLast(curr);
            }
        }
        
        done.add(plans[plans.length - 1][0]);
        
        while(!paused.isEmpty()) {
            done.add(paused.pollLast().name);
        }
        
        return done.toArray(new String[0]);
    }
}