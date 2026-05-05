package com.kcp.study.kim.the_first_week_of_May;

public class Solution {
    public String solution(String[] participant, String[] completion) {
        // participant  마라톤에 참여한 선수들의 이름이 담긴 배열
        // completion 완주한 선수들의 이름이 담긴 배열
        // answer 완주하지 못한 선수의 이름
//        ["mislav", "stanko", "mislav", "ana"]
//        마라톤 경기에 참여한 선수의 수는 1명 이상 100,000명 이하입니다.
//        completion의 길이는 participant의 길이보다 1 작습니다.
//        참가자의 이름은 1개 이상 20개 이하의 알파벳 소문자로 이루어져 있습니다.
//        참가자 중에는 동명이인이 있을 수 있습니다.
        participant = new String[]{"mislav", "stanko", "mislav", "ana"};
        completion = new String[]{"stanko", "ana", "mislav"};
        String answer = ""; // 미완주자

        boolean[] visited = new boolean[completion.length]; // boolean 배열 생성, 기본값 false, 동명이인을 걸러내기 위해 추가

        for (String s : participant) { // participant 수 만큼 반복
            boolean found = false;
            for (int i = 0; i < completion.length; i++) {
                if (!visited[i] && s.equals(completion[i])) {
                    visited[i] = true;
                    found = true;
                    break;
                }
            }
            if (!found) {
                answer = s;
            }

        }

        return answer;
    }
}
