package Level1;

/**
 * 공원
 * 깔 수 있는 가장 큰 돗자리의 크기
 */

import java.io.*;
import java.util.*;
import java.lang.*;

public class Park {

    public static int[] mats;   // 정사각형 돗자리들의 한 변의 길이들
    public static String[][] park; // 현재 공원의 자리 배치도, 있으면 알파벳, 없으면 -1
    public static int answer = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // mats
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = st.countTokens();
        mats = new int[N];
        for (int i=0; i<N; i++)
            mats[i] = Integer.parseInt(st.nextToken());

        // park, 2차원 배열
        st = new StringTokenizer(br.readLine());

    }

    public static int solution(int[] mats, String[][] park) {

        // mats 오름차순으로 정렬
        Arrays.sort(mats);

        // mat 확인
        for (int mat : mats)
            if (mat_check(mat, park))
                answer = mat;

        return answer;
    }

    public static boolean mat_check(int mat, String[][] park) {

        int row = park.length;      // 행
        int col = park[0].length;   // 열
        boolean chk;

        // [n,n] ~ [n+mat-1,n+mat-1] 안에 모두 "-1"이어야 함
        for (int r=0; r<=row-mat; r++) {
            for (int c=0; c<=col-mat; c++) {
                chk = true;
                // 돗자리 크기 내부 검사
                for (int i=r; i<r+mat; i++) {
                    for (int j=c; j<c+mat; j++) {
                        if (!park[i][j].equals("-1")) {
                            chk = false;
                            break;
                        }
                    }
                    if (!chk) break;
                }
                if (chk)
                    return true;
            }
        }

        return false;
    }
}
