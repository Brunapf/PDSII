
var editoraModule = angular.module('editoraModule',[]);

editoraModule.controller("editoraControl",function($scope,$http) {


	var urlEditora = 'http://localhost:8080/PDSII/rs/editora';


	
	$scope.pesquisarEditora = function(){
		$http.get(urlEditora).success(function(editoras){
			$scope.editoras = editoras;
		}).error(function(erro){
			$scope.mensagens.push('Erro ao pesquisar editora '+mensagemErro);
	});

	}
	$scope.selecionaEditora = function(editora){
		$scope.editora = editora;
	}
	
	$scope.montaMensagemErro = function(listaErro) {
		$scope.mensagens = [];
		$scope.mensagens.push('Falha de validação retornada do servidor');
		angular.forEach(listaErro, function(value, key){
			 $scope.mensagens.push(value.message);
		});
	}


	$scope.salvar = function(){
		if($scope.editora.codigo == undefined ||$scope.editora.codigo == ''){
			$http.post(urlEditora,$scope.editora).success(function(editora){
				$scope.editoras.push(editora);
				$scope.novo();
				$scope.mensagens.push('Editora salva com sucesso');
			}).error(function (erro){
				$scope.montaMensagemErro(erro.parameterViolations);

			});
		} else{
			$http.put(urlEditora,$scope.editora).success(function(editora){
				$scope.pesquisarEditora();
				$scope.novo();
				$scope.mensagens.push('Editora atualizada com sucesso');
			}).error(function (erro){
				$scope.montaMensagemErro(erro.parameterViolations);

			});

		}





	}



	$scope.excluir = function(){
		if($scope.editora.codigo == ''){
			alert('Selecione um editora');
		}
		else{
			urlExcluir = urlEditora + "/" + $scope.editora.codigo;
			$http.delete(urlExcluir).success(function(){
				$scope.pesquisarEditora();
				$scope.novo();
				$scope.mensagens.push('Editora excluída com sucesso');
			}).error(function (erro){
				$scope.mensagens.push('Erro ao excluir editora: '+erro);
			});
		}

	}

	$scope.novo = function(){
		$scope.editora = "";
	}


	$scope.pesquisarEditora();
	$scope.novo();
	});