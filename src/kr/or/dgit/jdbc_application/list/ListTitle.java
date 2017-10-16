package kr.or.dgit.jdbc_application.list;

import java.util.List;

import javax.swing.SwingConstants;

import kr.or.dgit.jdbc_application.dto.Title;
import kr.or.dgit.jdbc_application.service.TitleService;

public class ListTitle extends AbstractList {
	
	private TitleService service;
	
	public ListTitle(TitleService service) {
		this.service = service;
	}
/////////service
	
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
		/*Object[][] data = {
				{1,"사장"},
				{2,"부장"}
		};*/
		
		List<Title> lists = service.selectTitleByAll();
		Object[][] datas = new Object[lists.size()][];
		for(int i=0;i<lists.size();i++){
			datas[i] = lists.get(i).toArray();
		}
		return datas;
	}

	@Override
	public Object getSelectItem() {
		int selectIndex = table.getSelectedRow();
		int titleNo = (int) table.getValueAt(selectIndex, 0);
		/*String titleName = (String) table.getValueAt(selectIndex, 1);
		return new Title(titleNo, titleName);*/
		return service.selectTitleByNo(new Title(titleNo));
	}
	
	
	
}
