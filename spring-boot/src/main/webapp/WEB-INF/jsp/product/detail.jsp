<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../include/header.jsp" />

<h1 class="page-title">This is a product detail page</h1>

<section>
    <div class="row pt-5">
        <div class="col-12">
            <h2 class="text-center">Product Details</h2>
        </div>
    </div>
</section>

<section>
    <div class="container">
        <div class="row pt-5">
            <div class="col-12">
                <h2 class="text-center">Product Information</h2>
            </div>
        </div>
        <div class="row pt-3">
            <div class="col-12">
                <table class="table">
                    <tr>
                        <th>ID</th>
                        <th>Product Code</th>
                        <th>Name</th>
                        <th>Product Line ID</th>
                        <th>Scale</th>
                        <th>Vendor</th>
                        <th>Description</th>
                        <th>Quantity in Stock</th>
                        <th>Buy Price</th>
                        <th>MSRP</th>
                    </tr>
                    <tr>
                        <td>${product.id}</td>
                        <td>${product.productCode}</td>
                        <td>${product.productName}</td>
                        <td>${product.productLineId}</td>
                        <td>${product.productScale}</td>
                        <td>${product.productVendor}</td>
                        <td>${product.productDescription}</td>
                        <td>${product.quantityInStock}</td>
                        <td>${product.buyPrice}</td>
                        <td>${product.msrp}</td>
                    </tr>
                </table>
            </div>
        </div>
    </div>
</section>



<jsp:include page="../include/footer.jsp" />