<%@ taglib prefix="s" uri="/struts-tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
        <title>We Speak Online - wespeak.online</title>
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
        <link rel="shortcut icon" href="images/favicon.png">

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
    </head>
    <body>

        <!-- Page Pre Loader -->
        <div class="preloader-container white-bg">
            <div class="container">
                <div class="preloader-screen">
                    <div class="logo-container">
                        <!-- Logo -->
                        <a href="<s:url value="/" />" class="logo">
                            <img src="images/loding-logo.png" alt="Loading Logo">
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

        <!-- Header -->
    <header class="rp-main-header">
        <!-- Responsive Menu Overlay -->
        <div class="res-menu-head res-overlay"></div>
        <div class="rp-menu-expand slideRight">
            <!-- Responsive Menu toggle -->
            <a id="navToggle" class="animated-arrow slideLeft"><span></span></a>
            <!-- Responsive Logo -->
            <div class="smallogo">
                <a href="<s:url value="/" />">
                    <img src="images/logo.png" alt="Logo">
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
                            <img src="images/wespeak-logo.png" alt="Logo">
                        </a>
                    </div>
                    <!-- Main Menu -->
                    <ul class="mobile-sub rp-menu-list pull-right">
                        <li class="active"><a href="#home" class="">Home</a></li>
                        <li><a href="#features" class="">Features</a></li>
                        <li><a href="#register" class="">Register</a></li>
                        <li><a href="#it-works" class="">It Works!</a></li>
                        <li><a href="#" class="">About</a></li>
                    </ul>
                </nav>

            </div>
        </div>
    </header>


    <!-- Main Content -->
    <div class="main-content">
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
                        <form>
                            <div class="input-field">
                                <label class="input-lable">Email</label>
                                <input type="email" name="email" value="" placeholder="Email*">
                            </div>
                            <div class="input-field">
                                <label class="input-lable">Password</label>
                                <input type="text" name="name" value="" placeholder="Password*">
                            </div>
                            <div class="input-field">
                                <input id="Option" type="checkbox">
                                <label class="checkbox" for="Option"> Remember Me </label>
                            </div>
                            <button class="button-medium button-yellow button-full" name="demo" value="demo">login</button>
                            <div class="form-link">
                                <a href="#">Create a new account</a> | <a href="#">Forgot Password?</a>
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
                        <h3 class="text-center">Features</h3>
                        <p class="text-center"><b>wespeak.online</b> is the best way to find people who wants to speak English as you!</p>
                    </div>
                </div>
                <div class="row">
                    <!--Main features -->
                    <div class="col-lg-4 col-md-4 col-sm-6 col-xs-12">
                        <div class="feature">
                            <!-- feature icon -->
                            <div class="feature-icon">
                                <i class="fa fa-search" aria-hidden="true"></i>
                            </div>
                            <!-- feature title -->
                            <h6> Find a person with your same interests </h6>
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
                                <i class="fa fa-bookmark" aria-hidden="true"></i>
                            </div>
                            <!-- feature title -->
                            <h6> Book one time slot </h6>
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
                                <i class="fa fa-skype" aria-hidden="true"></i>
                            </div>
                            <!-- feature title -->
                            <h6>Let's call! </h6>
                            <!-- feature detail -->
                            <div class="feature-detail">
                                <p>The moment is arrived. Take a breath, call your new friend 
                                    and enjoy speaking about your interests.</p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <div class="padding-default" id="register">
            <div class="row">
                <div class="page-title login-home-page">
                    <img src="<s:url value="/images/ODRAKB0.jpg" />">
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

        <!-- Process -->
        <div class="container padding-bottom-100" id="it-works">
            <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                <h3 class="text-center">It Works!</h3>
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

        <%--
                <!-- Testimonial -->
                <div class="testimonial style-3 padding-default white-bg">
                    <div class="container">
                        <h3 class="text-center">Hear what they say</h3>
                        <div class="row">
                            <div class="rp-testimonial-center slider" data-slick='{"slidesToShow": 3, "slidesToScroll": 3}'>
                                <div>
                                    <!-- Testimonial Quote -->
                                    <div class="testimonial-quote">
                                        <i class="fa fa-quote-left" aria-hidden="true"></i>
                                    </div>
                                    <!-- Testimonial Detail -->
                                    <div class="testimonial-detail">
                                        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam sed ligula odio. Sed id metus felis. Ut pretium nisl non justo condimentum id tincidunt nunc faucibus. Ut neque eros, pulvinar eu blandit quis, lacinia nec ipsum. </p>
                                    </div>
                                    <!-- Testimonial Image -->
                                    <div class="testimonial-image">
                                        <img class="img-circle" src="http://placehold.it/82x82" alt="Testimonial Image">
                                    </div>
                                    <!-- Testimonial Name -->
                                    <div class="testimonial-name">
                                        John Doe
                                    </div>
                                    <!-- Testimonial Designation -->
                                    <div class="testimonial-designation">
                                        Art Director
                                    </div>
                                </div>
                                <div>
                                    <!-- Testimonial Quote -->
                                    <div class="testimonial-quote">
                                        <i class="fa fa-quote-left" aria-hidden="true"></i>
                                    </div>
                                    <!-- Testimonial Detail -->
                                    <div class="testimonial-detail">
                                        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam sed ligula odio. Sed id metus felis. Ut pretium nisl non justo condimentum id tincidunt nunc faucibus. Ut neque eros, pulvinar eu blandit quis, lacinia nec ipsum. </p>
                                    </div>
                                    <!-- Testimonial Image -->
                                    <div class="testimonial-image">
                                        <img class="img-circle" src="http://placehold.it/82x82" alt="Testimonial Image">
                                    </div>
                                    <!-- Testimonial Name -->
                                    <div class="testimonial-name">
                                        John Doe
                                    </div>
                                    <!-- Testimonial Designation -->
                                    <div class="testimonial-designation">
                                        Art Director
                                    </div>
                                </div>
                                <div>
                                    <!-- Testimonial Quote -->
                                    <div class="testimonial-quote">
                                        <i class="fa fa-quote-left" aria-hidden="true"></i>
                                    </div>
                                    <!-- Testimonial Detail -->
                                    <div class="testimonial-detail">
                                        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam sed ligula odio. Sed id metus felis. Ut pretium nisl non justo condimentum id tincidunt nunc faucibus. Ut neque eros, pulvinar eu blandit quis, lacinia nec ipsum. </p>
                                    </div>
                                    <!-- Testimonial Image -->
                                    <div class="testimonial-image">
                                        <img class="img-circle" src="http://placehold.it/82x82" alt="Testimonial Image">
                                    </div>
                                    <!-- Testimonial Name -->
                                    <div class="testimonial-name">
                                        John Doe
                                    </div>
                                    <!-- Testimonial Designation -->
                                    <div class="testimonial-designation">
                                        Art Director
                                    </div>
                                </div>
                                <div>
                                    <!-- Testimonial Quote -->
                                    <div class="testimonial-quote">
                                        <i class="fa fa-quote-left" aria-hidden="true"></i>
                                    </div>
                                    <!-- Testimonial Detail -->
                                    <div class="testimonial-detail">
                                        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam sed ligula odio. Sed id metus felis. Ut pretium nisl non justo condimentum id tincidunt nunc faucibus. Ut neque eros, pulvinar eu blandit quis, lacinia nec ipsum. </p>
                                    </div>
                                    <!-- Testimonial Image -->
                                    <div class="testimonial-image">
                                        <img class="img-circle" src="http://placehold.it/82x82" alt="Testimonial Image">
                                    </div>
                                    <!-- Testimonial Name -->
                                    <div class="testimonial-name">
                                        John Doe
                                    </div>
                                    <!-- Testimonial Designation -->
                                    <div class="testimonial-designation">
                                        Art Director
                                    </div>
                                </div>
                                <div>
                                    <!-- Testimonial Quote -->
                                    <div class="testimonial-quote">
                                        <i class="fa fa-quote-left" aria-hidden="true"></i>
                                    </div>
                                    <!-- Testimonial Detail -->
                                    <div class="testimonial-detail">
                                        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam sed ligula odio. Sed id metus felis. Ut pretium nisl non justo condimentum id tincidunt nunc faucibus. Ut neque eros, pulvinar eu blandit quis, lacinia nec ipsum. </p>
                                    </div>
                                    <!-- Testimonial Image -->
                                    <div class="testimonial-image">
                                        <img class="img-circle" src="http://placehold.it/82x82" alt="Testimonial Image">
                                    </div>
                                    <!-- Testimonial Name -->
                                    <div class="testimonial-name">
                                        John Doe
                                    </div>
                                    <!-- Testimonial Designation -->
                                    <div class="testimonial-designation">
                                        Art Director
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- Carosel -->
                <div class="container padding-default">
                    <div class="row">
                        <!-- carousal Style One -->
                        <div id="rp-clients-style-two" class="owl-carousel style-two client-carousel">
                            <div><a href="#"><img src="http://placehold.it/100x105" alt="Clients"></a></div>
                            <div><a href="#"><img src="http://placehold.it/100x105" alt="Clients"></a></div>
                            <div><a href="#"><img src="http://placehold.it/100x105" alt="Clients"></a></div>
                            <div><a href="#"><img src="http://placehold.it/100x105" alt="Clients"></a></div>
                            <div><a href="#"><img src="http://placehold.it/100x105" alt="Clients"></a></div>
                            <div><a href="#"><img src="http://placehold.it/100x105" alt="Clients"></a></div>
                            <div><a href="#"><img src="http://placehold.it/100x105" alt="Clients"></a></div>
                            <div><a href="#"><img src="http://placehold.it/100x105" alt="Clients"></a></div>
                            <div><a href="#"><img src="http://placehold.it/100x105" alt="Clients"></a></div>
                            <div><a href="#"><img src="http://placehold.it/100x105" alt="Clients"></a></div>
                            <div><a href="#"><img src="http://placehold.it/100x105" alt="Clients"></a></div>
                            <div><a href="#"><img src="http://placehold.it/100x105" alt="Clients"></a></div>
                        </div>                                  
                    </div>
                </div>
        --%>


        <!-- call-to-action-->
        <div class="call-to-action style-one theme-yellow-bg">
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
                        <p class="copyright">Copyright © 2017. WeSpeak.online</p>
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


        // Preloader js 
        if ($('.preloader-container').length) {
            $('body').jpreLoader({
                splashID: "#preloader-container",
                loaderVPos: '70%'
            });
        }
        ;

        // Slider Full height 
        $(window).on("load resize", function () {
            $winHeight = $(this).height();
            $(".home-slider").css("height", $winHeight - "85");
        });

        // Video Js
        $(".play-2").yu2fvl();


    </script>
</body>
</html>


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