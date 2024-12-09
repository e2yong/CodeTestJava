package Level1;

/**
 * 지폐 접기
 */
import java.io.*;
import java.util.*;
import java.lang.*;

public class FoldMoney {

    static int[] wallet;    // 지갑 [가로, 세로]
    static int[] bill;      // 지폐 [가로, 세로]
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 지갑 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        wallet = new int[st.countTokens()];
        wallet[0] = Integer.parseInt(st.nextToken());
        wallet[1] = Integer.parseInt(st.nextToken());

        // 지폐 입력
        st = new StringTokenizer(br.readLine());
        bill = new int[st.countTokens()];
        bill[0] = Integer.parseInt(st.nextToken());
        bill[1] = Integer.parseInt(st.nextToken());

        // 지폐를 지갑에 넣기 위해 접어야 하는 최소 횟수
        answer = solution(wallet, bill);

        // 출력
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }

    /** 지폐 접기 */
    public static int solution(int[] wallet, int[] bill) {
        // 지갑 최대 최소 길이
        int wallet_max = Math.max(wallet[0], wallet[1]);
        int wallet_min = Math.min(wallet[0], wallet[1]);

        // 지폐 최대 최소 길이
        int bill_max = Math.max(bill[0], bill[1]);
        int bill_min = Math.min(bill[0], bill[1]);

        // 목표 (wallet의 최대 >= bill의 최대) && (wallet의 최소 >= bill의 최소)
        while ((wallet_max < bill_max) || (wallet_min < bill_min)) {
            // 반으로 접기
            bill[0] = bill_max/2;   // 나머지 버리기
            bill[1] = bill_min;
            answer++;

            // 다시 지폐 최대 최소 길이
            bill_max = Math.max(bill[0], bill[1]);
            bill_min = Math.min(bill[0], bill[1]);
        }

        return answer;
    }
}
