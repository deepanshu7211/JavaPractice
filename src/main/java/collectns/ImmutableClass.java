package collectns;

import java.util.Date;

/**
 * Created by deepanshu.saxena on 09/06/16.
 */
public final class ImmutableClass {
    /**
     * Integer class is immutable as it does not provide any setter to change its content
     */
    private final Integer immutableField1;
    /**
     * String class is immutable as it also does not provide setter to change its content
     */
    private final String immutableField2;
    /**
     * Date class is mutable as it provide setters to change various date/time parts
     */
    private final Date mutableField;

    //Default private constructor will ensure no unplanned construction of class
    private ImmutableClass(Integer fld1, String fld2, Date date) {
        this.immutableField1 = fld1;
        this.immutableField2 = fld2;
        this.mutableField = new Date(date.getTime());
    }

    //Factory method to store object creation logic in single place
    public static ImmutableClass createNewInstance(Integer fld1, String fld2, Date date) {
        return new ImmutableClass(fld1, fld2, date);
    }

    //Provide no setter methods

    /**
     * Integer class is immutable so we can return the instance variable as it is
     */
    public Integer getImmutableField1() {
        return immutableField1;
    }

    /**
     * String class is also immutable so we can return the instance variable as it is
     */
    public String getImmutableField2() {
        return immutableField2;
    }

    /**
     * Date class is mutable so we need a little care here.
     * We should not return the reference of original instance variable.
     * Instead a new Date object, with content copied to it, should be returned.
     */
    public Date getMutableField() {
        System.out.println(" getMutableField called ");
        return new Date(mutableField.getTime());
//        return mutableField;
    }

    @Override
    public String toString() {
        return immutableField1 + " - " + immutableField2 + " - " + mutableField;
    }
}

class TestMain {
    public static void main(String[] args) {
        ImmutableClass im = ImmutableClass.createNewInstance(100, "test", new Date());
        System.out.println(im);

        // Modifying the Contents Of a Class
        Integer immutableField1 = im.getImmutableField1();
        immutableField1 = 10000;
        String immutableField2 = im.getImmutableField2();
        immutableField2 = "test changed";
        Date mutableField = im.getMutableField();
        mutableField.setDate(10);
        System.out.println(im);
    }
}
