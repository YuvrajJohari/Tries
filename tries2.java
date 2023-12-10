public class tries2 {
    static class Node{
        Node children[]=new Node[26];
        boolean eow=false;
      Node(){
        for (int i=0;i<26;i++){
         children[i]=null;
        }
      }
    }
     public static Node  root=new Node();
    // public static void insert(String word){
    //     Node curr=root;
    //     for(int level=0;level<word.length();level++){
    //         int idx=word.charAt(level)-'a';
    //         if(curr.children[idx]==null){
    //           curr.children[idx]=new Node ();

    //         }
    //         curr=curr.children[idx];
    //     }
    //     curr.eow=true;
    // }
    public static void Insert(String word){
      Node curr= root ;
      for (int i=0;i<word.length();i++){
          int idx=word.charAt(i)-'a';
          if(curr.children[idx]==null){
              curr.children[idx]=new Node();

          }
          curr=curr.children[idx];


      }
      curr.eow=true;

  }
    public static boolean Search(String key){
      Node curr =root;
      for (int level=0;level<key.length();level++){
        int idx=key.charAt(level)-'a';
        if (curr.children[idx]==null){
          return false;
        }
        curr=curr.children[idx];

      }
        return curr.eow==true;
    }
  
  // public static boolean wordBreak(String s){
  //   if(s.length()==0){
  //     return true;

  //   }
  //   for (int i=1;i<=s.length();i++){
  //   if (Search(s.substring(0,i))&&wordBreak(s.substring(i))){
  //     return true;
  //   }
  //   }
  //   return false;
  // } 
  public static boolean  WordBreak(String word){
    if (word.length()==0){
        return true;

    }
    for (int i=1;i<=word .length();i++){

    
    if(Search(word.substring(0, i)) && WordBreak(word .substring(i))){
        return true ;
    }
    
    }
    return false ;
  }

  public static void main(String args[]){
    String arr[]={"i","like","sam","samsung","mobile","ice"};
    for(int i=0;i<arr.length;i++){
      Insert(arr[i]);

    }
    String key="ilikesamsung";
    System.out.println(WordBreak(key));

  } 
}
