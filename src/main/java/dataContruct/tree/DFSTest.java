package dataContruct.tree;

/**
 * @author: yangmengjun
 * @date: 2018\5\23 0023 11:18
 *
 * 123排列组合，不重复
 */
public class DFSTest {

    private static int length = 3;
    private static boolean[] flag = new boolean[length];

    private static int[] data = new int[length];

    private static void dfs(int  pos){
        if(pos==length){
            for(int d:data){
                System.out.print(d+", ");
            }
            System.out.println();
            return;
        }
        for (int i=0;i<length;i++){
            if(flag[i]==false){
                flag[i]=true;
                data[pos]=i+1;
                dfs(pos+1);
                flag[i]=false;
            }
        }
    }

    public static  void main(String[] args){
        dfs(0);
    }
}

