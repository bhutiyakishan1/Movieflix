/**
 * Created by Kishan on 10/2/2016.
 */
(function () {
    'use strict';

    angular
        .module('movieflix')
        .directive('compareTo', compareTo);

    function compareTo() {
        var directive = {
            require: "ngModel",
            scope: {
                otherModelValue: "=compareTo"
            },
            link: function (scope, element, attributes, ngModel) {

                ngModel.$validators.compareTo = function (modelValue) {
                    return modelValue == scope.otherModelValue;
                };

                scope.$watch("otherModelValue", function () {
                    ngModel.$validate();
                });
            }
        };

        return directive;
    }


})();
