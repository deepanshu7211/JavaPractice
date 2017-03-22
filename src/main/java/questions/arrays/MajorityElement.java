/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package questions.arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * @author deepanshu.saxena
 */
public class MajorityElement {
    private static int arr[] = {1, 4, 4, 6, 10, 4};

    public static void main(String[] args) {
        int size = arr.length;
        Map<Integer, Integer> keyMap = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (!keyMap.containsKey(arr[i])) {
                keyMap.put(arr[i], 1);
            } else {
                keyMap.put(arr[i], keyMap.get(arr[i]) + 1);
            }
        }
        int maj = size / 2;

        for (Map.Entry entry : keyMap.entrySet()) {
            int val = (int) entry.getValue();
            if (val == maj)
                System.out.println(" maj element is : " + entry.getKey());
        }

        morreVotingAlgo();
    }

    public static void morreVotingAlgo()
    {
        int maj=0;int count =1;
        for(int i =0;i<arr.length;i++)
        {
            if(arr[maj] == arr[i])
            {
                count++;
            }
            else {
                count--;
            }
            if(count==0)
            {
                maj =i;
                count = 1;
            }
        }
        System.out.println(arr[maj]);
    }

}
