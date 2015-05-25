package entity;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("resultObject")
public class ResultObject {
	
	@XStreamAlias("winFlag")
	private boolean winFlag;
	
	@XStreamAlias("stageId")
	private String stageId;
	
	@XStreamAlias("pkgNum")
	private String pkgNum;
	
	@XStreamAlias("pkgName")
	private String pkgName;
	
	@XStreamAlias("winTime")
	private String winTime;
	
	@XStreamAlias("winRecordNo")
	private String winRecordNo;
	
	@XStreamAlias("winGiftType")
	private String winGiftType;
	
	@XStreamAlias("awardsName")
	private String awardsName;
	
	@XStreamAlias("desc")
	private String desc;
	

	public String getAwardsName() {
		return awardsName;
	}

	public void setAwardsName(String awardsName) {
		this.awardsName = awardsName;
	}

	public boolean isWinFlag() {
		return winFlag;
	}

	public void setWinFlag(boolean winFlag) {
		this.winFlag = winFlag;
	}

	public String getStageId() {
		return stageId;
	}

	public void setStageId(String stageId) {
		this.stageId = stageId;
	}

	public String getPkgNum() {
		return pkgNum;
	}

	public void setPkgNum(String pkgNum) {
		this.pkgNum = pkgNum;
	}

	public String getPkgName() {
		return pkgName;
	}

	public void setPkgName(String pkgName) {
		this.pkgName = pkgName;
	}

	public String getWinTime() {
		return winTime;
	}

	public void setWinTime(String winTime) {
		this.winTime = winTime;
	}

	public String getWinRecordNo() {
		return winRecordNo;
	}

	public void setWinRecordNo(String winRecordNo) {
		this.winRecordNo = winRecordNo;
	}

	public String getWinGiftType() {
		return winGiftType;
	}

	public void setWinGiftType(String winGiftType) {
		this.winGiftType = winGiftType;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	@Override
	public String toString() {
		return this.stageId+","+this.awardsName+","+this.pkgName+","+this.pkgNum+","+this.winGiftType+","+this.winRecordNo+","+this.winTime;
	}
}
