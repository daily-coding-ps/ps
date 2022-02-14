import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        int[] countingSort = new int[N+1];

        for (int stage : stages) {
            countingSort[stage - 1]++;
        }

        ArrayList<Game> list = new ArrayList<>();

        int totalPlayer = stages.length;

        for (int i = 0; i < N; i++) {
            if (countingSort[i] == 0) {
                list.add(new Game(0, i+1));
            }else{
                double failRate = (double) countingSort[i] / totalPlayer;

                list.add(new Game(failRate, i+1));
                totalPlayer -= countingSort[i];
            }
        }

        Collections.sort(list, new Comparator<Game>() {
            @Override
            public int compare(Game o1, Game o2) {
                if (o2.failRate == o1.failRate) {
                    return o1.stage - o2.stage;
                }
                return Double.compare(o2.failRate, o1.failRate);
            }
        });

        for (int i = 0; i < N; i++) {
            answer[i] = list.get(i).stage;
        }

        return answer;
    }
}

class Game{
    double failRate;
    int stage;

    public Game(double failRate, int stage) {
        this.failRate = failRate;
        this.stage = stage;
    }
}