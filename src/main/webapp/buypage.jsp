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
    <link rel="stylesheet" type="text/css" href="/styles/faq.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
          integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
    <script src="registration.js"></script>
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
</header>
<br>
<center><h1>Поздравляем с покупкой!</h1></center>
<div class="faq" id="faq">
    <div class="item">
        <h3><div class="question">1. Золотое правило! 1 игра - в одни руки!</div></h3>
        <div class="answer">Друзья! Ключ или Гифт который Вы получили, принадлежит только вам! Повторно получить этот код нереально!</div>
    </div>
    <div class="item">
        <h3><div class="question">2. Игры какой стоимости выпадают?</div></h3>
        <div class="answer">Спешим сообщить, что стоимость игр которые выпадают в рандоме составляет от 129 до 2599 руб в сервисе Steam, за исключением тех случаев, когда в Стиме проходят недели распродаж! </div>
    </div>
    <div class="item">
        <h3><div class="question">3. Где активируется полученная игра?</div></h3>
        <div class="answer">В сервисах Steam, Origin, Uplay и Battle.net</div>
    </div>
    <div class="item" id="Steam">
        <h3><div class="question">4. Как активировать Steam Ключ / Gift?</div></h3>
        <div class="answer">Инструкция по активации ключа в Steam:<br>
            1. Загрузите и установите клиент;<br>
            2. Зарегистрируйте аккаунт;<br>
            3. Нажмите кнопку <b>«Добавить игру - активировать через Steam»</b> - следуйте инструкциям;<br>
            4. После активации, игра появится в «Библиотеке» и Вы сможете ее скачать;<br>
            5. После полной установки наслаждайтесь игровым процессом.<br>
        </div>
    </div>
</div>
</body>
</html>