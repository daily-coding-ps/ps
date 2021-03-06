# 5월 3주차

## **[N과 M (2)](https://www.acmicpc.net/problem/15650)**

### 내용

## 문제

자연수 N과 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.

- 1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열
- 고른 수열은 오름차순이어야 한다.

## 입력

첫째 줄에 자연수 N과 M이 주어진다. (1 ≤ M ≤ N ≤ 8)

## 출력

한 줄에 하나씩 문제의 조건을 만족하는 수열을 출력한다. 중복되는 수열을 여러 번 출력하면 안되며, 각 수열은 공백으로 구분해서 출력해야 한다.

수열은 사전 순으로 증가하는 순서로 출력해야 한다.

### 풀이

1. 백 트래킹 문제 → DFS로 풀 수 있다
2. 수열은 중복이 없어야 하며 **오름차순**이어야 한다
   1. 재귀를 호출할 때마다 배열의 N - 1을 조회? → 그려지지 않음
   2. 수열의 수는 1씩 증가 → **재귀 호출 시 1씩 증가시켜서 호출**
3. ㅇㅇㅇ

   ```java
    public static void dfs(int at, int count) {
       if (count == M) {
           for (int num : arr) {
               sb.append(num).append(" ");
           }
           sb.append("\n");
           return;
       }

       for (int i = at; i <= N; i++) {
           arr[count] = i;
           dfs(i + 1, count + 1);
       }
   }
   ```

   1. 탈출 조건은 이전 문제와 그대로
   2. at이라는 변수는 시작지점을 가리키며 1씩 증가해서 호출하기 때문에 앞자리 수보다 무조건 높은 숫자가 출력될 수 밖에 없음

## [팰린드롬 만들기](https://www.acmicpc.net/problem/1213)

### 내용

## 문제

임한수와 임문빈은 서로 사랑하는 사이이다.

임한수는 세상에서 팰린드롬인 문자열을 너무 좋아하기 때문에, 둘의 백일을 기념해서 임문빈은 팰린드롬을 선물해주려고 한다.

임문빈은 임한수의 영어 이름으로 팰린드롬을 만들려고 하는데, 임한수의 영어 이름의 알파벳 순서를 적절히 바꿔서 팰린드롬을 만들려고 한다.

임문빈을 도와 임한수의 영어 이름을 팰린드롬으로 바꾸는 프로그램을 작성하시오.

## 입력

첫째 줄에 임한수의 영어 이름이 있다. 알파벳 대문자로만 된 최대 50글자이다.

## 출력

첫째 줄에 문제의 정답을 출력한다. 만약 불가능할 때는 "I'm Sorry Hansoo"를 출력한다. 정답이 여러 개일 경우에는 사전순으로 앞서는 것을 출력한다.

### 풀이

1. 문자열의 길이는 최대 50 → 어떤 알고리즘을 써야하는 지 잘 모르겠음 (조합은 DFS?)
   1. 문제 유형이 구현, 그리디길래 그냥 풀었음
2. 팰린드롬은 중앙을 기준으로 앞뒤가 대칭이어야 한다 → 실패 조건을 먼저 작성
   1. 입력받은 문자열이 짝수인 경우 → 모든 문자의 갯수가 2로 나누어 떨어져야 함
   2. 입력받은 문자열이 홀수인 경우 → 어느 문자 하나는 1개여야 하고(문자열 중앙) 나머지 문자는 역시 2로 나누어 떨어져야 함
   3. 팰린드롬이 가능한지 여부를 알려주는 메서드

      ```java
      public static boolean isAvailable(int length) {
          long count = Arrays.stream(arr)
                  .filter(value -> value % 2 != 0)
                  .count();

          if ((length % 2 == 0 && count >= 1) || count > 1) {
              System.out.println("I'm Sorry Hansoo");
              return false;
          }

          return true;
      }
      ```
3. 팰린드롬을 사전순으로 작성해야 함

   1. 각각의 알파벳을 index로 가리키는 배열을 생성 → A가 두개면 arr[0] = 2
   2. 문자열 가운데, 시작지점, 끝지점, 팰린드롬을 저장할 문자형 배열 선언

      ```java
      int center = Integer.MIN_VALUE;
      int start = 0;
      int end = str.length - 1;
      char[] result = new char[str.length];
      ```

   3. a에서 만든 배열을 순회하며 알파벳 갯수 확인
      1. 홀수인 경우 → center로 저장하고 배열에서 하나 감소 (짝수로 변경)
      2. 짝수인 경우 → 반복문을 한번 더 돌며 result에 start와 end index에 하나씩 추가하면서 각각 증가, 감소
   4. 만약 center 값이 변경이 되었다면 result 중간에 center 저장

   ```java
   for (int i = 0; i < arr.length; i++) {
       if ((arr[i] % 2) != 0) {
           center = i;
           arr[i] -= 1;
       }

       for (int j = 0; j < arr[i]; j += 2) {
           result[start] = (char) (i + 65);
           result[end] = (char) (i + 65);
           start += 1;
           end -= 1;
       }
   }

   if (center >= 0) {
       result[result.length / 2] = (char) (center + 65);
   }
   ```

## [1, 2, 3 만들기](https://www.acmicpc.net/problem/9095)

### 내용

## 문제

정수 4를 1, 2, 3의 합으로 나타내는 방법은 총 7가지가 있다. 합을 나타낼 때는 수를 1개 이상 사용해야 한다.

- 1+1+1+1
- 1+1+2
- 1+2+1
- 2+1+1
- 2+2
- 1+3
- 3+1

정수 n이 주어졌을 때, n을 1, 2, 3의 합으로 나타내는 방법의 수를 구하는 프로그램을 작성하시오.

## 입력

첫째 줄에 테스트 케이스의 개수 T가 주어진다. 각 테스트 케이스는 한 줄로 이루어져 있고, 정수 n이 주어진다. n은 양수이며 11보다 작다.

## 출력

각 테스트 케이스마다, n을 1, 2, 3의 합으로 나타내는 방법의 수를 출력한다.

### 풀이

1. n은 1 ~ 10까지 주어질 수 있다 → 왜 DP로 풀어야 할까?
   1. 테스트케이스가 몇 개로 주어질 지 모른다
   2. **메모이제이션을 활용하면 각 테스트케이스마다 처음부터 계산할 필요가 없다**
2. 점화식 구하기

   1. dp[1] = { 1 }
   2. dp[2] = { 1 + 1 }, { 2 }
   3. dp[3] = { 1 + 1 + 1 }, { 1 + 2 }, { 2 + 1 }, { 3 }
   4. dp[4] = { 1 + 1 + 1 + 1 }, { 1 + 1 + 2 }, { 1 + 2 + 1 }, { 2 + 1 + 1 }, { 2 + 2 }, { 1 + 3 }, { 3 + 1 }

   dp[4]를 만드는 경우는 (dp[1] + 3) + (dp[2] + 2) + (dp[3] + 1) = 7이 된다

   점화식은 **dp[N] = dp[N - 3] + dp[N - 2] + dp[N - 1]**

3. dp[1], dp[2], dp[3]은 경우의 수를 미리 dp 배열에 저장해둔다
   1. 각각 1, 2, 4를 담으며 이 값으로 N의 경우의 수를 구해야하므로
4. 바텀업 방식으로 반복문을 사용하여 값을 초기화해두고 dp[N]을 출력하는 방식으로 풀었다

```java
int[] arr = new int[11];

arr[1] = 1;
arr[2] = 2;
arr[3] = 4;

for (int i = 4; i <= 10; i++) {
    arr[i] = arr[i - 1] + arr[i - 2] + arr[i - 3];
}
```

## [계단 오르기](https://www.acmicpc.net/problem/2579)

### 내용

## 문제

계단 오르기 게임은 계단 아래 시작점부터 계단 꼭대기에 위치한 도착점까지 가는 게임이다. <그림 1>과 같이 각각의 계단에는 일정한 점수가 쓰여 있는데 계단을 밟으면 그 계단에 쓰여 있는 점수를 얻게 된다.

[https://upload.acmicpc.net/7177ea45-aa8d-4724-b256-7b84832c9b97/-/preview/](https://upload.acmicpc.net/7177ea45-aa8d-4724-b256-7b84832c9b97/-/preview/)

<그림 1>

예를 들어 <그림 2>와 같이 시작점에서부터 첫 번째, 두 번째, 네 번째, 여섯 번째 계단을 밟아 도착점에 도달하면 총 점수는 10 + 20 + 25 + 20 = 75점이 된다.

[https://upload.acmicpc.net/f00b6121-1c25-492e-9bc0-d96377c586b0/-/preview/](https://upload.acmicpc.net/f00b6121-1c25-492e-9bc0-d96377c586b0/-/preview/)

<그림 2>

계단 오르는 데는 다음과 같은 규칙이 있다.

1. 계단은 한 번에 한 계단씩 또는 두 계단씩 오를 수 있다. 즉, 한 계단을 밟으면서 이어서 다음 계단이나, 다음 다음 계단으로 오를 수 있다.
2. 연속된 세 개의 계단을 모두 밟아서는 안 된다. 단, 시작점은 계단에 포함되지 않는다.
3. 마지막 도착 계단은 반드시 밟아야 한다.

따라서 첫 번째 계단을 밟고 이어 두 번째 계단이나, 세 번째 계단으로 오를 수 있다. 하지만, 첫 번째 계단을 밟고 이어 네 번째 계단으로 올라가거나, 첫 번째, 두 번째, 세 번째 계단을 연속해서 모두 밟을 수는 없다.

각 계단에 쓰여 있는 점수가 주어질 때 이 게임에서 얻을 수 있는 총 점수의 최댓값을 구하는 프로그램을 작성하시오.

## 입력

입력의 첫째 줄에 계단의 개수가 주어진다.

둘째 줄부터 한 줄에 하나씩 제일 아래에 놓인 계단부터 순서대로 각 계단에 쓰여 있는 점수가 주어진다. 계단의 개수는 300이하의 자연수이고, 계단에 쓰여 있는 점수는 10,000이하의 자연수이다.

## 출력

첫째 줄에 계단 오르기 게임에서 얻을 수 있는 총 점수의 최댓값을 출력한다.

### 풀이

1. 얻을 수 있는 최댓값을 출력해야 한다 → 그리디 매 순간 최적의 해를 구하는 방법이지만 다음 계단보다 다다음 계단의 점수가 더 높다면? → DP로 푼다
2. 연속된 계단을 3번 밟을 수 없다 → 다음 계단을 밟는 방법은 n-2 + n 또는 n-3 + n-1
   1. 점화식은 dp[N] = Math.max(dp[N - 2), dp(N - 3) + arr[N - 1]) + arr[N]
   2. dp[N - 1]을 호출하는 경우 연속된 계단을 밟을 수 없다는 조건을 만족하지 못한다
   3. 각 계단을 밟는 2가지 경우의 수 중 더 많은 점수를 dp 배열에 저장한다
   4. 첫 계단과 두번째 계단은 미리 초기화해둔다 → 첫 계단은 경우의 수 1, 두번째 계단은 경우의 수 2
