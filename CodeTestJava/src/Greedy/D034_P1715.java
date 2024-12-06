package Greedy;

/**
 * 카드 정렬하기
 * 그리디 알고리즘
 */

import java.io.*;
import java.util.*;
import java.lang.*;

public class D034_P1715 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력1: 카드 묶음의 개수 N
        int N = Integer.parseInt(br.readLine());

        // 입력2: 각 묶음의 카드 개수, 0~N-1, 우선순위 큐
        PriorityQueue<Integer> pqCard = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            pqCard.add(Integer.parseInt(br.readLine()));
        }

        /**
         * 비교 = (A+B) + (A+B+C) + ...
         * 카드 개수가 적은 묶음부터 비교 및 병합
         */
        int result = 0; // 총 비교 횟수
        int comp = 0;   // 뽑힌 두 수의 비교 횟수
        // 우선순위 큐에서 두 수를 뽑아 더하고, 더한 값을 우선순위 큐에 추가
        while (pqCard.size() != 1) {
            // 이번 비교 횟수
            int card1 = pqCard.remove();
            int card2 = pqCard.remove();
            comp = card1 + card2;

            // 더한 값을 우선순위 큐에 삽입
            pqCard.add(comp);

            // 총 비교 횟수
            result += comp;
        }

        // 출력
        System.out.println(result);
        br.close();
    }
}

/*      // 시간 초과, 배열이 아닌 우선순위 큐로 풀어야함
        // 입력2: 각 묶음의 카드 개수, 0~N-1
        int[] Card = new int[N];
        for (int i = 0; i < N; i++) {
            Card[i] = Integer.parseInt(br.readLine());
        }

        // 카드 정렬
        Arrays.sort(Card);

        // 비교 횟수 구하기
        int sum = Card[0] + Card[1];    // 카드 묶음 2개 비교횟수
        int comp = sum;                 // 총 비교횟수
        for (int i = 2; i < N; i++) {
            sum += Card[i];
            comp += sum;
        }
*/