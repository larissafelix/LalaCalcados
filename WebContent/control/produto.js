var produtoModule= angular.module('produtoModule',[]);

produtoModule.controller("produtoControl",function($scope){
	
	$scope.produtos =[
	{'codigo':'1', 'nome':'Sandalia salto', 'valor':'100,00', 'descricao':'Linda'},
	{'codigo':'2', 'nome':'Sandalia salto', 'valor':'100,00', 'descricao':'Linda'}	
	];
	
	$scope.selecionaProduto = function(produto){
		$scope.produto = produto;
	}
	
	$scope.salvar = function(){
		$scope.produtos.push($scope.produto);
		$scope.novo();
	}
	$scope.excluir = function(){
		$scope.produtos.splice($scope.produtos.indexOf($scope.produto),1);
		$scope.novo();
	}
	$scope.novo = function(){
		$scope.produto="";
	}
});