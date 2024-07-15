<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="include/header.jsp"/>

<section style="background-color:darkgray">
    <div class="container">
        <div class="row pt-5 pb-5">
            <h1 class="text-center">Employee Search Page</h1>
        </div>
    </div>
</section>

<!-- a search form -->
<section>
    <div class="container">
        <div class="row justify-content-center pt-5 pb-3">
            <div class="col-8 text-center">
                <form action="/employee">
                    <div class="mb-3">
                        <label for="lastname" class="form-label"><h4>Employee Search</h4></label>
                        <input type="text" value="${nameSearch}" class="form-control" id="lastname" name="lastname" placeholder="Enter search term"/>
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
                <h2 class="text-center">Employee Found (${employees.size()})</h2>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-12">
            <table class="table">
                <tr>
                    <th>id</th>
                    <th>office id</th>
                    <th>last name</th>
                    <th>first name</th>
                    <th>email</th>
                    <th>job title</th>
                </tr>
                <c:forEach items="${employees}" var="employee">
                    <tr>
                        <td>${employee.id}</td>
                        <td>${employee.officeId}</td>
                        <td>${employee.lastname}</td>
                        <td>${employee.firstname}</td>
                        <td>${employee.email}</td>
                        <td>${employee.jobTitle}</td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</section>

<jsp:include page="include/footer.jsp"/>