package com.example.tests;
import java.util.Random;
import org.testng.annotations.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.*;
import com.example.utils.SortedListOf;

public class GroupRemovalTest extends TestBase {
	
	@Test
	public void deleteSomeGroup() {

	    //save old state
		SortedListOf<GroupParameters> oldList =  app.getGroupHelper().getUiGroups();
	    
	    Random rnd = new Random();
	    int index = rnd.nextInt(oldList.size());
	    
	    //actions
		app.getGroupHelper().deleteGroup(index);
	    
	    // save new state     
		SortedListOf<GroupParameters> newList =  app.getGroupHelper().getUiGroups();
	    
	    // compare states  
	    assertThat(newList,equalTo(oldList.without(index)));
		
	}
}
