
var editoraModule = angular.module('editoraModule',[]);

editoraModule.controller("editoraControl",function($scope) {


	urlEditora = 'http://localhost:8080/PDSII/rs/editora';

$scope.pesquisarEditora = function(){
	$http.get(urlEditora).sucess(function(editoras){
		$scope.editoras = editoras;
	}).error(function(erro){
	alert(erro);
});

$scope.selecionaEditora = function(editora){
	$scope.editora = editora;
}


	$scope.salvar = function(){
	$scope.editoras.push($scope.editora);
	$scope.novo();

}


$scope.excluir = function(){
	$scope.editoras.splice($scope.editoras.indexOf($scope.editora),1);
	$scope.novo();
}

$scope.novo = function(){
	$scope.editora = "";
}

$scope.pesquisarEditora();

});