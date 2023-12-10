import java .util.*;

public class tries1 {
    static class Node{
        Node children[]=new Node[26];
        boolean eow=false ;
        Node(){
            for (int i=0;i<26;i++){
                children[i]=null;
            }
        }
    }
    public static Node root;
    public static void insert(String s){
        Node curr=root;
        for (int i=0;i<s.length();i++){
            int idx= s.charAt(i)-'a';
            if (curr.children[idx]==null){
                curr.children[idx]=new Node();
            }
            curr=curr.children[idx];


        }
        curr.eow=true;
    }
    public static boolean Search(String key){
        Node curr = root;
        for (int i=0;i<key.length();i++){
            int idx=key.charAt(i);
            if (curr.children[idx]==null){
                return false;
            }
            curr=curr.children[idx];
        }
        return curr.eow;


    }
    
    
}
