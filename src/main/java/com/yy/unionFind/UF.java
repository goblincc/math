package com.yy.unionFind;

/**
 * Created by cc on 2020/2/7.
 */
public class UF {
//    记录连通分量的个数
    private int count;
//    存储若干个树
    private int[] parent;
//    记录树的重量
    private int[] size;

    public UF(int n){
        this.count = n;
        parent = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    public void union(int p, int q){
        int rootp = find(p);
        int rootq = find(q);
        if(rootp == rootq){
            return;
        }
        if(size[rootp] >= size[rootq]){
            parent[rootq] = rootp;
            size[rootp] = size[rootq];
        }else{
            parent[rootp] = rootq;
            size[rootq] += size[rootp];
        }
        count--;
    }

    public boolean connect(int p, int q){
        return find(p) == find(q);
    }

    /**
     * 找到x节点的根节点
     * @param x
     * @return
     */
    private int find(int x){
        while(parent[x] != x){
            parent[x] = parent[parent[x]];
            x = parent[x];
        }
        return x;
    }
    public int count(){
        return count;
    }
}
