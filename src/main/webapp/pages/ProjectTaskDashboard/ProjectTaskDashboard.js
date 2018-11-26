Application.$controller("ProjectTaskDashboardPageController", ["$scope", function($scope) {
    "use strict";

    /* perform any action on widgets within this block */
    $scope.onPageReady = function() {
        /*
         * widgets can be accessed through '$scope.Widgets' property here
         * e.g. to get value of text widget named 'username' use following script
         * '$scope.Widgets.username.datavalue'
         */
    };


    $scope.projectscountuserbyproductonSuccess = function(variable, data, options) {
        //console.log(data);
        $scope.Widgets.projectqtylbl1.caption = data.content[0].categoryname + ": " + data.content[0].firstname + " " + data.content[0].lastname;
        $scope.Widgets.projectqtylbl11.caption = data.content[0].totprojects;
        $scope.Widgets.projectqtylbl2.caption = data.content[1].categoryname + ": " + data.content[1].firstname + " " + data.content[1].lastname;
        $scope.Widgets.projectqtylbl22.caption = data.content[1].totprojects;
        $scope.Widgets.projectqtylbl3.caption = data.content[2].categoryname + ": " + data.content[2].firstname + " " + data.content[2].lastname;
        $scope.Widgets.projectqtylbl33.caption = data.content[2].totprojects;
        $scope.Widgets.projectqtylbl4.caption = data.content[3].categoryname + ": " + data.content[3].firstname + " " + data.content[3].lastname;
        $scope.Widgets.projectqtylbl44.caption = data.content[3].totprojects;
        $scope.Widgets.projectqtylbl5.caption = data.content[4].categoryname + ": " + data.content[4].firstname + " " + data.content[4].lastname;
        $scope.Widgets.projectqtylbl55.caption = data.content[4].totprojects;
        $scope.Widgets.projectqtylbl6.caption = data.content[5].categoryname + ": " + data.content[5].firstname + " " + data.content[5].lastname;
        $scope.Widgets.projectqtylbl66.caption = data.content[5].totprojects;

    };

}]);




Application.$controller("CategoriesTable1Controller", ["$scope",
    function($scope) {
        "use strict";
        $scope.ctrlScope = $scope;
    }
]);

Application.$controller("TasksTable1Controller", ["$scope",
	function($scope) {
		"use strict";
		$scope.ctrlScope = $scope;
	}
]);