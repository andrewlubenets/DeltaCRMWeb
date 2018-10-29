Application.$controller("TaskPageController", ["$scope", function($scope) {
    "use strict";

    /* perform any action on widgets/variables within this block */
    $scope.onPageReady = function() {
        /*
         * variables can be accessed through '$scope.Variables' property here
         * e.g. to get dataSet in a staticVariable named 'loggedInUser' use following script
         * $scope.Variables.loggedInUser.getData()
         *
         * widgets can be accessed through '$scope.Widgets' property here
         * e.g. to get value of text widget named 'username' use following script
         * '$scope.Widgets.username.datavalue'
         */
    };


    $scope.TasksLiveForm1Beforeservicecall = function($event, $operation, $data, options) {
        $data.relatedtoid = $scope.Widgets.table2.selectedItems[0].id;
        $data.relatedto = $scope.Widgets.table2.selectedItems[0].name;
        $data.relatedtotype = $scope.Widgets.table2.selectedItems[0].typerelation;
    };

}]);


Application.$controller("TasksTable1Controller", ["$scope",
    function($scope) {
        "use strict";
        $scope.ctrlScope = $scope;
    }
]);

Application.$controller("TasksLiveForm1Controller", ["$scope",
    function($scope) {
        "use strict";
        $scope.ctrlScope = $scope;

        $scope.relatedtoChange = function($event, $isolateScope, newVal, oldVal) {
            $scope.Widgets.table2.show = true;
        };

    }
]);

Application.$controller("table2Controller", ["$scope",
    function($scope) {
        "use strict";
        $scope.ctrlScope = $scope;
    }
]);