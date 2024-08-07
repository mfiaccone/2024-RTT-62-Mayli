<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../include/header.jsp" />

<!-- a page header -->
<section style="background-color:gray">
    <div class="container">
        <div class="row pt-5 pb-5">
            <c:if test="${empty form.customerId}">
                <h1 class="text-center">Create Customer</h1>
            </c:if>
            <c:if test="${not empty form.customerId}">
                <h1 class="text-center">Edit Customer</h1>
            </c:if>
        </div>
    </div>
</section>

<section>
    <div class="container">
        <div class="row pt-5 ">
            <div class="col-12">
                <form action="/customer/createSubmit" >
                    <input type="hidden" name="customerId" value="${form.customerId}">

                    <!-- Customer Name Input Field -->
                    <div class="row align-items-center justify-content-center pb-3">
                        <div class="col-2">
                            <label for="customerNameId" class="col-form-label">Customer Name</label>
                        </div>
                        <div class="col-4">
                            <input type="text" id="customerNameId" name="customerName" class="form-control <c:if test="${bindingResult.hasFieldErrors('customerName')}">is-invalid</c:if>" value="${form.customerName}">
                        </div>
                    </div>
                    <c:if test="${bindingResult.hasFieldErrors('customerName')}">
                        <div class="row align-items-center justify-content-center">
                            <div class="offset-2 col-4">
                                <div style="color:red">
                                    <c:forEach items="${bindingResult.getFieldErrors('customerName')}" var="error">
                                        ${error.defaultMessage}<br>
                                    </c:forEach>
                                </div>
                            </div>
                        </div>
                    </c:if>


                    <!-- Contact Last Name Field -->
                    <div class="row align-items-center justify-content-center pb-3">
                        <div class="col-2">
                            <label for="contactLastNameId" class="col-form-label">Contact Last Name</label>
                        </div>
                        <div class="col-4">
                            <input type="text" id="contactLastNameId" name="contactLastName" class="form-control <c:if test="${bindingResult.hasFieldErrors('contactLastName')}">is-invalid</c:if>" value="${form.contactLastName}">
                        </div>
                    </div>
                    <c:if test="${bindingResult.hasFieldErrors('contactLastName')}">
                        <div class="row align-items-center justify-content-center">
                            <div class="offset-2 col-4">
                                <div style="color:red">
                                    <c:forEach items="${bindingResult.getFieldErrors('contactLastName')}" var="error">
                                        ${error.defaultMessage}<br>
                                    </c:forEach>
                                </div>
                            </div>
                        </div>
                    </c:if>


                    <!-- Contact First Name Input Field -->
                    <div class="row align-items-center justify-content-center pb-3">
                        <div class="col-2">
                            <label for="contactFirstNameId" class="col-form-label">Contact First Name</label>
                        </div>
                        <div class="col-4">
                            <input type="text" id="contactFirstNameId" name="contactFirstName" class="form-control <c:if test="${bindingResult.hasFieldErrors('contactFirstName')}">is-invalid</c:if>" value="${form.contactFirstName}">
                        </div>
                    </div>
                    <c:if test="${bindingResult.hasFieldErrors('contactFirstName')}">
                        <div class="row align-items-center justify-content-center">
                            <div class="offset-2 col-4">
                                <div style="color:red">
                                    <c:forEach items="${bindingResult.getFieldErrors('contactFirstName')}" var="error">
                                        ${error.defaultMessage}<br>
                                    </c:forEach>
                                </div>
                            </div>
                        </div>
                    </c:if>


                    <!-- Phone Input Field -->
                    <div class="row align-items-center justify-content-center pb-3">
                        <div class="col-2">
                            <label for="phoneId" class="col-form-label">Phone</label>
                        </div>
                        <div class="col-4">
                            <input type="text" id="phoneId" name="phone" class="form-control <c:if test="${bindingResult.hasFieldErrors('phone')}">is-invalid</c:if>" value="${form.phone}">
                        </div>
                    </div>
                    <c:if test="${bindingResult.hasFieldErrors('phone')}">
                        <div class="row align-items-center justify-content-center">
                            <div class="offset-2 col-4">
                                <div style="color:red">
                                    <c:forEach items="${bindingResult.getFieldErrors('phone')}" var="error">
                                        ${error.defaultMessage}<br>
                                    </c:forEach>
                                </div>
                            </div>
                        </div>
                    </c:if>


                    <!-- Address Line One Input Field -->
                    <div class="row align-items-center justify-content-center pb-3">
                        <div class="col-2">
                            <label for="addressLineOneId" class="col-form-label">Address Line One</label>
                        </div>
                        <div class="col-4">
                            <input type="text" id="addressLineOneId" name="addressLineOne" class="form-control <c:if test="${bindingResult.hasFieldErrors('addressLineOne')}">is-invalid</c:if>" value="${form.addressLineOne}">
                        </div>
                    </div>
                    <c:if test="${bindingResult.hasFieldErrors('addressLineOne')}">
                        <div class="row align-items-center justify-content-center">
                            <div class="offset-2 col-4">
                                <div style="color:red">
                                    <c:forEach items="${bindingResult.getFieldErrors('addressLineOne')}" var="error">
                                        ${error.defaultMessage}<br>
                                    </c:forEach>
                                </div>
                            </div>
                        </div>
                    </c:if>


                    <!-- Address Line Two Input Field -->
                    <div class="row align-items-center justify-content-center pb-3">
                        <div class="col-2">
                            <label for="addressLineTwoId" class="col-form-label">Address Line Two</label>
                        </div>
                        <div class="col-4">
                            <input type="text" id="addressLineTwoId" name="addressLineTwo" class="form-control <c:if test="${bindingResult.hasFieldErrors('addressLineTwo')}">is-invalid</c:if>" value="${form.addressLineTwo}">
                        </div>
                    </div>
                    <c:if test="${bindingResult.hasFieldErrors('addressLineTwo')}">
                        <div class="row align-items-center justify-content-center">
                            <div class="offset-2 col-4">
                                <div style="color:red">
                                    <c:forEach items="${bindingResult.getFieldErrors('addressLineTwo')}" var="error">
                                        ${error.defaultMessage}<br>
                                    </c:forEach>
                                </div>
                            </div>
                        </div>
                    </c:if>


                    <!-- City Input Field -->
                    <div class="row align-items-center justify-content-center pb-3">
                        <div class="col-2">
                            <label for="cityId" class="col-form-label">City</label>
                        </div>
                        <div class="col-4">
                            <input type="text" id="cityId" name="city" class="form-control <c:if test="${bindingResult.hasFieldErrors('city')}">is-invalid</c:if>" value="${form.city}">
                        </div>
                    </div>
                    <c:if test="${bindingResult.hasFieldErrors('city')}">
                        <div class="row align-items-center justify-content-center">
                            <div class="offset-2 col-4">
                                <div style="color:red">
                                    <c:forEach items="${bindingResult.getFieldErrors('city')}" var="error">
                                        ${error.defaultMessage}<br>
                                    </c:forEach>
                                </div>
                            </div>
                        </div>
                    </c:if>


                    <!-- State Input Field -->
                    <div class="row align-items-center justify-content-center pb-3">
                        <div class="col-2">
                            <label for="stateId" class="col-form-label">State</label>
                        </div>
                        <div class="col-4">
                            <input type="text" id="stateId" name="state" class="form-control <c:if test="${bindingResult.hasFieldErrors('state')}">is-invalid</c:if>" value="${form.state}">
                        </div>
                    </div>
                    <c:if test="${bindingResult.hasFieldErrors('state')}">
                        <div class="row align-items-center justify-content-center">
                            <div class="offset-2 col-4">
                                <div style="color:red">
                                    <c:forEach items="${bindingResult.getFieldErrors('state')}" var="error">
                                        ${error.defaultMessage}<br>
                                    </c:forEach>
                                </div>
                            </div>
                        </div>
                    </c:if>


                    <!-- Postal Code Input Field -->
                    <div class="row align-items-center justify-content-center pb-3">
                        <div class="col-2">
                            <label for="postalCodeId" class="col-form-label">Postal Code</label>
                        </div>
                        <div class="col-4">
                            <input type="text" id="postalCodeId" name="postalCode" class="form-control <c:if test="${bindingResult.hasFieldErrors('postalCode')}">is-invalid</c:if>" value="${form.postalCode}">
                        </div>
                    </div>
                    <c:if test="${bindingResult.hasFieldErrors('postalCode')}">
                        <div class="row align-items-center justify-content-center">
                            <div class="offset-2 col-4">
                                <div style="color:red">
                                    <c:forEach items="${bindingResult.getFieldErrors('postalCode')}" var="error">
                                        ${error.defaultMessage}<br>
                                    </c:forEach>
                                </div>
                            </div>
                        </div>
                    </c:if>


                    <!-- Country Input Field -->
                    <div class="row align-items-center justify-content-center pb-3">
                        <div class="col-2">
                            <label for="countryId" class="col-form-label">Country</label>
                        </div>
                        <div class="col-4">
                            <input type="text" id="countryId" name="country" class="form-control <c:if test="${bindingResult.hasFieldErrors('country')}">is-invalid</c:if>" value="${form.country}">
                        </div>
                    </div>
                    <c:if test="${bindingResult.hasFieldErrors('country')}">
                        <div class="row align-items-center justify-content-center">
                            <div class="offset-2 col-4">
                                <div style="color:red">
                                    <c:forEach items="${bindingResult.getFieldErrors('country')}" var="error">
                                        ${error.defaultMessage}<br>
                                    </c:forEach>
                                </div>
                            </div>
                        </div>
                    </c:if>


                    <!-- Sales Rep Employee Input Field -->
                    <div class="row align-items-center justify-content-center pb-3">
                        <div class="col-2">
                            <label for="salesRepEmployeeId" class="col-form-label">Sales Rep Employee</label>
                        </div>
                        <div class="col-4">
                            <select id="salesRepEmployeeId" name="salesRepEmployeeId" class="form-control <c:if test="${bindingResult.hasFieldErrors('salesRepEmployeeId')}">is-invalid</c:if>">
                                <c:forEach items="${salesRepEmployees}" var="employee">
                                    <option
                                            value="${employee.id}"
                                            <c:if test="${employee.id == form.salesRepEmployeeId}">Selected</c:if>
                                    >
                                            ${employee.firstname} ${employee.lastname}</option>
                                </c:forEach>
                            </select>
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