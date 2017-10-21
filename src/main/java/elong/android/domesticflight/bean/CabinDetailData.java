package elong.android.domesticflight.bean;

public class CabinDetailData {
	
	private String departCity; // 顶部出发城市

	private String arriveCity; // 顶部到达城市

	private String departDate; // 顶部出发日期

	private String departTime; // 出发时间：时分

	private String arriveTime; // 到达时间：时分

	public String getDepartCity() {
		return departCity;
	}

	public String getArriveCity() {
		return arriveCity;
	}

	public String getDepartDate() {
		return departDate;
	}

	public String getDepartTime() {
		return departTime;
	}

	public String getArriveTime() {
		return arriveTime;
	}

	public void setDepartCity(String departCity) {
		this.departCity = departCity;
	}

	public void setArriveCity(String arriveCity) {
		this.arriveCity = arriveCity;
	}

	public void setDepartDate(String departDate) {
		this.departDate = departDate;
	}

	public void setDepartTime(String departTime) {
		this.departTime = departTime;
	}

	public void setArriveTime(String arriveTime) {
		this.arriveTime = arriveTime;
	}

	@Override
	public String toString() {
		return "CabinDetail [departCity=" + departCity + ", arriveCity=" + arriveCity + ", departDate=" + departDate
				+ ", departTime=" + departTime + ", arriveTime=" + arriveTime + "]";
	}

}
