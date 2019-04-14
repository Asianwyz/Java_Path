package Improve.Annotation;

public @interface MyAnno {
//    int age();
      int value();
//    String name() default "Asia";
//    String show2();
    MyAnno2 anno2();
    String[] args();
//
    Person per();
//    public abstract String show();
}
