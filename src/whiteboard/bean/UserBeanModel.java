package whiteboard.bean;

public class UserBeanModel {
	private Integer studentId;
	private String firstName;
	private String lastName;
	private String password;
	private String email;
	private String phone;
	private String address;
	private String city;
	private Integer zipcode;
	private int isActive;
	private boolean isPrivate;
	
	public Integer getStudentId() {
		return studentId;
	}
	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Integer getZipcode() {
		return zipcode;
	}
	public void setZipcode(Integer zipcode) {
		this.zipcode = zipcode;
	}
	public int getIsActive() {
		return isActive;
	}
	public void setIsActive(int isActive) {
		this.isActive = isActive;
	}
	public boolean isPrivate() {
		return isPrivate;
	}
	public void setPrivate(boolean isPrivate) {
		this.isPrivate = isPrivate;
	}
	public String toString()
	{
		return "userId " + getStudentId() + "\n"
				+ "password " + getPassword() + "\n"
				+ "firstname " + getFirstName() + "\n"
				+ "lastname " + getLastName() + "\n"
				+ "email " + getEmail() + "\n"
				+ "phone " + getPhone() + "\n"
				+ "address " + getAddress() + "\n"
				+ "city " + getCity() + "\n"
				+ "zipcode " + getZipcode() + "\n"
				+ "isPrivate" + isPrivate();			
	}
}
