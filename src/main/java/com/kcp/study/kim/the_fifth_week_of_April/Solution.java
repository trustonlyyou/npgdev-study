package com.kcp.study.kim.the_fifth_week_of_April;

// import java.util.Arrays;

// array = 데이터 1차원 배열
// commands = 규칙 2차원 배열

// 규칙 설명
// 1. 각 배열의 첫번째 인자 ~ 두번째 인자만큼 데이터를 자름
// 2. 각 배열을 정렬
// 3. 각 배열의 세번째 인자의 수에 해당하는 데이터를 추출하여 1차원 배열에 저장
public class Solution {

    public int[] solution(int[] array, int[][] commands) {
        array = new int[]{1, 5, 2, 6, 3, 7, 4};
        commands = new int[][]{{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};

        int[] answer = new int[commands.length]; //

        for(int i = 0; i < commands.length; i++) {
            int from = commands[i][0]; // 시작위치
            int to   = commands[i][1]; // 끝위치
            int k    = commands[i][2]; // 가져올 위치

            // 필요한 데이터 개수만큼만 새로운 배열에 할당
            int size = to - from + 1;
            int[] slice = new int[size];
            for(int p = 0; p < size; p++) {
                slice[p] = array[from -1 + p];
            }

            for(int a = 0; a < size -1; a++) {
                int min = a;
                for(int b = a+1; b < size; b++) {
                    if(slice[b] < slice[min]) {
                        min = b;
                    }
                }
                int tmp = slice[a];
                slice[a] = slice[min];
                slice[min] = tmp;
            }

            answer[i] = slice[k -1];

//            int[] slice = Arrays.copyOfRange(array, from, to);
//            Arrays.sort(slice);
//            answer[i] = slice[k];
        }

        return answer; // 기대값 [5, 6, 3]
    }
}
