package Backtracking.Others;

import java.util.*;

public class Leetcode332 {
    List<String> res = new ArrayList<>();
    Map<String, Map<String, Integer>> map = new HashMap<String, Map<String, Integer>>();
    // map<出发机场，map<到达机场，航班次数>>
    // 同一个出发机场可能有多个到达机场

    public List<String> findItinerary(List<List<String>> tickets) {
        //遍历List 初始化map
        for(List<String> t : tickets){

            Map<String, Integer> tmp;

            //判断是否已经有出发机场
            if(map.containsKey(t.get(0))){
                tmp = map.get(t.get(0));
                if(tmp.containsKey(t.get(1))){
                    //如果有出发机场，有到达机场
                    int times = tmp.get(t.get(1));
                    tmp.put(t.get(1),times+1);
                }else{
                    //如果有出发机场，没有到达机场
                    tmp.put(t.get(1),1);
                }
            }else{
                // 如果没有出发机场，初始化
                // TreeMap 默认排序规则：按照key的字典顺序来排序（升序）
                tmp = new TreeMap<>();
                tmp.put(t.get(1),1);
            }
            map.put(t.get(0),tmp);
        }
        res.add("JFK"); //添加初始出发机场
        backTracking(tickets.size());
        return res;
    }

    private boolean backTracking(int ticketNum){
        if(res.size()==ticketNum+1){
            return true;
        }
        //根据res的最后一个机场，在map中找这个机场出发的所有<到达机场，航班次数>
        String last = res.get(res.size()-1);
        if(map.containsKey(last)){ //防止出现null
            for( Map.Entry<String, Integer> target : map.get(last).entrySet()){
                int times = target.getValue();
                if(times>0){
                    res.add(target.getKey());
                    target.setValue(times-1);
                    if(backTracking(ticketNum)) return true;
                    res.remove(res.size()-1);
                    target.setValue(times);
                }
            }
        }
        return false;
    }
}
