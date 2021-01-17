package PermutationSequence;
import java.util.ArrayList;
public class Solution{
    static ArrayList<String> list=new ArrayList<>();
    public static String getPermutation(int n, int k) {
        list=new ArrayList<>();
        int num=list.size();
        int[] array=new int[n];
        for(int i=0; i<n; i++){
            array[i]=i+1;
        }
        int[] output=new int[n];
        boolean[] visit=new boolean[n];
        Permutation(array,output,visit,0);
        String result=list.get(k-1);
        return result;
    }
    private static void Permutation(int[] n,int[] output,boolean[] visit,int depth){
        if(depth==n.length){
            StringBuilder sb=new StringBuilder();
            for(int i=0; i<n.length; i++){
                sb.append(output[i]);
            }
            list.add(sb.toString());
            return;
        }
        for(int i=0; i<n.length; i++){
            if(!visit[i]){
                visit[i]=true;
                output[depth]=n[i];
                Permutation(n,output,visit,depth+1);
                output[depth]=0;
                visit[i]=false;
            }
        }
    }
    private static void swap(int[] array,int depth,int i){
        int temp=array[depth];
        array[depth]=array[i];
        array[i]=temp;
    }
    public static void main(String[] args) {
    	int n=10;
    	int k=30;
    	String temp=getPermutation(n,k);
    	System.out.println(temp);
    }
    
}
