package Graph;

/**
 * 그래프01: 효율적으로 해킹하기
 * 한 번에 가장 많은 컴퓨터를 해킹할 수 있는 컴퓨터의 번호
 */

import java.io.*;
import java.util.*;
import java.lang.*;

public class Graph01_D047 {

    static int N, M;                // N: 컴퓨터 개수(노드), M: 신뢰 관계 개수(엣지)
    static ArrayList<Integer>[] A;  // 그래프 -> 인접 리스트
    static boolean[] visited;       // 방문(방문 여부 표시) 배열
    static int[] result;            // 각 컴퓨터의 최대 해킹 수
    static int max;                 // 최대 해킹 수

    public static void main(String[] args) throws IOException {
        /** 입력 */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // N: 컴퓨터 개수(노드), M: 신뢰 관계 개수(엣지)
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // (A 컴퓨터, B 컴퓨터) 신뢰 관계 -> 인접 리스트 생성
        A = new ArrayList[N+1]; // 1번 컴퓨터 부터...
        for (int i = 1; i < N+1; i ++) {
            A[i] = new ArrayList<>();
        }
        for (int j = 0; j < M; j++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            A[start].add(end);
        }

        /** 풀이 */
        // 컴퓨터(노드)마다 BFS를 진행
        result = new int[N+1];          // 기본값 0
        for (int i = 1; i < N+1; i++) {
            visited = new boolean[N+1]; // 기본값 false
            BFS(i);
        }

        // result에서 최댓값 찾기
        max = 0;
        for (int i = 1; i < N+1; i++) {
            max = Math.max(max, result[i]);
        }

        /** 출력 */
        // result 값이 max값과 같은 인덱스 출력
        for (int i = 1; i < N+1; i++) {
            if (result[i] == max) {
                System.out.print(i + " ");
            }
        }
    }

    /**
     * BFS
     * @param start // 시작 컴퓨터
     */
    private static void BFS(int start) {
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(start);
        visited[start] = true;
        while (!queue.isEmpty()) {
            int now = queue.poll();
            for (int next : A[now]) {
                // 방문하지 않았다면
                if (visited[next] == false) {
                    visited[next] = true;
                    result[next]++;
                    queue.add(next);
                }
            }
        }
    }
}