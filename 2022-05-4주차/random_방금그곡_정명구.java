import java.util.*;

class Solution {
    public String solution(String m, String[] musicinfos) {
        ArrayList<Info> answerList = new ArrayList<>();

        String replaceInputM = replaceMelody(m);

        for (String musicinfo : musicinfos) {
            String[] splitInfo = musicinfo.split(",");

            String[] start = splitInfo[0].split(":");
            String[] end = splitInfo[1].split(":");
            int startMusic = Integer.parseInt(start[0]) * 60 + Integer.parseInt(start[1]);
            int endMusic = Integer.parseInt(end[0]) * 60 + Integer.parseInt(end[1]);

            int runningTime = endMusic - startMusic;

            String loopMelody = makeMelody(runningTime, replaceMelody(splitInfo[3]));

            if (loopMelody.contains(replaceInputM)) {
                answerList.add(new Info(splitInfo[2], runningTime));
            }
        }

        if (answerList.size() == 0) {
            return "(None)";
        }

        Collections.sort(answerList, (o1, o2) -> o2.runningTime - o1.runningTime);

        return answerList.get(0).title;
    }

    private String makeMelody(int runningTime, String melody) {
        String loopMelody = melody;

        if (runningTime > melody.length()) {
            int loop = runningTime / (melody.length() - 1);
            int overTime = runningTime % (melody.length() - 1);

            for (int i = 0; i < loop; i++) {
                loopMelody = loopMelody + melody;
            }

            if (overTime != 0) {
                loopMelody = loopMelody + melody;
            }
        }else{
            loopMelody = loopMelody.substring(0, runningTime);
        }
        return loopMelody;
    }

    private String replaceMelody(String info) {
        info = info.replaceAll("C#", "c");
        info = info.replaceAll("D#", "d");
        info = info.replaceAll("F#", "f");
        info = info.replaceAll("G#", "g");
        info = info.replaceAll("A#", "a");

        return info;
    }


    static class Info{
        String title;
        int runningTime;

        public Info(String title, int runningTime) {
            this.title = title;
            this.runningTime = runningTime;
        }
    }
}