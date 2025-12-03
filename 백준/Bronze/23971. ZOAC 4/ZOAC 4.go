package main

import (
	"fmt"
	"math"
)

var H, W, N, M float64

func main() {
	fmt.Scan(&H, &W, &N, &M)
	hCount := math.Ceil(H / (N + 1))
	wCount := math.Ceil(W / (M + 1))
	answer := int(hCount * wCount)
	fmt.Print(answer)
}