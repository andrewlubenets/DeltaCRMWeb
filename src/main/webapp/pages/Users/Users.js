Application.$controller("UsersPageController", ["$scope", function($scope) {
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


Application.$controller("UsersTable1Controller", ["$scope",
    function($scope) {
        "use strict";
        $scope.ctrlScope = $scope;
    }
]);

Application.$controller("UsersLiveForm1Controller", ["$scope",
    function($scope) {
        "use strict";
        $scope.ctrlScope = $scope;
    }
]);

Application.$controller("dialog1Controller", ["$scope",
    function($scope) {
        "use strict";
        $scope.ctrlScope = $scope;

        $scope.button4Click = function($event, $isolateScope) {
            console.log("userinfo: ", $scope.Variables.finduserinfo);
            if ($scope.Variables.finduserinfo.dataSet.content.length > 0) {
                $scope.Variables.CmrEditUserinfo.update();
            } else {
                $scope.Variables.createuserinfo.update();
            }
        };

    }
]);