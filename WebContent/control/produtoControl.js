var produtoModule= angular.module('produtoModule',[]);

produtoModule.controller("produtoControl",function($scope){
	
	urlCliente='http://localhost:8080/LalaCalcados/rs/cliente';
	urlProduto='http://localhost:8080/LalaCalcados/rs/produto';
	
	$scope.pesquisaCliente= function(){
		$http.get(urlCliente).success(function (cliente){
			$scope.clientes = clientes;
		}).error(function(erro){
		alert(erro);
	});
	}
	
	$scope.pesquisaProduto= function(){
		$http.get(urlProduto).success(function (produto){
			$scope.produtos = produtos;
		}).error(function(erro){
		alert(erro);
	});
	}
	
	$scope.selecionaProduto = function(produto){
		$scope.produto = produto;
	}
	
	$scope.salvar = function(){
		if($scope.produto.codigo=''){
			$http.post(urlProduto,$scope.produto).success(function(produto){
			$scope.produtos.push($scope.produto);
			$scope.novo();
			}).error(function(error){
				alert(erro);
			});
		}else{
			$http.put(urlProduto,$scope.produto).success(function(produto){
				$scope.pesquisarProduto();
				$scope.novo();
				}).error(function(error){
					alert(erro);
				});
			
		}
	}
	$scope.excluir = function(){
		if($scope.produto.codigo==''){
			alert('Selecione um produto');
		}else{
			urlExcluir = urlProduto+"/"+ $scope.produto.codigo;
			$http.delete(urlExcluir).success(function(){
				$scope.pesquisarProduto();
				$scope.novo();
			}).error(function(erro){
				alert(erro);
			});
			}
		}
	$scope.novo = function(){
		$scope.produto="";
	}
	
	$scope.pesquisaCliente();
	$scope.pesquisaProduto();
});