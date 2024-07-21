<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../include/header.jsp" />

<section style="background-color:gray">
    <div class="container">
        <div class="row pt-5 pb-5">
            <c:if test="${empty form.productId}">
                <h1 class="text-center">Create Product</h1>
            </c:if>
            <c:if test="${not empty form.productId}">
                <h1 class="text-center">Edit Product</h1>
            </c:if>
        </div>
    </div>
</section>








<jsp:include page="../include/footer.jsp" />