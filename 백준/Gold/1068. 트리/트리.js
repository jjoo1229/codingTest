const input = require("fs")
    .readFileSync(process.platform === "linux" ? "/dev/stdin" : "./baekjoon/input.txt")
    .toString()
    .trim()
    .split("\n")

const n = Number(input[0]);
const parent = input[1].split(" ").map(Number);
const erase = Number(input[2]);

// 자식 리스트 생성
const child = Array.from({ length: n }, () => []);
let root = -1;

for (let i = 0; i < n; i++) {
  if (parent[i] === -1) root = i;
  else child[parent[i]].push(i);
}

// 노드 제거 DFS
function remove(node) {
  // 부모의 자식 목록에서 자신 제거
  if (parent[node] !== -1) {
    child[parent[node]] = child[parent[node]].filter(v => v !== node);
  }

  // 자신의 서브트리 제거
  for (let next of child[node]) {
    remove(next);
  }
  child[node] = [];
}

// 리프 노드 개수 DFS
function countLeaves(node) {
  if (child[node].length === 0) return 1;
  let cnt = 0;
  for (let next of child[node]) {
    cnt += countLeaves(next);
  }
  return cnt;
}

if (erase === root) {
  console.log(0);
} else {
  remove(erase);
  console.log(countLeaves(root));
}