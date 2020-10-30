<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.*, java.text.*" %>
<html lang="en">
<head>
    <title>NNGameShop</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="icon" type="image/png" href="images/homePageImages/icon.png">
    <link rel="stylesheet" type="text/css" href="/styles/homepage.css">
    <link rel="stylesheet" type="text/css" href="/styles/editapage.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
          integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
    <script src="registration.js"></script>
</head>
<body>
<header>
    <a href="/homepage"><img src="images/homePageImages/Logo.png" id="logo" alt=""></a>
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
                <a href="/profilepage" class="nav-link ml-0">Привет, <%=request.getSession().getAttribute("username")%>
                    ❗</a>
            </ul>
            <ul class="navbar-nav col-1 mr-0">
                <a href="/basketpage" class="nav-link ml-0">Корзина🛒</a>
            </ul>
        </div>
    </nav>
</header>
<br>
<div class="row py-5 px-4">
    <div class="col-md-5 mx-auto">
        <div class="bg-white shadow rounded overflow-hidden">
            <form class="form" method="post" action="/changeEmail">
                <div class="form-group">
                    <label for="email">Электронная почта</label>
                    <input type="email" class="form-control" id="email" aria-describedby="emailHelp"
                           placeholder="Email" name="email">
                    <small id="emailHelp" class="form-text text-muted"> Ваш адрес электронной почты хранится только у
                        нас.
                    </small>
                </div>
                <center>
                    <button id="add-email" class="btn">Добавить</button>
                </center>
            </form>
            <form class="form" method="post" action="/changeUsername">
                <div class="form-group">
                    <label for="username">Логин</label>
                    <input class="form-control" id="username" placeholder="Новый логин" onblur="checkUsername()" name="new-username">
                    <p class="error" id="username-error" style="display: none; color: red">Логин уже занят</p>
                    <p class="error" id="username-size-error" style="display: none; color: red">Логин слишком короткий</p>
                </div>
                <center>
                    <button id="lgn" class="btn" disabled="disabled">Заменить</button>
                </center>
            </form>
        </div>
    </div>
</div>
</body>
</html>