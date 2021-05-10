var app= angular.module ('myApp', []);


app.controller('compteCtrl', function($scope,$http,$window,$location) {
var compte= [];

$http.get("/getCompte")
   .then(function (response) {
   console.log(response);
   $scope.compte = response.data;
   console.log(compte);
   })

$scope.update=function(compte){
   console.log(compte);
   var url = '/update', data = {

       nom : $scope.compte.nom,
       mail : $scope.compte.mail,
       telephone : $scope.compte.telephone,
       presentation : $scope.compte.presentation,
       image : $scope.compte.image,
       video: $scope.compte.video,
       adresse : $scope.compte.adresse,
       ville : $scope.compte.ville,
       codePostal : $scope.compte.codePostal,
       libellePays : $scope.compte.libellePays,
       libelleMetier : $scope.compte.libelleMetier,
       libelleCategorie : $scope.compte.libelleCategorie
                     };

                      console.log(data);
   $http.post(url, data).then(function (response) {


   }, function (response) {

   // this function handles error

   });
   }

  $scope.deconnexion=function(){

   var url = '/deconnexion', data = {};


   $http.post(url, data).then(function (response) {

     $window.location.href= "/inscription";
   }, function (response) {

   // this function handles error

   });
   }


 $scope.updatePassword=function(compte){
 console.log(compte);
 var url = '/updatePassword', data = {

     username : $scope.compte.username,
     password : $scope.compte.password,

                   };

                    console.log(data);
 $http.post(url, data).then(function (response) {


 }, function (response) {

 // this function handles error

 });
 }
}

);
var pays= [];
app.controller('paysCtrl', function($scope, $http) {
   $http.get("/getPays")
   .then(function (response) {
   console.log(response);
   $scope.pays = response.data;
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

app.controller('updateCtrl', function($scope,$http){
$scope.update=function(){
    var data = {
        nom : $scope.compte.nom,
        mail : $scope.formCompte.mai,
        telephone : $scope.compte.telephone,
        presentation : $scope.compte.presentation,
        image : $scope.compte.image,
        video: $scope.compte.video,
        adresse : $scope.compte.adresse,
        ville : $scope.compte.ville,
        codePostal : $scope.compte.codePostal,
        libellePays : $scope.compte.pays.libellePays,
        libelleMetier : $scope.compte.metier.libelleMetier,
        libelleCategorie : $scope.compte.categorie.libelleCategorie
    }
    var url = '/update', data,config='contenttype';
        console.log(data);


        $http.post(url, data, config).then(function (response) {


        }, function (response) {



        });
    }
})
