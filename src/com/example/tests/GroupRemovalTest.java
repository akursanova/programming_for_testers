package com.example.tests;
import com.example.utils.SortedListOf;
import java.util.Random;
import org.testng.annotations.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.*;

public class GroupRemovalTest extends TestBase {
	
	@Test
	public void deleteSomeGroup() {

	    //save old state
		SortedListOf<GroupParameters> oldList =  app.getGroupHelper().getGroups();
	    
	    Random rnd = new Random();
	    int index = rnd.nextInt(oldList.size());
	    
	    //actions
		app.getGroupHelper().deleteGroup(index);
	    
	    // save new state     
		SortedListOf<GroupParameters> newList =  app.getGroupHelper().getGroups();
	    
	    // compare states  
	    assertThat(newList,equalTo(oldList.without(index)));
		
	}
}
