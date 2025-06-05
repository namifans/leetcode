class Solution:
    def findOrder(self, numCourses: int, prerequisites: List[List[int]]) -> List[int]:
        courses = defaultdict(list)
        degrees = [0] * numCourses
        for course, pre in prerequisites:
            courses[pre].append(course)
            degrees[course] += 1
        heap = []
        for i in range(len(degrees)):
            if degrees[i] == 0:
                heappush(heap, (degrees[i], i))
        res = []
        while heap:
            degree, course = heappop(heap)
            res.append(course)
            for nxt in courses[course]:
                degrees[nxt] -= 1
                if degrees[nxt] == 0:
                    heappush(heap, (degrees[nxt], nxt))
        return res if len(res) == numCourses else []