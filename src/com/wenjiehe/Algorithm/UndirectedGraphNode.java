package com.wenjiehe.Algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by yiyuan on 17/3/2.
 */
public class UndirectedGraphNode {
    int label;
    ArrayList<UndirectedGraphNode> neighbors;
    UndirectedGraphNode(int x) {
        label = x;
        neighbors = new ArrayList<UndirectedGraphNode>();
    }

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node ==null)
            return null;

        UndirectedGraphNode cloneNode = null;
        Map<Integer,UndirectedGraphNode> map = new HashMap<>();

        cloneNode = cloneNode(node,map);
        return  cloneNode;
    }

    public UndirectedGraphNode cloneNode(UndirectedGraphNode node,Map<Integer,UndirectedGraphNode> map){

        UndirectedGraphNode cloneNode = new UndirectedGraphNode(node.label);
        map.put(cloneNode.label,cloneNode);
        for (UndirectedGraphNode n: node.neighbors) {
            UndirectedGraphNode nClone = null;
            if(map.get(n.label)==null) {
                nClone = cloneNode(n, map);
                cloneNode.neighbors.add(nClone);
            }
            else{
                cloneNode.neighbors.add(map.get(n.label));
            }
        }
    return cloneNode;
    }
}
