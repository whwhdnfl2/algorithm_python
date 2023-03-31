package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution_G4_미세먼지안녕 {
    static int R, C, T, map[][], tempMap[][];
    static int cleanerX;
    static int answer = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        R = Integer.parseInt(split[0]);
        C = Integer.parseInt(split[1]);
        T = Integer.parseInt(split[2]);
        
    
        
        map = new int[R][C];
        for(int i=0;i<R;i++) {
            split = br.readLine().split(" ");
            for(int j=0;j<C;j++) {
                int a = Integer.parseInt(split[j]);
                if(a == -1) {
                    cleanerX = i;
                }
                map[i][j] = a;
                if(a > 0) {
                    answer += a;
                }
            }
        }
        
        for(int t=0;t<T;t++) {
            spread();
            //clean();
            System.out.println();
            for(int i=0;i<R;i++) {
                System.out.println(Arrays.toString(map[i]));
            }
        }
        System.out.println(answer);
        
    }
    static int dx[] = {0, 0, -1, 1};
    static int dy[] = {-1, 1, 0, 0};
    private static void spread() {
        tempMap = new int[R][C];
        for(int i = 0; i < R; i++) {
            for(int j = 0; j < C; j++) {
                if(map[i][j] > 0) {
                    int now = map[i][j] / 5;
                    for(int d=0;d<4;d++) {
                        int X = i+dx[d];
                        int Y = j+dy[d];
                        if(X>=0 && X<R && Y>=0 && Y<C) {
                            if(map[X][Y] >= 0) {
                                tempMap[X][Y] += now;
                                map[i][j] -= now;
                            }
                        }
                    }
                    
                    
                }
            }
        }

        for(int i=0;i<R;i++) {
            for(int j=0;j<C;j++) {
                map[i][j]+=tempMap[i][j];
            }
        }
        
    }
    
    //cleanerX
    private static void clean() {
        answer -= map[cleanerX - 2][0];
        answer -= map[cleanerX + 1][0];
        //아래로
        for(int i=cleanerX - 2;i>0;i--) {
            map[i][0] = map[i-1][0];
        }
        
        //왼쪽으로
        for(int j=0;j<C-1;j++) {
            map[0][j] = map[0][j+1];
        }
        
        //위로
        for(int i=0;i<cleanerX-1;i++) {
            map[i][C-1] = map[i+1][C-1];
        }
        
        //오른쪽으로
        for(int j=C - 1;j > 1;j--) {
            map[cleanerX-1][j] = map[cleanerX-1][j-1];
        }
        
        ////
        
        //위로
        for(int i=cleanerX + 1;i<R - 1;i++) {
            map[i][0] = map[i+1][0];
        }
        //왼쪽으로
        for(int j=0;j<C-1;j++) {
            map[R - 1][j] = map[R - 1][j+1];
        }
        
        
        //아래로
        for(int i=R - 1;i>cleanerX + 1;i--) {
            map[i][C - 1] = map[i-1][C - 1];
        }
        
        
        //오른쪽으로
        for(int j=C - 1;j>1;j--) {
            map[cleanerX][j] = map[cleanerX][j - 1];
        }
        
        map[cleanerX][1] = 0;
        map[cleanerX - 1][1] = 0;
        
    }
}

