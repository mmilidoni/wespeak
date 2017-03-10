<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ page contentType="text/html; charset=UTF-8" %>

<tiles:insertTemplate template="/WEB-INF/layouts/basicLayout.jsp" flush="true">
    <tiles:putAttribute name="title" value="Home Page" />
    <tiles:putAttribute name="content" type="string">        
        <div id="home">
            <div class="row">
                <div class="page-title login-home-page">
                    <img src="<s:url value="/images/ODRAKB0.jpg" />">
                    <h1>Login</h1>
                    <h5>Login and Speak English with Everybody.</h5>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-6 col-lg-offset-3 col-sm-8 col-sm-offset-2 col-md-6 col-md-offset-3">
                    <div class="form-box">
                        <!-- Login Form -->
                        <form ng-submit="login()" ng-controller="AuthController">
                            <div class="input-field">
                                <label class="input-lable">Email</label>
                                <input ng-model="form.email" type="email" name="email" value="" placeholder="Email*">
                            </div>
                            <div class="input-field">
                                <label class="input-lable">Password</label>
                                <input ng-model="form.password" type="password" name="password" value="" placeholder="Password*">
                            </div>
                            <div class="input-field">
                                <input id="Option" type="checkbox">
                                <label class="checkbox" for="Option"> Remember Me </label>
                            </div>
                            <button class="button-medium button-yellow button-full" name="demo" value="demo">login</button>
                            <div class="form-link">
                                <a href="#register">Create a new account</a> | <a href="#">Forgot Password?</a>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>

        <!-- Featuress -->
        <div class="white-bg padding-default" id="features">
            <!-- features -->
            <div class="container">
                <div class="row">
                    <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                        <h1 class="text-center">Features</h1>
                        <p class="text-center"><b>wespeak.online</b> is the best way to find people who wants to speak English as you!</p>
                    </div>
                </div>
                <div class="row">
                    <!--Main features -->
                    <div class="col-lg-4 col-md-4 col-sm-6 col-xs-12">
                        <div class="feature">
                            <!-- feature icon -->
                            <div class="feature-icon">
                                <i class="fa fa-search" style="color: #7a6c5d;" aria-hidden="true"></i>
                            </div>
                            <!-- feature title -->
                            <h6 style="color: #7a6c5d;"> Find a person with your same interests </h6>
                            <!-- feature detail -->
                            <div class="feature-detail">
                                <p>A very simple search helps you to find a person with 
                                    your same interests.</p>
                            </div>
                        </div>
                    </div>

                    <div class="col-lg-4 col-md-4 col-sm-6 col-xs-12">
                        <div class="feature">
                            <!-- feature icon -->
                            <div class="feature-icon">
                                <i style="color: #AE6AD7;" class="fa fa-bookmark" aria-hidden="true"></i>
                            </div>
                            <!-- feature title -->
                            <h6 style="color: #AE6AD7;"> Book a time slot </h6>
                            <!-- feature detail -->
                            <div class="feature-detail">
                                <p>People specify their time availability, 
                                    so you can book a call at a precise time.</p>
                            </div>
                        </div>
                    </div>

                    <div class="col-lg-4 col-md-4 col-sm-6 col-xs-12">
                        <div class="feature">
                            <!-- feature icon -->
                            <div class="feature-icon">
                                <i style="color: #e83f6f;" class="fa fa-skype" aria-hidden="true"></i>
                            </div>
                            <!-- feature title -->
                            <h6 style="color: #e83f6f;" >Let's call! </h6>
                            <!-- feature detail -->
                            <div class="feature-detail">
                                <p>The moment is arrived. Take a breath, call your new friend 
                                    and enjoy speaking about your interests.</p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                <h3 class="text-center">How It Works</h3>
            </div>
            <div class="row">
                <div class="col-lg-4 col-md-4 col-sm-5 col-xs-12">
                    <!-- Step Style Five -->
                    <div class="step style-five">
                        <!-- Process line -->
                        <div class="process-line"></div>
                        <!-- Step Box -->
                        <div class="step-box">
                            <!-- Step Icon -->
                            <div class="step-icon">
                                <i class="fa fa-lightbulb-o" aria-hidden="true"></i>
                            </div>    
                            <!-- Step Title -->
                            <h6> Ideas </h6>    
                            <!-- Step Detail -->
                            <div class="step-detail">
                                <p>Lorem ipsum dolor sit amet, muna consectetuer.</p>
                            </div>    
                        </div>
                        <!-- Step Box -->
                        <div class="step-box">
                            <!-- Step Icon -->
                            <div class="step-icon">
                                <i class="fa fa-coffee" aria-hidden="true"></i>
                            </div>    
                            <!-- Step Title -->
                            <h6> Stretagy </h6>    
                            <!-- Step Detail -->
                            <div class="step-detail">
                                <p>Lorem ipsum dolor sit amet, muna consectetuer.</p>
                            </div>    
                        </div>

                        <!-- Step Box -->
                        <div class="step-box">
                            <!-- Step Icon -->
                            <div class="step-icon">
                                <i class="fa fa-code" aria-hidden="true"></i>
                            </div>    
                            <!-- Step Title -->
                            <h6> Development </h6>    
                            <!-- Step Detail -->
                            <div class="step-detail">
                                <p>Lorem ipsum dolor sit amet, muna consectetuer.</p>
                            </div>    
                        </div>

                        <!-- Step Box -->
                        <div class="step-box">
                            <!-- Step Icon -->
                            <div class="step-icon">
                                <i class="fa fa-paper-plane" aria-hidden="true"></i>
                            </div>    
                            <!-- Step Title -->
                            <h6> Deliver </h6>    
                            <!-- Step Detail -->
                            <div class="step-detail">
                                <p>Lorem ipsum dolor sit amet, muna consectetuer.</p>
                            </div>    
                        </div>

                    </div>
                </div>

                <!-- Step Image -->
                <div class="col-lg-7 col-md-8 col-sm-7 col-xs-12 pull-right">
                    <img alt="step Image" src="http://placehold.it/673x649" class="img-responsive">
                </div>
            </div>
        </div>

        <div class="padding-default" id="register" style="background-color: #7a6c5d;">
            <div class="row">
                <div class="page-title login-home-page col-xl-12">
                    <h1>Register</h1>
                    <h5>Register now and Speak English with Everybody.</h5>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-6 col-lg-offset-3 col-sm-8 col-sm-offset-2 col-md-6 col-md-offset-3">
                    <div class="form-box">
                        <!-- Login Form -->
                        <form>
                            <div class="input-field">
                                <label class="input-lable">Email</label>
                                <input type="email" name="email" value="" placeholder="Email*">
                            </div>
                            <div class="input-field">
                                <label class="input-lable">Password</label>
                                <input type="text" name="name" value="" placeholder="Password*">
                            </div>
                            <button class="button-medium button-yellow button-full" name="demo" value="demo">register</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </tiles:putAttribute>

    <tiles:putAttribute name="footerScript" type="string">
        <script>
            // Main Slider
            jQuery(document).ready(function ($) {
                var ocClientsFull = $("#rp-slider-style-two");
                ocClientsFull.owlCarousel({
                    items: 1,
                    itemsDesktop: [970, 1],
                    margin: 0,
                    padding: 0,
                    loop: true,
                    nav: true,
                    navText: ['<i class="fa fa-angle-left"></i>', '<i class="fa fa-angle-right"></i>'],
                    autoplay: true,
                    autoplayHoverPause: false,
                    dots: false,
                    navRewind: false,
                    responsive: {
                        0: {items: 1},
                        480: {items: 1},
                        768: {items: 1},
                        992: {items: 1},
                        1200: {items: 1},
                        1400: {items: 1}
                    }
                });
            });

            // carousel script  
            jQuery(document).ready(function ($) {
                var ocClientsFull = $("#rp-slider-style-three");
                ocClientsFull.owlCarousel({
                    items: 3,
                    itemsDesktop: 3,
                    margin: 30,
                    padding: 0,
                    navText: ['<i class="fa fa-angle-left"></i>', '<i class="fa fa-angle-right"></i>'],
                    autoplay: true,
                    autoplayHoverPause: false,
                    dots: true,
                    responsive: {
                        0: {items: 0},
                        280: {items: 1},
                        480: {items: 1},
                        768: {items: 3},
                        992: {items: 3},
                        1200: {items: 3},
                        1400: {items: 3}
                    }
                });
            });

            // Client carosel 
            jQuery(document).ready(function ($)
            {
                var ocClients = $("#rp-clients-style-two");
                ocClients.owlCarousel(
                        {
                            items: 5,
                            margin: 30,
                            nav: false,
                            navText: ['<i class="fa fa-angle-left"></i>', '<i class="fa fa-angle-right"></i>'],
                            dots: false,
                            navRewind: false,
                            responsive:
                                    {
                                        0: {items: 2},
                                        480: {items: 3},
                                        768: {items: 4},
                                        1000: {items: 5},
                                        1200: {items: 5}
                                    }
                        });
            });

            // Portfolio Filter 
            $(window).load(function () {
                var $container = $('.animate-grid .gallary-thumbs');
                $container.isotope({
                    filter: '*',
                    animationOptions: {
                        duration: 750,
                        easing: 'linear',
                        queue: false
                    }
                });
                $('.animate-grid .categories a').click(function () {
                    $('.animate-grid .categories .active').removeClass('active');
                    $(this).addClass('active');
                    var selector = $(this).attr('data-filter');
                    $container.isotope({
                        filter: selector,
                        animationOptions: {
                            duration: 750,
                            easing: 'linear',
                            queue: false
                        }
                    });
                    return false;
                });
            });

            // Testimonial  Carousal 
            $('.rp-testimonial-center').slick({
                centerMode: true,
                dots: true,
                arrows: false,
                centerPadding: '0',
                slidesToShow: 3,
                responsive: [
                    {
                        breakpoint: 920,
                        settings: {
                            arrows: false,
                            centerMode: true,
                            centerPadding: '0',
                            slidesToShow: 2
                        }
                    },
                    {
                        breakpoint: 767,
                        settings: {
                            arrows: false,
                            centerMode: true,
                            centerPadding: '0',
                            slidesToShow: 1
                        }
                    }
                ]
            });

            // Slider Full height 
            $(window).on("load resize", function () {
                $winHeight = $(this).height();
                $(".home-slider").css("height", $winHeight - "85");
            });

            // Video Js
            $(".play-2").yu2fvl();
        </script>
    </tiles:putAttribute>
</tiles:insertTemplate>

<%--
<html>
    <head>
        <meta charset="ISO-8859-1">
        <title>AJAX with Struts 2 using AngularJS</title>
        <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.2/angular.min.js"></script>
        <script>
            var app = angular.module('myApp', []);

            app.controller("MyController", function ($scope, $http) {
                $scope.getDataFromServer = function () {
                    $http.get("angularAction").then(function (response) {
                        $scope.person = response.data;
                    });
                }
            });
        </script>
    </head>
    <body>
        <div ng-app="myApp" ng-controller="MyController">
            <button data-ng-click="getDataFromServer()">
                Fetch data from server
            </button>

            <p>The name is: {{ person.name}}</p> 
        </div>
    </body>
</html>
--%>