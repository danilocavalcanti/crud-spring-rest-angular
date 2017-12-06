var appCliente = angular.module("appCliente",[]);

appCliente.controller("indexController", function ($scope, $http){
	
	$scope.nome = "Danilo";
	$scope.sobrenome = "Cavalcanti";
	$scope.clientes=[];
	
	$http.get(
			'http://localhost:8080/cliente/listar', 
			null
			).then(function sucesso(response) {
				$scope.clientes=response.data;
				console.log(response.data);
				console.log(response.status);
			}, 
			function erro(response){
				console.log('Não foi possível retornar a lista de clientes!');
				console.log(response.data);
				console.log(response.status);
			});
});

appCliente.controller("cadastroController", function ($scope, $http){
	
	$scope.cliente = null;
	
	$scope.cadastrar = function () {		
		$http.post(
				'http://localhost:8080/cliente/criar', 
				$scope.cliente, 
				null
				).then(function sucesso(response) {
					console.log("Cadastro efetuado com sucesso!");
					console.log(response.status);
				}, 
				function erro(response){
					console.log('Não foi possível efetuar o cadastro do cliente!');
					console.log(response.status);
				});
	}
});