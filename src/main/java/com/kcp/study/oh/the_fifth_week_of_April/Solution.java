package com.kcp.study.oh.the_fifth_week_of_April;

/*
배열 array의 i번째 숫자부터 j번째 숫자까지 자르고 정렬했을 때, k번째에 있는 수를 구하려 합니다.

예를 들어 array가 [1, 5, 2, 6, 3, 7, 4], i = 2, j = 5, k = 3이라면

array의 2번째부터 5번째까지 자르면 [5, 2, 6, 3]입니다.
1에서 나온 배열을 정렬하면 [2, 3, 5, 6]입니다.
2에서 나온 배열의 3번째 숫자는 5입니다.
배열 array, [i, j, k]를 원소로 가진 2차원 배열 commands가 매개변수로 주어질 때, commands의 모든 원소에 대해 앞서 설명한 연산을 적용했을 때 나온 결과를 배열에 담아 return 하도록 solution 함수를 작성해주세요.

제한사항
array의 길이는 1 이상 100 이하입니다.
array의 각 원소는 1 이상 100 이하입니다.
commands의 길이는 1 이상 50 이하입니다.
commands의 각 원소는 길이가 3입니다.

입출력 예
array	                commands	                        return
[1, 5, 2, 6, 3, 7, 4]	[[2, 5, 3], [4, 4, 1], [1, 7, 3]]	[5, 6, 3]
입출력 예 설명
[1, 5, 2, 6, 3, 7, 4]를 2번째부터 5번째까지 자른 후 정렬합니다. [2, 3, 5, 6]의 세 번째 숫자는 5입니다.
[1, 5, 2, 6, 3, 7, 4]를 4번째부터 4번째까지 자른 후 정렬합니다. [6]의 첫 번째 숫자는 6입니다.
[1, 5, 2, 6, 3, 7, 4]를 1번째부터 7번째까지 자릅니다. [1, 2, 3, 4, 5, 6, 7]의 세 번째 숫자는 3입니다.
 */
public class Solution {
    public int[] solution1(int[] array, int[][] commands) {
        // command 의 배열의 크기 만큼 돌아야 하기 때문에 (동적)
        int[] answer = new int[commands.length];

        // 2차원 배열은 배열의 배열이다, 우선 command의 크기 만큼 반복문이 돈다.
        for (int i = 0; i < commands.length; i++) {
            // i 는 배열을 짜를 시작점
            int splitStart = commands[i][0];
            // j 는 배열 짜를 끝점
            int splitEnd = commands[i][1];
            // 배열을 꺼낼 인덱스
            int targetIndex = commands[i][2];

            // 배열을 새롭게 만들어서, 정렬할 배열을 만들어준다.
            int[] targetArray = new int[splitEnd - splitStart + 1];
            for (int a = 0; a < targetArray.length; a++) {
                targetArray[a] = array[splitStart - 1 + a];
            }

            // 버블 정렬
            for (int a = 0; a < targetArray.length - 1; a++) {
                for (int b = 0; b < targetArray.length - 1 - a; b++) {
                    if (targetArray[b] > targetArray[b + 1]) {
                        int temp = targetArray[b];
                        targetArray[b] = targetArray[b + 1];
                        targetArray[b + 1] = temp;
                    }
                }
            }

            answer[i] = targetArray[targetIndex - 1];
        }

        return answer;
    }
}
