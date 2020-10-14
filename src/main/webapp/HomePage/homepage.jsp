<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*, java.text.*" %>
<html lang="en">
<head>
    <title>NNGameShop</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="icon" type="image/png" href="./HomePage/images/icon.png">
    <link rel="stylesheet" type="text/css" href="./HomePage/css/homepage.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
</head>
<body>
<header>
    <a href="#"><img src="./HomePage/images/Logo.png" id="logo" alt=""></a>
    <nav class="navbar navbar-expand-lg navbar-light bg-light navbar-expand-sm">
        <div class="collapse navbar-collapse" id="navbarTogglerDemo02">
            <ul class="navbar-nav mr-auto mt-1 mt-lg-0">
                <a class="navbar-brand">🎮</a>
                <li class="nav-item active">
                    <a class="nav-link" href="#">Каталог<span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item active">
                    <a class="nav-link" href="#">Подборки<span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item active">
                    <a class="nav-link" href="#">Скидки<span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item active">
                    <a class="nav-link" href="#">FAQ<span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item active">
                    <a class="nav-link" href="#">Кейсы<span class="sr-only">(current)</span></a>
                </li>
            </ul>
            <ul class="navbar-nav mr-0">
                <a class="nav-link ml-0">Привет, <%=request.getSession().getAttribute("username")%></a>
            </ul>
        </div>
    </nav>
</header><br>

<div class="bd-example mb-5">
    <div id="carouselExampleControls" class="carousel slide mt-1" data-ride="carousel">
        <div class="carousel-inner w-100 m-auto ml-2 mr-2">
            <div class="carousel-item active">
                <img class="d-block w-100 rounded" src="./HomePage/images/Bitmap.png" alt="Баннер" data-holder-rendered="true">
            </div>
        </div>
    </div>
</div>

<div class="card-deck m-md-auto w-75">
    <div class="card w-auto">
        <img class="card-img-top m-auto" src="/HomePage/images/CaseOne.jpg" alt="Кейс 1">
        <div class="card-body">
            <h5 class="card-title">Набор №1 - Эконом</h5>
            <p class="card-text">Сбалансированный кейс. Возможность выиграть: Journey, Forza Horizon, Minecraft и многое другое...</p>
            <h5 class="card-title">229р</h5>
            <a href="#" class="btn btn-dark">Купить</a>
        </div>
    </div>
    <div class="card">
        <img class="card-img-top m-auto" src="/HomePage/images/CaseTwo.jpg" alt="Кейс 2">
        <div class="card-body">
            <h5 class="card-title">Набор №2 - Баланс</h5>
            <p class="card-text">Выше шанс получить новинки игровой индустрии! Возможность выиграть: Mortal Combat X, GTA V и многое другое..</p>
            <h5 class="card-title">329р</h5>
            <a href="#" class="btn btn-dark">Купить</a>
        </div>
    </div>
    <div class="card">
        <img class="card-img-top m-auto" src="/HomePage/images/CaseThree.jpg" alt="Кейс 3">
        <div class="card-body">
            <h5 class="card-title">Набор №3 - Огонь</h5>
            <p class="card-text">Только новинки! Возможность выиграть: Metro Exodus, Death Stranding, Star Wars и многое другое..</p>
            <h5 class="card-title">529р</h5>
            <a href="#" class="btn btn-dark">Купить</a>
        </div>
    </div>
</div>

</body>
</html>