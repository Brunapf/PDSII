
var categoriaModule = angular.module('categoriaModule',[]);

categoriaModule.controller("categoriaControl",function($scope,$http) {


	urlCategoria = 'http://localhost:8080/PDSII/rs/categoria';


$scope.pesquisarCategoria = function(){
	$http.get(urlCategoria).sucess(function(categorias){
		$scope.categorias = categorias;
	}).error(function(erro){
	alert(erro);
});


$scope.selecionaCategoria = function(categoria){
	$scope.categoria = categoria;
}


	$scope.salvar = function(){
	$scope.categorias.push($scope.categoria);
	$scope.novo();

}


$scope.excluir = function(){
	$scope.categorias.splice($scope.categorias.indexOf($scope.categoria),1);
	$scope.novo();
}

$scope.novo = function(){
	$scope.categoria = "";
}


$scope.pesquisarCategoria();

});