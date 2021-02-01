<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>


<!DOCTYPE html>
<html>
<div class="topnav">
    <a class="active" href="/">Home</a>
    <a href="/news">News</a>
    <a href="/admin">Admin</a>
    <a href="/login">Login</a>
</div>
<head>
    <meta charset="utf-8">
    <title>Новости</title>
    <link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/style.css">
</head>
<body>
<div>
    <h2>Новости <br> Только для залогинившихся пользователей.</h2>
    <a href="/">Главная</a>
</div>
<!-- TradingView Widget BEGIN -->
<div class="tradingview-widget-container">
    <div id="tradingview_1aad7"></div>
    <div class="tradingview-widget-copyright"><a href="https://ru.tradingview.com/symbols/NASDAQ-AAPL/" rel="noopener" target="_blank"><span class="blue-text">График AAPL</span></a> от TradingView</div>
    <script type="text/javascript" src="https://s3.tradingview.com/tv.js"></script>
    <script type="text/javascript">
        new TradingView.widget(
            {
                "width": 980,
                "height": 610,
                "symbol": "NASDAQ:AAPL",
                "interval": "D",
                "timezone": "Etc/UTC",
                "theme": "light",
                "style": "1",
                "locale": "ru",
                "toolbar_bg": "#f1f3f6",
                "enable_publishing": false,
                "allow_symbol_change": true,
                "container_id": "tradingview_1aad7"
            }
        );
    </script>
</div>
<!-- TradingView Widget END -->
</body>
</html>