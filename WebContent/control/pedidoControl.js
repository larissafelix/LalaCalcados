var app= angular.module('pedidoModule',[]);

app.controller("pedidoControl",function($scope,$http){
	
	var urlPedido='http://localhost:8080/LalaCalcados/rs/pedido';
		
	$scope.pesquisarPedido= function(){
		$http.get(urlPedido).success(function (pedido){
			$scope.pedidos = pedidos;
		}).error(function(erro){
		alert(erro);
	});
	}
	$scope.pesquisarPedido = function(pedido){
		$scope.pedido = pedido;
	}
	$scope.salvar = function(){
		if($scope.pedido.codigo==''){
			$http.post(urlPedido,$scope.pedido).success(function(pedido){
			$scope.pedidos.push($scope.pedido);
			$scope.novo();
			}).error(function(error){
				alert(erro);
			});
		}else{
			$http.put(urlPedido,$scope.pedido).success(function(pedido){
				$scope.pesquisarPedido();
				$scope.novo();
				}).error(function(error){
					alert(erro);
				});
		}
	}
	$scope.excluir = function() {
		if ($scope.pedido.codigo == '') {
			alert('Selecione um pedido');
		} else {
			urlExcluir = url+'/'+$scope.pedido.codigo;
			$http.delete(urlExcluir).success(function () {
				$scope.pesquisarPedido();
				$scope.novo();
			}).error(function (erro) {
				alert(erro);
			});
		}
	}
	$scope.selecionaPedido = function(pedidoTabela) {
		$scope.pedido = pedidoTabela;
	}
});