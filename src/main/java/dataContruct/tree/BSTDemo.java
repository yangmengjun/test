package dataContruct.tree;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * Created by Json on 2018/9/20.
 * BST 树：二叉搜索树
 *       BST是对于任意的node x，如果node y是node x的左边的节点, 那么Key(y) <= Key(x); 对于任意的node x， 如果node y 是node x的右边的节点， 那么key(y)>=key(x).
 *       4
 *     3   6
 *   2    5 7
 */

public class BSTDemo {
    public static void main(String[] args) {
        bstTransfromLinkedList();
    }

    public static class Node{
        private int id;
        private String name;
        public Node(int id,String name){
            this.id = id;
            this.name = name;
        }
        Node left;
        Node right;
    }

    /**
     * 二叉搜索树转双向链表
     *
     *       4
     *    2      6
     *  1   3   5   7
     *
     *  中序遍历：1 2 3 4 5 6 7
     *  前序遍历： 4 2 1 3 6 5 7
     *  后续遍历： 1 3 2 5 7 6 4
     */
    public static void bstTransfromLinkedList(){
        Node node1 = new Node(1,"节点1");
        Node node2 = new Node(2,"节点2");
        Node node3 = new Node(3,"节点3");
        Node node4 = new Node(4,"节点4");
        Node node5 = new Node(5,"节点5");
        Node node6 = new Node(6,"节点6");
        Node node7 = new Node(7,"节点七");
        node2.left=node1;
        node2.right=node3;
        node4.left=node2;
        node4.right=node6;
        node6.left=node5;
        node6.right=node7;
        System.out.println(node4);

        List<Node> nodes = Lists.newLinkedList();
        //BST转双向链表，BST的中序排序
        middleFirstSearch(nodes, node4);
        printNodesList("BST转双向链表（中序排序）",nodes);
        //前序排序
        List<Node> frontNodes = Lists.newLinkedList();
        frontFirstSearch(frontNodes, node4);
        printNodesList("前序排序",frontNodes);
       //后序排序
        List<Node> backNodes = Lists.newLinkedList();
        backFirstSearch(backNodes,node4);
        printNodesList("后序排序",backNodes);
    }

    private static void printNodesList(String msg,List<Node> nodes) {
        System.out.print(msg+":");
        nodes.stream().forEach(item->{System.out.print(item.id+" ");});
    }

    /**
     * 二叉树的中序遍历
     * @param nodes
     * @param rootNode
     */
    public static void middleFirstSearch(List<Node> nodes,Node rootNode){
        if(rootNode.left!=null){
            middleFirstSearch(nodes, rootNode.left);
        }
        nodes.add(rootNode);
        if(rootNode.right!=null){
            middleFirstSearch(nodes, rootNode.right);
        }
    }
   /**
     * 二叉树的前序遍历
     * @param nodes
     * @param rootNode
     */
    public static void frontFirstSearch(List<Node> nodes,Node rootNode){
        nodes.add(rootNode);
        if(rootNode.left!=null){
            frontFirstSearch(nodes, rootNode.left);
        }
        if(rootNode.right!=null){
            frontFirstSearch(nodes, rootNode.right);
        }
    }
   /**
     * 二叉树的后序遍历
     * @param nodes
     * @param rootNode
     */
    public static void backFirstSearch(List<Node> nodes,Node rootNode){
        if(rootNode.left!=null){
            backFirstSearch(nodes, rootNode.left);
        }
        if(rootNode.right!=null){
            backFirstSearch(nodes, rootNode.right);
        }
        nodes.add(rootNode);
    }
}

