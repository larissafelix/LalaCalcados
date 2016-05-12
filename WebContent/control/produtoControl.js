var app= angular.module('produtoModule',[]);

app.controller("produtoControl",function($scope,$http){
	
	var urlProduto='http://localhost:8080/LalaCalcados/rs/produto';
		
	$scope.pesquisarProduto= function(){
		$http.get(urlProduto).success(function (produto){
			$scope.produtos = produtos;
		}).error(function(erro){
		alert(erro);
	});
	}
	
	$scope.pesquisarProduto = function(produto){
		$scope.produto = produto;
	}
	
	$scope.salvar = function(){
		if($scope.produto.codigo==''){
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
	$scope.excluir = function() {
		if ($scope.produto.codigo == '') {
			alert('Selecione um produto');
		} else {
			urlExcluir = url+'/'+$scope.produto.codigo;
			$http.delete(urlExcluir).success(function () {
				$scope.pesquisarProduto();
				$scope.novo();
			}).error(function (erro) {
				alert(erro);
			});
		}
	}
	
	$scope.selecionaProduto = function(produtoTabela) {
		$scope.produto = produtoTabela;
	}
});