import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    private static int mean(ArrayList<Integer> nums) {
        double sum = 0;
        for (int i = 0; i < nums.size(); i++) {
            sum += nums.get(i);
        }
        return (int) Math.round(sum / nums.size());
    }

    private static int mid(ArrayList<Integer> nums) {
        return nums.get(nums.size() / 2);
    }

    private static int frequency(ArrayList<Integer> nums) {
        int[] numCnt = new int[8001];
        for (int num : nums) {
           numCnt[num + 4000]++;
        }

        int maxFreq = 0;
        for (int cnt : numCnt) {
            if (cnt > maxFreq) maxFreq = cnt;
        }

        ArrayList<Integer> maxFreqList = new ArrayList<>();
        for (int i = 0; i < numCnt.length; i++) {
            if (numCnt[i] == maxFreq) maxFreqList.add(i-4000);
        }

        if(maxFreqList.size() > 1) return maxFreqList.get(1);
        else return maxFreqList.get(0);
    }

    private static int range(ArrayList<Integer> nums){
        return nums.get(nums.size() - 1) - nums.get(0);
    }
    //-10 -9 - 8 -7 -6 -5 -4 -3 -2 -1 0 1 2 3 4 5 6 7 8 9 10
    //  0  1   2  3  4  5  6  7  8  9 10
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer> nums = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            nums.add(Integer.parseInt(br.readLine()));
        }

        Collections.sort(nums);
        br.close();
        bw.write(String.valueOf(mean(nums)) + "\n");
        bw.write(String.valueOf(mid(nums)) + "\n");
        bw.write(String.valueOf(frequency(nums)) + "\n");
        bw.write(String.valueOf(range(nums)) + "\n");
        bw.flush();
        bw.close();
    }
}
