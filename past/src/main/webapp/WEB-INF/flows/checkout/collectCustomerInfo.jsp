<html>
<head>
 <%@ include file="/WEB-INF/pages/links.jsp" %> 
<%@ page isELIgnored="false" %>
</head>
<body>
<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Cutomer</h1>


            <p class="lead">Customer Details:</p>
        </div>

        <form:form commandName="order.bid" modelAttribute="order" class="form-horizontal">

        <h3>Basic Info:</h3>

        <div class="form-group">
            <label for="name">Name</label>
            <form:input path="bid.bname" id="name" class="form-Control" />
        </div>

        <%-- <div class="form-group">
            <label for="email">Email</label>
            <form:input path="customer.users.email" id="email" class="form-Control" />
        </div> --%>

        <div class="form-group">
            <label for="phone">Phone</label>
            <form:input path="contact" id="phone" class="form-Control" />
        </div>

        <br/>

        <h3>Billing Address:</h3>

        <div class="form-group">
            <label for="billingStreet">Address Lane</label>
            <form:input path="addresslane" id="billingStreet" class="form-Control" />
        </div>

        <div class="form-group">
            <label for="billingApartmentNumber">Apartment Number</label>
            <form:input path="doorno" id="billingApartmentNumber" class="form-Control" />
        </div>

        <div class="form-group">
            <label for="billingCity">City</label>
            <form:input path="city" id="billingCity" class="form-Control" />
        </div>

        <div class="form-group">
            <label for="billingState">State</label>
            <form:input path="state" id="billingState" class="form-Control" />
        </div>

        <%-- <div class="form-group">
            <label for="billingCountry">Country</label>
            <form:input path="cart.customer.billingAddress.country" id="billingCountry" class="form-Control" />
        </div>
 --%>
        <div class="form-group">
            <label for="billingZip">Zipcode</label>
            <form:input path="pincode" id="billingZip" class="form-Control" />
        </div>

        <input type="hidden" name="_flowExecutionKey" />

        <br/><br/>
        <!--  on attribute - assign event id -->
        <!--  to attribute id value in state -->

        <input type="submit" value="Next" class="btn btn-default" name="_eventId_customerInfoCollected" />

        <button class="btn btn-default" name="_eventId_cancel">Cancel</button>

        </form:form>

<%-- <%@ include file="/WEB-INF/views/footer.jsp" %> --%>
</body>
</html>