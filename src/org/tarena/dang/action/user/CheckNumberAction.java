package org.tarena.dang.action.user;

import org.tarena.dang.action.BaseAction;

public class CheckNumberAction extends BaseAction{
	private String number;
	private boolean ok=false;
	public boolean isOk() {
		return ok;
	}
	public void setOk(boolean ok) {
		this.ok = ok;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		String check=((StringBuffer) session.get("check_code")).toString();
		if(number.equalsIgnoreCase(check)){
			ok=true;
		}
		
		return super.execute();
	}

}
