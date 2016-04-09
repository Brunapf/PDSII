
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
	if ($scope.editora.codigo == ''){
		$http.post(urlEditora,$scope.editora).success(function(editora){
			$scope.editoras.push($scope.editora);
			$scope.novo();
		}).error(function (erro){
			alert(erro);
		});
	
} else{
	$http.put(urlEditora,$scope.editora).success(function(editora){
		$scope.pesquisarEditora();
		$scope.novo();
	}).error(function (erro){
		alert(erro);
	});
}
}



$scope.excluir = function(){
	if ($scope.editora.codigo == ''){
		alert('Selecione um editora');
	}
	else{
		urlExcluir = urlUsuario + "/" + $scope.editora.codigo;
		$http.delete(urlEditora).success(function(){
			$scope.pesquisarUsuario();
			$scope.novo();
		}).error(function (erro){
			alert(erro);
		});
	}
}

$scope.pesquisarEditora();

});