<%@ page import="com.google.mvc.dto.TbFoodDto" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    TbFoodDto dto = (TbFoodDto)request.getAttribute("food");
%>
<jsp:include page="header.jsp" />
    <div id="what-the-hell-is-this">
        <div class="page-title">
            <h2>검색</h2>
            <div class="form-inline">
                <div class="form-group">
                    <label for="search"></label>
                    <input type="text" class="form-control" id="search" placeholder="검색어" name="search">
                </div>
                <button id="searchBtn" type="button" class="btn btn-primary">검색</button>
            </div>
        </div>
        <div id="shownews"></div>
    </div>
</div>

<script>
    $(document).ready(function(){
        alert("페이지 로드");
        $("#searchBtn").click(function(){
            alert("버튼클릭");
            var s = $("#search").val();
            $.post("searchnext.gg",
                {
                    search: s
                },
                function(data, status){
                // console.log(data);
                    $.each(data.items, function(i, field){
                        var html = "<a href='" + field.link +"'>" + field.title + "</a><br>";
                        $("#shownews").append(html);
                    });
                });
        });
    });


</script>
</body>
</html>