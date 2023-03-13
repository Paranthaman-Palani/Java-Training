package assignment1;

class MySingleton5 {
   public static void main(String[] args) {
      single obj = single.method();
      System.out.println(obj);
     
   }
}

class single{
	
   static single object = new single() ;

   private single() {
	   
   }

   public static single method() {
	   return object;

      }

      
}