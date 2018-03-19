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

      <form:form commandName="newMember" id="reg">
	<h2>Member Registration</h2>
	<p>Enforces annotation-based constraints defined on the model class.</p>
	<table>
	  <tbody>
	    <tr>
	      <td><form:label path="name">Name:</form:label></td>
	      <td><form:input path="name"/></td>
	      <td><form:errors class="invalid" path="name"/></td>
	    </tr>
	    <tr>
	      <td><form:label path="email">Email:</form:label></td>
	      <td><form:input path="email"/></td>
	      <td><form:errors class="invalid" path="email"/></td>
	    </tr>
	    <tr>
	      <td><form:label path="phoneNumber">Phone #:</form:label>
	      <td><form:input path="phoneNumber"/></td>
	      <td><form:errors class="invalid" path="phoneNumber"/></td>
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
      <h2>Members</h2>
      <c:choose>
	<c:when test="${members.size()==0}">
	  <em>No registered members.</em>
	</c:when>
	<c:otherwise>
	  <table class="simpletablestyle">
	    <thead>
	      <tr>
		<th>Id</th>
		<th>Name</th>
		<th>Email</th>
		<th>Phone #</th>
		<th>REST URL</th>
	      </tr>
	    </thead>
	    <tbody>
	      <c:forEach items="${members}" var="member">
		<tr>
		  <td>${member.id}</td>
		  <td>${member.name}</td>
		  <td>${member.email}</td>
		  <td>${member.phoneNumber}</td>
		  <td><a href="<c:url value="/rest/members/${member.id}"/>">/rest/members/${member.id}</a></td>
	      </c:forEach>
	    </tbody>
	  </table>
	  <table class="table table-striped">
	    <tr>
	      <td>
		REST URL for all members: <a href="<c:url value="/rest/members"/>">/rest/members</a>
	      </td>
	    </tr>
	  </table>
	</c:otherwise>
      </c:choose>
    </div>
  </body>
</html>
