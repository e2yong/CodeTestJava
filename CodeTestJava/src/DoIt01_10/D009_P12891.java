package DoIt01_10;

/**
 * 슬라이딩 윈도우
 * DNA 비밀번호
 */

import java.io.*;
import java.util.*;
import java.lang.*;

public class D009_P12891 {
    // 조건을 만족하는 문자의 개수
    static int partCheck = 0;
    // 조건: ACGT 개수
    static int[] check = new int[4];
    // 부분 문자열의 A C G T 개수
    static int[] count = new int[4];

    public static void main(String[] args) throws IOException {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력1: DNA 문자열의 길이 N, 부분 문자열의 길이 M
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 입력2: DNA 전체 문자열, DNA = {A, C, G, T}
        char[] all = new char[N];
        all = br.readLine().toCharArray();

        // 입력3: 조건, 부분 문자열에 포함돼야 할 A, C, G, T 최소 개수

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            check[i] = Integer.parseInt(st.nextToken());
            if (check[i] == 0)
                partCheck++;
        }

        // 연산: 만들 수 있는 비밀번호의 종류의 수
        int result = 0;

        // 초기 partCheck 구하기
        for (int i = 0; i < M; i++) {
            AddCheck(all[i]);
        }
        if (partCheck == 4)
            result++;

        // 슬라이딩 윈도우([0]~[M-1])->([1]~[M])
        for (int i = M; i < N; i++) {
            // 새로 추가되는 end
            AddCheck(all[i]);
            // 지워지는 이전 start
            RemoveCheck(all[i-M]);
            if (partCheck == 4)
                result++;
        }

        // 출력
        System.out.println(result);
    }

    // 윈도우(부분 문자열)에 추가 시 조건 확인
    private static void AddCheck(char c) {
        // count[] 증가, count[]가 check[]과 같다면 partCheck 증가
        switch (c) {
            case 'A':
                count[0]++;
                if (count[0] == check[0])
                    partCheck++;
                break;
            case 'C':
                count[1]++;
                if (count[1] == check[1])
                    partCheck++;
                break;
            case 'G':
                count[2]++;
                if (count[2] == check[2])
                    partCheck++;
                break;
            case 'T':
                count[3]++;
                if (count[3] == check[3])
                    partCheck++;
                break;
        }
    }

    // 윈도우에서 제거 시 조건 확인
    private static void RemoveCheck(char c) {
        switch (c) {
            case 'A':
                if (count[0] == check[0])
                    partCheck--;
                count[0]--;
                break;
            case 'C':
                if (count[1] == check[1])
                    partCheck--;
                count[1]--;
                break;
            case 'G':
                if (count[2] == check[2])
                    partCheck--;
                count[2]--;
                break;
            case 'T':
                if (count[3] == check[3])
                    partCheck--;
                count[3]--;
                break;
        }
    }
}
