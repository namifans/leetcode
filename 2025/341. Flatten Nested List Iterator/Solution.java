/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {

    Stack<NestedInteger> stack; 

    public NestedIterator(List<NestedInteger> nestedList) {
        stack = new Stack<>();
        refill(nestedList);
    }

    @Override
    public Integer next() {
        NestedInteger ni = stack.pop();
        return ni.getInteger();
    }

    @Override
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    private void refill(List<NestedInteger> nestedList) {
        for (int i = nestedList.size() - 1; i >= 0; i--) {
            NestedInteger ni = nestedList.get(i);
            if (!ni.isInteger()) {
                refill(ni.getList());
            } else
                stack.push(ni);
        }
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */