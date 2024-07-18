<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../include/header.jsp" />

<h1 class="page-title">This is a customer detail page</h1>

<section>
    <div class="row pt-5">
        <div class="col-12">
            <h2 class="text-center">Customer: ${customer.customerName}</h2>
        </div>
    </div>


</section>


<section>
    <div class="container">
        <div class="row pt-5">
            <div class="col-12">
                <h2 class="text-center">Customer Information</h2>
            </div>
        </div>
        <div class="row pt-3">
            <div class="col-12">
                <table class="table">
                    <tr>
                        <th>ID</th>
                        <th>Customer Name</th>
                        <th>Contact Name</th>
                        <th>Phone</th>
                        <th>Address Line One</th>
                        <th>Address Line Two</th>
                        <th>City</th>
                        <th>State</th>
                        <th>Postal Code</th>
                        <th>Country</th>
                        <th>Sales Rep Employee</th>

                    </tr>
                    <tr>
                        <td>${customer.id}</td>
                        <td>${customer.customerName}</td>
                        <td>${customer.contactFirstName} ${customer.contactLastName}</td>
                        <td>${customer.phone}</td>
                        <td>${customer.addressLineOne}</td>
                        <td>${customer.addressLineTwo}</td>
                        <td>${customer.city}</td>
                        <td>${customer.state}</td>
                        <td>${customer.postalCode}</td>
                        <td>${customer.country}</td>
                        <td><a href="${pageContext.request.contextPath}/employee/detail?employeeId=${customer.salesRepEmployeeId}">
                            ${customer.salesRepEmployeeId}
                        </a></td>

                    </tr>
                </table>
            </div>
        </div>
    </div>
</section>

<section>
    <div class="container">
        <div class="row pt-5">
            <div class="col-12">
                <h2 class="text-center">Orders</h2>
            </div>
        </div>
        <div class="row pt-3">
            <div class="col-12">
                <table class="table">
                    <tr>
                        <th>Order ID</th>
                        <th>Order Date</th>
                        <th>Status</th>
                    </tr>
                    <c:forEach items="${orders}" var="order">
                        <tr>
                            <td><a href="/order/detail?orderId=${order.id}">${order.id}</a></td>
                            <td>${order.orderDate}</td>
                            <td>${order.status}</td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
    </div>
</section>


<jsp:include page="../include/footer.jsp" />