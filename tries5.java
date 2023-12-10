package Tries;
public class tries5 {
    static class Node {
        Node children[]=new Node[26];
        boolean eow=false;
        Node(){
            for (int i=0;i<26;i++){
                children[i]=null;
            }
        }
        
    }
    public static Node root=new Node();
    public static void Insert(String word){
        Node curr=root;
        for(int i=0;i<word.length();i++){
            int idx=word.charAt(i)-'a';
            if (curr.children[i]==null){
                curr.children[i] = new Node() ;
            }
            curr=curr.children[idx];

        }
        curr.eow=true;
    }
    public static int countNode(Node root){
        if(root==null){
            return 0;
        }
        int count=0;
        for (int i=0;i<26;i++){
            if (root.children[i]!=null){
                count+=countNode(root.children[i]);
            }
        }
        return count+1;
    }
    public static void findUniquesub(String word){
        for(int i=0;i<word .length();i++){
            Insert(word.substring(i));

        }
        System.out.println(countNode(root));
    }
    public static void main(String args[]){
        String word="ababa";
        findUniquesub(word);
    }
    
}
