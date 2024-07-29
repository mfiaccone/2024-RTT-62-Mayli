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

<section>
    <div class="container">
        <div class="row pt-5">
            <div class="col-12">
                <form action="product/createSubmit">

                    <!-- Product Name Input Field -->
                    <div class="row align-items-center justify-content-center pb-3">
                        <div class="col-2">
                            <label for="productNameId" class="col-form-label">Product Name</label>
                        </div>
                        <div class="col-4">
                            <input type="text"
                                   id="productNameId"
                                   name="productName"
                                   class="form-control <c:if test="${bindingResult.hasFieldErrors('productName')}">is-invalid</c:if>"
                                   value="${form.productName}">
                        </div>
                    </div>

                    <!-- Product Code Input Field -->
                    <div class="row align-items-center justify-content-center pb-3">
                        <div class="col-2">
                            <label for="productCodeId" class="col-form-label">Product Code</label>
                        </div>
                        <div class="col-4">
                            <input type="text"
                                   id="productCodeId"
                                   name="productCode"
                                   class="form-control <c:if test="${bindingResult.hasFieldErrors('productCode')}">is-invalid</c:if>"
                                   value="${form.productCode}">
                        </div>
                    </div>

                    <!-- Product LineId Input Field -->
                    <div class="row align-items-center justify-content-center pb-3">
                        <div class="col-2">
                            <label for="productLineId" class="col-form-label">Product Line Id</label>
                        </div>
                        <div class="col-4">
                            <input type="text"
                                   id="productLineId"
                                   name="productLineId"
                                   class="form-control <c:if test="${bindingResult.hasFieldErrors('productLineId')}">is-invalid</c:if>"
                                   value="${form.productLineId}">
                        </div>
                    </div>

                    <!-- Product Scale Input Field -->
                    <div class="row align-items-center justify-content-center pb-3">
                        <div class="col-2">
                            <label for="productScaleId" class="col-form-label">Product Scale</label>
                        </div>
                        <div class="col-4">
                            <input type="text"
                                   id="productScaleId"
                                   name="productScale"
                                   class="form-control <c:if test="${bindingResult.hasFieldErrors('productScale')}">is-invalid</c:if>"
                                   value="${form.productScale}">
                        </div>
                    </div>

                    <!-- Product Vendor Input Field -->
                    <div class="row align-items-center justify-content-center pb-3">
                        <div class="col-2">
                            <label for="productVendorId" class="col-form-label">Product Vendor</label>
                        </div>
                        <div class="col-4">
                            <select
                                    id="productVendorId"
                                    name="productVendor"
                                    class="form-control <c:if test="${bindingResult.hasFieldErrors('productVendor')}">is-invalid</c:if>"
                            <c:forEach items="${productVendorList}" var="vendor">
                                <option
                                        value="${product.productVendor}"
                                        <c:if test="${vendor.productVendor == form.productVendor}">Selected</c:if>
                                >
                                        ${product.productVendor}
                                </option>
                            </c:forEach>
                            </select>
                        </div>
                    </div>

                    <!-- Product Description Input Field -->
                    <div class="row align-items-center justify-content-center pb-3">
                        <div class="col-2">
                            <label for="productDescriptionId" class="col-form-label">Product Description</label>
                        </div>
                        <div class="col-4">
                            <input type="text"
                                   id="productDescriptionId"
                                   name="productDescription"
                                   class="form-control <c:if test="${bindingResult.hasFieldErrors('productDescription')}">is-invalid</c:if>"
                                   value="${form.productDescription}">
                        </div>
                    </div>

                    <!-- Product Quantity In Stock Input Field -->
                    <div class="row align-items-center justify-content-center pb-3">
                        <div class="col-2">
                            <label for="quantityInStockId" class="col-form-label">Quantity In Stock</label>
                        </div>
                        <div class="col-4">
                            <input type="text"
                                   id="quantityInStockId"
                                   name="quantityInStock"
                                   class="form-control <c:if test="${bindingResult.hasFieldErrors('quantityInStock')}">is-invalid</c:if>"
                                   value="${form.quantityInStock}">
                        </div>
                    </div>

                    <!-- Product Buy Price Input Field -->
                    <div class="row align-items-center justify-content-center pb-3">
                        <div class="col-2">
                            <label for="buyPriceId" class="col-form-label">Buy Price</label>
                        </div>
                        <div class="col-4">
                            <input type="text"
                                   id="buyPriceId"
                                   name="buyPrice"
                                   class="form-control <c:if test="${bindingResult.hasFieldErrors('buyPrice')}">is-invalid</c:if>"
                                   value="${form.buyPrice}">
                        </div>
                    </div>

                    <!-- Product MSRP Input Field -->
                    <div class="row align-items-center justify-content-center pb-3">
                        <div class="col-2">
                            <label for="msrpId" class="col-form-label">MSRP</label>
                        </div>
                        <div class="col-4">
                            <input type="text"
                                   id="msrpId"
                                   name="msrp"
                                   class="form-control <c:if test="${bindingResult.hasFieldErrors('msrp')}">is-invalid</c:if>"
                                   value="${form.msrp}">
                        </div>
                    </div>

                    <div class="row justify-content-center ">
                        <div class="col-auto text-center">
                            <button type="submit" class="btn btn-primary">Submit</button>
                        </div>
                    </div>




                </form>
            </div>
        </div>
    </div>
</section>






<jsp:include page="../include/footer.jsp" />