
public class 방금그곡 {

    public static void main(String[] args) {
        String m = "ABCDEFG";
        String[] musicinfos = {"12:00,12:14,HELLO,CDEFGAB", "13:00,13:05,WORLD,ABCDEF"};
        System.out.println(solution(m, musicinfos));
    }

    public static String solution(String m, String[] musicinfos) {
        String answer = "(None)";
        int maxtime = 0;
        for (int i = 0; i < m.length(); i++) {
            m = replace(m);
        }

        for (String musicinfo : musicinfos) {
            String[] tmp = musicinfo.split(",");

            tmp[3] = replace(tmp[3]);

            String[] starttime = tmp[0].split(":");
            String[] endtime = tmp[1].split(":");

            int hour = Integer.parseInt(endtime[0]) - Integer.parseInt(starttime[0]);
            int min = Integer.parseInt(endtime[1]) - Integer.parseInt(starttime[1]) + (hour * 60);

            String melody = "";
            for (int j = 0; j < min; j++) {
                melody += tmp[3].charAt(j % tmp[3].length());
            }
            if (melody.contains(m)) {
                if (maxtime < melody.length()) {
                    maxtime = melody.length();
                    answer = tmp[2];
                }
            }
        }
        return answer;
    }

    private static String replace(String str) {
        str = str.replace("A#", "a");
        str = str.replace("C#", "c");
        str = str.replace("D#", "d");
        str = str.replace("F#", "f");
        str = str.replace("G#", "g");
        str = str.replace("E#", "e");
        return str;
    }

}
