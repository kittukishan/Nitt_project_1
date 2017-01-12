<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
 <%@ include file="/WEB-INF/pages/links.jsp" %> 
<%@ page isELIgnored="false" %>
<div class="container-wrapper">
    <div class="container">
        <section>
            <div class="jumbotron">
                <div class="container">
                    <h1>Thank you for placing order in BuyToys.com</h1>
                    <br>
					<h2>Your order details have been mailed to your registered email id.</h2>
                    <p>Your order will be shipped in next few days.</p>
                </div>
            </div>
        </section>

        <section class="container">
            <p><a href="<spring:url value="displayUserHome" />" class="btn btn-default">OK</a></p>
        </section>

<%--  <%@ include file="/WEB-INF/views/footer.jsp" %> --%>