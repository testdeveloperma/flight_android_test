package elong.android.domesticflight.bean;

public class FlightListData {
	
	private String departCity; // 出发城市

	private String arriveCity; // 到达城市

	private String departDate; // 出发日期,包括周几、最低价

	public String getDepartCity() {
		return departCity;
	}

	public String getArriveCity() {
		return arriveCity;
	}

	public String getDepartDate() {
		return departDate;
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

	@Override
	public String toString() {
		return "FlightListData [departCity=" + departCity + ", arriveCity=" + arriveCity + ", departDate=" + departDate
				+ "]";
	}
	
	
	
	
	
	
}
