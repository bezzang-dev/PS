func solution(want []string, number []int, discount []string) int {
    // 1. Map<제품이름, 수량> 자료구조를 만든다.
    wantMap := make(map[string]int)
    for i, w := range want {
        wantMap[w] = number[i]
    }
    
    // 2. discount 배열을 순회한다.
    
    result := 0
    days := 10
    
    for i := 0; i <= len(discount) - days; i++ {
        discountMap := make(map[string]int)
        for j := 0; j < days; j++ {
            product := discount[i+j]
            discountMap[product]++
        }
        
        if isMatch(wantMap, discountMap) {
            result++
        }
    }
    
    return result
}

func isMatch(target map[string]int, current map[string]int) bool {
    for key, val := range target {
        if current[key] != val {
            return false
        }
    }
    return true
}