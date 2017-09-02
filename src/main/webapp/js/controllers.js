/**
 *-------------------------------------------------------------------------
 * Copyright 2016 (C) by Thales Alenia Space France - all rights reserved
 *-------------------------------------------------------------------------
 */



define(['angular', './controllers/order', './controllers/recipe', './controllers/ingredient'],
		function (angular, orderCtrl, recipeCtrl, ingredientCtrl) {
			'use strict';
			/* Controllers */
			var controllersModule = angular.module('BetoDriveApp.controllers', []);
			controllersModule.controller('orderCtrl', orderCtrl);
			controllersModule.controller('recipeCtrl', recipeCtrl);
			controllersModule.controller('ingredientCtrl', ingredientCtrl);
		});
