$(function() {
    var s = $(".res-overlay, .slideLeft"),
        n = $(".res-menu-head"),
        e = function() {
            $(s).removeClass("menuclose").addClass("menuopen")
        },
        l = function() {
            $(s).removeClass("menuopen").addClass("menuclose")
        };
    $("#navToggle").click(function() {
        n.hasClass("menuopen") ? $(l) : $(e)
    }), n.click(function() {
        n.hasClass("menuopen") && $(l)
    }), $("#navToggle,.overlapblackbg").on("click", function() {
        $(".wsmenucontainer").toggleClass("mrginleft")
    }), $(".rp-menu-list li").has(".wsmenu-submenu, .wsmenu-submenu-sub, .wsmenu-submenu-sub-sub").prepend('<span class="wsmenu-click"><i class="wsmenu-arrow fa fa-angle-down"></i></span>'), $(".rp-menu-list li").has(".megamenu").prepend('<span class="wsmenu-click"><i class="wsmenu-arrow fa fa-angle-down"></i></span>'), $(".wsmenu-mobile").click(function() {
        $(".rp-menu-list").slideToggle("slow")
    }), $(".wsmenu-click").click(function() {
        $(this).siblings(".wsmenu-submenu").slideToggle("slow"), $(this).children(".wsmenu-arrow").toggleClass("wsmenu-rotate"), $(this).siblings(".wsmenu-submenu-sub").slideToggle("slow"), $(this).siblings(".wsmenu-submenu-sub-sub").slideToggle("slow"), $(this).siblings(".megamenu").slideToggle("slow")
    })
});