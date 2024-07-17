<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../include/header.jsp" />

<!-- a page header -->
<section style="background-color:gray">
    <div class="container">
        <div class="row pt-5 pb-5">
            <h1 class="text-center">Create Customer</h1>
        </div>
    </div>
</section>

<section>
    <div class="container">
        <div class="row pt-5 ">
            <div class="col-12">
                <form action="/customer/createSubmit">
                    <div class="row align-items-center justify-content-center pb-3">
                        <div class="col-2">
                            <label for="customerNameId" class="col-form-label">Customer Name</label>
                        </div>
                        <div class="col-auto">
                            <input type="text" id="customerNameId" name="customerName" class="form-control">
                        </div>
                    </div>

                    <div class="row align-items-center justify-content-center pb-3">
                        <div class="col-2">
                            <label for="contactLastNameId" class="col-form-label">Contact Last Name</label>
                        </div>
                        <div class="col-auto">
                            <input type="text" id="contactLastNameId" name="contactLastName" class="form-control">
                        </div>
                    </div>

                    <div class="row align-items-center justify-content-center pb-3">
                        <div class="col-2">
                            <label for="contactFirstNameId" class="col-form-label">Contact First Name</label>
                        </div>
                        <div class="col-auto">
                            <input type="text" id="contactFirstNameId" name="contactFirstName" class="form-control">
                        </div>
                    </div>

                    <div class="row align-items-center justify-content-center pb-3">
                        <div class="col-2">
                            <label for="phoneId" class="col-form-label">Phone</label>
                        </div>
                        <div class="col-auto">
                            <input type="text" id="phoneId" name="customerPhone" class="form-control">
                        </div>
                    </div>

                    <div class="row align-items-center justify-content-center pb-3">
                        <div class="col-2">
                            <label for="addressLineOneId" class="col-form-label">Address Line One</label>
                        </div>
                        <div class="col-auto">
                            <input type="text" id="addressLineOneId" name="addressLineOne" class="form-control">
                        </div>
                    </div>

                    <div class="row align-items-center justify-content-center pb-3">
                        <div class="col-2">
                            <label for="addressLineTwoId" class="col-form-label">Address Line Two</label>
                        </div>
                        <div class="col-auto">
                            <input type="text" id="addressLineTwoId" name="addressLineTwo" class="form-control">
                        </div>
                    </div>

                    <div class="row align-items-center justify-content-center pb-3">
                        <div class="col-2">
                            <label for="cityId" class="col-form-label">City</label>
                        </div>
                        <div class="col-auto">
                            <input type="text" id="cityId" name="city" class="form-control">
                        </div>
                    </div>

                    <div class="row align-items-center justify-content-center pb-3">
                        <div class="col-2">
                            <label for="stateId" class="col-form-label">State</label>
                        </div>
                        <div class="col-auto">
                            <input type="text" id="stateId" name="state" class="form-control">
                        </div>
                    </div>

                    <div class="row align-items-center justify-content-center pb-3">
                        <div class="col-2">
                            <label for="postalCodeId" class="col-form-label">Postal Code</label>
                        </div>
                        <div class="col-auto">
                            <input type="text" id="postalCodeId" name="postalCode" class="form-control">
                        </div>
                    </div>

                    <div class="row align-items-center justify-content-center pb-3">
                        <div class="col-2">
                            <label for="countryId" class="col-form-label">Country</label>
                        </div>
                        <div class="col-auto">
                            <input type="text" id="countryId" name="country" class="form-control">
                        </div>
                    </div>

                    <div class="row align-items-center justify-content-center pb-3">
                        <div class="col-2">
                            <label for="salesRepEmployeeId" class="col-form-label">Sales Rep Employee</label>
                        </div>
                        <div class="col-4">
                            <select id="salesRepEmployeeId" name="salesRepEmployee" class="form-control">
                                <c:forEach items="${salesRepEmployees}" var="employee">
                                    <option value="${employee.id}">${employee.firstname} ${employee.lastname}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>

<%--                    <div class="row align-items-center justify-content-center pb-3">--%>
<%--                        <div class="col-2">--%>
<%--                            <label for="officeId" class="col-form-label">Office</label>--%>
<%--                        </div>--%>
<%--                        <div class="col-4">--%>
<%--                            <select id="officeId" name="officeId" class="form-control">--%>
<%--                                <c:forEach items="${offices}" var="office">--%>
<%--                                    <option value="${office.id}">${office.city}</option>--%>
<%--                                </c:forEach>--%>
<%--                            </select>--%>
<%--                        </div>--%>
<%--                    </div>--%>

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