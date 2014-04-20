package com.example.tests;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import com.example.utils.SortedListOf;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static com.example.tests.GroupDataGenerator.loadGroupsFromXmlFile;
import static com.example.tests.GroupDataGenerator.loadGroupsFromCsvFile;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.*;

public class GroupCreationTest extends TestBase {
	
	@DataProvider
	public Iterator<Object[]> groupsFromFile() throws IOException {
		return wrapGroupsForDataProvider(loadGroupsFromCsvFile(new File("groups.csv"))).iterator();
	}


	@Test(dataProvider = "groupsFromFile")
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
