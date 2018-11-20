Application.$controller("ProjectsPageController", ["$scope", function($scope) {
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


    $scope.ProjectsLiveForm1Beforeservicecall = function($event, $operation, $data, options) {
        try {

            if ($operation == "insert") {
                $data.createdby = $scope.Variables.loggedInUser.getData().id;
                $data.dateCreation = moment().format("YYYY-MM-DD HH:mm:ss");
            }
            if ($operation == "update") {
                $data.modifyby = $scope.Variables.loggedInUser.getData().id;
                $data.dateModification = moment().format("YYYY-MM-DD HH:mm:ss");
            }
        } catch (e) {
            console.log(e.message);
        }
    };

}]);


Application.$controller("ProjectsTable1Controller", ["$scope",
    function($scope) {
        "use strict";
        $scope.ctrlScope = $scope;
    }
]);

Application.$controller("ProjectsLiveForm1Controller", ["$scope",
    function($scope) {
        "use strict";
        $scope.ctrlScope = $scope;
    }
]);

Application.$controller("dialog1Controller", ["$scope",
    function($scope) {
        "use strict";
        $scope.ctrlScope = $scope;

        $scope.TasksLiveForm1Beforeservicecall = function($event, $operation, $data, options) {
            try {
                $data.relatedtoid = $scope.Widgets.ProjectsTable1.selectedItems[0].id;
                $data.relatedtotype = "(Project)";
                $data.relatedto = $scope.Widgets.ProjectsTable1.selectedItems[0].name;
            } catch (e) {}

            try {

                if ($operation == "insert") {
                    $data.createdby = $scope.Variables.loggedInUser.getData().id;
                    $data.dateCreation = moment().format("YYYY-MM-DD HH:mm:ss");
                }
                if ($operation == "update") {
                    $data.modifyby = $scope.Variables.loggedInUser.getData().id;
                    $data.dateModification = moment().format("YYYY-MM-DD HH:mm:ss");
                }
            } catch (e1) {
                console.log(e1.message);
            }

        };

    }
]);

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
    }
]);

Application.$controller("dialog2Controller", ["$scope",
    function($scope) {
        "use strict";
        $scope.ctrlScope = $scope;

        $scope.FilesProjectsLiveForm1Beforeservicecall = function($event, $operation, $data, options) {

            $data.projectid = $scope.Widgets.ProjectsTable1.selectedItems[0].id;
            $data.name = $scope.Widgets.fileupload1.fileTransfers[0].name;
            $data.size = $scope.Widgets.fileupload1.fileTransfers[0].size;
            try {



                if ($operation == "insert") {
                    $data.createdby = $scope.Variables.loggedInUser.getData().id;
                    $data.dateCreation = moment().format("YYYY-MM-DD HH:mm:ss");
                }
            } catch (e) {}

        };

    }
]);

Application.$controller("FilesProjectsTable1Controller", ["$scope",
    function($scope) {
        "use strict";
        $scope.ctrlScope = $scope;
    }
]);

Application.$controller("FilesProjectsLiveForm1Controller", ["$scope",
    function($scope) {
        "use strict";
        $scope.ctrlScope = $scope;
    }
]);