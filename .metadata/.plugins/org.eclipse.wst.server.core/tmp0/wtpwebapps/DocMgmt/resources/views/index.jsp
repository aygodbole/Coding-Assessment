<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Document Management</title>
</head>
<body ng-app ="DocManagerApp">
<div ng-controller = "DocCtrl">
<h1>{{msg}} </h1>
<table>
<tr>
<td>UsersName:</td>
<td><input type= "text" id="userName" ng-model="userName"></td>
</tr>

<tr>
<td>Dcoument Id:</td>
<td><input type= "text" id="docId" ng-model="docId"></td>
</tr>

<tr>
<td>FileUpload :</td>
<td><input id="fileAttUpload" type="file" file-model = "myFile"></td>
</tr>
</table>

<button ng-click = "saveAttachments();">upload</button>
</div>


<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
 <script type="text/javascript" src='<%=request.getContextPath()%>/resources/js/jquery.min.js'></script>
<script type="text/javascript" src='<%=request.getContextPath() %>/resources/js/angular.min.js'></script>
<script type="text/javascript" src='<%=request.getContextPath() %>/resources/js/angular-route.min.js'></script>
<script type="text/javascript" src='<%=request.getContextPath() %>/resources/js/angular-resource.min.js'></script>
<script type="text/javascript" src='<%=request.getContextPath() %>/resources/js/app.js'></script>
<!-- <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular.js'></script>-->
</body>
</html>