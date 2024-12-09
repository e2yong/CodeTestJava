package Level1;

/**
 * 동영상 재생기
 */

import java.io.*;
import java.util.*;
import java.lang.*;

public class VideoPlayer {

    static String video_len, pos;   // 동영상 길이, 처음 재생위치
    static String op_start, op_end; // 오프닝 시작 시각, 오프닝 끝나는 시각
    static String[] commands;       // 사용자의 입력
    static String answer = "";           // "mm:ss"

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        video_len = st.nextToken();
        pos = st.nextToken();
        op_start = st.nextToken();
        op_end = st.nextToken();

        st = new StringTokenizer(br.readLine());
        int N = st.countTokens();
        commands = new String[N];
        for (int i=0; i<N; i++)
            commands[i] = st.nextToken();

        answer = solution(video_len, pos, op_start, op_end, commands);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(answer);
        bw.flush();
        bw.close();

    }

    public static String solution(String video_len, String pos,
                                  String op_start, String op_end,
                                  String[] commands) {
        // 초 단위로 변경
        int iLen = toSecond(video_len);
        int iPos = toSecond(pos);
        int iStart = toSecond(op_start);
        int iEnd = toSecond(op_end);

        // 시작할 때 jump 확인
        iPos = jump(iPos, iStart, iEnd);

        // 명령
        for (String command : commands) {
            if (command.equals("prev")) {
                // 10초 prev
                if (iPos < 10)
                    iPos = 0;
                else
                    iPos -= 10;
            } else {
                // 10초 next
                if (iLen < iPos + 10)
                    iPos = iLen;
                else
                    iPos += 10;
            }
            // jump 확인
            iPos = jump(iPos, iStart, iEnd);
        }

        // 다시 mm:ss로
        answer = String.format("%02d:%02d", iPos/60, iPos%60);

        return answer;
    }

    /** 초 단위로 변경 */
    public static int toSecond(String before) {

        int min = Integer.parseInt(before.substring(0,2));
        int sec = Integer.parseInt(before.substring(3));

        return min*60 + sec;
    }

    /** 오프닝 jump 기능 */
    public static int jump(int iPos, int iStart, int iEnd) {
        // iPos가 오프닝 시간 사이면 iEnd로
        if (iPos >= iStart && iPos < iEnd)
            return iEnd;
        else
            return iPos;
    }

}
