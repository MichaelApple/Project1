<%@include file="header.jsp"%>
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
