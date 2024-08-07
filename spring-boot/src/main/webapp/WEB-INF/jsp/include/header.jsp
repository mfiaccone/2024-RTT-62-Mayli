<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>

    <link href="/pub/css/global.css" rel="stylesheet">

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container-fluid">
        <a class="navbar-brand" href="#">Navbar</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">

                <sec:authorize access="!isAuthenticated()">
                <li class="nav-item">
                    <a class="nav-link" aria-current="page" href="/account/loginPageUrl">Log In</a>
                </li>
                </sec:authorize>

                <sec:authorize access="isAuthenticated()">
                <li class="nav-item">
                    <a class="nav-link" aria-current="page" href="/login/logout">Log Out</a>
                </li>
                </sec:authorize>

                <li class="nav-item">
                    <a class="nav-link" aria-current="page" href="/account/create-account">Create Account</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" aria-current="page" href="/">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/page-url">2nd Page</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/homework">Homework</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/search">Product Search</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" aria-current="page" href="/employee">Employee Search</a>
                </li>

                <li class="nav-item">
                    <a class="nav-link" aria-current="page" href="/employee/create">Create Employee</a>
                </li>

                <li class="nav-item">
                    <a class="nav-link" aria-current="page" href="/customer/create">Create Customer</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" aria-current="page" href="/product/create">Create Product</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" aria-current="page" href="/file-upload">File Upload</a>
                </li>

                <sec:authorize access="hasAnyAuthority('ADMIN')">
                    <li class="nav-item">
                        <a class="nav-link" href="/admin/dashboard">Admin Dashboard</a>
                    </li>
                </sec:authorize>

                <li class="nav-item">
                    <span class="nav-link"><sec:authentication property="name"/></span>
                </li>



            </ul>
        </div>
    </div>
</nav>