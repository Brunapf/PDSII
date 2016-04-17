
var livroModule = angular.module('livroModule',[]);

livroModule.controller("livroControl",function($scope,$http) {


	urlLivro = 'http://localhost:8080/PDSII/rs/livro';


$scope.pesquisarLivro = function(){
	$http.get(urlLivro).success(function(livros){
		$scope.livros = livros;
	}).error(function(erro){
	alert(erro);
});

}
$scope.selecionaLivro = function(livro){
	$scope.livro = livro;
}


$scope.salvar = function(){
	if($scope.livro.codigo == ''){
		$http.post(urlLivro,$scope.livro).success(function(livro){
			$scope.livros.push($scope.livro);
			$scope.novo();
		}).error(function (erro){
			alert(erro);

		});
	} else{
		$http.put(urlLivro,$scope.livro).success(function(livro){
			$scope.pesquisarLivro();
			$scope.novo();
		}).error(function (erro){
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
		$http.delete(urlExcluir).success(function(){
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


$scope.pesquisarLivro();

});