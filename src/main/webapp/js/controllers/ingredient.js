/**
 *-------------------------------------------------------------------------
 * Copyright 2016 (C) by Thales Alenia Space France - all rights reserved
 *-------------------------------------------------------------------------
 */

define([], function () {
	'use strict';

	var ingredientCtrl = function ($scope, $http, CONFIG) {
		$scope.ingredientNom = null;
		$scope.ingredientStock = null;
		$scope.ingredientTypeSelected = {};
		$scope.ingredientTypes = [
			{id: 'sand', name: 'sable'},
			{id: 'aggregate', name: 'granulat'},
			{id: 'cement', name: 'ciment'},
			{id: 'adjuvant', name: 'adjuvant'}
		];

		var pData = {
			"nom": $scope.ingredientNom,
			"stock": $scope.ingredientStock,
			"type": $scope.ingredientTypeSelected.name
		};

		$scope.createIngredient = function test() {
			$http.post(CONFIG.PUT_CREATE_INGREDIENT, pData);
		};

	};
	ingredientCtrl.$inject = ['$scope', '$http', 'CONFIG'];

	return ingredientCtrl;
});
