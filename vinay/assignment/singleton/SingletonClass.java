package vinay.assignment.singleton;

public class SingletonClass {
    private String name;

    public static SingletonClass initialization(String name) {
        SingletonClass instance = new SingletonClass();
        instance.name = name;
        return instance;
    }

    public void printName() {
        System.out.println("Name : " + name);
    }
}
