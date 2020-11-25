package ��ųƮ��;

public class Main {
	public static void main(String[] args) {
		String skill="AB";
		String[] skill_trees= {"DEAB", "DEBA", "ABDE", "BEAD", "CA", "CBA"};
		int num=solution(skill,skill_trees);
		System.out.println(num);
		
	}
	public static int solution(String skill, String[] skill_trees) {
		int answer = 0;
      	char[] skill1=skill.toCharArray();
        String[] result=new String[skill_trees.length];
        for(int i=0; i<skill_trees.length; i++){
            char[] temp=skill_trees[i].toCharArray();
            StringBuilder builder=new StringBuilder();
            for(int j=0; j<temp.length; j++){
                for(int k=0; k<skill1.length; k++){
                    if(temp[j]==skill1[k]){
                        builder.append(skill1[k]);
                    }
                }
            }
            result[i]=builder.toString();
        }
        for(int i=0; i<result.length; i++){
            if(result[i].length()==0){
                answer++;
            }else if(result[i].equals(skill)){
                answer++;
            }else if(skill.contains(result[i])){
            	boolean check=true;
            	for(int j=0; j<result[i].length(); j++) {
            		if(result[i].charAt(j)!=skill.charAt(j)) {
            			check=false;
            			break;
            		}
            	}
            	if(check)
            		answer++;
            }
        }
        return answer;
   }
}
