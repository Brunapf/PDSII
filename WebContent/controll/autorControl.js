
var autorModule = angular.module('autorModule',[]);

autorModule.controller("autorControl",function($scope,$http) {


	urlAutor = 'http://localhost:8080/PDSII/rs/autor';


$scope.pesquisarAutor = function(){
	$http.get(urlAutor).sucess(function(autores){
		$scope.autores = autores;
	}).error(function(erro){
	alert(erro);
});




// colocar o novo salvar nos outros
	$scope.salvar = function(){
		if($scope.autor.codigo == ''){
			$http.post(urlAutor,$scope.autor.sucess(function(autor){
				$scope.autores.push($scope.autor);
				$scope.novo();
			}).error(function erro){
				alert(erro);

			});
		} else{
			$http.put(urlAutor,$scope.autor.sucess(function(autor){
				$scope.pesquisarAutor();
				$scope.novo();
			}).error(function erro){
				alert(erro);

			});

		}


	
	

}

// colocar o novo excluir nos outros
$scope.excluir = function(){
	if($scope.autor.codigo == ''){
		alert('Selecione um autor');
	}
	else{
		urlExcluir = urlAutor + "/" + $scope.autor.codigo;
		$http.delete(urlExcluir).sucess(function(){
			$scope.pesquisarAutor();
			$scope.novo();
		}).error(function (erro){
			alert(erro);
		});
	}

}

$scope.novo = function(){
	$scope.autor = "";
}

$scope.selecionaAutor = function(autor){
	$scope.autor = autor;
}

$scope.pesquisarAutor();

});