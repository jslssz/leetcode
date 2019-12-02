package com.hx.ncccu.n2;

import java.util.*;

/**
 * @author jxlgcmh
 * @date 2019-12-01 14:05
 * @description
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n=input.nextInt();
        Map<Integer,Integer> map =new HashMap<>();
        for (int i = 0; i < n; i++) {
            int value =input.nextInt();
            if (map.containsKey(value)) {
                map.put(value,map.get(value)+1);
            }else {
                map.put(value,1);
            }
        }
        List<Node> list =new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            list.add(new Node(entry.getKey(),entry.getValue()));
        }
        Collections.sort(list,new Node());
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

    }
    static class Node implements Comparator<Node>{
        private  int key;
        private int value;

        public Node() {
        }

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }

        public int getKey() {
            return key;
        }

        public void setKey(int key) {
            this.key = key;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return this.key+" "+this.value;
        }

        @Override
        public int compare(Node o1, Node o2) {
            int i = o2.value -o1.value;
            if (i==0){
                return o2.key-o1.key;
            }else {
                return i;
            }
        }
    }
}
