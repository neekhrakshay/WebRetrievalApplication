<%-- 

    Document   : Retrievaljsp
    Created on : 9 Aug, 2017, 11:52:38 PM
    Author     : Akshay Neekhra
--%>
<%@page import ="java.sql.*" %>
<% Class.forName ("com.mysql.jdbc.Driver"); %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Retrieval Page</title>
    </head>
    <body>
        <h1>Retrieving data</h1>
        <%! public class user{
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
        %>
        <%!
            user user1 = new user();
          ResultSet users =  user1. getUser();
          
            
%>
<table border="1">
   
    <tbody>
        <tr>
            <td>Name</td>
            <td>Account</td>
            <td>Amount</td>
        </tr>
        <% while (users.next()){%>
        <tr>
            <td><%=users.getString("Name")%></td>
            <td><%=users.getInt("Account")%></td>
            <td><%=users.getInt("Amount")%></td>
        </tr>
        <% } %>
    </tbody>
</table>

    </body>
</html>
