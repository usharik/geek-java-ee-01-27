<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="en">

<jsp:include page="head.jsp">
    <jsp:param name="header" value="Product form"/>
</jsp:include>

<body>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="#">EShop</a>

    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="#">List</a>
            </li>
        </ul>
    </div>
</nav>

<div class="container">
    <div class="row py-2">
        <div class="col-12">
            <c:url value="/product" var="productSubmitUrl"/>
            <form action="${productSubmitUrl}" method="post">
                <input type="hidden" id="id" name="id" value="${product.id}">
                <div class="form-group">
                    <label>Name</label>
                    <input type="text" class="form-control" id="name" name="name" value="${product.name}" placeholder="Enter name">
                </div>
                <div class="form-group">
                    <label>Description</label>
                    <input type="text" class="form-control" id="description" name="description" value="${product.description}" placeholder="Enter description">
                </div>
                <div class="form-group">
                    <label>Price</label>
                    <input type="number" class="form-control" id="price" name="price" value="${product.price}" placeholder="Enter price">
                </div>
                <button type="submit" class="btn btn-primary">Submit</button>
            </form>
        </div>
    </div>
</div>

<%@include file="scripts.jsp"%>

</body>

</html>