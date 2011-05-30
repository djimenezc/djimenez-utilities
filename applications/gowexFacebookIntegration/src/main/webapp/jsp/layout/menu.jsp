<%-- 
    Document   : menu
    Created on : 13-dic-2010, 16:28:41
    Author     : rafael
--%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://struts-menu.sf.net/tag" prefix="menu" %>


<script src="../../js/nicetabs.js" type="text/javascript"></script>

<menu:useMenuDisplayer name="TabbedMenu"
  bundle="org.apache.struts.action.MESSAGE" >
  <menu:displayMenu name="indexMenu"/>
  <menu:displayMenu name="signupMenu"/>
  <menu:displayMenu name="rechargeMenu"/>
  <menu:displayMenu name="hireMenu"/>
  <menu:displayMenu name="historicMenu"/>
</menu:useMenuDisplayer>