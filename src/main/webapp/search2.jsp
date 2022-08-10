<%@ page import="com.google.mvc.dto.TbFoodDto" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    TbFoodDto dto = (TbFoodDto)request.getAttribute("food");
%>
<jsp:include page="header.jsp" />
    <div id="what-the-hell-is-this">
        <div class="page-title">
            <h2>검색</h2>
            <form class="form-inline" action="search.gg" method="post">
                <div class="form-group">
                    <label for="search"></label>
                    <input type="text" class="form-control" id="search" placeholder="검색어" name="search">
                </div>
                <button id="searchBtn" type="button" class="btn btn-primary">검색</button>
            </form>
        </div>
        <div id="shownews"></div>
    </div>
</div>

<script>
    $(document).ready(function(){
        var s = $("#search").text();
        // alert(s);
        $.getJSON("search.gg?search=" + s, function(result){
            $.each(result.items, function(i, field){
                var html = "<a href='" + field.link +"'>" + field.title + "</a><br>";
                $("div").append(html);
            });
        });
    });
</script>


</script>
</body>
</html>