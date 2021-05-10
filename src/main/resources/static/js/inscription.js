var app= angular.module ('myApp', []);

app.controller('inscriptionCtrl', function($scope,$http){
    console.log("je suis dans angular js inscription");


    $scope.save=function(){
    var data = {
        nom : $scope.formInscription.no,
        mail : $scope.formInscription.mai,
        telephone : $scope.formInscription.telephon,
        presentation : $scope.formInscription.presentatio,
        image : $scope.formInscription.imag,
        video: $scope.formInscription.vide,
        adresse : $scope.formInscription.adress,
        ville : $scope.formInscription.vill,
        codePostal : $scope.formInscription.codePosta,
        libellePays : $scope.formInscription.pays.libellePays,
        libelleMetier : $scope.formInscription.metier.libelleMetier,
        libelleCategorie : $scope.formInscription.categorie.libelleCategorie,
        password : $scope.formInscription.passwor,
    }
    var url = '/save', data,config='contenttype';
        console.log(data);


        $http.post(url, data, config).then(function (response) {

        formInscription.reset();


        }, function (response) {



        });
    }


})

var pays= [];
app.controller('paysCtrl', function($scope, $http) {
   $http.get("/getPays")
   .then(function (response) {
   console.log(response);
   $scope.pays = response.data;
   console.log("je suis pays");
   console.log(pays);
   });
});

var metier= [];
app.controller('metierCtrl', function($scope, $http) {
   $http.get("/getMetier")
   .then(function (response) {
   console.log(response);
   $scope.metier = response.data;
   console.log(metier);
   });
});

var categorie= [];
app.controller('categorieCtrl', function($scope, $http) {
   $http.get("/getCategorie")
   .then(function (response) {
   console.log(response);
   $scope.categorie = response.data;
   console.log(categorie);
   });
});

app.controller('ConnexionCtrl',function($scope,$http,$window,$location){

    $scope.checkIdentifiant=function(){
    var data = {
        username : $scope.formConnexion.username,
        password : $scope.formConnexion.password
    }
    var url = '/identification', data = data,config='contenttype';
        console.log(data);
        console.log($scope.formConnexion.username);
        console.log($scope.formConnexion.password);

        $http.post(url, data, config).then(function (response) {
        console.log("success");
        console.log(response.data.admin);

        if(response.data.admin == true || response.data.admin == false){
            $window.location.href= "/compte";
        }



        }, function (response) {

        });
    }




})