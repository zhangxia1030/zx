package entity;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("result")
public class Result {
	
	@XStreamAlias("success")
	private boolean success;
	
	@XStreamAlias("resultCode")
	private int resultCode;
	
	@XStreamAlias("resultObject")
	private ResultObject resultObject;

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public int getResultCode() {
		return resultCode;
	}

	public void setResultCode(int resultCode) {
		this.resultCode = resultCode;
	}

	public ResultObject getResultObject() {
		return resultObject;
	}

	public void setResultObject(ResultObject resultObject) {
		this.resultObject = resultObject;
	}
	
	@Override
	public String toString() {
		return this.resultCode+","+this.success+",["+this.resultObject.toString()+"]";
	}
}
