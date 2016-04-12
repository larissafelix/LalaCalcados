var app = angular.module('clienteModule',[]);

app.controller('clienteControl',function($scope,$http){
	
	var url='http://localhost:8080/SistemaEcommerce/rs/cliente';
	$scope.clientes = [{'codigo':'1','nome':'Cliente 1','endereco':'rua aqui','cidade':'Udia',
						'cep':'38400420','telefone':'12345678'},
					  {'codigo':'2','nome':'Cliente 2','endereco':'rua la','cidade':'Udia',
						'cep':'38400421','telefone':'87654321'}];
						


	$scope.novo = function(){
		$scope.cliente = "";
	}

	$scope.salvar = function(){
			$scope.clientes.push($scope.cliente);
			$scope.novo();
			
		}
	
	$scope.excluir = function(){
		$scope.clientes.splice($scope.clientes.indexOf($scope.cliente),1);
		$scope.novo();
			
		}
		
	$scope.selecionaCliente = function(clienteTabela){
		$scope.cliente = clienteTabela;
		
		
	}
	
});