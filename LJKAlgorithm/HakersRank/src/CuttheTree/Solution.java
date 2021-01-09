package CuttheTree;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'cutTheTree' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY data
     *  2. 2D_INTEGER_ARRAY edges
     */

    static int[] sum;
    static int[] parents;
    static int[] visit;
    static int[] dp;
    public static int cutTheTree(List<Integer> data, List<List<Integer>> edges) {
    // Write your code here
        List<List<Integer>> tree=new ArrayList<>();
        sum=new int[data.size()];
        parents=new int[data.size()];
        for(int i=0; i<data.size(); i++){
            tree.add(new ArrayList<Integer>());
            parents[i]=-1;
        }
        
        for(int i=0; i<edges.size(); i++){
             int first=edges.get(i).get(0);
             int second=edges.get(i).get(1);
             List<Integer> temp=tree.get(first-1);
             List<Integer> temp2=tree.get(second-1);
             temp.add(second-1);
             temp2.add(first-1);
        }
        findParent(0,tree);
         int root=0;
         for(int i=0; i<parents.length; i++) {
             if(parents[i]==i) {
                 root=i;
                 break;
             }
         }
         dp=new int[data.size()];
         
         DFS(root,data,tree);
         int min=Integer.MAX_VALUE;
         int rootnum=sum[root];
         for(int i=0; i<edges.size(); i++) {
             int num=sum[edges.get(i).get(1)-1];
             int sub=rootnum-num;
             int gap=Math.abs(num-sub);
             min=Math.min(min, gap);
        }
        return min;
    }   
    public static void findParent(int start,List<List<Integer>> tree) {
        Queue<Integer> queue=new LinkedList<>();
        queue.add(start);
        parents[0]=0;
        while(!queue.isEmpty()) {
            int now=queue.poll();
            List<Integer> list=tree.get(now);
            for(int i=0; i<list.size(); i++) {
                int item=list.get(i);
                if(parents[item]==-1) {
                    parents[item]=now;
                    queue.add(item);
                }
            }
        }
    }
    
    public static int DFS(int root,List<Integer> data,List<List<Integer>> tree) {
        List<Integer> list=tree.get(root);
        sum[root]+=data.get(root);
        for(int i=0; i<list.size(); i++) {
            int node=list.get(i);
            if(node!=parents[root]) {
                sum[root]+=DFS(node,data,tree);
            }
        }

        return sum[root];
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> data = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<List<Integer>> edges = new ArrayList<>();

        IntStream.range(0, n - 1).forEach(i -> {
            try {
                edges.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = Result.cutTheTree(data, edges);
        System.out.println(result);
        //bufferedWriter.write(String.valueOf(result));
        //bufferedWriter.newLine();

        bufferedReader.close();
        //bufferedWriter.close();
    }
}
