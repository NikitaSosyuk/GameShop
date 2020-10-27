<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*, java.text.*" %>
<%@ page import="Servlets.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
<head>
    <title>NNGameShop</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="icon" type="image/png" href="images/homePageImages/icon.png">
    <link rel="stylesheet" type="text/css" href="/styles/homepage.css">
    <link rel="stylesheet" type="text/css" href="/styles/basketpage.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
</head>
<body>
<header>
    <a href="#"><img src="images/homePageImages/Logo.png" id="logo" alt=""></a>
    <nav class="navbar navbar-expand-lg navbar-light bg-light navbar-expand-sm">
        <div class="collapse navbar-collapse" id="navbarTogglerDemo02">
            <ul class="navbar-nav mr-auto mt-1 mt-lg-0">
                <a class="navbar-brand">🎮</a>
                <li class="nav-item active">
                    <a class="nav-link" href="/homepage">Каталог<span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item active">
                    <a class="nav-link" href="#">Подборки<span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item active">
                    <a class="nav-link" href="#">Скидки<span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item active">
                    <a class="nav-link" href="/faqpage">FAQ<span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item active">
                    <a class="nav-link" href="#">Кейсы<span class="sr-only">(current)</span></a>
                </li>
            </ul>
            <ul class="navbar-nav mr-0">
                <a href="/profilepage" class="nav-link ml-0">Привет, <%=request.getSession().getAttribute("username")%>❗</a>
            </ul>
            <ul class="navbar-nav col-1 mr-0">
                <a href="/basketpage" class="nav-link ml-0">Корзина🛒</a>
            </ul>
        </div>
    </nav>
</header><br>
<table>
    <thead>
    <tr>
        <td class="table-name">Наименование товара</td>
        <td class="table-count">Количество</td>
        <td class="table-price">Цена за шт.</td>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="product" items="${products}">
        <tr>
            <td class="table-name">${product.getName()}</td>
            <td class="table-count">1</td>
            <td class="table-price">${product.getPrice()} рублей <a href="/delete?id=${product.getId()}" class="delete">Удалить</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<center><a href="/buypage" class="buy_btn">Совершить покупку</a></center>
</body>
</html>