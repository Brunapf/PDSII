
var livroModule = angular.module('livroModule',[]);

livroModule.controller("livroControl",function($scope,$http) {



urlautor = 'http://localhost:8080/PDSII/rs/autor';
urlLivro = 'http://localhost:8080/PDSII/rs/livror';
urlCategoria = 'http://localhost:8080/PDSII/rs/categoria';
urlEditora = 'http://localhost:8080/PDSII/rs/editora';


$scope.pesquisarAutor = function(){
	$http.get(urlAutor).sucess(function(autores){
		$scope.autores = autores;
	}).error(function(erro){
	alert(erro);
});

$scope.pesquisarLivro = function(){
	$http.get(urlLivro).sucess(function(livrores){
		$scope.livrores = livrores;
	}).error(function(erro){
	alert(erro);
});

$scope.pesquisarCategoria = function(){
	$http.get(urlCategoria).sucess(function(categorias){
		$scope.categorias = categorias;
	}).error(function(erro){
	alert(erro);
});


$scope.pesquisarEditora = function(){
	$http.get(urlEditora).sucess(function(editoras){
		$scope.editoras = editoras;
	}).error(function(erro){
	alert(erro);
});




	

$scope.selecionaAutor = function(autor){
	$scope.autor = autor;
}

$scope.selecionaLivro = function(livror){
	$scope.livro.livror = livror;
}

$scope.selecionaCategoria = function(categoria){
	$scope.livro.categoria = categoria;
}
$scope.selecionaEditora = function(editora){
	$scope.livro.editora = editora;
}


$scope.salvar = function(){
	if($scope.livro.codigo == ''){
		$http.post(urlLivro,$scope.livro.sucess(function(livro){
			$scope.livros.push($scope.livro);
			$scope.novo();
		}).error(function erro){
			alert(erro);

		});
	} else{
		$http.put(urlLivro,$scope.livror.sucess(function(livro){
			$scope.pesquisarLivro();
			$scope.novo();
		}).error(function erro){
			alert(erro);

		});

	}





}


	


$scope.excluir = function(){
	if($scope.livro.codigo == ''){
		alert('Selecione um livro');
	}
	else{
		urlExcluir = urlLivro + "/" + $scope.livro.codigo;
		$http.delete(urlExcluir).sucess(function(){
			$scope.pesquisarLivro();
			$scope.novo();
		}).error(function (erro){
			alert(erro);
		});
	}

}

$scope.novo = function(){
	$scope.livro = "";
}


$scope.pesquisarAutor();
$scope.pesquisarLivro();
$scope.pesquisarCategoria();
$scope.pesquisarEditora();

});