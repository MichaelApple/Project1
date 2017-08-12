<%@ page import="java.util.ResourceBundle" %><%--
  Created by IntelliJ IDEA.
  User: Miha
  Date: 31.07.2017
  Time: 9:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="language" value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}" scope="session" />
<fmt:setLocale value="${language}" />
<fmt:setBundle basename="resources.text" />
<html lang="${language}">
<html>
  <head>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css" integrity="sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ" crossorigin="anonymous">
    <link rel="stylesheet" href="css/main.css">
    <script src="https://code.jquery.com/jquery-3.1.1.slim.min.js" integrity="sha384-A7FZj7v+d/sdmMqp/nOQwliLvUsJfDHW+k9Omg/a/EheAdgtzNs3hpfag6Ed950n" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js" integrity="sha384-vBWWzlZJ8ea9aCX4pEW3rVHjgjt7zpkNpZk+02D9phzyeVkE+jo0ieGizqPLForn" crossorigin="anonymous"></script>
    <script src="js/library.js"></script>

    <title>Play Room</title>
  </head>
  <body>
  <div class="container myContainer" style="width: 50%">
    <br>
    <h2 align="center"><fmt:message key="enter.data" /></h2>
    <br>
    <form>
      <select id="language" name="language" onchange="submit()">
        <option value="en" ${language == 'en' ? 'selected' : ''}>English</option>
        <option value="ua" ${language == 'ua' ? 'selected' : ''}>Українська</option>
      </select>
    </form>
    <br><br>
    <form action="playRoom" method="post">
      <div class="form-group row">
        <label for="roomPrice" class="col-sm-4 col-form-label"><fmt:message key="label.roomPrice" /></label>
        <div class="col-sm-8">
          <input type="text" class="form-control " id="roomPrice" placeholder="<fmt:message key="form.input.roomPrice" />" name="roomPrice" required>
        </div>
      </div>
      <div class="form-group row">
        <div class="offset-sm-4 col-sm-6 offset-sm-2">
          <button type="submit" class="btn btn-primary"><fmt:message key="button.senddata"/></button>
        </div>
      </div>
    </form>
  </div>
  </body>
</html>
