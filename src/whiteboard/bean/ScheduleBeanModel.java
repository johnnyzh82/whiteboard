package whiteboard.bean;

import java.util.Date;

public class ScheduleBeanModel {
	private Integer studentId;
    private Date start;
    private Date end;
    private boolean repeat;
    private String repeatOption;
    private Integer interval;
    private String weeklyDays;
    private String description;

	public Integer getStudentId() {
		return studentId;
	}


	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}


	public Date getStart() {
		return start;
	}


	public void setStart(Date start) {
		this.start = start;
	}


	public Date getEnd() {
		return end;
	}


	public void setEnd(Date end) {
		this.end = end;
	}


	public boolean isRepeat() {
		return repeat;
	}


	public void setRepeat(boolean repeat) {
		this.repeat = repeat;
	}


	public String getRepeatOption() {
		return repeatOption;
	}


	public void setRepeatOption(String repeatOption) {
		this.repeatOption = repeatOption;
	}


	public Integer getInterval() {
		return interval;
	}


	public void setInterval(Integer interval) {
		this.interval = interval;
	}


	public String getWeeklyDays() {
		return weeklyDays;
	}


	public void setWeeklyDays(String weeklyDays) {
		this.weeklyDays = weeklyDays;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}
	
//	public String toString(){		
//		return 'aa';
//	}
}
