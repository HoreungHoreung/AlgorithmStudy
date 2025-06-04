import java.util.*;
class Solution {
    private static int[] parent;
    public int solution(int n, int[][] costs) {
        int answer = 0;
        
        //각 가중치 오름차순 정렬
        Arrays.sort(costs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2] - o2[2];
            }
        });
        
        //log 확인
        for(int i = 0; i < costs.length; i++){
            System.out.println(costs[i][2]);
        }
        
        parent = new int[n]; //최종적으로 연결된 최소 신장 트리 연결 비용
        
        //부모집합 생성
        for(int i = 0; i < n; i++) {
            parent[i] = i;
        }
        
        for(int i = 0; i < costs.length; i++) {
            int from = costs[i][0];
            int to = costs[i][1];
            int cost = costs[i][2];
            if(find(from) != find(to)){
                union(from, to);
                answer += cost;
            }
            continue;
        } 
        
        return answer;
    }
    private static void union(int a, int b) {
        a = find(a);
        b = find(b);
        
        if(a > b) {
            parent[a] = b;
        } else {
            parent[b] = a;
        }
    }
    
    private static int find(int x) {
        if(parent[x] == x) return x;
        else return find(parent[x]);
    }
}