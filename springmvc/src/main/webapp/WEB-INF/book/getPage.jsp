<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="<c:out value="${pageContext.request.contextPath}"/>/styles/displaytag.css"/>
<title>JDAL Spring MVC and DisplayTag Sample</title>
</head>
<body>
<H1>JDAL Spring MVC and DisplayTag Sample</H1>

<form:form commandName="bookFilter" action="getPage" method="POST">
      <table>
          <tr>
              <td>Book Title:</td>
              <td><form:input path="name" /></td>
          </tr>
          <tr>
              <td>Category:</td>
              <td><form:select path="category">
                <form:option value="0">--Please Select</form:option>
                <form:options items="${categoryList}" itemValue="id" itemLabel="name" /><
                </form:select>
              </td>
          </tr>
           <tr>
              <td>ISBN:</td>
              <td><form:input path="isbn" /></td>
          </tr>
           <tr>
              <td>Author Name:</td>
              <td><form:input path="authorName" /></td>
          </tr>
           <tr>
              <td>Author Surname:</td>
              <td><form:input path="authorSurname" /></td>
          </tr>
          <tr>
              <td colspan="2">
                  <input type="submit" value="Apply Filter" />
              </td>
          </tr>
      </table>
  </form:form>
  
  <br>
 
  <display:table name="paginatedList" requestURI="getPage" >
    <display:column property="id" title="ID" sortable="true" style="width:80px" />
    <display:column property="name" title="Title" sortable="true" style="width:300px "/>
    <display:column property="category" title="Category" sortable="true" sortProperty="category.name" style="width:200px"/>
    <display:column property="author" title="Author" sortable="true" sortProperty="author.surname" style="width:200px" />
    <display:column property="isbn" title="ISBN" sortable="true" style="width:180px"/>
</display:table>

</body>
</html>