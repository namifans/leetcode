class Course {
    int id;
    int preqs;
    List<Course> nextCourses;
    public Course(int id) {
        this.id = id;
        nextCourses = new ArrayList<>();
    }
}

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Course[] courses = new Course[numCourses];
        for (int[] preq : prerequisites) {
            int c = preq[0], p = preq[1];
            if (courses[c] == null)
                courses[c] = new Course(c);
            if (courses[p] == null)
                courses[p] = new Course(p);
            courses[c].preqs ++;
            courses[p].nextCourses.add(courses[c]);
        }
        Queue<Course> heap = new PriorityQueue<>((Course x, Course y) -> x.preqs - y.preqs); 
        for (int i = 0; i < numCourses; i++) {
            if (courses[i] == null) {
                courses[i] = new Course(i);
            }
            if (courses[i].preqs == 0) {
                heap.offer(courses[i]);
            }
        }
        int res[] = new int[numCourses];
        int num = 0;
        while (!heap.isEmpty()) {
            Course course = heap.remove();
            res[num++] = course.id;
            for (Course nextCourse : course.nextCourses) {
                nextCourse.preqs --;
                if (nextCourse.preqs == 0) {
                    heap.offer(nextCourse);
                }
            }
        }
        if (num < numCourses) {
            return new int[0];
        }
        return res;
    }
}