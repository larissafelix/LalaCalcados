var app = angular.module('pedidoModule',[]);

app.controller('pedidoControl',function($scope,$http){
		urlPedido='http://localhost:8080/LalaCalcados/rs/pedido';
		
		$scope.pesquisaPedido= function(){
			$http.get(urlPedido).success(function (pedido){
				$scope.pedidos = pedidos;
			}).error(function(erro){
			alert(erro);
		});
		}
		
		$scope.pesquisaPedido= function(){
			$http.get(urlPedido).success(function (pedido){
				$scope.pedidos = pedido;
			}).error(function(erro){
			alert(erro);
		});
		}
		
		$scope.selecionaPedido = function(pedido){
			$scope.pedido = pedido;
		}
		
		$scope.salvar = function(){
			if($scope.pedido.codigo=''){
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
		$scope.excluir = function(){
			if($scope.pedido.codigo==''){
				alert('Selecione um pedido');
			}else{
				urlExcluir = urlPedido+"/"+ $scope.pedido.codigo;
				$http.delete(urlExcluir).success(function(){
					$scope.pesquisarPedido();
					$scope.novo();
				}).error(function(erro){
					alert(erro);
				});
				}
			}
		$scope.novo = function(){
			$scope.cliente="";
		}
		$scope.pesquisaPedido();
});