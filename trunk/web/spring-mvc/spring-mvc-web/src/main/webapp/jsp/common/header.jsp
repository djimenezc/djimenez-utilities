<%@ include file="/jsp/common/taglibs.jsp"%>

<c:if test="${pageContext.request.locale.language NE 'en'}">
	<div id="switchLocale"><a href="<c:url value='/?locale=en'/>"><fmt:message
		key="webapp.name" /> in English</a></div>
</c:if>

<div id="branding">
<h1><a href="<c:url value='/'/>"><fmt:message key="webapp.name" /></a></h1>


<!--<div class="block block-block region-even even region-count-2 count-2"-->
<!--	id="block-block-29">-->

<p><a href="/wifimas-network" class="texto-fuera"
	id="link-red-wifi-gowex"> <fmt:message key="webapp.gowex.network" />
</a></p>
<!--</div>--> <!--    <p><fmt:message key="webapp.tagline"/></p>--></div>
<hr />

<%-- Put constants into request scope --%>
<djimenez:constants scope="request" />