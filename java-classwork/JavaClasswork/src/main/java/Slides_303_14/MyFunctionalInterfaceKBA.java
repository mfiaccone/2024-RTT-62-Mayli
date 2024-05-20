package Slides_303_14;
//kba question exactly
//multiple choice and one of the answers is 25 (which is the output)
@FunctionalInterface
public interface MyFunctionalInterfaceKBA {

    public Integer sqr(int a);

    default String sqr(String a) {
        return a + a;
    }
}
