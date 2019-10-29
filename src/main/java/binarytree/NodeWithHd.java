package binarytree;

public class NodeWithHd {
    public Integer data;
    public NodeWithHd left;
    public NodeWithHd right;
    public int hd;

    public NodeWithHd(int data) {
      this.data = data;
      left = right = null;
      hd = 0;
    }
}
