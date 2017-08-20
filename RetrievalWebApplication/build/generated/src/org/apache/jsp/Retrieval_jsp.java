package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;

public final class Retrieval_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

 public class user{
            String URL = "jdbc:mysql://localhost:3306/transaction";
            String USERNAME = "root";
            String  Password = "root";
            
            Connection connection = null;
            PreparedStatement selectUser = null;
            ResultSet resultset = null;
            public user()
            {
                try{
                    connection = DriverManager.getConnection(URL, USERNAME, Password);
                    selectUser =connection.prepareStatement("Select * from mytransaction");
                    
                } catch (SQLException e)
                {
                    e.printStackTrace();
                }
            }
            
            public ResultSet getUser()
            {
                try {
                    resultset = selectUser.executeQuery();
                }
                    
                
             catch (SQLException e)
             {             
                  e.printStackTrace();
                }
                return resultset ;
        }
        
        }
        

            user user1 = new user();
          ResultSet users =  user1. getUser();
          
            

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write('\n');
      out.write('\n');
 Class.forName ("com.mysql.jdbc.Driver"); 
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Retrieval Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h1>Retrieving data</h1>\n");
      out.write("        ");
      out.write("\n");
      out.write("        ");
      out.write("\n");
      out.write("<table border=\"1\">\n");
      out.write("   \n");
      out.write("    <tbody>\n");
      out.write("        <tr>\n");
      out.write("            <td>Name</td>\n");
      out.write("            <td>Account</td>\n");
      out.write("            <td>Amount</td>\n");
      out.write("        </tr>\n");
      out.write("        ");
 while (users.next()){
      out.write("\n");
      out.write("        <tr>\n");
      out.write("            <td>");
      out.print(users.getString("Name"));
      out.write("</td>\n");
      out.write("            <td>");
      out.print(users.getInt("Account"));
      out.write("</td>\n");
      out.write("            <td>");
      out.print(users.getInt("Amount"));
      out.write("</td>\n");
      out.write("        </tr>\n");
      out.write("        ");
 } 
      out.write("\n");
      out.write("    </tbody>\n");
      out.write("</table>\n");
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
