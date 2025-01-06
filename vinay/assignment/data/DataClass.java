package vinay.assignment.data;

public class DataClass {
    int intMember;
    char charMember;
    public void printMembers(){
        System.out.println("intMember: " + intMember);
        System.out.println("charMember: " + charMember);
    }
    public void printLocalVariables(){
//        int localInt;
//        char localChar;
//        System.out.println("localInt: " + localInt);
//        System.out.println("localChar: " + localChar);

        /*
        This part is not possible in Java. Local variables must be initialized
        before they can be used. Unlike member variables, local variables do not
        receive default values.
         */
    }
}
