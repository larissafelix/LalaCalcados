var app = angular.module('pedidoModule',[]);

app.controller('pedidoControl',function($scope,$http){
	$scope.pedidos = [{'codigo':'1','nome':'Pedido 1','produto':'Produto 1'},
					  {'codigo':'2','nome':'Pedido 2','produto':'Produto 2'}
					  ];
					  
					  
		$scope.novo = function(){
			$scope.pedido ="";
			
		}
		$scope.salvar = function(){
			$scope.pedido.push($scope.pedido);
			$scope.novo
			
		}
		$scope.excluir = function(){
			
		}
		
});