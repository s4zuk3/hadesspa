// CRUD FACTURA
hadesApp.service("Facturas_service", function($http) {
    this.getAllFacturas = function() {
      return $http.get(URL_API+"/facturas").
        then(function(response) {
            return response;
        }, function(response) {
            console.log("Error get AllFacturas: "+response);
        });
    }
    this.getFactura = function(id) {
      return $http.get(URL_API+"/facturas/"+id).
        then(function(response) {
            return response;
        }, function(response) {
            console.log("Error get Factura "+id+": "+response);
        });
    }
    this.createFactura = function(newFactura) {
            return $http.post(URL_API+"/facturas", newFactura).
                then(function(response) {
                    return response;
                }, function(response) {
                    console.log("Error creating new Factura: "+response);
                });
    }
    this.deleteFactura = function(id) {
            var url = "/bosses/" + bossId;
            return $http.delete(URL_API+"/facturas/"+id).
                then(function(response) {
                    return response;
                }, function(response) {
                     console.log("Error delete Factura "+id+": "+response);
                });
        }
    this.editFactura = function(newFactura,id) {
            return $http.put(URL_API+"/facturas/"+id, newFactura).
                then(function(response) {
                    return response;
                }, function(response) {
                    console.log("Error edit Factura "+id+": "+response);
                });
    }
});