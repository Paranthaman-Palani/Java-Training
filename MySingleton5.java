package assignment1;

class MySingleton5 {
   public static void main(String[] args) {
      Single object1 = Single.getInstance();
      Single object2 = Single.getInstance();
      System.out.println(object1 +" "+ object2);
   }
}

class Single{
   static Single object = new Single() ;
   private Single() {
	   
   }
   public static Single getInstance() {
	   return object;

   }     
}