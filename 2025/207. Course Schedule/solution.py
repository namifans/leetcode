class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        courses = [[] for _ in range(numCourses)]
        for (preq, course) in prerequisites:
            courses[course].append(preq)

        visited = [False] * numCourses
        taken = [False] * numCourses
        def dfs(course: int) -> bool:
            if taken[course]:
                return False
            if visited[course]:
                return True
            visited[course] = True
            taken[course] = True
            for preq in courses[course]:
                if not dfs(preq):
                    return False
            taken[course] = False
            return True

        for course in range(numCourses):
            if not visited[course]:
                if not dfs(course):
                    return False
        return True