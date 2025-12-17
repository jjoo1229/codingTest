const input = require("fs")
    .readFileSync(process.platform === "linux" ? "/dev/stdin" : "./baekjoon/input.txt")
    .toString()
    .trim()
    .split("\n")

const [n, m] = input[0].split(" ").map(Number)
let graph = []
for (let i = 1; i <= n; i++) {
    const arr = input[i].split(" ").map(Number)
    graph.push(arr)
}

let startX, startY
for (let i = 0; i < n; i++) {
    for (let j = 0; j < m; j++) {
        if (graph[i][j] === 2) {
            startX = i
            startY = j
        }
    }
}

const dx = [0, 0, 1, -1]
const dy = [1, -1, 0, 0]

let answer = Array.from({ length: n }, () => Array(m).fill(-1))
answer[startX][startY] = 0

const bfs = (x, y) => {
    let queue = [[x, y]]
    let head = 0

    while (head < queue.length) {
        let [x, y] = queue[head++]

        for (let i = 0; i < 4; i++) {
            let nx = x + dx[i]
            let ny = y + dy[i]

            if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue
            if (graph[nx][ny] !== 0 && answer[nx][ny] === -1) {
                queue.push([nx, ny])
                answer[nx][ny] = answer[x][y] + 1
            }
        }
    }
}
bfs(startX, startY)

for (let i = 0; i < n; i++) {
    for (let j = 0; j < m; j++) {
        if (graph[i][j] === 0) {
            answer[i][j] = 0
        }
    }
}
console.log(answer.map(row => row.join(" ")).join("\n"))