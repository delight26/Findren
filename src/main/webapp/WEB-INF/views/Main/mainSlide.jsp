<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

  <!-- Header Carousel -->
    <header id="myCarousel" class="carousel slide mainslide">
        <!-- Indicators -->
        <ol class="carousel-indicators">
            <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
            <li data-target="#myCarousel" data-slide-to="1"></li>
            <li data-target="#myCarousel" data-slide-to="2"></li>
        </ol>

        <!-- Wrapper for slides -->
        <div class="carousel-inner">
            <div class="item active">
            <img class="mainslide_img" src="resources/images/mainslide01.jpg">
                <div class="carousel-caption">
<!--                     <h2>Caption 1</h2> -->
                </div>
            </div>
            <div class="item">
             <img class="mainslide_img"  src="resources/images/mainslide02.jpg">
                <div class="carousel-caption">
<!--                     <h2>Caption 2</h2> -->
                </div>
            </div>
            <div class="item">
             <img class="mainslide_img" src="resources/images/mainslide03.jpg">
                <div class="carousel-caption">
<!--                     <h2>Caption 3</h2> -->
                </div>
            </div>
        </div>

        <!-- Controls -->
        <a class="left carousel-control" href="#myCarousel" data-slide="prev">
            <span class="icon-prev"></span>
        </a>
        <a class="right carousel-control" href="#myCarousel" data-slide="next">
            <span class="icon-next"></span>
        </a>
    </header>