package kr.or.dgit.jdbc_application.list;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

public abstract class AbstractList extends JPanel {
	//private JTable table;
	protected JTable table;	
	
	public AbstractList() {
		setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		//loadData(); 외부에서 호출하도록 바꿔주어야한다.
	}
	
	public void setPopupMenu(JPopupMenu menu){
		table.setComponentPopupMenu(menu);
	}
	
	public void loadData() {
		DefaultTableModel model = new DefaultTableModel(getData(), getColumnNames());
		table.setModel(model);
		setAlignWidth();
	
		/*	setWidth(100,150,50); //셀의 폭을 조절
		setAlign(SwingConstants.CENTER,0,2); //table이 바뀔때 마다 새롭게 호출하게 해주어야한다. 정렬을 할려면 새로 불러서 보여줘야한다.
		setAlign(SwingConstants.RIGHT, 1);*/
	}

	protected abstract void setAlignWidth();

	protected void setCellWidth(int...width){
		TableColumnModel cModel = table.getColumnModel();
		for(int i=0;i<width.length;i++){
			cModel.getColumn(i).setPreferredWidth(width[i]);
		}
	/*	cModel.getColumn(0).setPreferredWidth(100); //비율로 적절히 맞춰서 width가 나타난다.
		cModel.getColumn(1).setPreferredWidth(150);
		cModel.getColumn(2).setPreferredWidth(50);*/
	}
	protected void setAlign(int align,int...idx) {
		//0번 컬림을 정렬(Letf,Right,Center)
		DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer(); //컬럼에 해당하는 셀을 정렬하겠다. 컬럼끼리 같은 정렬을 해야한다. row는 따로 불가능
		dtcr.setHorizontalAlignment(align); //하나의 셀을 가운데 정렬을 하겠다.
		
		TableColumnModel cModel = table.getColumnModel(); //department에서는 3개가 존재한다.(부서번호, 부서명, 위치)
		
		//idx=[0,2] //int...idx가변인수
		for(int i=0;i<idx.length;i++){
			//0[0]~0[2],2[0]~2[2]
			cModel.getColumn(idx[i]).setCellRenderer(dtcr); //부서번호를 모두 가운데 정렬하겠다.0~2까지 3개 존재
		}
		
		
	}

	protected abstract String[] getColumnNames();
	
	protected abstract Object[][] getData();
	
	public abstract Object getSelectItem(); //외부에서 호출할거기 때문에 //자식은 부모보다 같거나 커야한다. 부모다 public이면 자식도 젤로 큰 public
}
