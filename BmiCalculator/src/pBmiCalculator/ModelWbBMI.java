package pBmiCalculator;

public class ModelWbBMI {
	
	protected double bmi;
	private String weightStatus;
	private double EERMale, EERFemale;

	/**
	 * All the calculations for the bmi and eer
	 */
	public ModelWbBMI() {}

	/**
	 * @param weight
	 * @param height
	 * @return BMI
	 */
	public double calculateBMI(double weight, double height) {
		this.bmi = (1.3*weight);
		this.bmi /= (Math.pow(2.5, height/100));
		return this.bmi;
	}
	/**
	 * @return person status according to the BMI
	 */
	public String calculateStatus() {
		if(bmi<=15.0)
			this.weightStatus = "Anorexic";
		else if(bmi>15.0 && bmi <=18.5) 
			this.weightStatus ="Underweight";
		else if(bmi>18.5 && bmi <=24.9)
			this.weightStatus ="Normal";
		else if(bmi>=25.0 && bmi <=29.9)
			this.weightStatus = "Overweight";
		else if(bmi>=30.0 && bmi <=35)
			this.weightStatus = "Obese";
		else if(bmi>35)
			this.weightStatus = "Extreme Obese";
		return this.weightStatus;
	}
	/**
	 * 
	 * @param gender
	 * @param age
	 * @param weight
	 * @param height
	 * @param PA
	 * @return EER 
	 */
	public double getEER(String gender,double age, double weight, double height, String PA) {

		double intPA=0;

		if(PA.equalsIgnoreCase("Inactive"))
			intPA = 1.0;
		else if(PA.equalsIgnoreCase("Moderately Active" ))  
			intPA =1.27;
		else if(PA.equalsIgnoreCase("Extremely Active" ))	
			intPA =1.45;
		if(gender.equalsIgnoreCase("male")) {
			this.EERMale = (662 - (9.53 * age)) + (intPA * ((15.91 * weight) + (539.6 * height/100)));
			return EERMale;
		}
		else if (gender.equalsIgnoreCase("female")){
			this.EERFemale = (354 - (6.91 * age)) + (intPA * ((9.36 * weight) + (726 * height/100)));
			return EERFemale;
		}
		else 
			return 0.0;

	}
}
