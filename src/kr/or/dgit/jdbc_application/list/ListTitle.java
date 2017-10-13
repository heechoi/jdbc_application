package kr.or.dgit.jdbc_application.list;

import javax.swing.SwingConstants;

import kr.or.dgit.jdbc_application.dto.Title;

public class ListTitle extends AbstractList {
	@Override
	protected void setAlignWidth() {
		setAlign(SwingConstants.CENTER, 0,1);
		setCellWidth(100,150);
	}

	@Override
	protected String[] getColumnNames() {
		return new String[]{"직잭번호","직책명"};
	}

	@Override
	protected Object[][] getData() {
		Object[][] data = {
				{1,"사장"},
				{2,"부장"}
		};
		return data;
	}

	@Override
	public Object getSelectItem() {
		int selectIndex = table.getSelectedRow();
		int titleNo = (int) table.getValueAt(selectIndex, 0);
		String titleName = (String) table.getValueAt(selectIndex, 1);
		return new Title(titleNo, titleName);
	}

}
