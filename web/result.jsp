<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="model.PlayRoom" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="language" value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}" scope="session" />
<fmt:setLocale value="${language}" />
<fmt:setBundle basename="resources.text" />
<html lang="${language}">
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css" integrity="sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ" crossorigin="anonymous">
    <link rel="stylesheet" href="css/main.css">
    <link rel="icon" href="images/icon.png" type="image/png" sizes="16x16">
    <script src="https://code.jquery.com/jquery-3.1.1.slim.min.js" integrity="sha384-A7FZj7v+d/sdmMqp/nOQwliLvUsJfDHW+k9Omg/a/EheAdgtzNs3hpfag6Ed950n" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js" integrity="sha384-vBWWzlZJ8ea9aCX4pEW3rVHjgjt7zpkNpZk+02D9phzyeVkE+jo0ieGizqPLForn" crossorigin="anonymous"></script>
    <script src="js/library.js"></script>
    <title>Process User</title>
</head>
<body>
        <jsp:useBean id="playRoom" class="model.PlayRoom" scope="application"/>

        <div class="jumbotron">
            <div class="alert alert-success" role="alert">
                <h3><strong>Well done!</strong> You successfully created new PlayRoom.</h3>
            </div>
            <hr class="my-4">
            <h4 align="center">Your Room Cost: ${playRoom.moneyAmount}</h4>
            <h4 align="center">Toys in your room: ${playRoom.allToys.size()} </h4>
        </div>
        <div class="container">
            <div class="row">
                <div class="col-sm-4">
                    <div class="container myContainer">
                        <form action="playRoom" method="post">
                            <h4 align="center">Sort All Toys by Price</h4>
                            <input type="hidden" name="sort" value="Price">
                            <div class="form-group row">
                                <div class="offset-sm-4 col-sm-6 offset-sm-2">
                                    <button type="submit" class="btn btn-primary">Sort Toys</button>
                                </div>
                            </div>
                        </form>
                        <form action="playRoom" method="post">
                            <h4 align="center">Sort All Toys by Size</h4>
                            <input type="hidden" name="sort" value="Size">
                            <div class="form-group row">
                                <div class="offset-sm-4 col-sm-6 offset-sm-2">
                                    <button type="submit" class="btn btn-primary">Sort Toys</button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
                <div class="col-sm-8">
                    <c:forEach var="toy" items="${playRoom.allToys}">
                        <div class="container myContainer" style="width: 75%">
                            <div class="row">
                                <div class="col-sm-3">
                                    <p>Toy Name: <strong><c:out value="${toy.name}" /></strong></p>
                                </div>
                                <div class="col-sm-3">
                                    <p>Price: <strong><c:out value="${toy.cost}"/></strong></p>
                                </div>
                                <div class="col-sm-3">
                                    <p>Age Group: <strong><c:out value="${toy.ageGroup}"/></strong></p>
                                </div>
                                <div class="col-sm-3">
                                    <p>Size: <strong><c:out value="${toy.size}"/></strong></p>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                </div>
            </div>
        </div>
</body>
</html>
