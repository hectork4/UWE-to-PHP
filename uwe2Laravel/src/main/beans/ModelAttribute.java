package main.beans;

public class ModelAttribute {
	private boolean isPersistible;
		
	public ModelAttribute(boolean isPersistible) {
		this.isPersistible = (isPersistible == false)? isPersistible : true;
	}

	public boolean isPersistible() {
		return isPersistible;
	}

	public void setPersistible(boolean isPersistible) {
		this.isPersistible = isPersistible;
	}

	public String getFQN() {
		return this.getClass().getCanonicalName();
	}
}
