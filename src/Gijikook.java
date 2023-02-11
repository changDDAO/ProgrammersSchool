class Gijikook {
    public int solution(int n, int[] stations, int w) {
        //제한사항에 stations 배열은 오름차순으로 정렬돼있으므로 고려x
        //w 전파범위, []stations 기지국 위치가 담긴배열, n(전체 아파트 갯수)
        //목표는 최소 기지국 설치로 전체 아파트가 다 통신할수 있게
        int answer = 0;
        int curApt = 1; //현재 아파트 위치
        int stationIndex = 0;
        while (curApt <= n) {
            if (stationIndex<stations.length&&stations[stationIndex]-w<=curApt) {
                //현재 아파트가 설치된 기지국의 전파범위 안에 있다면
                curApt=stations[stationIndex]+w+1;
                stationIndex++;
            } else {//현재 아파트가 설치된 기지국의 전파 범위 밖에 있다면
                answer++;
                curApt+=2*w+1;
            }
        }
        //Object Type보단 primitive Type이 빠르다. 명심하자


        return answer;
    }
}