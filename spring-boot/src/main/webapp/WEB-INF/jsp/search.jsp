<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="include/header.jsp"/>

<section style="background-color:darkgray">
    <div class="container">
        <div class="row pt-5 pb-5">
            <h1 class="text-center">Product Search Page</h1>
        </div>
    </div>
</section>

<!-- a search form -->
<section>
    <div class="container">
        <div class="row justify-content-center pt-5 pb-3">
            <div class="col-8 text-center">
                <form action="/search">
                    <div class="mb-3">
                        <label for="search" class="form-label"><h4>Product Name Search</h4></label>
                        <input type="text" value="${search}" class="form-control" id="search" name="search" placeholder="Enter search term"/>
                    </div>
                    <button type="submit" class="btn btn-primary">Search</button>
                </form>
            </div>
        </div>
    </div>
</section>



<section>
    <div class="container">
        <div class="row pt-5">
            <div class="col-12">
                <h2 class="text-center">Products Found (${products.size()})</h2>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-12">
            <table class="table">
                <tr>
                    <th>id</th>
                    <th>code</th>
                    <th>name</th>
                    <th>description</th>
                </tr>
                <c:forEach items="${products}" var="product">
                    <tr>
                        <td>${product.id}</td>
                        <td>${product.productCode}</td>
                        <td><a href="/product/detail?productId=${product.id}">${product.productName}</a></td>
                        <td>${product.productDescription}</td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</section>


<jsp:include page="include/footer.jsp"/>