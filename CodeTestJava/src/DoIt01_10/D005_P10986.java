package DoIt01_10;

// 나머지 합 구하기
// 구간 합 + 나머지 연산 분배 법칙: (A + B) % N = ((A % N) + (B % N)) % N
import java.io.*;
import java.util.*;
import java.lang.*;

public class D005_P10986 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 입력1: 수의 개수 N, 나누는 값 M
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 입력2: N개의 수, 1부터 N
        long[] Num = new long[N+1]; // N개의 수
        long[] S = new long[N+1];   // 구간 합
        long[] C = new long[M];     // S[]%M의 나머지 값의 각 개수

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N + 1; i++) {
            // 원본
            Num[i] = Integer.parseInt(st.nextToken());

            // 구간 합
            S[i] = S[i-1] + Num[i];

            // 구간 합 % M
            S[i] = S[i] % M;
            // 나머지 연산 분배 법칙을 위한 C[]
            C[(int) S[i]]++;
        }

        long count = C[0];
        for (int i = 0; i < M; i++) {
            if (C[i] > 1) {
                count = count + (C[i] * (C[i]-1)) / 2;
            }
        }

        /** 연산: 시간 초과
        int count = 0;
        for (int i = 1; i < N + 1; i++) {
            for (int j = i; j < N + 1; j++) {
                if ((Sum[j]-Sum[i-1])%M == 0)
                    count++;
            }
        }
        */

        // 출력
        System.out.print(count);
    }
}
