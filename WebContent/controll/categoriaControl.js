
var categoriaModule = angular.module('categoriaModule',[]);

categoriaModule.controller("categoriaControl",function($scope,$http) {


	urlCategoria = 'http://localhost:8080/PDSII/rs/categoria';


$scope.pesquisarCategoria = function(){
	$http.get(urlCategoria).success(function(categorias){
		$scope.categorias = categorias;
	}).error(function(erro){
	alert(erro);
});


$scope.selecionaCategoria = function(categoria){
	$scope.categoria = categoria;
}

/*
$scope.salvar = function(){
	if($scope.categoria.codigo == ''){
		$http.post(urlCategoria,$scope.categoria.sucess(function(categoria){
			$scope.categorias.push($scope.categoria);
			$scope.novo();
		}).error(function erro){
			alert(erro);

		});
	} else{
		$http.put(urlAutor,$scope.categoria.sucess(function(categoria){
			$scope.pesquisarCategoria();
			$scope.novo();
		}).error(function erro){
			alert(erro);

		});

	}





}



$scope.excluir = function(){
	if($scope.categoria.codigo == ''){
		alert('Selecione uma categoria');
	}
	else{
		urlExcluir = urlCategoria + "/" + $scope.categoria.codigo;
		$http.delete(urlExcluir).sucess(function(){
			$scope.pesquisarCategoria();
			$scope.novo();
		}).error(function (erro){
			alert(erro);
		});
	}

}
*/
$scope.novo = function(){
	$scope.categoria = "";
}


$scope.pesquisarCategoria();
}
});