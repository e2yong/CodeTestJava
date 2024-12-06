package DoIt01_10;

// 투 포인터: 좋은 수 구하기
// 좋은 수 = 다른 두 수의 합으로 표현되는 수
// 음수 값이 존재하며, Arrays.sort() 범위 지정에 주의
import java.io.*;
import java.util.*;
import java.lang.*;

public class D008_P1253 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력1: 수의 개수
        int N = Integer.parseInt(br.readLine());
        // 입력2: N개의 수, 음수가 있을 수 있음
        int[] A = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N + 1; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        // 오름차순 정렬
        Arrays.sort(A, 1, N+1);

        // 좋은 수의 개수
        int count = 0;

        // 투 포인터: 변하는 범위에서 마주보는 형태
        // A[start] + A[end] = A[good], 1~N
        for (int good = 1; good < N + 1; good++) {
            int find = A[good];
            int start = 1;
            int end = N;        // 음수 값이 존재

            while (start < end) {
                // start와 end가 good이면
                if (start == good) {
                    start++;
                    continue;
                } else if (end == good) {
                    end--;
                    continue;
                }

                // 투 포인터
                int sum = A[start] + A[end];
                if (sum == find) {
                    // find가 서로 다른 두 수 의 합임을 체크
                    count++;
                    break;
                } else if (sum > find) {
                    end--;
                } else {        // sum < find
                    start++;
                }
            }
        }

        // 출력
        System.out.println(count);
        br.close();
    }
}
