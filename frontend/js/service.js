
hadesApp.service("Facturas_service", function($http) {
    this.getAllFacturas = function() {
      return $http.get(URL_API+"/facturas").
        then(function(response) {
            return response;
        }, function(response) {
            console.log("Error get AllFacturas: "+JSON.stringify(response));
            return response;
        });
    }
    this.getFactura = function(id) {
      return $http.get(URL_API+"/facturas/"+id).
        then(function(response) {
            return response;
        }, function(response) {
            console.log("Error get Factura "+id+": "+JSON.stringify(response));
            return response;
        });
    }
    this.createFactura = function(newFactura) {
            return $http.post(URL_API+"/facturas", newFactura).
                then(function(response) {
                    return response;
                }, function(response) {
                    console.log("Error creating new Factura: "+JSON.stringify(response));
                    return response;
                });
    }
    this.editFactura = function(newFactura,id) {
            return $http.put(URL_API+"/facturas/"+id, newFactura).
                then(function(response) {
                    return response;
                }, function(response) {
                    console.log("Error edit Factura "+id+": "+JSON.stringify(response));
                    return response;
                });
    }
});


hadesApp.service("Clientes_service", function($http) {
    this.getAllClientes = function() {
      return $http.get(URL_API+"/clientes").
        then(function(response) {
            return response;
        }, function(response) {
            console.log("Error get AllClientes: "+JSON.stringify(response));
            return response;
        });
    }
    this.getCliente = function(id) {
      return $http.get(URL_API+"/clientes/"+id).
        then(function(response) {
            return response;
        }, function(response) {
            console.log("Error get Clientes "+id+": "+JSON.stringify(response));
            return response;
        });
    }
    this.createCliente = function(newCliente) {
            return $http.post(URL_API+"/clientes", newCliente).
                then(function(response) {
                    return response;
                }, function(response) {
                    console.log("Error creating new Cliente: "+JSON.stringify(response));
                    return response;
                });
    }
    this.editCliente = function(newCliente,id) {
            return $http.put(URL_API+"/clientes/"+id, newCliente).
                then(function(response) {
                    return response;
                }, function(response) {
                    console.log("Error edit Cliente "+id+": "+JSON.stringify(response));
                    return response;
                });
    }
});

hadesApp.service("OT_service", function($http) {
    this.getAllOT = function() {
      return $http.get(URL_API+"/ordentrabajos").
        then(function(response) {
            return response;
        }, function(response) {
            console.log("Error get AllOT: "+JSON.stringify(response));
            return response;
        });
    }
    this.getOT = function(id) {
      return $http.get(URL_API+"/ordentrabajos/"+id).
        then(function(response) {
            return response;
        }, function(response) {
            console.log("Error get OT "+id+": "+JSON.stringify(response));
            return response;
        });
    }
    this.createOT = function(newOT) {
            return $http.post(URL_API+"/ordentrabajos", newOT).
                then(function(response) {
                    return response;
                }, function(response) {
                    console.log("Error creating new OT: "+JSON.stringify(response));
                    return response;
                });
    }
    this.editOT = function(newOT,id) {
            return $http.put(URL_API+"/ordentrabajos/"+id, newOT).
                then(function(response) {
                    return response;
                }, function(response) {
                    console.log("Error edit OT "+id+": "+JSON.stringify(response));
                    return response;
                });
    }
});