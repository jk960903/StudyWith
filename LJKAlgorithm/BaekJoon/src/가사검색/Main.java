package 가사검색;

public class Main {
	String[] words= {"frodo", "front", "frost", "frozen", "frame", "kakao"};
	String[] queries= {"fro??", "????o", "fr???", "fro???", "pro?"};
	
}
class Solution{
	public int[] solution(String[] words,String[] queries) {
		int[] answer=new int[queries.length];
		Trie[] tries=new Trie[10001];
		Trie[] rtries=new Trie[10001];
		for(int i=0; i<words.length; i++) {
			int len=words[i].length();
			try {
				tries[len].insert(words[i].toCharArray());
			}catch(NullPointerException e) {
				tries[len]=new Trie();
				tries[len].insert(words[i].toCharArray());
			}
			words[i]=(new StringBuffer(words[i])).reverse().toString();
			try {
				rtries[len].insert(words[i].toCharArray());
			}catch(NullPointerException e) {
				rtries[len]=new Trie();
				rtries[len].insert(words[i].toCharArray());
			}
		}
		for(int i=0; i<queries.length; i++) {
			String query=queries[i];
			if(query.indexOf('?')==0) {
				try {
					query=(new StringBuffer(query)).reverse().toString();
					answer[i]=rtries[query.length()].search(query.toCharArray());
				}catch(Exception e) {
					continue;
				}
			}else {
				try {
					answer[i]=tries[query.length()].search(query.toCharArray());
				}catch(Exception e) {
					continue;
				}
			}
		}
		return answer;
	}
}
class Trie{
	int count;
	Trie[] childList;
	public Trie() {
		childList=new Trie[26];
		count=0;
	}
	void insert(char[] word) {
		Trie current=this;
		for(char c : word) {
			current.count+=1;
			if(current.childList[c-'a']!=null) {
				current=current.childList[c-'a'];
			}else {
				current.childList[c-'a']=new Trie();
				current=current.childList[c-'a'];
			}
		}
	}
	int search(char[] query) {
		Trie current=this;
		for(char c : query) {
			if(c=='?') {
				return current.count;
			}
			if(current.childList[c-'a']!=null) {
				current=current.childList[c-'a'];
			}else {
				return 0;
			}
		}
		return current.count;
	}
}
