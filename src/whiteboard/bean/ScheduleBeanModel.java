package whiteboard.bean;

public class ScheduleBeanModel {
	private Integer schedule_id;
	private Integer studentId;
	private String title;
    private String date;
    private String startTime;
    private String endTime;
    private String description;

	public Integer getSchedule_id() {
		return schedule_id;
	}


	public void setSchedule_id(Integer schedule_id) {
		this.schedule_id = schedule_id;
	}


	public Integer getStudentId() {
		return studentId;
	}


	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}


	public String getStartTime() {
		return startTime;
	}


	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}


	public String getEndTime() {
		return endTime;
	}


	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	
}
