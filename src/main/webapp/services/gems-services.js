'use strict';
angular.module('gemsApp.services', []).
value('version', '0.1')
.factory('rtmFactory', function() {
    var countries = [
    {name: 'USA',code: 'us'}, 
    {name: 'UK',code: 'uk'}, 
    {name: 'France',code: 'fr'}
    ];
    return {
        getCountries: function() {
            return countries;
        }
    }
});
