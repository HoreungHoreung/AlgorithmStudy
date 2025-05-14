import java.util.*;

class Solution
{
    public int solution(int []A, int []B)
    {
        int answer = 0;
        
        PriorityQueue<Integer> aHeap = new PriorityQueue<>(new Comparator<Integer>(){
           @Override
            public int compare(Integer a, Integer b) {
                return b - a;
            }
        });
        
        PriorityQueue<Integer> bHeap = new PriorityQueue<>();
        
        for(int i = 0; i < A.length; i++) {
            aHeap.offer(A[i]);
            bHeap.offer(B[i]);
        }
        
        while(!aHeap.isEmpty()) {
            answer += (int)aHeap.poll() * (int)bHeap.poll();
        }
        
        

        return answer;
    }
}