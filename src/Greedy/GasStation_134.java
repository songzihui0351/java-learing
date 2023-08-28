package Greedy;

public class GasStation_134 {
    public static void main(String[] args) {
        int[] gas = {3,1,1};
        int[] cost = {1,2,2};
        System.out.println(canCompleteCircuit(gas, cost));
    }

    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int i = 0, amount = 0, start = -1;
        boolean cycle = false;
        while (i < gas.length) {
            if (start == -1) {
                if (gas[i] >= cost[i]) {
                    start = i;
                } else {
                    i++;
                    continue;
                }
            }

            amount += gas[i] - cost[i];

            if (amount < 0) {
                if (cycle) {
                    return -1;
                }
                start = -1;
                amount = 0;
            } else if (start == (i + 1) % cost.length) {
                return start;
            }

            if (i == cost.length - 1) {
                cycle = true;
                i = 0;
            } else {
                i++;
            }
        }

        return start;
    }
}
