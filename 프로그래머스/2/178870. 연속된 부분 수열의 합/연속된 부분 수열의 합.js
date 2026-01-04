function solution(sequence, k) {
    let left = 0
    let sum = 0
    let answer = [0, sequence.length - 1]

    for (let right = 0; right < sequence.length; right++) {
        sum += sequence[right]

        while (sum >= k) {
            if (sum === k) {
                if (right - left < answer[1] - answer[0]) {
                    answer = [left, right]
                }
            }
            sum -= sequence[left]
            left++
        }
    }

    return answer
}
