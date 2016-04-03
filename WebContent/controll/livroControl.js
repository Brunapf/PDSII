
var livroModule = angular.module('livroModule',[]);

livroModule.controller("livroControl",function($scope,$http) {



urlLivro = 'http://localhost:8080/PDSII/rs/livro';

urlAutor = 'http://localhost:8080/PDSII/rs/autor';
urlCategoria = 'http://localhost:8080/PDSII/rs/categoria';
urlEditora = 'http://localhost:8080/PDSII/rs/editora';


$scope.pesquisarLivro = function(){
	$http.get(urlLivro).sucess(function(livros){
		$scope.livros = livros;
	}).error(function(erro){
	alert(erro);
});

$scope.pesquisarAutor = function(){
	$http.get(urlAutor).sucess(function(autores){
		$scope.autores = autores;
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



$scope.livros = [
	{codigo:1, nome:'livro1',descricao:'nada',quantidade:242,autor:{codigo:1, nome:'autor1'},categoria:{codigo:1, nome:'Terror'},editora:{codigo:2, nome:'Nova Era'}},
	{codigo:2, nome:'livro2',descricao:'grege',quantidade:434, autor: {codigo:2, nome:'autor2'},categoria:{codigo:1, nome:'Terror'},editora:{codigo:1, nome:'Abril'}}


];

	

$scope.selecionaLivro = function(livro){
	$scope.livro = livro;
}

$scope.selecionaAutor = function(autor){
	$scope.livro.autor = autor;
}

$scope.selecionaCategoria = function(categoria){
	$scope.livro.categoria = categoria;
}
$scope.selecionaEditora = function(editora){
	$scope.livro.editora = editora;
}





	


$scope.excluir = function(){
	$scope.livros.splice($scope.livros.indexOf($scope.livro),1);
	$scope.novo();
}

$scope.novo = function(){
	$scope.livro = "";
}


$scope.pesquisarAutor();
$scope.pesquisarLivro();
$scope.pesquisarCategoria();
$scope.pesquisarEditora();

});