(function() {

    'use strict';

    var mod = angular.module('pm', ['ui.router', 'ngResource']);


    mod.config(function($stateProvider, $urlRouterProvider) {
        $urlRouterProvider.otherwise('/');

        $stateProvider
            .state('home', { url: "/", templateUrl: 'views/pm-home.html' })
            .state('all', { url: "/view-all", templateUrl: 'views/pm-grid.html', controller: 'ViewAllController' })
            .state('new', { url: "/add-new", templateUrl: 'views/pm-product-form.html', controller: 'AddNewController' })
            .state('all.edit',
            {
                url: "/edit-item/:prodId",
                views: {
                    'edit': { templateUrl: 'views/pm-product-form.html', controller: 'ViewAndUpdateController' },
                    'view': { templateUrl: 'views/pm-product-view.html', controller: 'ViewAndUpdateController' },
                }
            })
            .state('all.view',
            {
                url: "/view-item/:prodId",
                views: {
                    'view': { templateUrl: 'views/pm-product-view.html', controller: 'ViewAndUpdateController' },
                }
            })

    });


    mod.controller('ViewAllController', function($scope, Product, $state) {
        Product.query(function(items) {
            $scope.products = items;
        });
        $scope.delete = function(id) {
            Product.delete({ id: id }, function(product) {
                $state.reload();
            });
        }
    });
    mod.controller('AddNewController', function($scope, Product, $location, $state) {
        $scope.product = {};
        $scope.save = function() {
            var newProduct = new Product();
            angular.extend(newProduct, $scope.product, { make: Date.now() });
            newProduct.$save(function(product) {
                //$location.path('view-all');
                $state.go('all');
            });
        }
    });
    mod.controller('ViewAndUpdateController', function($scope, Product, $location, $state, $stateParams) {

        if ($stateParams.prodId) {
            Product.get({ id: $stateParams.prodId }, function(item) {
                $scope.product = item;
            })
        }


        $scope.save = function() {
            var product = new Product();
            angular.extend(product, $scope.product);
            Product.update(product, function(product) {
                //$location.path('view-all');
                $state.go('all');
            });
        }
    });



    mod.factory('Product', function($resource) {
        var apiUrl = "api/v1/products/:id";
        var Product = $resource(apiUrl, { id: '@id' }, { 'update': { method: 'PUT' } });
        return Product;
    });


} ());