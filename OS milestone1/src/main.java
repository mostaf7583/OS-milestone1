public class main {
    public static void main(String[] args) {
        process p = new process();
        p.getVariables().put("key", "value");
        p.getVariables().put("key2", "5");

        System.out.println(p.getVariables().get("key"));
    }
}
