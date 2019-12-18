package test.main.fudan.CourseSelectionSystem.dao.Impl; 

import main.fudan.CourseSelectionSystem.dao.Impl.StudentDaoImpl;
import main.fudan.CourseSelectionSystem.dao.Impl.TakesDaoImpl;
import main.fudan.CourseSelectionSystem.dao.StudentDao;
import main.fudan.CourseSelectionSystem.dao.TakesDao;
import main.fudan.CourseSelectionSystem.entity.Takes;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;

import java.sql.Date;

/** 
* TakesDaoImpl Tester. 
* 
* @author <Authors name> 
* @since <pre>十二月 7, 2019</pre> 
* @version 1.0 
*/ 
public class TakesDaoImplTest { 

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: getTakes(String studentID, int courseID, int sectionID, int year, String semester) 
* 
*/ 
@Test
public void testGetTakes() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: updateTakes(Takes takes) 
* 
*/ 
@Test
public void testUpdateTakes() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: addTakes(Takes takes) 
* 
*/ 
@Test
public void testAddTakes() throws Exception { 
//TODO: Test goes here...
    TakesDao takesDao = new TakesDaoImpl();
    Takes takes = new Takes("S10000001", 102537, 1, 2019, "春季", "U", false);
    takesDao.addTakes(takes);
} 

/** 
* 
* Method: dropSection(String studentID, int courseID, int sectionID, int year, String semester) 
* 
*/ 
@Test
public void testDropSection() throws Exception { 
    TakesDao takesDao = new TakesDaoImpl();
    Takes takes = new Takes("S10000001", 102537, 1, 2019, "春季", "U", false);
    takesDao.dropSection("S10000001", 102536, 1, 2019, "春季");
} 

/** 
* 
* Method: getTimeConflictSectionList(String studentID, int courseID, int sectionID, int year, String semester) 
* 
*/ 
@Test
public void testGetTimeConflictSectionList() throws Exception {
    TakesDao takesDao = new TakesDaoImpl();
    System.out.println(takesDao.getTimeConflictSectionList("S10000001", 102537, 1, 2019, "春季"));
} 

/** 
* 
* Method: getExamConflictSectionList(String studentID, int courseID, int sectionID, int year, String semester) 
* 
*/ 
@Test
public void testGetExamConflictSectionList() throws Exception {
    TakesDao takesDao = new TakesDaoImpl();
    System.out.println(takesDao.getExamConflictSectionList("S10000001", 102537, 1, 2019, "春季"));
} 


} 
