package my.virkato;

public class Main {

    public static void main(String[] args) {
        System.out.println(getCallerClassAndMethodName());
        anotherMethod();
    }

    private static void anotherMethod() {
        System.out.println(getCallerClassAndMethodName());
    }

    public static String getCallerClassAndMethodName() {
/*
        StackTraceElement[] ste = new Throwable().getStackTrace();
       if (ste.length>2) return ste[2].getClassName()+"#"+ste[2].getMethodName();
/*/
        try {
            throw new Exception();
        } catch (Exception e) {
            StackTraceElement[] ste = e.getStackTrace();
            if (!ste[ste.length-1].getMethodName().equals(ste[1].getMethodName()))
                return ste[1].getClassName() + "#" + ste[1].getMethodName();
        }
//*/
        return null;
    }

}
