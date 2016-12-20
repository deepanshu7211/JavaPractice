package lmbk;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by deepanshu.saxena on 28/10/15.
 */

public class WithoutLombokAnnotations {
    private final int number;
    private final String text;
    private boolean flag;
    private List<String> stringList = new ArrayList<>();

    public WithoutLombokAnnotations(int number, String text) {
        this.number = number;
        this.text = text;
    }

    public int getNumber() {
        return number;
    }

    public String getText() {
        return text;
    }

    public List<String> getStringList() {
        return stringList;
    }

    public void setStringList(List<String> stringList) {
        this.stringList = stringList;
    }

    public boolean isFlag() {

        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    @Override
    public int hashCode() {
        int result = 11;
        result = result + result * this.number;
        result = result + this.text.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;

        final WithoutLombokAnnotations other = (WithoutLombokAnnotations) obj;
        if (this.number != other.number)
            return false;
        if (!Objects.equals(this.text, other.text))
            return false;

        return true;
    }

    @Override
    public String toString() {
        return "WithoutLombokAnnotations{" +
                "flag=" + flag +
                ", number=" + number +
                ", text='" + text + '\'' +
                ", stringList=" + stringList +
                '}';
    }
}
