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
        //console.log($scope.Variables.findStages.dataSet.content.length);
        var names = $scope.Variables.findPipelines.dataSet.content[0].name;
        for (var i = 1; i < $scope.Variables.findPipelines.dataSet.content.length; i++) {
            names += "," + $scope.Variables.findPipelines.dataSet.content[i].name;
        }
        console.log(names);
        $data.pipesize = $scope.Variables.findPipelines.dataSet.content.length;
        $data.pipenames = names;

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


    $scope.OpportunitiesLiveForm1Success = function($event, $operation, $data) {
        console.log($operation, $data, "pipelinestatus");
        if ($data.opportunityStates.name == "WON") {
            $scope.Variables.createProjectIfWon.update();
        }
    };





    $scope.findPipelinesonSuccess = function(variable, data, options) {
        console.log("find pipelines: ", data);
    };


    $scope.productfromuseridonSuccess = function(variable, data, options) {
        if (data.content[0].product !== null) {
            $scope.Variables.productavailable.dataSet = [{
                "dataValue": data.content[0].product
            }];
        } else {
            $scope.Variables.productavailable.dataSet = [{
                "dataValue": "DeltaApp"
            }, {
                "dataValue": "Hardware-Software"
            }];
        }
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


        $scope.valueBidamountKeyup = function($event, $isolateScope) {

        };


        $scope.valueBidamountChange = function($event, $isolateScope, newVal, oldVal) {
            try {
                $scope.Widgets.valueBidamount.datavalue = $scope.Widgets.valueBidamount.datavalue.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
            } catch (e) {
                console.log(e.message, $scope.Widgets.valueBidamount);
            }
        };

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

            try {
                if ($operation == "insert") {
                    $data.createdby = $scope.Variables.loggedInUser.getData().id;
                    $data.dateCreation = moment().format("YYYY-MM-DD HH:mm:ss");
                }

            } catch (e) {}

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

Application.$controller("dialog2Controller", ["$scope",
    function($scope) {
        "use strict";
        $scope.ctrlScope = $scope;

        $scope.TasksLiveForm1Beforeservicecall = function($event, $operation, $data, options) {
            $data.relatedtoid = $scope.Widgets.OpportunitiesTable1.selectedItems[0].id;
            $data.relatedtotype = "(Opportunity)";
            $data.relatedto = $scope.Widgets.OpportunitiesTable1.selectedItems[0].name;

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