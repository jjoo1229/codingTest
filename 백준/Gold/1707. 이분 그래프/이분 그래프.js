const input = require("fs")
    .readFileSync(process.platform === "linux" ? "/dev/stdin" : "./input.txt")
    .toString()
    .trim()
    .split("\n")

let idx = 0
const k = Number(input[idx++])
let result = []

while (idx < input.length) {
    const [v, e] = input[idx++].split(" ").map(Number)
    let graph = Array.from({ length: v + 1 }, () => [])
    for (let i = 0; i < e; i++) {
        const [node1, node2] = input[idx++].trim().split(" ").map(Number)
        graph[node1].push(node2)
        graph[node2].push(node1)
    }
    
    let color = Array(v + 1).fill(0)  // 0: 방문 안 함, 1/-1은 색
    let isBipartite = true

    for (let start = 1; start <= v; start++) {
        if (color[start] !== 0) continue  // 전에 방문했으면 패스

        let queue = [start]
        color[start] = 1

        for (let q = 0; q < queue.length && isBipartite; q++) {
            const cur = queue[q]

            for (let neighbor of graph[cur]) {
                if (color[neighbor] === 0) {  // 방문한 적 없으면 색 지정
                    color[neighbor] = -color[cur]
                    queue.push(neighbor)
                } else if (color[cur] === color[neighbor]) {  // 이웃한 노드끼리 색 같으면 NO
                    isBipartite = false
                    break
                }
            }
        }
        if (!isBipartite) break
    }

    result.push(isBipartite ? "YES" : "NO")
}
console.log(result.join("\n"))