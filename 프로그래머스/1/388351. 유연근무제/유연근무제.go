func CalculateDeadline (schedule int) int {
    hour := schedule / 100
    minute := schedule % 100
    
    minute += 10
    
    if minute >= 60 {
        hour++
        minute -= 60
    }
    
    return hour * 100 + minute
}

func solution(schedules []int, timelogs [][]int, startday int) int {
    
    // startday 5 % 7?
    // 토, 일 제외
    // 직원별 스케줄, 타임로그을 포함하는 객체가 필요한가?
    // 걍 직원별로 타임로그 모아서 스케줄 범위 내에 있는지 판별하고 
    // 토, 일 제외한 평일인지 따져서 
    // 총 인원수에 지각하면 -1 하면 될듯?
    
    n := len(schedules)
    answer := n
    
    startDayIdx := startday - 1
    
    for i := 0; i < n; i++ {
        deadline := CalculateDeadline(schedules[i])
        
        for j := 0; j < 7; j++ {
            // 0=월, 1=화, 2=수, 3=목, 4=금, 5=토, 6=일
            currentDayIdx := (startDayIdx + j) % 7
            isWeekend := currentDayIdx < 5
            if isWeekend {
                checkInTime := timelogs[i][j]
                if checkInTime > deadline {
                    answer--
                    break
                }
            }
        }
    }
    return answer
}