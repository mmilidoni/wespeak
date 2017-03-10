<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
        <title><tiles:insertAttribute name="title" ignore="true" /> - We Speak Online - wespeak.online</title>
        <meta name="description" content="Speaking English with Everybody">
        <meta name="keywords" content="">
        <meta name="author" content="Michele Milidoni">
        <meta property="og:title" content="WeSpeak.online">
        <meta property="og:description" content="Speaking English with Everybody">
        <meta property="og:site_name" content="WeSpeak.online">
        <meta property="og:url" content="http://wespeak.online/">
        <meta property="og:image" content="http://wespeak.online/images/wespeak-logo.png">
        <meta name="twitter:card" content="We Speak English with Everybody">
        <meta name="twitter:site" content="http://wespeak.online/">
        <meta name="twitter:creator" content="Michele Milidoni">
        <meta name="twitter:title" content="WeSepak.online">
        <meta name="twitter:description" content="http://wespeak.online/">
        <meta name="twitter:image" content="http://wespeak.online/images/wespeak-logo.png">

        <!-- Favicon Icon -->
        <link rel="shortcut icon" href="<s:url value="/images/favicon.png" />">

        <!-- Fonts --> 
        <link href='https://fonts.googleapis.com/css?family=Open+Sans:400,700italic,800,600italic,700,600,400italic,300,300italic' rel='stylesheet' type='text/css'>
        <link href='https://fonts.googleapis.com/css?family=Montserrat:400,700' rel='stylesheet' type='text/css'>
        <link href='https://fonts.googleapis.com/css?family=Roboto+Slab:400,100,300,700' rel='stylesheet' type='text/css'>
        <link href='https://fonts.googleapis.com/css?family=Playfair+Display:400,400italic,700,700italic,900italic,900' rel='stylesheet' type='text/css'>
        <link href='https://fonts.googleapis.com/css?family=Oleo+Script:400,700' rel='stylesheet' type='text/css'>
        <link href='https://fonts.googleapis.com/css?family=Pacifico' rel='stylesheet' type='text/css'>

        <!-- Bootstrap CSS -->
        <link href="<s:url value="/css/bootstrap.css" />" rel="stylesheet" type="text/css" media="all">


        <!-- Stylesheet -->
        <link href="<s:url value="/style.css" />" rel="stylesheet" type="text/css" media="all">

        <!-- Common CSS -->
        <link href="<s:url value="/css/common.css" />" rel="stylesheet" type="text/css" media="all">

        <!-- Font Awsome CSS -->
        <link href="<s:url value="/css/font-awesome.min.css" />" rel="stylesheet" type="text/css" media="all">

        <!-- Carousal CSS -->
        <link href="<s:url value="/css/carousel.css" />" rel="stylesheet" type="text/css" media="all">

        <!-- Swiper CSS -->
        <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/Swiper/3.3.1/css/swiper.css">

        <!-- <link href="<s:url value="/css/ananst-color-blue.css" />" rel="stylesheet" type="text/css" media="all"> -->
        <!--[if lt IE 9]>
          <script src="js/html5.js"></script>
        <![endif]-->

        <link href="<s:url value="/css/custom.css" />" rel="stylesheet" type="text/css" media="all">

        <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.2/angular.min.js"></script>
        <script>
            var app = angular.module('myApp', []);

            app.controller("AuthController", function ($scope, $http) {
                $scope.login = function () {
                    $http.post("login", $scope.form)
                            .then(function (response) {
                                console.log(response);
                                debugger;
                                if (response.data.error) {
                                    alert(response.data.error);
                                } else {
                                    location.reload();
                                }
                            });
                };
            });
        </script>

    </head>
    <body ng-app="myApp">

        <!-- Page Pre Loader -->
        <div class="preloader-container white-bg">
            <div class="container">
                <div class="preloader-screen">
                    <div class="logo-container">
                        <!-- Logo -->
                        <a href="<s:url value="/" />" class="logo">
                            <img src="<s:url value="/images/loding-logo.png" />" alt="Loading Logo">
                        </a>
                    </div>
                    <!-- Pre Load bar -->
                    <div class="preloader-bar">
                        <span class="bar"></span>
                    </div>
                    <!-- Loading Percentage -->
                    <p class="preloader-percentage">
                        Loading
                        <span class="percentage">0%</span>
                    </p>
                </div>
            </div>
        </div>
    <header class="rp-main-header">
        <!-- Responsive Menu Overlay -->
        <div class="res-menu-head res-overlay"></div>
        <div class="rp-menu-expand slideRight">
            <!-- Responsive Menu toggle -->
            <a id="navToggle" class="animated-arrow slideLeft"><span></span></a>
            <!-- Responsive Logo -->
            <div class="smallogo">
                <a href="<s:url value="/" />">
                    <img src="<s:url value="/images/logo.png" />" alt="Logo">
                </a>
            </div>
        </div>


        <div class="nav-wrapper">
            <div class="container">
                <!-- Navigation -->
                <nav class="rp-menu slideLeft clearfix">
                    <!-- Desktop Logo -->
                    <div class="logo pull-left">
                        <a href="<s:url value="/" />">
                            <img src="<s:url value="/images/wespeak-logo.png" />" alt="Logo">
                        </a>
                    </div>
                    <!-- Main Menu -->
                    <tiles:insertAttribute name="horizontalMenu" ignore="true" defaultValue="/WEB-INF/include/horizontalMenu.jsp" />
                </nav>
            </div>
        </div>
    </header>

    <!-- Main Content -->
    <div class="main-content">
        <tiles:insertAttribute name="content" ignore="true" />
        <div class="call-to-action style-one theme-yellow-bg">
            <div class="container">                                
                <div class="pull-left">
                    <h5>Heart 
                        <i style="color: #e83f6f;" class="fa fa-heartbeat" aria-hidden="true"></i> 
                        and pizza 
                        <i style="color: #7a6c5d;" class="fa fa-database" aria-hidden="true"></i> 
                        would be enough to maintain this website</h5>
                </div>
                <div class="pull-right">
                    <a target="_blank" href="http://paypal.me/MicheleMilidoni/5" class="button-medium button-grey">Offer me a pizza!</a>
                </div>                    
            </div>
        </div>
    </div>


    <!-- Footer -->
    <footer class="footer-style-2">
        <!--
        <div class="container">
            <div class="row">
            </div>
        </div>
        -->
        <!-- Footer Bottom -->
        <div class="bottom-footer">
            <div class="container">
                <div class="row">
                    <!-- Copyright Text -->
                    <div class="col-lg-7 col-md-7 col-sm-7 col-xs-12">
                        <p class="copyright">Copyright © 2017 - Michele Milidoni</p>
                    </div>

                    <!-- Social Icon -->
                    <div class="col-lg-5 col-md-5 col-sm-5 col-xs-12">
                        <div class="social-icon-box pull-right">
                            <a title="Facebook" class="social-icon si-facebook" href="#" target="blank">
                                <i aria-hidden="true" class="fa fa-facebook"></i>
                                <i aria-hidden="true" class="fa fa-facebook"></i>
                            </a>
                            <a title="Twitter" class="social-icon si-twitter" href="#" target="blank">
                                <i aria-hidden="true" class="fa fa-twitter"></i>
                                <i aria-hidden="true" class="fa fa-twitter"></i>
                            </a>
                            <a title="Google Plus" class="social-icon si-gplus" href="#" target="blank">
                                <i aria-hidden="true" class="fa fa-google-plus"></i>
                                <i aria-hidden="true" class="fa fa-google-plus"></i>
                            </a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </footer>

    <!-- Jquery -->
    <script type="text/javascript" src="<s:url value="/js/jquery-2.2.3.min.js" />"></script>

    <!-- Navigation Js -->
    <script src="<s:url value="/js/menu.js" />"></script>

    <!-- Search Bar JS -->
    <script type="text/javascript" src="<s:url value="/js/classie.js" />"></script> 

    <!-- carousel JS -->
    <script type="text/javascript" src="<s:url value="/js/carousel.js" />"></script>  

    <!-- Portfolio JS -->
    <script src="https://npmcdn.com/isotope-layout@3.0/dist/isotope.pkgd.min.js"></script>

    <!-- Counter JS -->
    <script src="<s:url value="/js/jquery.countTo.js" />"></script>
    <script src="<s:url value="/js/jquery.appear.js" />"></script>  

    <!-- Slick JS (Testimonial) -->
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/slick-carousel/1.6.0/slick.js"></script>

    <!-- preloader-js -->       
    <script src="<s:url value="/js/jpreloader.js" />"></script>

    <!-- Video JS -->
    <script src="<s:url value="/js/video.js" />"></script>


    <script type="text/javascript">

            // Page Full Height JS
            $(window).on("load resize", function () {
                $winHeight = $(this).height();
                $(".error-page").css("height", $winHeight - "125");
            });

            //  COUNTER INIT 
            (function () {
                'use strict';
                $(window).on('load', function () {
                    if ($('.counter').length) {
                        $('.counter').appear(function () {
                            var $this = $(this),
                                    counterNumber = $this.find('.number');
                            counterNumber.countTo({to: $this.find('.number').text(), refreshInterval: 3});
                        });
                    }
                    ;
                });
            })();

            // Preloader js 
            if ($('.preloader-container').length) {
                $('body').jpreLoader({
                    splashID: "#preloader-container",
                    loaderVPos: '70%'
                });
            }

    </script>
    <tiles:insertAttribute name="footerScript" ignore="true" />
</body>
</html>