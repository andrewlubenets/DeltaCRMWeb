Application.$controller("OpportunitiesPageController", ["$scope", function($scope) {
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





    $scope.OpportunitiesLiveForm1Beforeservicecall = function($event, $operation, $data, options) {
        console.log($scope.Variables.findStages.dataSet.content.length);
        var names = $scope.Variables.findStages.dataSet.content[0].name;
        for (var i = 1; i < $scope.Variables.findStages.dataSet.content.length; i++) {
            names += "," + $scope.Variables.findStages.dataSet.content[i].name;
        }
        console.log(names);
        $data.pipesize = $scope.Variables.findStages.dataSet.content.length;
        $data.pipenames = names;
    };

}]);


Application.$controller("OpportunitiesTable1Controller", ["$scope",
    function($scope) {
        "use strict";
        $scope.ctrlScope = $scope;
    }
]);

Application.$controller("OpportunitiesLiveForm1Controller", ["$scope",
    function($scope) {
        "use strict";
        $scope.ctrlScope = $scope;
    }
]);

Application.$controller("dialog1Controller", ["$scope",
    function($scope) {
        "use strict";
        $scope.ctrlScope = $scope;

        $scope.FilesOpportunitiesLiveForm1Beforeservicecall = function($event, $operation, $data, options) {
            console.log($scope.Widgets.fileupload1.fileTransfers[0]);
            $data.name = $scope.Widgets.fileupload1.fileTransfers[0].name;
            $data.size = $scope.Widgets.fileupload1.fileTransfers[0].size;
            $data.opportunitiesid = $scope.Widgets.OpportunitiesTable1.selectedItems[0].id;

        };

    }
]);

Application.$controller("FilesOpportunitiesTable1Controller", ["$scope",
    function($scope) {
        "use strict";
        $scope.ctrlScope = $scope;
    }
]);

Application.$controller("FilesOpportunitiesLiveForm1Controller", ["$scope",
    function($scope) {
        "use strict";
        $scope.ctrlScope = $scope;

        $scope.fileupload1Success = function($event, $isolateScope) {

        };

    }
]);