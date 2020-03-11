//package beximtex;
/**
 * <p>Title: BeximTex, BU Manager</p>
 * <p>Description: Support Software System</p>
 * <p>Copyright: 2006-2010</p>
 * <p>Company: ASKA</p>
 * @author Adeel Ashraf Malik
 * @version 1.0.0
 */

import java.io.Serializable;

public class BU implements Serializable
{//Class

 private String f_BU;

 /**
  * Default Constructor With no parameter
  *
  */

 public BU()
 {//Default Constructor...

  f_BU = "";

 }//END Default Constructor...


 /**
  * Constructor with parameter
  *
  */

 public BU(BU dep)
 {//Constructor...

  f_BU = dep.f_BU;

 }//END Constructor...


    //Setting Values...
 public void setBU(String BU)
 { f_BU=BU; }

    //Get Methods...
 public String getBU(){ return f_BU; }

}//Class