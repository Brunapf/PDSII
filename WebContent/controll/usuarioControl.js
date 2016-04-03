
var usuarioModule = angular.module('usuarioModule',[]);

usuarioModule.controller("usuarioControl",function($scope) {


	urlUsuario = 'http://localhost:8080/PDSII/rs/usuario';

$scope.pesquisarUsuario = function(){
	$http.get(urlUsuario).sucess(function(usuarios){
		$scope.usuarios = usuarios;
	}).error(function(erro){
	alert(erro);
});

$scope.selecionaUsuario = function(usuario){
	$scope.usuario = usuario;
}


	$scope.salvar = function(){
	$scope.usuarios.push($scope.usuario);
	$scope.novo();

}


$scope.excluir = function(){
	$scope.usuarios.splice($scope.usuarios.indexOf($scope.usuario),1);
	$scope.novo();
}

$scope.novo = function(){
	$scope.usuario = "";
}

$scope.pesquisarEditora();

});