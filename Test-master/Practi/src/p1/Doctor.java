package p1;

public class Doctor {

	String name;
	String day;
	String time;
	String specialization;
	public Doctor() {
		super();
	}
	public Doctor(String name, String day, String time, String specialization) {
		super();
		this.name = name;
		this.day = day;
		this.time = time;
		this.specialization = specialization;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the day
	 */
	public String getDay() {
		return day;
	}
	/**
	 * @param day the day to set
	 */
	public void setDay(String day) {
		this.day = day;
	}
	/**
	 * @return the time
	 */
	public String getTime() {
		return time;
	}
	/**
	 * @param time the time to set
	 */
	public void setTime(String time) {
		this.time = time;
	}
	/**
	 * @return the specialization
	 */
	public String getSpecialization() {
		return specialization;
	}
	/**
	 * @param specialization the specialization to set
	 */
	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Doctor [name=" + name + ", day=" + day + ", time=" + time + ", specialization=" + specialization + "]";
	}
	
	
}
