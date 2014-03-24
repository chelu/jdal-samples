<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="<c:out value="${pageContext.request.contextPath}"/>/styles/styles.css"/>
<title>JDAL Spring MVC and DataTable Sample</title>

<script src="<c:out value="${pageContext.request.contextPath}"/>/scripts/jdal.js"></script>
</head>
<body>

<h1>JDAL Spring MVC and YUI DataTable Sample</h1>

<form:form commandName="filter" action="getPage" method="POST">
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
  
  <div id="bookTable"></div>

<script> 


// Defer instantiation of dataTable until page is loaded
YAHOO.util.Event.addListener(window, "load", function() {
    var bookTable = new YAHOO.widget.DataTable("bookTable", cols, dataSource, {
    	generateRequest : JDAL.requestBuilder,
    	initialRequest : JDAL.requestBuilder(),	
    	dynamicData : true, // Enables dynamic server-driven data 
    	sortedBy : {
    		key : "id",
    		dir : YAHOO.widget.DataTable.CLASS_ASC
    	}, // Sets UI initial sort arrow 
    	paginator : new YAHOO.widget.Paginator( {
    		rowsPerPage : 10
    	}) // Enables pagination  
        	
	});
	// update totalRecords and startIndex
    bookTable.doBeforeLoadData = function(oRequest, oResponse, oPayload) {
        oPayload.totalRecords = oResponse.meta.totalRecords;
        oPayload.pagination.recordOffset = oResponse.meta.startIndex;
        return oPayload;
    };
});

 
// The label is the text that will be rendered in the table head
var cols = [
    { key: "id", label: "ID", sortable: "true", width: 50 },
    { key: "name", label: "Title", sortable: "true", width: 250  },
    { key: "category", label: "Category", sortable: "true", sortProperty: "category.name", width: 140  },
    { key: "author",   label: "Author", sortable: "true", sortProperty: "author.surname", width: 180  }, 
    { key: "publishedDate", label: "Published Date", sortable: "true", formatter:"date", width: 120 },
    { key: "isbn", label: "ISBN", sortable: "true", width: 180  }
];

// Custom  Date parser 
var timestampToDate = function(oData) { 
        return new Date(oData); 
 }; 

// DataSource instance
var dataSource = new YAHOO.util.DataSource("getData?");
dataSource.responseType = YAHOO.util.DataSource.TYPE_JSON;
dataSource.responseSchema = {
  resultsList: "records",
     fields: [
        {key:"id", parser:"number"},
        {key:"name"},
        {key:"publishedDate", parser:timestampToDate},
        {key:"category"},
        {key:"author"},
        {key:"isbn"}
      ],
     // Access to values in the server response
     metaFields: {
        totalRecords: "totalRecords",
        startIndex: "startIndex"
     }
 };

</script>

</body>
</html>