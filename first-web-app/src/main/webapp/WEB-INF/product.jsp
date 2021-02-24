<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="en">

<jsp:include page="head.jsp">
    <jsp:param name="header" value="Product list"/>
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
            <c:url value="/product/new" var="productNewUrl" />
            <a class="btn btn-primary" href="${productNewUrl}">Add Product</a>
        </div>

        <div class="col-12">
            <table class="table table-bordered my-2">
                <thead>
                <tr>
                    <th scope="col">Id</th>
                    <th scope="col">Name</th>
                    <th scope="col">Description</th>
                    <th scope="col">Price</th>
                    <th scope="col">Actions</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="product" items="${requestScope.products}">
<%--                <% for (Product product : (List<Product>) request.getAttribute("products")) { %>--%>
                <tr>
                    <th scope="row">
                        <c:out value="${product.id}"/>
<%--                        <%= product.getId() %>--%>
                    </th>
                    <td>
                        <c:out value="${product.name}"/>
<%--                        <%= product.getName() %>--%>
                    </td>
                    <td>
                        <c:out value="${product.description}"/>
<%--                        <%= product.getDescription() %>--%>
                    </td>
                    <td>$
                        <c:out value="${product.price}"/>
<%--                        <%= product.getPrice() %>--%>
                    </td>
                    <td>
                        <c:url value="/product/edit" var="productEditUrl">
                            <c:param name="id" value="${product.id}"/>
                        </c:url>
                        <a class="btn btn-success" href="${productEditUrl}"><i class="fas fa-edit"></i></a>
                        <c:url value="/product/delete" var="productDeleteUrl">
                            <c:param name="id" value="${product.id}"/>
                        </c:url>
                        <a class="btn btn-danger" href="${productDeleteUrl}"><i class="far fa-trash-alt"></i></a>
                    </td>
                </tr>
<%--                <% } %>--%>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>

<%@include file="scripts.jsp"%>

</body>
</html>