
var categoriaModule = angular.module('categoriaModule',[]);

categoriaModule.controller("categoriaControl",function($scope,$http) {


	var urlCategoria = 'http://localhost:8080/PDSII/rs/categoria';


	$scope.pesquisarCategoria = function(){
		$http.get(urlCategoria).success(function(categorias){
			$scope.categorias = categorias;
		}).error(function(erro){
			$scope.mensagens.push('Erro ao pesquisar categorias '+mensagemErro);
	});

	}
	
	$scope.selecionaCategoria = function(categoria){
		$scope.categoria = categoria;
	}

	$scope.montaMensagemErro = function(listaErro) {
		$scope.mensagens = [];
		$scope.mensagens.push('Falha de validação retornada do servidor');
		angular.forEach(listaErro, function(value, key){
			 $scope.mensagens.push(value.message);
		});
	}

	$scope.salvar = function(){
		if($scope.categoria.codigo == undefined || $scope.categoria.codigo == ''){
			$http.post(urlCategoria,$scope.categoria).success(function(categoria){
				$scope.categorias.push(categoria);
				$scope.novo();
				$scope.mensagens.push('Categoria salva com sucesso');
			}).error(function (erro){
				$scope.montaMensagemErro(erro.parameterViolations);

			});
		} else{
			$http.put(urlCategoria,$scope.categoria).success(function(categoria){
				$scope.pesquisarCategoria();
				$scope.novo();
				$scope.mensagens.push('Categoria atualizada com sucesso');
			}).error(function (erro){
				$scope.montaMensagemErro(erro.parameterViolations);

			});

		}
	}



	$scope.excluir = function(){
		if($scope.categoria.codigo == ''){
			alert('Selecione um categoria');
		}
		else{
			urlExcluir = urlCategoria + "/" + $scope.categoria.codigo;
			$http.delete(urlExcluir).success(function(){
				$scope.pesquisarCategoria();
				$scope.novo();
				$scope.mensagens.push('Categoria excluída com sucesso');
			}).error(function (erro){
				$scope.mensagens.push('Erro ao excluir categoria: '+erro);
			});
		}

	}

	$scope.novo = function(){
		$scope.categoria = "";
	}


	$scope.pesquisarCategoria();
	$scope.novo();
	});