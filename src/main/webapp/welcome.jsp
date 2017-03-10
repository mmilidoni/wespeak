<%@ taglib prefix="s" uri="/struts-tags" %>

<s:if test="loggedUser == null">
<%
    response.sendRedirect("home");
%>
</s:if>
<s:else>
<%
    response.sendRedirect("userHome");
%>
</s:else>