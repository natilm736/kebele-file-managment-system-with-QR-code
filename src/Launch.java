import sample.Main;

public class Launch {
    public static void main(String[] args){
        try {
            Main.main(args);
        }catch (Exception e){
            System.out.println(e);
            System.out.println("not open");
        }
    }
}
