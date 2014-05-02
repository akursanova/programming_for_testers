package com.example.tests;
import com.example.utils.SortedListOf;
import java.util.Random;
import org.testng.annotations.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.*;

public class GroupModificationTest extends TestBase {

	@Test(dataProvider = "randomValidGroupGenerator")
	public void modifySomeGroup(GroupParameters group) {
	    
	    //save old state
		SortedListOf<GroupParameters> oldList =  app.getGroupHelper().getUiGroups();
	    
	    Random rnd = new Random();
	    int index = rnd.nextInt(oldList.size());
	    
	    app.getGroupHelper().modifyGroup(index, group);
	    
	    // save new state     
	    SortedListOf<GroupParameters> newList =  app.getGroupHelper().getUiGroups();
	    
	    // compare states  
	    assertThat(newList,equalTo(oldList.without(index).withAdded(group)));
	
	}
}