package property;

import java.beans.PropertyEditorSupport;

import entity.User;

public class Property1 extends PropertyEditorSupport{
	
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		String[] sts = text.split(",");
		User user = new User();
		user.setName(sts[0]);
		user.setAge(Integer.parseInt(sts[1]));
		setValue(user);
	}
}
