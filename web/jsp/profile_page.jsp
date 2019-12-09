<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Peng Deng
  Date: 2019/7/21
  Time: 14:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Friend</title>
    <link href="../font/font-awesome-4.7.0/css/font-awesome.min.css" rel="stylesheet">
    <link rel="stylesheet" href="../css/bootstrap.min.css">
    <link rel="stylesheet" href="../css/util.css">
    <link rel="stylesheet" href="../css/profile.css">
    <script type="text/javascript" rel="script" src="../js/jquery-3.3.1.min.js"></script>
    <script type="text/javascript" rel="script" src="../js/popper.min.js"></script>
    <script type="text/javascript" rel="script" src="../js/bootstrap.min.js"></script>
</head>
<body>
<jsp:include page="../inc/header.inc.jsp"/>
<main>
    <section class="profile">
        <header class="header">
            <div class="details">
                <img src="../img/019070.jpg" alt="John Doe" class="profile-pic">
                <h1 class="heading">${friend.username}</h1>
                <div class="signature">
                    <p>${friend.signature}</p>
                </div>
                <div class="stats">
                    <div class="col-4">
                        <h6><i class="fa fa-envelope-o" aria-hidden="true"></i> Email</h6>
                        <p>${friend.email}</p>
                    </div>
                    <div class="col-4">
                        <h6><i class="fa fa-phone-square" aria-hidden="true"></i> Phone</h6>
                        <p>${friend.phone}</p>
                    </div>
                    <div class="col-4">
                        <h6><i class="fa fa-map-marker" aria-hidden="true"></i> Address</h6>
                        <p>${friend.address}</p>
                    </div>
                </div>
            </div>
        </header>
    </section>
    <section class="container">
        <div class="my-3">
            <h3>最近收藏:</h3>
        </div>
        <div class="row">
        </div>
        <div class="my-3">
            <a class="btn btn-primary" href="profile_page.jsp" role="button">返回</a>
        </div>
    </section>
</main>
<jsp:include page="../inc/footer.inc.jsp"/>
</body>
</html>
