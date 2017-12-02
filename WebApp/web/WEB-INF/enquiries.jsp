
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../header.jsp" %>

<h1>Enquiries</h1>

<div class="pull-right">
                <p>
                    <a href="./enquiry/add" class="btn btn-primary btn-lg">
                        <span class="glyphicon glyphicon-plus"></span>Add Enquiry</a>
                </p>
</div>

<table class="table table-striped table-bordered table-hover">
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Email</th>
        <th>Contact No.</th>
        <th>Status</th>
    </tr>
    <c:forEach var="enq" items="${requestScope.enquiries}">
    <tr>
        <th>${enq.id}</th>
        <th>${enq.firstName} ${enq.lastName}</th>
        <th>${enq.email}</th>
        <th>${enq.contactNo}</th>
        <th>${enq.status}</th>
    </tr>
    </c:forEach>
</table>
</div>
</body>
</html>