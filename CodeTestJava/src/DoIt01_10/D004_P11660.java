package DoIt01_10;

// 구간 합 구하기 2차원 배열
import java.io.*;
import java.util.*;
import java.lang.*;

public class D004_P11660 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 입력1: 표의 크기 N X N, 횟수 M
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 입력2: 원본 표 + 구간 합
        long[][] Num = new long[N+1][N+1];
        long[][] Sum = new long[N+1][N+1];
        for (int i = 1; i < N+1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < N+1; j++) {
                Num[i][j] = Long.parseLong(st.nextToken());

                // 구간 합
                Sum[i][j] = (Sum[i][j-1] + Sum[i-1][j] - Sum[i-1][j-1]) + Num[i][j];
            }
        }

        // 입력3: M번의 (x1,y1)부터 (x2,y2)까지의 합
        for (int i = 0; i < M; i++) {
            // 입력
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            // 출력
            // 연산: Sum[x2][y2] - Sum[x1-1][y2] - Sum[x2][y1-1] + Sum[x1-1][y1-1]
            System.out.println(Sum[x2][y2] - Sum[x1-1][y2] - Sum[x2][y1-1] + Sum[x1-1][y1-1]);
        }
    }
}
