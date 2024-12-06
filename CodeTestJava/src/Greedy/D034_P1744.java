package Greedy;

/**
 * 수를 묶어서 최댓값 만들기
 * 그리디 알고리즘
 */

import java.io.*;
import java.util.*;
import java.lang.*;

public class D034_P1744 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력1: 수열의 크기 N
        int N = Integer.parseInt(br.readLine());

        // 입력2: 수열의 수(양수, 1, 0, 음수 구분)
        // 양수는 큰 수부터 묶기
        PriorityQueue<Long> plusPQ = new PriorityQueue<>(Collections.reverseOrder());
        // 음수는 작은 수부터 묶기
        PriorityQueue<Long> minusPQ = new PriorityQueue<>();
        // 1과 0의 개수
        int one = 0;
        int zero = 0;
        for (int i = 0; i < N; i++) {
            long data = Integer.parseInt(br.readLine());
            if (data > 1)
                plusPQ.add(data);
            else if (data == 1)
                one++;
            else if (data == 0)
                zero++;
            else
                minusPQ.add(data);
        }

        /**
         * 길이가 N인 수열의 합
         * 두 수를 묶으면 곱연산
         */
        long result = 0; // 수열의 합

        // 양수: 큰 수부터 묶기
        while (plusPQ.size() > 1) {
            long data1 = plusPQ.remove();
            long data2 = plusPQ.remove();
            result += data1 * data2;
        }
        // 하나가 남았으면
        if (!plusPQ.isEmpty()) {
            long data = plusPQ.remove();
            result += data;
        }

        // 음수: 작은 수부터 묶기
        while (minusPQ.size() > 1) {
            long data1 = minusPQ.remove();
            long data2 = minusPQ.remove();
            result += data1 * data2;
        }
        // 하나가 남았으면
        if (!minusPQ.isEmpty()) {
            // 0이 없으면
            if (zero == 0) {
                long data = minusPQ.remove();
                result += data;
            }
        }

        // 1 더하기
        result += one;

        // 출력
        System.out.println(result);
        br.close();
    }
}
