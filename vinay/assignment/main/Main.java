package vinay.assignment.main;

import vinay.assignment.data.DataClass;
import vinay.assignment.singleton.SingletonClass;

public class Main {
    public static void main(String[] args) {
        DataClass dataClass = new DataClass();
        dataClass.printMembers();
        dataClass.printLocalVariables();

        SingletonClass singletonObj = SingletonClass.initialization("Lahari");
        singletonObj.printName();
    }
}
