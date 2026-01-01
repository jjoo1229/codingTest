const input = require("fs")
    .readFileSync(process.platform === "linux" ? "/dev/stdin" : "./baekjoon/input.txt")
    .toString()
    .trim()
    .split("\n")

let idx = 0
const T = Number(input[idx++])
let result = []

for (let t = 0; t < T; t++) {
    const [N, M] = input[idx++].split(" ").map(Number)

    // 비행기 정보는 그냥 건너뜀
    idx += M

    // 정답은 항상 N - 1
    result.push(N - 1)
}

console.log(result.join("\n"))