
var livroModule = angular.module('livroModule',[]);

livroModule.controller("livroControl",function($scope,$http) {


	var urlLivro = 'http://localhost:8080/PDSII/rs/livro';
	var urlEditora = 'http://localhost:8080/PDSII/rs/editora';
	var urlCategoria = 'http://localhost:8080/PDSII/rs/categoria';


$scope.pesquisarLivro = function(){
	$http.get(urlLivro).success(function(livros){
		$scope.livros = livros;
	}).error(function(erro){
		$scope.mensagens.push('Erro ao pesquisar livro '+mensagemErro);
});
}

$scope.pesquisarCategoria = function(){
	$http.get(urlCategoria).success(function(categorias){
		$scope.categorias = categorias;
	}).error(function(erro){
		$scope.mensagens.push('Erro ao pesquisar livro '+mensagemErro);
});
}

$scope.pesquisarEditora = function(){
	$http.get(urlEditora).success(function(editoras){
		$scope.editoras = editoras;
	}).error(function(erro){
		$scope.mensagens.push('Erro ao pesquisar categorias '+mensagemErro);
});

}

$scope.selecionaLivro = function(livro){
	$scope.livro = livro;
}


$scope.montaMensagemErro = function(listaErro) {
	$scope.mensagens = [];
	$scope.mensagens.push('Falha de validação retornada do servidor');
	angular.forEach(listaErro, function(value, key){
		 $scope.mensagens.push(value.message);
	});
}


$scope.salvar = function(){
	if($scope.livro.codigo == undefined || $scope.livro.codigo == ''){
		$http.post(urlLivro,$scope.livro).success(function(livro){
			$scope.livros.push($scope.livro);
			$scope.novo();
			$scope.mensagens.push('Livro salvo com sucesso');
		}).error(function (erro){
			$scope.montaMensagemErro(erro.parameterViolations);

		});
	} else{
		$http.put(urlLivro,$scope.livro).success(function(livro){
			$scope.pesquisarLivro();
			$scope.novo();
			$scope.mensagens.push('Livro atualizado com sucesso');
		}).error(function (erro){
			$scope.montaMensagemErro(erro.parameterViolations);
		});
	}
}



$scope.excluir = function(){
	if($scope.livro.codigo == ''){
		alert('Selecione um livro');
	}
	else{
		urlExcluir = urlLivro + "/" + $scope.livro.codigo;
		$http.delete(urlExcluir).success(function(){
			$scope.pesquisarLivro();
			$scope.novo();
			$scope.mensagens.push('Livro excluído com sucesso');
		}).error(function (erro){
			$scope.mensagens.push('Erro ao excluir livro: '+erro);
		});
	}

}

$scope.novo = function(){
	$scope.livro = "";
}


$scope.pesquisarLivro();
$scope.pesquisarEditora();
$scope.pesquisarCategoria();
$scope.novo();
});