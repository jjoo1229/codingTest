const input = require("fs")
    .readFileSync(process.platform === "linux" ? "/dev/stdin" : "./baekjoon/input.txt")
    .toString()
    .trim()
    .split("\n")

const [a, k] = input[0].split(" ").map(Number)

const MAX = Math.max(a, k) * 2  // 시간 초과 방지용

const bfs = (x) => {
    let queue = new Array(MAX + 1)
    let head = 0, tail = 0
    queue[tail++] = [x, 0]
    let visited = Array(MAX + 1).fill(false)
    visited[x] = true

    while (head < tail) {
        let [x, count] = queue[head++]  // 시간 초과 방지를 위해 shift 대신 head 포인터 사용

        if (x === k) return count

        let nx1 = x + 1
        if (nx1 <= MAX && !visited[nx1]) {
            visited[nx1] = true
            queue[tail++] = [nx1, count + 1]
        }

        let nx2 = x * 2
        if (nx2 <= MAX && !visited[nx2]) {
            visited[nx2] = true
            queue[tail++] = [nx2, count + 1]
        }
    }
}

console.log(bfs(a))