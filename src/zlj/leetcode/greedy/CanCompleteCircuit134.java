package zlj.leetcode.greedy;

import org.junit.Test;

import java.lang.management.GarbageCollectorMXBean;
import java.util.stream.Collectors;

/**
 * @author zlj
 * @create 2022-06-28-18:19
 */
public class CanCompleteCircuit134 {
    @Test
    public void test(){
        int[] gas = {2,3,4};
        int[] cost = {3,4,3};
        System.out.println(canCompleteCircuit(gas, cost));
    }
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int len = gas.length;
        //始发站
        int start = 0;
        while (start < len){
            int sumGas = gas[start];
            int sumCost = cost[start];
            //已经完成ready段路程
            int ready = 0;
            while (ready < len && sumGas >= sumCost){
                ready++;
                int index = (start + ready) % len;
                sumGas = sumGas + gas[index];
                sumCost = sumCost + cost[index];
            }
            if (ready == len){
                return start;
            }
            start++;
        }
        return -1;
    }

    /**
     * 折线图
     * @param gas
     * @param cost
     * @return
     */
    public int canCompleteCircuit1(int[] gas, int[] cost) {
        int curSum = 0;
        int start = 0;
        int sum = 0;
        for (int i = 0; i < gas.length; i++){
            curSum += gas[i] - cost[i];
            sum += gas[i] - cost[i];
            if (curSum < 0){
                start = i + 1;
                curSum = 0;
            }
        }
        if (sum < 0){
            return -1;
        }
        return start;
    }

}
