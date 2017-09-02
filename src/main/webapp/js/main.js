/**
 *-------------------------------------------------------------------------
 * Copyright 2016 (C) by Thales Alenia Space France - all rights reserved
 *-------------------------------------------------------------------------
 */

requirejs
		.config({
			waitSeconds: 200,
			paths: {
				// define sis common angular (minified)
				'angular': ['lib/angular'],
				// define angular-route
				'angular-route': ['lib/angular-route'],
				// define jquery
				'jquery': ['lib/jquery'],
				// define bootstrap
				'bootstrap': ['lib/bootstrap'],
				// define angular-ui-bootstrap
				'angular-ui-bootstrap': ['lib/ui-bootstrap-tpls'],
				//define angular-strap
				'angular-strap': ['lib/angular-strap'],
				//define angular-strap-tpl
				'angular-strap-tpl': ['lib/angular-strap-tpl'],
				//define angular animate
				'angular-animate': ['lib/angular-animate'],
				//define angular sanitize
				'angular-sanitize': ['lib/angular-sanitize']

			},
			// set the dependencie
			shim: {
				'angular': {
					exports: 'angular'
				},
				'angular-route': {
					deps: ['angular'],
					exports: 'angular'
				},
				'bootstrap': {
					deps: ['jquery']
				},
				'angular-ui-bootstrap': {
					deps: ['angular', 'bootstrap']
				},
				'angular-strap': {
					deps: ['angular', 'bootstrap']
				},
				'angular-strap-tpl': {
					deps: ['angular-strap']
				},
				'angular-animate': {
					deps: ['angular']
				},
				'angular-sanitize': {
					deps: ['angular']
				}
			}
		});


// define all the required libraries
require(
		['angular', './config', './controllers', './filters', './services', 'angular-route', 'jquery', 'bootstrap', 'angular-ui-bootstrap', 'angular-strap', 'angular-strap-tpl', 'angular-animate', 'angular-sanitize'],
		function (angular, config) {
			'use strict';

			// Declare app level module which depends on filters, and services
			var BetoDriveApp = angular.module('BetoDriveApp', ['BetoDriveApp.controllers',
				'BetoDriveApp.filters', 'BetoDriveApp.services',
				'ngRoute', 'ngAnimate', 'ui.bootstrap', 'mgcrea.ngStrap', 'ngSanitize']);
			BetoDriveApp.constant('CONFIG', config);

			// configure the translate provider
			BetoDriveApp.config([
				'$routeProvider',
				function ($routeProvider) {
					$routeProvider
							.when('/Recipe', {
								templateUrl: 'partials/Recipe.html',
								controller: 'recipeCtrl'
							})
							.when('/Order', {
								templateUrl: 'partials/Order.html',
								controller: 'orderCtrl'
							})
							.when('/Ingredient', {
								templateUrl: 'partials/Ingredient.html',
								controller: 'ingredientCtrl'
							})
							.otherwise({
								redirectTo: '/Ingredient'
							});
				}]);
			angular.bootstrap(document, ['BetoDriveApp']);
		});
