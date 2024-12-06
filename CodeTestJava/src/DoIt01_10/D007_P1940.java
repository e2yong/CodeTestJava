package DoIt01_10;

// 투 포인터 - 주몽의 명령
import java.io.*;
import java.util.*;
import java.lang.*;

public class D007_P1940 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력1: 재료의 개수
        int N = Integer.parseInt(br.readLine());
        // 입력2: 갑옷이 완성되는 M 값
        int M = Integer.parseInt(br.readLine());
        // 입력3: 재료의 고유 번호들
        int[] A = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N + 1; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        // 재료를 오름차순으로 정렬
        Arrays.sort(A);

        // 투 포인터: start와 end가 서로 가까워지는 형태
        int start_index = 1;    // A[start_index]
        int end_index = N;      // A[end_index]
        int sum = 0;            // 두 재료의 합
        int count = 0;          // 갑옷이 만들어지는 경우의 수

        // 연산
        while (start_index < end_index) {
            sum = A[start_index] + A[end_index];
            if (sum < M) {          // 값이 M보다 작으면, start를 증가
                start_index++;
            } else if (sum > M) {   // 값이 M보다 크면, end를 감소
                end_index--;
            } else {                // 값이 M이랑 같을 때
                count++;
                start_index++;
                end_index--;;
            }
        }

        // 출력
        System.out.println(count);
    }
}
