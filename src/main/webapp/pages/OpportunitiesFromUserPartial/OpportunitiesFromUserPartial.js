Application.$controller("OpportunitiesFromUserPartialPageController", ["$scope", function($scope) {
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


    $scope.CrmOpportunitiesDataonSuccess = function(variable, data, options) {
        var suma = 0;
        console.log(data);
        for (var i = 0; i < data.length; i++) {
            console.log("bidamount:", data[i].valueBidamount, " bid amt without commas: ", data[i].valueBidamount.replace(/,/g, ''));
            suma += parseInt(data[i].valueBidamount.replace(/,/g, ''));
            console.log("bid amount parsed to int: ", parseInt(data[i].valueBidamount.replace(",", "")));
        }
        $scope.Widgets.lbltotal.caption = suma.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
    };

}]);


Application.$controller("OpportunitiesTable1Controller", ["$scope",
    function($scope) {
        "use strict";
        $scope.ctrlScope = $scope;
    }
]);