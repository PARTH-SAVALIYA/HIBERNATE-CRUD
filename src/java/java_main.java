
public class java_main {

    public static void main(String[] args) {

        try {

            testcalss tc = new testcalss();
            
            tc.insert("Laksh", "Life", 0);
            
            tc.list();

            tc.update(2, "ram krishna", "Satya", 800f);

            tc.delete(10); 

        tc.author();

        } catch (Exception e) {
            System.out.println("ERROR = " + e.getMessage());
        } finally {
            System.exit(0);
        }

    }

}
