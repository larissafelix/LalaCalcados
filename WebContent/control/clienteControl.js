var clienteModule= angular.module('clienteModule',[]);

clienteModule.controller("clienteControl",function($scope){
	
	urlCliente='http://localhost:8080/LalaCalcados/rs/cliente';
		
	$scope.pesquisaCliente= function(){
		$http.get(urlCliente).success(function (cliente){
			$scope.clientes = clientes;
		}).error(function(erro){
		alert(erro);
	});
	}
	
	$scope.selecionaCliente = function(cliente){
		$scope.cliente = cliente;
	}
	
	$scope.salvar = function(){
		if($scope.cliente.codigo=''){
			$http.post(urlCliente,$scope.cliente).success(function(cliente){
			$scope.clientes.push($scope.cliente);
			$scope.novo();
			}).error(function(error){
				alert(erro);
			});
		}else{
			$http.put(urlCliente,$scope.cliente).success(function(cliente){
				$scope.pesquisarCliente();
				$scope.novo();
				}).error(function(error){
					alert(erro);
				});
			
		}
	}
	$scope.excluir = function(){
		if($scope.cliente.codigo==''){
			alert('Selecione um cliente');
		}else{
			urlExcluir = urlCliente+"/"+ $scope.cliente.codigo;
			$http.delete(urlExcluir).success(function(){
				$scope.pesquisarCliente();
				$scope.novo();
			}).error(function(erro){
				alert(erro);
			});
			}
		}
	$scope.novo = function(){
		$scope.cliente="";
	}
	
	$scope.pesquisaCliente();
	$scope.pesquisaProduto();
});