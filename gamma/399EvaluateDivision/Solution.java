class Solution {

    Map<String, List<String>> edges = new HashMap<>();
    Map<String, List<Double>> weights = new HashMap<>();

    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        double[] results = new double[queries.length];
        for (int i = 0; i < equations.length; i++) {
            if (!edges.containsKey(equations[i][0])) {
                edges.put(equations[i][0], new ArrayList<>());
                weights.put(equations[i][0], new ArrayList<>());
            }
            edges.get(equations[i][0]).add(equations[i][1]);
            weights.get(equations[i][0]).add(values[i]);
            if (!edges.containsKey(equations[i][1])) {
                edges.put(equations[i][1], new ArrayList<String>());
                weights.put(equations[i][1], new ArrayList<Double>());
                
            }
            if (values[i] != 0.0) {
                edges.get(equations[i][1]).add(equations[i][0]);
                weights.get(equations[i][1]).add(1 / values[i]);
            }
            System.out.println("x " + equations[i][0] + " y " + equations[i][1] + " value " + values[i] + " 1/value " + (1/values[i]));
        }
        for (int i = 0; i < queries.length; i++) {
            Set<String> visited = new HashSet<>();
            double result = helper(queries[i][0], queries[i][1], visited, 1.0);
            results[i] = result == 0.0 ? -1.0 : result;
        }
        return results;
    }

    private double helper(String x, String y, Set<String> visited, double currentValue) {
        if (visited.contains(x) || !edges.containsKey(x)) {
            return 0.0;
        }
        if (x.equals(y)) {
            return currentValue;
        }
        visited.add(x);
        List<String> pairList = edges.get(x);
        List<Double> valueList = weights.get(x);
        double tmp = 0.0;
        for (int i = 0; i < pairList.size(); i++) {
            tmp = helper(pairList.get(i), y, visited, currentValue * valueList.get(i));
            if (tmp != 0.0) {
                break;
            }
        }
        visited.remove(x);
        return tmp;
    }
}