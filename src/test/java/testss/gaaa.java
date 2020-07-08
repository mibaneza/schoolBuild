package testss;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;
public class gaaa {
	public static boolean chkEmpty(final String s) {
		return s == null || s.trim().isEmpty();
	}
	
	public static void ejemplo() {
	     String stringArray[] = {"Hello ", " how", " are", " you", " welcome", " to", " Tutorialspoint"};
	      StringBuffer sb = new StringBuffer();
	      for(int i = 0; i < stringArray.length; i++) {
	         sb.append(stringArray[i]);
	      }
	      String str = sb.toString();
	      System.out.println(str);
	   }
	
	public static void ejemplo2() {
		 StringBuffer sb = new StringBuffer();
		
	
		List<String> listCourseError =new ArrayList();		
		List<String> course =new ArrayList();	
		course.add("historia");
		course.add("geometria");
		course.add("algebra");
		course.add("historia2");
		course.add("geometria2");

		String errorCursos = "";
		for(String courses : course) {
			String forCourse = courses;
			if(forCourse == "algebra")
			{
				sb.append(courses+" ");
				forCourse = null;
			}
			if(forCourse != null)
			{
				listCourseError.add(courses);
			}
		}
		String cursosListError = sb.toString();
			if(!chkEmpty(cursosListError)) {
				errorCursos = "but not saved: "+cursosListError;
			}	
		
		System.out.println(errorCursos+"\n *****************");
		System.out.println("\n *****************");
		System.out.println(listCourseError);
	  }		
		
		
		
		
	     
	//  for(int i = 0; i < stringArray.length; i++) {
	  //    sb.append(stringArray[i]);
	    //  }
		
	
	/*		
	      String str = sb.toString();
	 	 if(str != " " || str != null) {
			 System.out.println("esta vcio");
		 }
	      System.out.println(str);*/
	 
	
	
	
	   public static void main(String args[]) {
		   ejemplo2();
		}	
	}