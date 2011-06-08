<%
session.invalidate();
response.sendRedirect("/TokenService/jsp/openid/consumer/index.jsp");
%>