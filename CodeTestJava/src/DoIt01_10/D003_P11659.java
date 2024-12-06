package DoIt01_10;

// 구간 합 구하기 1
import java.util.*;
import java.io.*;
import java.lang.*;

public class D003_P11659 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 수의 개수 N, 합을 구해야 하는 횟수 M
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // N개의 수, num[1]부터 num[5]
        long[] num = new long[N+1];
        long[] s = new long[N+1];   // 구간 합
        long sum = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N+1; i++) {
            num[i] = Long.parseLong(st.nextToken());

            //구간 합 구하기
            sum += num[i];
            s[i] = sum;
        }

        // M번의 num[i]부터 num[j]까지의 합
        for (int m = 0; m < M; m++) {
            // i, j 입력
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());

            // s[j]-s[i-1] 연산
            System.out.println(s[j]-s[i-1]);
        }
    }
}
