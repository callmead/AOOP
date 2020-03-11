//package beximtex;
/**
 * <p>Title: BeximTex, Department Manager</p>
 * <p>Description: Support Software System</p>
 * <p>Copyright: 2006-2010</p>
 * <p>Company: ASKA</p>
 * @author Adeel Ashraf Malik
 * @version 1.0.0
 */

import java.io.Serializable;

public class Department implements Serializable
{//Class

 private String f_Department;

 /**
  * Default Constructor With no parameter
  *
  */

 public Department()
 {//Default Constructor...

  f_Department = "";

 }//END Default Constructor...


 /**
  * Constructor with parameter
  *
  */

 public Department(Department dep)
 {//Constructor...

  f_Department = dep.f_Department;

 }//END Constructor...


    //Setting Values...
 public void setDepartment(String Department)
 { f_Department=Department; }

    //Get Methods...
 public String getDepartment(){ return f_Department; }

}//Class