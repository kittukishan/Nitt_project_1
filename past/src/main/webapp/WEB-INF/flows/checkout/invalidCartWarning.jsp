<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
 <%@ include file="/WEB-INF/pages/links.jsp" %> 

<%@ page isELIgnored="false" %>
<div class="container-wrapper">
    <div class="container">
        <section>
            <div class="jumbotron">
                <div class="container">
                    <h1>Your cart is empty. Please add items to cart before checkout.</h1>
                </div>
            </div>
        </section>

        <section class="container">
            <p><a href="<spring:url value="displayUserHome" />" class="btn btn-default">Browse Toys</a></p>
        </section>

<%-- <%@ include file="/WEB-INF/views/footer.jsp" %> --%>