<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
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