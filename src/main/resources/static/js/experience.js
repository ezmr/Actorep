var app= angular.module ('myApp', []);

var experience = [];
app.controller('experienceCtrl', function($scope, $http) {
   $http.get("/getExperience")
   .then(function (response) {
   console.log(response);
   experience = response.data;
   $scope.experience=experience;
   console.log($scope.experience);
   });

$scope.deleteExperience=function(e, index){
console.log(e);
console.log(index);
var url = 'deleteExperience', data = {
                      idExperience: e.idExperience,
                      objet : e.objet,
                      dateDebut : e.dateDebut,
                      dateFin : e.dateFin,
                      description : e.description
                  };
                   console.log(data);
$http.post(url, data).then(function (response) {

experience.splice(index,1);

}, function (response) {

// this function handles error

});
}
}


);

app.controller('addExperienceCtrl',function($scope,$http){

$scope.addExperience=function(){

       var data = {
           objet : $scope.formExperience.obj,
           dateDebut : $scope.formExperience.dateDebu,
           dateFin : $scope.formExperience.dateFi,
           description : $scope.formExperience.descriptio
       }
       var url = '/addExperience', data = data,config='contenttype';

           $http.post(url, data, config).then(function (response) {
           console.log("success");

           console.log(response);

            experience.push(response.data);
            formExperience.reset();

           }, function (response) {

           console.log("error");
           formExperience.reset();

           });
       }


});










