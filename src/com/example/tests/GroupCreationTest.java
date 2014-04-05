package com.example.tests;
import com.example.utils.SortedListOf;
import org.testng.annotations.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.*;

public class GroupCreationTest extends TestBase {
	
	@Test(dataProvider = "randomValidGroupGenerator")
    public void testGroupCreationWithValidData(GroupParameters group) throws Exception {
    
    //save old state
	SortedListOf<GroupParameters> oldList =  app.getGroupHelper().getGroups();
    
    // actions
    app.getGroupHelper().createGroup(group);

    
    // save new state     
    SortedListOf<GroupParameters> newList =  app.getGroupHelper().getGroups();
    
    // compare states  
    assertThat(newList,equalTo(oldList.withAdded(group)));
    
	}
  }
