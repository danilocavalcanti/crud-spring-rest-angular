var appCliente = angular.module("appCliente",[]);

appCliente.controller("indexController", function ($scope, $http){
	
	$scope.nome = "Danilo";
	$scope.sobrenome = "Cavalcanti";
	$scope.clientes=[];
	
	$http({
		method: 'GET',
		url: 'http://localhost:8080/cliente/listar'
	}).then(function sucesso(response){
		$scope.clientes=response.data;
		console.log(response.data);
		console.log(response.status);
	}, function erro(response){
		console.log('deu ruim');
		console.log(response.data);
		console.log(response.status);
	});
	
});