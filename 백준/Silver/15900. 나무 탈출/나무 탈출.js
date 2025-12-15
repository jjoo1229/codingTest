const input = require("fs")
    .readFileSync(process.platform === "linux" ? "/dev/stdin" : "./baekjoon/input.txt")
    .toString()
    .trim()
    .split("\n")

const n = Number(input[0])
let graph = Array.from({ length: n + 1 }, () => [])
for (let i = 1; i < n; i++) {
    const [a, b] = input[i].split(" ").map(Number)
    graph[a].push(b)
    graph[b].push(a)
}

let answer = 0

const dfs = (node, parent, depth) => {
    let stack = [[node, parent, depth]]

    while (stack.length) {
        let [node, parent, depth] = stack.pop()
        let isLeaf = true  // 리프 노드인지

        for (let next of graph[node]) {
            if (next !== parent) {
                isLeaf = false
                stack.push([next, node, depth + 1])
            }
        }

        if (isLeaf && node !== 1) {
            answer += depth
        }
    }
}
dfs(1, 0, 0)
console.log(answer % 2 == 0 ? "No" : "Yes")