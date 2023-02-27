### DFS(깊이 우선 탐색, Depth First Search)

:heavy_check_mark: 개념

- **루트 노드(혹은 다른 임의의 노드)에서 다음 분기(branch)로 넘어가기 전에, 해당 분기를 모두 탐색하는 방법**
  - 한 분기에서 다음 분기로 넘어가기 전에 해당 분기를 완벽하게 탐색
- 탐색 후에는 다시 원점으로 돌아가 다른 분기를 탐색

<br>

:heavy_check_mark: 동작 방식

- `스택` 자료구조 이용

1. 탐색 시작 노드를 스택에 삽입하고, 방문 처리
2. 스택의 최상단 노드에 방문하지 않은 인접 노드가 있으면 그 인접 노드를 스택에 넣고 방문 처리하고, 방문하지 않은 인접 노드가 없으면 스택에서 최상단 노드를 꺼낸다
3. 위의 1번과 2번 과정을 더 이상 수행할 수 없을 때까지 반복

<br>

:heavy_check_mark: 특징

- **자기 자신을 호출**하는 순환 알고리즘의 형태 (`재귀` or `스택`)
- 이 알고리즘을 구현할 때 가장 큰 차이점은 그래프 탐색의 경우 **어떤 노드를 방문했었는지 여부를 반드시 검사**
  - 이를 검사하지 않을 경우 무한루프에 빠질 수 있다
  - ex) visited[index] = true;
- 미로를 탐색할 때, 해당 분기에서 갈 수 있을 때까지 계속 가다 더 이상 갈 수 없게 되면 다시 가장 가까운 갈림길로(새로운 분기)로 돌아와서 다른 방향으로 다시 탐색을 진행하는 방법과 유사
- **모든 노드를 방문하고자 할 때**, 이 방법 선택
- BFS보다 더 간단
- 검색 속도 자체는 BFS에 비해 느림

<br>

:heavy_check_mark: 코드

- 재귀 함수를 통한 DFS 구현

````java
public class DFS_Recursion {
    public static boolean[] visited = new boolean[10];
    public static int[][] graph = {
        {},
        {2, 3, 8},
        {1, 7},
        {1, 4, 5},
        {3, 5},
        {3, 4},
        {7},
        {2, 6, 8},
        {1, 7}
    };
    
    public static void main(String[] args) {
        int start = 1;  //시작 노드
        dfs(start);
    }
    
    public static void dfs(int v) {
        visited[v] = true;
        System.out.print(v + " "); //방문 노드 출력
        
        //인접 노드 탐색
        for(int i : graph[v]) {
            if(visited[i] == false) {
                dfs(i);
            }
        }
    }
}
````

- Stack 클래스를 통한 DFS 구현

````java
public class DFS_Stack {
    public static boolean[] visited = new boolean[10];
    public static int[][] graph = {
        {},
        {2, 3, 8},
        {1, 7},
        {1, 4, 5},
        {3, 5},
        {3, 4},
        {7},
        {2, 6, 8},
        {1, 7}
    };
    
    public static void main(String[] args) {
        DFS_Stack dfsExam = new DFS_Stack();
        dfsExam.dfs(graph, 1, visited);
    } 
    
    void dfs(int[][] graph, int start, boolean[] visited) {
        visited[start] = true; // 시작 노드 방문 처리
        System.out.println(start + " ");
        
        Deque<Integer> stack = new LinkedList<>();
        stack.push(start);
        
        while(!stack.isEmpty()) {
            int now = stack.peek();
            
            boolean hasNearNode = false; //방문하지 않은 인접 노드가 있는지 확인
            for(int i : graph[now]) {
                if(!visited[i]) {
                    hasNearNode = true;
                    stack.push(i);
                    visited[i] = true;
                    System.out.println(i + " ");
                    break;
                }
            }
            
            //방문하지 앟은 인접 노드가 없는 경우 해당 노드 꺼내기
            if(hasNearNode = false) 
                stack.pop();
        }
    }
}
````





<br>



### BFS(너비 우선 탐색, Bread First Search)

:heavy_check_mark: 개념

- **루트 노드(혹은 다른 임의의 노드)에서 시작한 인접 노드를 먼저 탐색하는 방법**
  - 루트 노드에서 탐색을 시작하여 같은 레벨에 있는 노드를 모두 탐색한 다음 하위 레벨로 내려가 또 모두 탐색을 진행하다 더 이상 탐색할 노드가 없을 때 탐색을 멈추는 방식
- `큐`를 이용하여 구현

<br>

:heavy_check_mark: 특징

- BFS는 재귀적으로 동작하지 않는다
- 그래프 탐색의 경우 어떤 노드를 방문했었는지 여부를 반드시 검사해야 한다(이를 검사하지 않을 경우 무한루프에 빠질 수 있다)
- 방문한 노드들을 차례로 저장한 후 꺼낼 수 있는 자료 구조인 `큐`를 사용
  - 선입선출 원칙으로 탐색
- 시작 정점으로부터 가까운 정점을 먼저 방문하고 멀리 떨어져 있는 정점을 나중에 방문하는 순회 방법
  - 넓게(wide) 탐색하는 것
- **두 노드 사이의 최단 경로 혹은 임의의 경로를 찾고 싶을 때** 이 방법 사용
  - ex) 지구 상에 존재하는 모든 친구 관계를 그래프로 표현한 후 A와 B 사이
    - DFS의 경우 -> 모든 친구 관계를 다 살펴봐야 할지도 모른다
    - BFS의 경우 -> A와 가까운 관계부터 탐색한다 



<br>

:heavy_check_mark: 과정

- 깊이가 1인 모든 노드를 방문하고 나서 그 다음에, 깊이가 2인 모든 노드를, 그 다음엔 깊이가 3인 모든 노드를 방문하는 식으로 계속 방문하다 더 이상 방문할 곳이 없으면 탐색을 마친다
  - 인접한 노드를 반복적으로 큐에 넣도록 알고리즘을 작성하면 자연스럽게 먼저 들어온 것이 먼저 나가며, 가까운 노드부터 탐색하게 된다

1. 탐색 시작 노드를 큐에 삽입하고 방문 처리
2. 큐에서 노드를 꺼내 해당 노드의 인접 노드 중 방문하지 않은 노드를 모두 큐에 삽입하고 방문 처리
3. 위의 1번과 2번 과정을 더 이상 수행할 수 없을때까지 반복

<br>

:heavy_check_mark: 코드

````java
public class BFS {
    public static void main(String[] args) {
        int [][]graph = {{},
            {2, 3, 8},
            {1, 7},
            {1, 4, 5},
            {3, 5},
            {3, 4},
            {7},
            {2, 6, 8},
            {1, 7}};
        boolean[] visited = new boolean[10];
        
        int start = 1; // 시작 노드
        
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
       	visited[start] = true;
        
        while(!queue.isEmpty()) {
            int v = queue.poll();
            System.out.println(v + " ");
            
            for(int i : graph[v]) {
                if(!visited[i]) {
                	queue.add(i);
                    visited[i] = true;
                }
            }
        }
    }
}
````



<br>

### DFS, BFS를 활용하면 좋은 상황

1. 그래프의 모든 정점을 방문하는 것이 주요한 문제

   :arrow_forward: DFS, BFS 모두 무방

2. **경로의 특징을 저장해둬야 하는 문제**

   - 각 정점에 숫자가 있고 a부터 b까지 가는 경로를 구하는데 경로에 같은 숫자가 있으면 안된다는 문제 등, 각각의 경로마다 특징을 저장해둬야 하는 경우 **`DFS`** 사용
   -  BFS는 경로의 특징을 저장하지 못한다

3. **최단 거리를 구하는 문제**

   - **`BFS`**가 유리
   - DFS의 경우 처음으로 발견되는 해답이 최단 거리가 아닐 수 있지만 BFS의 경우 먼저 찾아지는 해답이 곧 최단거리이기 때문
