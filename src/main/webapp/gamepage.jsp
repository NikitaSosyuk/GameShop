<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*, java.text.*" %>
<html lang="en">
<head>
    <title>NNGameShop</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="icon" type="image/png" href="images/homePageImages/icon.png">
    <link rel="stylesheet" type="text/css" href="/styles/homepage.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
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
                <a href="/profilepage" class="nav-link ml-0">Привет, <%=request.getSession().getAttribute("username")%>❗</a>
            </ul>
            <ul class="navbar-nav col-1 mr-0">
                <a href="/basketpage" class="nav-link ml-0">Корзина🛒</a>
            </ul>
        </div>
    </nav>
</header><br>
<div class="row py-5 px-4">
    <div class="col-md-5 mx-auto">
        <div class="bg-white shadow rounded overflow-hidden">
            <div class="px-4 pt-0 pb-4 cover">
                <center>
                    <div class="block">
                        <div class="profile"><img src="${game.getImage()}" alt="Фото игры" width="200" class="rounded mb-2 img-thumbnail">
                            <div class="media-body mb-5 text-black">
                                <h4 class="mt-0 mb-0">${game.getName()}</h4>
                                <p class="small mb-0"> <i class="fas fa-map-marker-alt mr-2"></i>${game.getCompany()}</p>
                            </div>
                        </div>
                    </div>
                    <h5 class="font-weight-bold mb-0 d-block">Цена: ${game.getPrice()} Руб.</h5><br>
                    <h6 class="font-weight-bold mb-0 d-block">Рейтинг: ${game.getRating()}</h6>
                </center>
                <div class="px-4 py-3">
                    <h5 class="mb-0">О игре:</h5>
                    <div class="p-4 rounded shadow-sm bg-light">
                        <p class="font-weight-normal mb-0">${game.getDescription()}</p>
                    </div>
                </div>
                <form action="/addToBasket?gameId=${game.getId()}" method="post">
                    <div class="py-4 px-4">
                        <div class="d-flex align-items-center justify-content-between m-auto">
                            <button class="btn btn-outline-dark btn-sm btn-block">Добавить в корзину</button></div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>
