const input = require("fs")
    .readFileSync(process.platform === "linux" ? "/dev/stdin" : "./baekjoon/input.txt")
    .toString()
    .trim()
    .split("\n")

const [n, m] = input[0].split(" ").map(Number)
const arr = input[1].split(" ").map(Number)

const tree = Array.from({ length: n + 1 }, () => []);

for (let i = 2; i <= n; i++) {
    tree[arr[i - 1]].push(i);
}

const praise = Array(n + 1).fill(0);

// 직접 받은 칭찬 저장
for (let i = 2; i < 2 + m; i++) {
    const [x, w] = input[i].split(" ").map(Number);
    praise[x] += w;
}

// DFS로 칭찬 전파
function dfs(node) {
    for (const child of tree[node]) {
        praise[child] += praise[node];
        dfs(child);
    }
}

dfs(1);

let result = [];
for (let i = 1; i <= n; i++) result.push(praise[i]);
console.log(result.join(" "));