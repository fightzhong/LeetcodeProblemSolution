package com.fightzhong.question_101_to_150;

import java.util.ArrayList;
import java.util.List;

public class lc_0133_CloneGraph {
    public static void main(String[] args) {
        Node one = new Node( 1 );
        Node two = new Node( 2 );
        Node three = new Node( 3 );
        Node four = new Node( 4 );

        one.addNode( two ).addNode( four );
        two.addNode( one ).addNode( three );
        three.addNode( two ).addNode( four );
        four.addNode( one ).addNode( three );

        new lc_0133_CloneGraph().cloneGraph( one );
    }

    public Node cloneGraph(Node node) {
        return cloneGraph( node, new Node[101] );
    }

    private Node cloneGraph(Node node, Node[] used) {
        if ( used[node.val] != null ) {
            return used[node.val];
        }

        Node clone = new Node( node.val );
        used[node.val] = clone;
        List<Node> nodeList = node.neighbors;
        for ( Node item: nodeList ) {
            clone.neighbors.add( cloneGraph( item, used ) );
        }

        return clone;
    }

    static class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }

        public Node addNode(Node item) {
            neighbors.add( item );
            return this;
        }
    }
}
