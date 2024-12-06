package Greedy;

/**
 * 동전 개수의 최솟값 구하기
 * 그리디 알고리즘
 */

import java.io.*;
import java.util.*;
import java.lang.*;

public class D033_P11047 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력1: 동전 종류의 수 N, 목표 금액 K
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        // 입력2: 동전의 금액이 N줄, 오름차순
        int[] Coin = new int[N+1];
        for (int i = 1; i < N+1; i++) {
            Coin[i] = Integer.parseInt(br.readLine());
        }

        // 동전의 금액이 높은 순으로
        int useCoin = 0;
        for (int i = N; i > 0; i--) {
            useCoin += K / Coin[i];
            K = K % Coin[i];
            if (K == 0)
                break;
        }

        // 출력
        System.out.println(useCoin);
        br.close();
    }
}