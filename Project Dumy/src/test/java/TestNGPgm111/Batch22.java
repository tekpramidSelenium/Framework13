package TestNGPgm111;

import org.testng.annotations.Test;

import comCRM.business.ObjectRepository.CreateNewLeadsPage;
import comCRM.business.ObjectRepository.Homepage;
import comCRM.business.ObjectRepository.LeadsInfopage;
import comCRM.business.ObjectRepository.Leadspage;
import comCRM.generic.baseUtility.BaseClass;

public class Batch22 extends BaseClass {
	@Test(groups= {"smokeTest"})
	public void createLeadsNameTest() throws Throwable
	{
		String L_Name=eu.getDatafromExcelfile("Leads", 1, 2)+jlib.getRandomNumber(1000);
		String C_Name=eu.getDatafromExcelfile("Leads", 1, 3)+jlib.getRandomNumber(1000);
	
	// navigate to Leads module
	Homepage hp=new Homepage(driver);
	hp.getLeadsLink().click();
	
	// click on "create Leads" button
	Leadspage lsp=new Leadspage(driver);
	lsp.getNewLeadsBtn().click();
	
	// enter all details & create new Leads 
	CreateNewLeadsPage cnlp=new CreateNewLeadsPage(driver);
	cnlp.createLeads(L_Name, C_Name);
	
	// verify header msg Expected result
	LeadsInfopage lfip=new LeadsInfopage(driver);
	String headerinfo =lfip.getLeadsheaderMsg() .getText();		
	jlib.verifyInfo(headerinfo,L_Name);
	
	// verify  LastName info 
	String act_L_Name = lfip.getLeadslastNameInfo().getText();
	jlib.verifyInfo(act_L_Name, L_Name);
	
	// verify CompanyName info 
	String act_C_Name = lfip.getCompanyInfo().getText();
	jlib.verifyInfo(act_C_Name, C_Name);
	
	}
}
