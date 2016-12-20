package effective_java.builder;

/**
 * Created by desaxena on 10/10/2016.
 */
public class NutritionFacts {

	private final int Serving_size;
	private final int servings;
	private final int calories;
	private final int fat;
	private final int sodium;

	public static class Builder {
		private final int servingSize;
		private final int servings;

		private int calories = 0;
		private int fat = 0;
		private int sodium = 0;

		public Builder(int servingSize, int servings) {

			this.servingSize = servingSize;
			this.servings = servings;
		}

		public Builder calories(int val) {
			calories = val;
			return this;
		}

		public Builder fat(int val) {
			fat = val;
			return this;
		}

		public Builder sodium(int val) {
			sodium = val;
			return this;
		}

		public NutritionFacts build() {
			return new NutritionFacts(this);
		}

	}

	private NutritionFacts(Builder builder) {
		Serving_size = builder.servingSize;
		servings = builder.servings;
		calories = builder.calories;
		fat = builder.fat;
		sodium = builder.sodium;
	}
	
	
	
	@Override
	public String toString() {
		return "NutritionFacts [Serving_size=" + Serving_size + ", servings=" + servings + ", calories=" + calories
				+ ", fat=" + fat + ", sodium=" + sodium + "]";
	}



	public static void main(String[] args) {
		NutritionFacts nutritionFacts = new NutritionFacts.Builder(240, 8).calories(100).build();
		System.out.println(nutritionFacts);
	}

}
