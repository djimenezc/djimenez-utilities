<%@ include file="/WEB-INF/jsp/include.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
  <title>Simple Text Generation Demo</title>
  <meta http-equiv="Content-Type" content="text/html; charset=us-ascii" />
  
<script type='text/javascript' src='<c:url value="/scripts/dwr/EchoDwr.js"/>'></script>
<script type='text/javascript' src='<c:url value="/scripts/dwr/People.js"/>'></script>
<script type='text/javascript' src='<c:url value="/dwr/interface/EchoDwr.js"/>'></script>
<script type='text/javascript' src='<c:url value="/dwr/interface/People.js"/>'></script>
<script type='text/javascript' src='<c:url value="/dwr/engine.js"/>'></script>
<script type='text/javascript' src="<c:url value="/dwr/util.js"/>"></script>

<link rel="stylesheet" type="text/css" href="<c:url value="/styles/generic.css"/>" />

<%-- DWR AJAX setup --%>
<script type="text/javascript">
		
function init() {
  dwr.util.useLoadingMessage();
  fillTable();
  //var aux= People.getAllPeople();
}

</script>
  
</head>
<body onload="init();">

<jsp:include page="/WEB-INF/jsp/header.jsp"></jsp:include>


<div id="helloSample">
<h1>Echo jsp</h1>
  
  <p>
  Name:
  <input type="text" id="demoName"/>
  <input value="Send" type="button" onclick="update()"/>
  <br/>
  Reply: <span id="demoReply"></span>
</p>
</div>

<div id="peopleSample">
<h3>All People</h3>
<table border="1" class="rowed grey">
  <thead>
    <tr>
      <th>Person</th>
      <th>Salary</th>
      <th>Actions</th>
    </tr>
  </thead>
  <tbody id="peoplebody">
    <tr id="pattern" style="display:none;">
      <td>
        <span id="tableName">Name</span><br/>
        <small>  <span id="tableAddress">Address</span></small>
      </td>
      <td>$<span id="tableSalary">Salary</span></td>
      <td>
        <input id="edit" type="button" value="Edit" onclick="editClicked(this.id)"/>
        <input id="delete" type="button" value="Delete" onclick="deleteClicked(this.id)"/>
      </td>
    </tr>
  </tbody>
</table>

<h3>Edit Person</h3>
<table class="plain">
  <tr>
    <td>Name:</td>
    <td><input id="name" type="text" size="30"/></td>
  </tr>
  <tr>
    <td>Salary:</td>
    <td>$<input id="salary" type="text" size="20"/></td>
  </tr>
  <tr>
    <td>Address:</td>
    <td><input type="text" id="address" size="40"/></td>
  </tr>
  <tr>
    <td colspan="2" align="right">
      <small>(ID=<span id="id">-1</span>)</small>
      <input type="button" value="Save" onclick="writePerson()"/>
      <input type="button" value="Clear" onclick="clearPerson()"/>
   </td>
  </tr>
</table>
</div>

<jsp:include page="/WEB-INF/jsp/footer.jsp"></jsp:include>
</body>
</html>