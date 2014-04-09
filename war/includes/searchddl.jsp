<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>

<c:if test="${not empty sessionScope.welcome_logging}">
<div class="collapse navbar-collapse">
	<ul class="nav navbar-nav navbar-right">
		 <li class="dropdown" data-dropdown="dropdown">
			<a href="#" class="dropdown-toggle" data-toggle="dropdown">
			  <span class="glyphicon glyphicon-user"></span>
			  <span class="user_name">
			  <c:out value="${sessionScope.welcome_logging}" ></c:out></span>
			  <b class="caret"></b>
			</a>
			<ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu">
				<li><a href="./my_profile.html">My profile</a></li>
				<li class="divider"></li>
				<li><a>Schedule</a></li>
				<li><a href="./schedule/scheduling_common_time.html" >Find Common Time</a></li>
				<li><a href="./schedule/schedule.html">Find a Study Group</a></li>
				<li class="divider"></li>
				<li><a>Tutor</a></li>
				<li><a href="./tutor/tutoring_hunting.html" >Find a Tutor</a></li>
				<li><a href="./tutor/tutoring_providing.html" >Provide a Tutor</a></li>
				<li class="divider"></li>
				<li><a>Trading Textbook</a></li>
				<li><a href="./textbook/sell_a_textbook.html" >Sell a Book</a></li>
				<li><a href="./textbook/find_a_textbook.html" >Find a Book</a></li>
				<li class="divider"></li>
				<li><a target="_self" href="./logout.html">Log out</a></li>
			</ul>	
		</li>
	</ul>
</div>
</c:if>