package DoIt01_10;

// 평균 구하기
import java.io.*;

public class D002_P1546 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 과목의 개수 N
        int N = Integer.parseInt(br.readLine());
        // 세준의 현재 성적 (길이가 N인 1차원 배열)
        String[] tmp = br.readLine().split(" ");

        // String -> int
        int[] scores = new int[N];
        long max = 0;
        long sum = 0;

        for (int i = 0; i < N; i++) {
            scores[i] = Integer.parseInt(tmp[i]);

            // 점수 합계
            sum += scores[i];
            // 최고 점수
            if (scores[i] > max)
                max = scores[i];
        }

        // 변환 점수의 평균 구하기
        System.out.println((sum * 100.0 / max) / N);
    }
}