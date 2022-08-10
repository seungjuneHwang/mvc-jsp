<%@ page import="com.google.mvc.dto.TbFoodDto" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    TbFoodDto dto = (TbFoodDto)request.getAttribute("food");
%>

    <jsp:include page="header.jsp" />
    <div id="what-the-hell-is-this">
        <div class="page-title">
            <h2>음식추천</h2>
            <p class="lead">
                <%=dto.getName()%> 드세요~
            </p>
            <img src="<%=dto.getImg()%>" class="rounded" alt="<%=dto.getName()%>" width="640" height="480">
        </div>
        </div>
    </div>
</div>

</body>
</html>