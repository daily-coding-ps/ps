function solution(n, times) {
  times.sort((a, b) => a - b); // 오름차순 정렬
  let left = 0;
  let right = n * times[times.length - 1]; // 최대로 걸릴 시간

  while (left <= right) {
    let mid = Math.floor((left + right) / 2);
    const count = times.reduce((acc, curr) => acc + Math.floor(mid / curr), 0); // 심사 가능한 인원 구하기

    if (count >= n) {
      right = mid - 1;
    } else {
      left = mid + 1;
    }
  }
  return left;
}
