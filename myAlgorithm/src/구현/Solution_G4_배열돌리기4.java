import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    
    //input
    static int N, M, K;
    static int[][] map;
    static int[][] rotation;
    
    //logic
    static boolean[] executed;
    static int minArrVal = Integer.MAX_VALUE;
    
    public static void main(String[] args) throws NumberFormatException, IOException {
        //input
        String[] nmk = in.readLine().split(" ");
        N = Integer.parseInt(nmk[0]);
        M = Integer.parseInt(nmk[1]);
        K = Integer.parseInt(nmk[2]);
        map = new int[N][M];        //입력받은 이차원 배열
        rotation = new int[K][3];    //입력받은 회전연산
        executed = new boolean[K];    //해당 회전 연산 수행했는지

        map = inputArr(N, M);
        rotation = inputArr(K, 3);
        
        //logic - 순열 구하기
        dfs(0, map); 

        //val
        System.out.println(minArrVal);
    }

    private static int[][] inputArr(int n, int m) throws IOException {
        int[][] res = new int[n][m];
        for (int i = 0; i < n; i++) {
            String[] line = in.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                res[i][j] = Integer.parseInt(line[j]);
            }
        }
        return res;
    }

    private static int[][] myClone(int[][] rotMap) { //2차원 배열 복사는 이렇게 해야 깊은복사(주소 달라짐)
        int[][] clone = new int[rotMap.length][rotMap[0].length];
        for (int i = 0; i < rotMap.length; i++) {
            clone[i] = rotMap[i].clone();
        }
        return clone;
    }
    
    private static void dfs(int cnt, int[][] rotMap) { //cnt: 수행한 회전연산 수, rotMap: 해당 연산까지 수행한 중간 결과물
        if (cnt == K) {//회전 연산 모두 수행
            //배열 값 구하기 & 최소 저장
            int val = getArrVal(rotMap);
            if (minArrVal > val) {
                minArrVal = val;
            }
            return;
        }

        //수행 안 한 연산 수행
        for (int i = 0; i < K; i++) {
            if (executed[i]) continue;

            executed[i] = true;
            dfs(cnt + 1, rotation(i, myClone(rotMap)));
            executed[i] = false;
        }
    }

    private static int[][] rotation(int rotI, int[][] rotMap) { //회전연산 idx, 회전연산할 맵
        int r, c, s;
        r = rotation[rotI][0]-1; //index 조정 - 중심점의 r좌표
        c = rotation[rotI][1]-1; //index 조정 - 중심점의 c좌표
        s = rotation[rotI][2];   //중심점으로부터 얼만큼 떨어진 거리까지 회전할지

        //반시계방향 값을 가져와야 함
        int[] dr = {1, 0, -1, 0};
        int[] dc = {0, 1, 0, -1};
        for (int curS = 1; curS <= s; curS++) { //중심점에서 점점 멀어지는 방향으로 회전
            int cr = r - curS; //현재 좌표
            int cc = c - curS;
            int di = 0;//안으로
            
            int save = rotMap[cr][cc]; //맨 처음 자리 값 저장
            while(true) {
                //다음 인덱스 계산
                int nr = cr + dr[di];
                int nc = cc + dc[di];
                
                //인덱스 초과하면 di 증가
                if (nr < r-curS || nr > r+curS || nc < c-curS || nc > c+curS) {
                    di++;
                    continue;
                }
                
                //다음 값 가져옴
                rotMap[cr][cc] = rotMap[nr][nc];
                
                //다음 계산한 곳이 처음 위치이면 저장하고 break;
                if (nr == r - curS && nc == c - curS) {
                    rotMap[cr][cc] = save;
                    break;
                }
                cr = nr;
                cc = nc;
            }
        }
        return rotMap;
    }
    
    private static int getArrVal(int[][] rotMap) {
        int min = Integer.MAX_VALUE - 1;
        for (int i = 0; i < rotMap.length; i++) {
            int sum = 0;
            for (int j = 0; j < rotMap[0].length; j++) {
                sum += rotMap[i][j];
            }
            if (min > sum) min = sum;
        }
        return min;
    }

}