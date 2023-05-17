package org.evenos.process;

import org.compiere.model.MAsset;

import org.compiere.process.ProcessInfoParameter;
import org.compiere.process.SvrProcess;

public class AssignProcess extends SvrProcess{
	private Integer User_ID;
	private Integer asset_ID;
	@Override
	protected void prepare() {
		ProcessInfoParameter[] paras= getParameter();
		for(ProcessInfoParameter para: paras) {
			String ParaName= para.getParameterName();
			if(ParaName.equalsIgnoreCase("AD_User_ID")) {
				User_ID= para.getParameterAsInt();
			}else if(ParaName.equalsIgnoreCase("A_Asset_ID")) {
				asset_ID= para.getParameterAsInt();
			}
		}
	}

	@Override
	protected String doIt() throws Exception {
		if (asset_ID == null) {
		    return "Asset ID is not provided or invalid.";
		}else if(User_ID == null) {
			return "user ID is not provided or invalid.";
		}
		 	MAsset asset = new MAsset(getCtx(), asset_ID, get_TrxName());
	        asset.setAD_User_ID(User_ID); // Set the user ID
	        asset.saveEx();

	        return "Asset with ID " + asset_ID + " updated successfully.";
	}

}
