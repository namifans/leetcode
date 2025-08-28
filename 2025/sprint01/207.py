class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        course_map = defaultdict(list)
        degrees = [0] * numCourses
        for course, preq in prerequisites:
            course_map[preq].append(course)
            degrees[course] += 1
        queue = deque([c for c in range(numCourses) if degrees[c] == 0])
        course_completed = 0
        while queue:
            course = queue.popleft()
            course_completed += 1
            for depend_course in course_map[course]:
                degrees[depend_course] -= 1
                if degrees[depend_course] == 0:
                    queue.append(depend_course)
        return course_completed == numCourses