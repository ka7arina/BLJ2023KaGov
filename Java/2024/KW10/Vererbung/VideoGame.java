public class VideoGame extends Medium {
   private String creator;

   @Override
   public void printInfo() {
      super.printInfo();
      String moreInfo = "Creator: " + creator;
      System.out.println(moreInfo);
   }

   public String getCreator() {
      return creator;
   }

   public void setCreator(String creator) {
      this.creator = creator;
   }
}
