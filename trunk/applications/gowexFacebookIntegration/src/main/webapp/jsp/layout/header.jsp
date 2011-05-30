<%-- 
    Document   : header
    Created on : 09-dic-2010, 15:15:01
    Author     : rafael
--%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div id="cabecera">

<img src="../../images/cabecera.gif" />


<div>
<ul>
        <c:url var="loguot" value="/logout.do"/>
        <c:url var="help" value="/help.do"/>
        
	<li> 902 108 295 | </li>
	<li><a target="_blank" href="${help}"><bean:message key="index.link.ayuda" /> | </a></li>
	<li><a href="${loguot}"><bean:message key="disconnect" /></a></li>
</ul>
</div>

        <div class="limpiar"></div>
		<div id="infoUser"> 
		        <span class="user"> ${ACEGI_SECURITY_CONTEXT.authentication.principal}</span>
		</div>
        <div class="limpiar"></div>

</div>