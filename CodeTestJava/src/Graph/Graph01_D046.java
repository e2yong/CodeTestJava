package Graph;

/**
 * 그래프01: 특정 거리의 도시 찾기
 * 가중치 없는 그래프 -> 인접 리스트
 * BFS
 */

import java.io.*;
import java.util.*;
import java.lang.*;

public class Graph01_D046 {

    static int N, M, K, X;          // 입력 변수들
    static ArrayList<Integer>[] A;  // 그래프 -> 인접리스트
    static int vistied[];           // BFS를 위한 방문배열(방문거리를 저장)
    static List<Integer> result;    // 방문거리가 K인 도시들

    public static void main(String[] args) throws IOException {
        /** 입력 */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 필요 변수 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 노드: 도시 개수 N
        M = Integer.parseInt(st.nextToken()); // 엣지: 도로 개수 M
        K = Integer.parseInt(st.nextToken()); // 목표 최단 거리 K
        X = Integer.parseInt(st.nextToken()); // 출발 도시 번호 X

        // 인접 리스트 생성 (리스트의 배열)
        A = new ArrayList[N+1];    // 인접리스트, 1부터
        for (int i = 1; i < N+1; i++) {
            A[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken()); // 출발 도시
            int end = Integer.parseInt(st.nextToken());   // 도착 도시
            // 인접 리스트에 추가
            A[start].add(end);
        }

        /** 풀이 */
        // 방문 배열 초기화
        vistied = new int[N+1];
        for (int i = 0; i < N+1; i++) {
            vistied[i] = -1;
        }

        // BFS
        BFS(X);

        // visited 배열의 값이 K인 도시들을 오름차순으로 정렬
        result = new ArrayList<>();
        for (int i = 1; i < N+1; i++) {
            if (vistied[i] == K) {
                result.add(i);
            }
        }
        Collections.sort(result);

        /** 출력 */
        // 도시가 없으면 -1, 아니면 1줄에 하나씩 출력
        if (result.isEmpty()) {
            System.out.println(-1);
        } else {
            for (int i : result) {
                System.out.println(i);
            }
        }
    }

    /**
     * BFS 함수
     * @param Start // 출발 도시
     */
    private static void BFS(int Start) {
        // 큐에 출발 도시 추가
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(Start);
        // visited에 방문 도시 추가
        vistied[Start]++;
        // BFS
        while (!queue.isEmpty()) {
            // 현재 도시와 인접한 도시들 방문
            int now_Node = queue.poll();
            for (int next_Node : A[now_Node]) {
                // 방문하지 않았던 도시만
                if (vistied[next_Node] == -1) {
                    vistied[next_Node] = vistied[now_Node] + 1;
                    queue.add(next_Node);
                }
            }
        }
    }
}
