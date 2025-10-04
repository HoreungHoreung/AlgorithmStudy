import java.util.*;
class Solution {
    class Car{
        String num;
        int fee;
        public Car(String num, int fee) {
            this.num = num;
            this.fee = fee;
        }
    }
    
    public int[] solution(int[] fees, String[] records) {
        int[] answer = {};
        final int lastTime = 23 * 60 + 59;
        Map<String, Integer> fee = new HashMap<>();
        Map<String, String> lot = new HashMap<>();
        
        //기록에 있는 값들 저장
        for(String r : records) {
            String[] carRecord = r.split(" ");
            String time = carRecord[0];
            String carNum = (carRecord[1]);
            String command = carRecord[2];
            if(command.equals("IN")) {
                lot.put(carNum, time);
            } else {
                String[] inTime = lot.get(carNum).split(":");
                String[] outTime = time.split(":");
                int outHour = Integer.valueOf(outTime[0]), outMin = Integer.valueOf(outTime[1]), inHour = Integer.valueOf(inTime[0]), inMin = Integer.valueOf(inTime[1]);
                int timeFee = (outHour * 60 + outMin) - (inHour * 60 + inMin);
                
                fee.put(carNum, fee.getOrDefault(carNum, 0) + timeFee);
                lot.remove(carNum);
            }
        }
        
        for(String carNum : lot.keySet()) {
            String[] inTime = lot.get(carNum).split(":");
            int inHour = Integer.valueOf(inTime[0]), inMin = Integer.valueOf(inTime[1]);
            int timeFee = (lastTime - (inHour * 60 + inMin));
            
            fee.put(carNum, fee.getOrDefault(carNum, 0) + timeFee);
        }
        
        // //출력
        // for(String carNum : fee.keySet()) {
        //     System.out.println(carNum + " " + fee.get(carNum));
        // }
        
        int baseTime = fees[0], baseFee = fees[1], timeUnit = fees[2], feeUnit = fees[3];
        
        List<Car> cars = new ArrayList<>();
        
        for(String carNum : fee.keySet()) {
            int carFee = fee.get(carNum);
            int totalFee = 0;
            if(carFee <= baseTime) totalFee = baseFee;
            else{
                totalFee += baseFee;
                carFee -= baseTime;
                
                int hour = carFee / timeUnit, min = carFee % timeUnit;
                
                int newUnit = 0;
                if(min != 0) newUnit = hour + 1;
                else newUnit = hour;
                
                totalFee += newUnit * feeUnit;
            }
            cars.add(new Car(carNum, totalFee));
        }
        
        Collections.sort(cars, new Comparator<Car>(){
            @Override
            public int compare(Car c1, Car c2) {
                return c1.num.compareTo(c2.num);
            }
        });
        
        // for(Car c : cars) {
        //     System.out.println(c.num + " : " +  c.fee);
        // }
        
        answer = new int[cars.size()];
        for(int i = 0; i < cars.size(); i++) {
            answer[i] = cars.get(i).fee;
        }
        return answer;
    }
}