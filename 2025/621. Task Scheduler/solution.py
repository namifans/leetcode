class Solution:
    def leastInterval(self, tasks: List[str], n: int) -> int:
        task_count = Counter(tasks)
        heap = []
        for task, count in task_count.items():
            heappush(heap, (-count,task))
        cpu = 0
        while heap:
            process = []
            for _ in range(n + 1):
                if heap:
                    (count,task) = heappop(heap)
                    count = -count
                    process.append((count, task))
            for count,task in process:
                if count > 1:
                    count -= 1
                    heappush(heap, (-count, task))
            if heap:
                cpu += n + 1
            else:
                cpu += len(process)
        return cpu