public class TreeSum {
    public static void main (String[] args) {

        Node nl211 = new Node(1, null, null);
        Node nl212 = new Node(2, null, null);

        Node nl221 = new Node(3, null, null);
        Node nl222 = new Node(4, null, null);

        Node nl11 = new Node(5, nl211, nl212);
        Node nl12 = new Node(6, nl221, nl222);

        Node nl = new Node(7, nl11, nl12);


        Node nr211 = new Node(8, null, null);
        Node nr212 = new Node(9, null, null);

        Node nr221 = new Node(10, null, null);
        Node nr222 = new Node(11, null, null);

        Node nr11 = new Node(12, nl211, nl212);
        Node nr12 = new Node(13, nl221, nl222);

        Node nr = new Node(14, nr11, nr12);

        Node head = new Node(30, nl, nr);

        System.out.println(treeSum(nl));
    }

    public static int treeSum(Node node) {
        if (node == null) {
            return 0;
        }

        // if (node.left == null && node.right == null) {
        //     return node.value;
        // }

        return treeSum(node.left) + treeSum(node.right) + node.value;
    }

    private static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

    /*
                                      head
                      nl                                 nr
            nl11>5           nl12>6            nr11>12          nr12>13
       nl211>1 nl212>2  nl221>3 nl222>4   nr211>8 nr212>9  nr211>10 nr212>11
    */
}