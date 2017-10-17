package kr.or.dgit.jdbc_application.content;

import java.awt.GridLayout;

import javax.swing.JPanel;

import kr.or.dgit.jdbc_application.common.TextFieldComponent;
import kr.or.dgit.jdbc_application.dto.Title;

@SuppressWarnings("serial")
public abstract class AbstractContent<T> extends JPanel {

	/*private TextFieldComponent pTitleNo;
	private TextFieldComponent pTitleName;*/

/*	public AbstractContent() {
		setLayout(new GridLayout(0, 1, 0, 10));
		
		pTitleNo = new TextFieldComponent("직책 번호");
		add(pTitleNo);
		
		pTitleName = new TextFieldComponent("직책명");
		add(pTitleName);

	}*/
	
	public abstract T getContent();
	
	public abstract void setContent(T content);
	public abstract void isEmptyCheck() throws Exception;
	public abstract void clear();
	public abstract void showContent(Object content);

	
	
	
}
