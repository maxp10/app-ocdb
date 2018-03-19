<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="en">
  <head>
    <title>Spring BRO</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link rel="stylesheet" href="http://twitter.github.com/bootstrap/assets/css/bootstrap.css"/>
  </head>

  <body>
    <div class="container">

      <div class="hero-unit">
	<h1>SPRING BRO</h1>
	<p>I WROTE THIS APP IN '94</p>
      </div>

      <form:form commandName="newBeer" id="reg">
	<h2>Beer Registration</h2>
	<p>Enforces annotation-based constraints defined on the model class.</p>
	<table>
	  <tbody>
	    <tr>
	      <td><form:label path="name">Name:</form:label></td>
	      <td><form:input path="name"/></td>
	      <td><form:errors class="invalid" path="name"/></td>
	    </tr>
	    <tr>
	      <td><form:label path="rating">Rating:</form:label></td>
	      <td><form:input path="rating"/></td>
	      <td><form:errors class="invalid" path="rating"/></td>
	    </tr>
	  </tbody>
	  <br />
	</table>
	<table>
	  <tr>
	    <td>
	      <input type="submit" value="Register" class="register"/>
	    </td>
	  </tr>
	</table>
      </form:form>
      <h2>Beers</h2>
      <c:choose>
	<c:when test="${beers.size()==0}">
	  <em>No registered beers.</em>
	</c:when>
	<c:otherwise>
	  <table class="simpletablestyle">
	    <thead>
	      <tr>
		<th>Id</th>
		<th>Name</th>
		<th>Rating</th>
		<th>REST URL</th>
	      </tr>
	    </thead>
	    <tbody>
	      <c:forEach items="${beers}" var="beer">
		<tr>
		  <td>${beer.id}</td>
		  <td>${beer.name}</td>
		  <td>${beer.rating}</td>
		  <td><a href="<c:url value="/rest/beers/${beer.id}"/>">/rest/beers/${beer.id}</a></td>
	      </c:forEach>
	    </tbody>
	  </table>
	  <table class="table table-striped">
	    <tr>
	      <td>
		REST URL for all beers: <a href="<c:url value="/rest/beers"/>">/rest/beers</a>
	      </td>
	    </tr>
	  </table>
	</c:otherwise>
      </c:choose>
    </div>
  </body>
</html>
