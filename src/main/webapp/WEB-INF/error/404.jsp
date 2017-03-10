<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>

<tiles:insertTemplate template="/WEB-INF/layouts/basicLayout.jsp" flush="true">
    <tiles:putAttribute name="title" value="404 Page" />
    <tiles:putAttribute name="content" type="string">
        <div class="error-page">
            <div class="error-inner">
                <div class="container">
                    <h1><i class="fa fa-chain-broken" aria-hidden="true"></i>Error 404</h1>
                    <h5>Uh Oh! The Page You're looking for no longer exist.</h5>
                    <div class="clearfix"></div>
                    <a class="button-medium button-yellow" href="<s:url value="/" />">View Homepage</a>
                </div>
            </div>
        </div>
    </tiles:putAttribute>
</tiles:insertTemplate>