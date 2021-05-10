
var app= angular.module ('myApp', []);

var service = [];
app.controller('serviceCtrl', function($scope, $http) {

   $http.get("/getService")
   .then(function (response) {
   console.log(response);
   service = response.data;
   $scope.service=service;
   console.log($scope.service);
   });

$scope.deleteService=function(s, index){
console.log(s);
console.log(index);
var url = 'deleteService', data = {
                      //id: s.id,
                      idActeur:s.idActeur,
                      idActivie:s.idActivie,
                      libelleActivite :s.libelleActivite,
                      descriptionActivite : s.descriptionActivite,
                      prixActiviteActeur : s.prixActiviteActeur
                  };

                   console.log(data);
$http.post(url, data).then(function (response) {

service.splice(index,1);

}, function (response) {

// this function handles error

});
}
}


);

app.controller('addServiceCtrl',function($scope,$http){

$scope.addService=function(){
       var data = {
           libelleActivite : $scope.formService.libelleActivit,
           descriptionActivite : $scope.formService.descriptionActivit,
           prixActiviteActeur : $scope.formService.prixActiviteActeu,

       }
       var url = '/addService', data = data,config='contenttype';

            console.log(data);

           $http.post(url, data, config).then(function (response) {

           console.log("success");
           service.push(response.data);
           formService.reset();

           }, function (response) {

           console.log("error");

           });
       }


});
