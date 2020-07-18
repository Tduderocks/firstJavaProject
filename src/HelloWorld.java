
public class HelloWorld {
    public static void main(String[] args)
    {
        TestClass test = new TestClass();
        test.setAge(31);
        test.setName("Steve");
        System.out.println("Hello World this is: " + test.toString());
    }
}
