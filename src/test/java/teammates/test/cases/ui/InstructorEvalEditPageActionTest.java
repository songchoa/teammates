package teammates.test.cases.ui;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import teammates.common.datatransfer.DataBundle;
import teammates.common.datatransfer.EvaluationAttributes;
import teammates.common.util.Constants;

public class InstructorEvalEditPageActionTest extends BaseActionTest {

	DataBundle dataBundle;
	
	
	@BeforeClass
	public static void classSetUp() throws Exception {
		printTestClassHeader();
		uri = Constants.ACTION_INSTRUCTOR_EVAL_EDIT;
	}

	@BeforeMethod
	public void caseSetUp() throws Exception {
		dataBundle = getTypicalDataBundle();
		restoreTypicalDataInDatastore();
	}
	
	@Test
	public void testAccessControl() throws Exception{
		
		EvaluationAttributes evaluationInCourse1 = dataBundle.evaluations.get("evaluation1InCourse1");
		
		String[] submissionParams = new String[]{
				Constants.PARAM_COURSE_ID, evaluationInCourse1.courseId,
				Constants.PARAM_EVALUATION_NAME, evaluationInCourse1.name 
		};
		
		verifyOnlyInstructorsOfTheSameCourseCanAccess(submissionParams);
		
	}
	
	@Test
	public void testExecuteAndPostProcess() throws Exception{
		
		//TODO: implement this
	}
	

}