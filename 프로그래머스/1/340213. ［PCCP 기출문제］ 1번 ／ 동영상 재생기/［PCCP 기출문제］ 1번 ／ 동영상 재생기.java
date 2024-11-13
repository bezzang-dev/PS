class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        int videoLenSec = timeToSeconds(video_len);
        int currentSec = timeToSeconds(pos);
        int opStartSec = timeToSeconds(op_start);
        int opEndSec = timeToSeconds(op_end);

        // 오프닝 구간에 있다면 바로 오프닝 끝으로 이동
        if (opStartSec <= currentSec && currentSec <= opEndSec) {
            currentSec = opEndSec;
        }

        // 명령어 처리
        for (String command : commands) {
            if (command.equals("next")) {
                currentSec += 10;
                // 비디오 길이를 넘어가면 마지막 위치로 이동
                if (currentSec > videoLenSec) {
                    currentSec = videoLenSec;
                }
            } else if (command.equals("prev")) {
                currentSec -= 10;
                // 0보다 작으면 처음 위치로 이동
                if (currentSec < 0) {
                    currentSec = 0;
                }
            }

            // 오프닝 구간에 들어가면 오프닝 끝으로 이동
            if (opStartSec <= currentSec && currentSec <= opEndSec) {
                currentSec = opEndSec;
            }
        }

        return secondsToTime(currentSec);
    }

    // "mm:ss" 형식의 시간을 초 단위로 변환
    private int timeToSeconds(String time) {
        String[] parts = time.split(":");
        int minutes = Integer.parseInt(parts[0]);
        int seconds = Integer.parseInt(parts[1]);
        return minutes * 60 + seconds;
    }

    // 초 단위를 "mm:ss" 형식으로 변환
    private String secondsToTime(int totalSeconds) {
        int minutes = totalSeconds / 60;
        int seconds = totalSeconds % 60;
        return String.format("%02d:%02d", minutes, seconds);
    }
}
