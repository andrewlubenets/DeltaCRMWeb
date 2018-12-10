Application.$controller("OpportunityDashboardPageController", ["$scope", function($scope) {
    "use strict";

    /* perform any action on widgets within this block */
    $scope.onPageReady = function() {
        /*
         * widgets can be accessed through '$scope.Widgets' property here
         * e.g. to get value of text widget named 'username' use following script
         * '$scope.Widgets.username.datavalue'
         */


    };


    $scope.totalsumoppoonSuccess = function(variable, data, options) {
        // console.log(data);
        $scope.Widgets.lblTotSumOpp.caption = data.content[0].totsum.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
    };


    $scope.totcommitonSuccess = function(variable, data, options) {
        $scope.Widgets.lblTotCommit.caption = data.content[0].totcommit.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
    };


    $scope.totSumUpsideonSuccess = function(variable, data, options) {
        $scope.Widgets.lblTotUpside.caption = data.content[0].totupside.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
    };


    $scope.totaldeltaonSuccess = function(variable, data, options) {
        $scope.Widgets.lblTotDelta.caption = data.content[0].totdelta.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
    };

}]);


Application.$controller("grid2Controller", ["$scope",
    function($scope) {
        "use strict";
        $scope.ctrlScope = $scope;
    }
]);


Application.$controller("executeTop5usersMoreOppoTable1Controller", ["$scope",
    function($scope) {
        "use strict";
        $scope.ctrlScope = $scope;
    }
]);

Application.$controller("executeTop5valopposTable1Controller", ["$scope",
    function($scope) {
        "use strict";
        $scope.ctrlScope = $scope;
    }
]);

Application.$controller("executeWonvstargetTable1Controller", ["$scope",
	function($scope) {
		"use strict";
		$scope.ctrlScope = $scope;
	}
]);