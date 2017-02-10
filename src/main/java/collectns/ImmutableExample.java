package collectns;

import java.util.Date;

public class ImmutableExample {
	public static void main(String[] args) {
		Dept dept = new Dept();
		dept.setName("hr");
		Immutable immutable = Immutable.createInstance(100, "test", new Date(), dept);
		System.out.println(immutable);
		int immut1 = immutable.getImmut1();
		immut1 = 1000;
		String immut2 = immutable.getImmut2();
		immut2 = "hello";
		Date mutable = immutable.getMutable();
		mutable.setDate(20);
		Dept change = immutable.getDept();
		change.setName("finace");
		System.out.println(immutable);
	}
}

final class Immutable {
	private final int immut1;
	private final String immut2;
	private final Date mutable;
	private final Dept dept;

	public Immutable(int immut1, String immut2, Date mutable, Dept dept) {
		this.immut1 = immut1;
		this.immut2 = immut2;
		this.mutable = new Date(mutable.getTime());
		this.dept = dept;
	}

	public static Immutable createInstance(int immut1, String immut2, Date mutable, Dept dept) {
		return new Immutable(immut1, immut2, mutable, dept);
	}

	public int getImmut1() {
		return immut1;
	}

	public String getImmut2() {
		return immut2;
	}

	public Date getMutable() {
		return new Date(mutable.getTime());
	}

	public Dept getDept() {
		Dept deptClone = null;
		try {
			deptClone = (Dept) dept.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return deptClone; // If it change to Dept then it will return finance.
							// Then it will be non immutable class.
	}

	@Override
	public String toString() {
		return "Immutable [immut1=" + immut1 + ", immut2=" + immut2 + ", mutable=" + mutable + ", dept=" + dept + "]";
	}

}

class Dept implements Cloneable {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}

	@Override
	public String toString() {
		return "Dept [name=" + name + "]";
	}

}