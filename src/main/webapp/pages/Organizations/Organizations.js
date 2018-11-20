Application.$controller("OrganizationsPageController", ["$scope", function($scope) {
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


    $scope.OrganizationsLiveForm1Beforeservicecall = function($event, $operation, $data, options) {
        try {
            if ($operation == "insert") {
                $data.createdby = $scope.Variables.loggedInUser.getData().id;
                $data.dateCreation = moment().format("YYYY-MM-DD HH:mm:ss");
            }
            if ($operation == "update") {
                $data.modifyby = $scope.Variables.loggedInUser.getData().id;
                $data.dateModification = moment().format("YYYY-MM-DD HH:mm:ss");
            }
        } catch (e) {}
    };

}]);


Application.$controller("OrganizationsTable1Controller", ["$scope",
    function($scope) {
        "use strict";
        $scope.ctrlScope = $scope;
    }
]);

Application.$controller("OrganizationsLiveForm1Controller", ["$scope",
    function($scope) {
        "use strict";
        $scope.ctrlScope = $scope;
    }
]);