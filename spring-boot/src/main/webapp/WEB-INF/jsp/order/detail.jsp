<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../include/header.jsp" />

<h1 class="page-title">This is an order detail page</h1>

<section>
    <div class="row pt-5">
        <div class="col-12">
            <h2 class="text-center">Order Details</h2>
        </div>
    </div>
</section>

<section>
    <div class="container">
        <div class="row pt-5">
            <div class="col-12">
                <h2 class="text-center">Order Information</h2>
            </div>
        </div>
        <div class="row pt-3">
            <div class="col-12">
                <table class="table">
                    <tr>
                        <th>Order ID</th>
                        <th>Customer</th>
                        <th>Order Date</th>
                        <th>Status</th>
                        <th>Comments</th>
                    </tr>
                    <tr>
                        <td>${order.id}</td>
                        <td>${order.customer.customerName}</td>
                        <td>${order.orderDate}</td>
                        <td>${order.status}</td>
                        <td>${order.comment}</td>
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
                <h2 class="text-center">Order Details</h2>
            </div>
        </div>
        <div class="row pt-3">
            <div class="col-12">
                <table class="table">
                    <tr>
                        <th>Order Detail ID</th>
                        <th>Product Name</th>
                        <th>Quantity Ordered</th>
                        <th>Unit Price</th>
                    </tr>
                    <c:forEach items="${order.orderDetails}" var="detail">
                        <tr>
                            <td>${detail.id}</td>
                            <td><a href="/product/detail?productId=${detail.product.id}">${detail.product.productName}</a></td>
                            <td>${detail.quantityOrdered}</td>
                            <td>${detail.priceEach}</td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
    </div>
</section>


<jsp:include page="../include/footer.jsp" />