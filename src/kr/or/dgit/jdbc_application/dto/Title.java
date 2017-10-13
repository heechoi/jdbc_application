package kr.or.dgit.jdbc_application.dto;

public class Title {
	private int titleNo;
	private String titleName;

	public Title() {}

	public Title(int titleNo, String titleName) {
		this.titleNo = titleNo;
		this.titleName = titleName;
	}
	
	
	
	
	public Title(String titleName) {
		this.titleName = titleName;
	}

	public Title(int titleNo) {
		this.titleNo = titleNo;
	}

	public int getTitleNo() {
		return titleNo;
	}

	public void setTitleNo(int titleNo) {
		this.titleNo = titleNo;
	}

	public String getTitleName() {
		return titleName;
	}

	public void setTitleName(String titleName) {
		this.titleName = titleName;
	}

	@Override
	public String toString() {
		return String.format("%s(%s)", titleName, titleNo);
	}

}
