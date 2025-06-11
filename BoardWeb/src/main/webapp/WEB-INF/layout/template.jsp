<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 밑 3 http://localhost:8080/BoardWeb/user.tiles-->    
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Simple Sidebar - Start Bootstrap Template</title>
        <!-- Favicon-->
        <link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
        <!-- Core theme CSS (includes Bootstrap)../-->
        <link href="css/styles.css" rel="stylesheet" />
    </head>
    <body>
        <div class="d-flex" id="wrapper">
        <!-- menu.jsp-->
        
           <tiles:insertAttribute name="menu"/>
            <!-- Page content wrapper-->
            <div id="page-content-wrapper">
				<!-- header.jsp -->
				<tiles:insertAttribute name="header"/>
				
                <!-- Page content-->
                <!-- body.jsp -->
                <div class="container-fluid">
                <tiles:insertAttribute name="body"/>

                </div>
            </div>
        </div>
        <!-- footer.jsp -->
		<tiles:insertAttribute name="footer"></tiles:insertAttribute>
    </body>
</html>
<!-- 일반사용자용 -->