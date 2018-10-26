Application.$controller("PipelinesPageController", ["$scope", function($scope) {
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

}]);


Application.$controller("PipelinesTable1Controller", ["$scope",
    function($scope) {
        "use strict";
        $scope.ctrlScope = $scope;
    }
]);

Application.$controller("PipelinesLiveForm1Controller", ["$scope",
    function($scope) {
        "use strict";
        $scope.ctrlScope = $scope;
    }
]);

Application.$controller("dialog1Controller", ["$scope",
    function($scope) {
        "use strict";
        $scope.ctrlScope = $scope;

        $scope.StagesLiveForm1Beforeservicecall = function($event, $operation, $data, options) {
            console.log($scope.Widgets.PipelinesTable1.selectedItems[0].id, $scope.Widgets.PipelinesTable1);
            $data.pipelineid = $scope.Widgets.PipelinesTable1.selectedItems[0].id;
            //$data.productid = $scope.Widgets.getShirtOrdersTable1.selectedItems[0].productid;

        };

    }
]);

Application.$controller("StagesTable1Controller", ["$scope",
    function($scope) {
        "use strict";
        $scope.ctrlScope = $scope;
    }
]);

Application.$controller("StagesLiveForm1Controller", ["$scope",
    function($scope) {
        "use strict";
        $scope.ctrlScope = $scope;
    }
]);