package DoIt01_10;

// 투 포인터
// 2개의 포인터로 알고리즘
import java.io.*;
import java.util.*;
import java.lang.*;

public class D006_P2018 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력1: 정수 N
        int N = Integer.parseInt(br.readLine());

        // 연산
        int count = 0;
        // 투 포인터
        int start = 1;  // 시작 숫자
        int end = 1;    // 끝 숫자
        int sum = 1;    // start부터 end까지의 합

        // start와 end 모두 N일 때
        count++;
        // N이 아닐 때
        while (end != N) {
            if (sum == N) {         // 현재 연속 합이 N
                count++;

                // end 증가
                end++;
                sum += end;
            } else if (sum > N) {   // 현재 연속 합이 N보다 큼
                // start 증가
                sum -= start;
                start++;
            } else {                // 현재 연속 합이 N보다 작음
                end++;
                sum += end;
            }
        }

        // 출력
        System.out.println(count);
    }
}
