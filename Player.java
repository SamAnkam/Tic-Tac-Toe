public class Player { 
   private String name;
   private String icon; //this is 'X' or 'O'


   Player(String name, String icon) { //constructor initializing a player with a name and icon
      this.name = name;
      this.icon = icon;
   }

   public String getName() {
      return name;
   }
   public String getIcon() {
      return icon;
   }


}
