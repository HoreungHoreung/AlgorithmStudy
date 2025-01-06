import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	// FizzBuzz 메서드 정의
	static String fizzBuzz(int num) {
		if (num % 3 == 0 && num % 5 == 0) {
			return "FizzBuzz";
		} else if (num % 3 == 0) {
			return "Fizz";
		} else if (num % 5 == 0) {
			return "Buzz";
		} else {
			return Integer.toString(num);
		}
	}

	// 문자열이 숫자인지 확인하는 헬퍼 메서드
	static boolean isNumeric(String str) {
		if (str == null || str.isEmpty()) return false;
		for(char c : str.toCharArray()) {
			if(!Character.isDigit(c)) return false;
		}
		return true;
	}

	public static void main(String[] args) throws IOException {
		// BufferedReader를 사용하여 입력을 빠르게 받습니다.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] nums = new String[3];

		// 3개의 입력을 받습니다.
		for(int i = 0; i < 3; i++) {
			nums[i] = br.readLine();
		}

		// 초기화
		boolean flag = false;
		int index = 0;

		// 숫자인 첫 번째 입력을 찾습니다.
		for(int i = 0; i < nums.length; i++) {
			if(isNumeric(nums[i])) {
				flag = true;
				index = i;
				break; // 첫 번째 숫자만 찾으면 종료
			}
		}

		// 숫자를 찾았다면 FizzBuzz 적용
		if(flag) {
			int originalNum = Integer.parseInt(nums[index]);
			String firstResult = fizzBuzz(originalNum);
			int newNum = 0;

			// 인덱스에 따라 더할 값을 결정
			if(index == 0) {
				newNum = originalNum + 3;
			}
			else if(index == 1) {
				newNum = originalNum + 2;
			}
			else {
				newNum = originalNum + 1;
			}

			String finalResult = fizzBuzz(newNum);
			System.out.println(finalResult);
		}

		br.close();
	}
}
