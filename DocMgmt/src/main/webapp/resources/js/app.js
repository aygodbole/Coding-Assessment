var app = angular.module('DocManagerApp', []);

app.directive('fileModel', ['$parse', function ($parse) {
    return {
       restrict: 'A',
       link: function(scope, element, attrs) {
          var model = $parse(attrs.fileModel);
          var modelSetter = model.assign;
          
          element.bind('change', function(){
             scope.$apply(function(){
                modelSetter(scope, element[0].files[0]);
             });
          });
       }
    };
 }]);

app.controller('DocCtrl', ['$scope', '$http', '$log',
		function($scope, $http, $log) {
			$log.info("Inside Doc controller");
			$scope.saveAttachments = function(){
				$log.info("Inside save attachment");
				var fd = new FormData();
				fd.append("file",$scope.myFile);
				fd.append("userName",$scope.userName);
				fd.append("docId",$scope.docId);
				    $http.post("/DocMgmt/upload", fd, {
				           transformRequest: angular.identity,
				           headers: {'Content-Type': undefined,
				           	'enctype' :'multipart/form-data'}
				       }).success(function(results){
				       	// console.log("response : _>",results);
				       	$scope.showPreLoader = false;
				if(results.STATUS=='SUCCESS'){
					$log.info("SUCCESS");
					$scope.msg = results.msg;
				}else {
				$scope.errorMessage = "Error in saving the Attachments";
				 }
				})
				   .error(function(data,status){
				   	$scope.showPreLoader = false;
				   	$scope.errorMessage = "Error in saving the Attachments";
				   });
				};
		} ]);