package spatial.hibernate.domain;

import java.io.Serializable;

public class LastRecord implements Serializable{
	
	private static final long serialVersionUID = -8206690967344361485L;
	
	private int id;
	private double latitude;
	private double longitude;
	private String jmx;
	private String jmy;
	private double speed;
	private double direction;
	private double height;
	private double distance;
	private double statllite_num;
	private String device_id;
	private java.util.Date gpstime;
	private java.util.Date inputdate;
	private String locate_type;
	private String alarm_read_flag;
	private String speed_alarm_flag;
	private int coord_type;
	private String state;
	private String pos_desc;
	private String loc_id;
	private String obj_id;
	private String obj_type;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	public String getJmx() {
		return jmx;
	}
	public void setJmx(String jmx) {
		this.jmx = jmx;
	}
	public String getJmy() {
		return jmy;
	}
	public void setJmy(String jmy) {
		this.jmy = jmy;
	}
	public double getSpeed() {
		return speed;
	}
	public void setSpeed(double speed) {
		this.speed = speed;
	}
	public double getDirection() {
		return direction;
	}
	public void setDirection(double direction) {
		this.direction = direction;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public double getDistance() {
		return distance;
	}
	public void setDistance(double distance) {
		this.distance = distance;
	}
	public double getStatllite_num() {
		return statllite_num;
	}
	public void setStatllite_num(double statllite_num) {
		this.statllite_num = statllite_num;
	}
	public String getDevice_id() {
		return device_id;
	}
	public void setDevice_id(String device_id) {
		this.device_id = device_id;
	}
	public java.util.Date getGpstime() {
		return gpstime;
	}
	public void setGpstime(java.util.Date gpstime) {
		this.gpstime = gpstime;
	}
	public java.util.Date getInputdate() {
		return inputdate;
	}
	public void setInputdate(java.util.Date inputdate) {
		this.inputdate = inputdate;
	}
	public String getLocate_type() {
		return locate_type;
	}
	public void setLocate_type(String locate_type) {
		this.locate_type = locate_type;
	}
	public String getAlarm_read_flag() {
		return alarm_read_flag;
	}
	public void setAlarm_read_flag(String alarm_read_flag) {
		this.alarm_read_flag = alarm_read_flag;
	}
	public String getSpeed_alarm_flag() {
		return speed_alarm_flag;
	}
	public void setSpeed_alarm_flag(String speed_alarm_flag) {
		this.speed_alarm_flag = speed_alarm_flag;
	}
	public int getCoord_type() {
		return coord_type;
	}
	public void setCoord_type(int coord_type) {
		this.coord_type = coord_type;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPos_desc() {
		return pos_desc;
	}
	public void setPos_desc(String pos_desc) {
		this.pos_desc = pos_desc;
	}
	public String getLoc_id() {
		return loc_id;
	}
	public void setLoc_id(String loc_id) {
		this.loc_id = loc_id;
	}
	public String getObj_id() {
		return obj_id;
	}
	public void setObj_id(String obj_id) {
		this.obj_id = obj_id;
	}
	public String getObj_type() {
		return obj_type;
	}
	public void setObj_type(String obj_type) {
		this.obj_type = obj_type;
	}




}
