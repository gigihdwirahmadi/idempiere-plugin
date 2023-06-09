package callout;

import java.util.ArrayList;
import java.util.List;

import org.adempiere.base.IColumnCallout;
import org.adempiere.base.IColumnCalloutFactory;
import org.compiere.model.MOrder;

public class MyCalloutFactory implements IColumnCalloutFactory{

	@Override
	public IColumnCallout[] getColumnCallouts(String tableName, String columnName) {
		// TODO Auto-generated method stub
		
		List<IColumnCallout> list = new ArrayList<IColumnCallout>();
		
		if(tableName.equalsIgnoreCase(MOrder.Table_Name) && columnName.equalsIgnoreCase(MOrder.COLUMNNAME_Description))
			list.add(new MyCallout());

			
		return list != null ? list.toArray(new IColumnCallout[0]) : new IColumnCallout[0];
	}

}