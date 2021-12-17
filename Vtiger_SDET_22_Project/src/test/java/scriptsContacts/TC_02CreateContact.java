package scriptsContacts;

import com.crm.vtiger.pomrepositorylib.HomePage;

public class TC_02CreateContact {
	
	@Test
	public void CreateContact()
	{
	
		/*read test data*/
		String contactLastName = eUtil.getExcelData("Contacts", 1, 1)+"_"+jUtil.getRandomData();
		String assignedTo = eUtil.getExcelData("Contacts", 1, 3);
		
	HomePage hp=new HomePage("driver");
	hp.ContactsLink.click();

}
}