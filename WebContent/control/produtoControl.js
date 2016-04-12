var app = angular.module('produtoModule',[]);

app.controller('produtoControl',function($scope,$http){
	
	var url='http://localhost:8080/SistemaEcommerce/rs/produto';
	$scope.produtos =[
	{'codigo':'1', 'nome':'Sandalia salto', 'valor':'100', 'descricao':'Linda'},
	{'codigo':'2', 'nome':'Sandalia salto', 'valor':'100', 'descricao':'Linda'}	
	];
						


	$scope.novo = function(){
		$scope.produto = "";
	}

	$scope.salvar = function(){
			$scope.produtos.push($scope.produto);
			$scope.novo();
			
		}
	
	$scope.excluir = function(){
		$scope.produtos.splice($scope.produtos.indexOf($scope.produto),1);
		$scope.novo();
			
		}
		
	$scope.selecionaProduto = function(produtoTabela){
		$scope.produto = produtoTabela;
		
		
	}
	
});