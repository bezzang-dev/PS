func solution(todo_list []string, finished []bool) []string {
    
    answer := []string{}
    for i := 0; i < len(todo_list); i++ {
        if !finished[i] {
            answer = append(answer, todo_list[i])
        }
    }
    
    return answer
}