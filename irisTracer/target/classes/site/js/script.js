let BASE_URL = "http://localhost:8080/api/Tracer";

class Data {
    constructor() {
        this.percurso = document.getElementById("percurso").value;
        this.diaCorrido = document.getElementById("diaCorrido").value;
    }
}

function alerta() {
    location.reload();
}

function onSubmitCreate() {
    let dat = new Data();
        createTracer(dat, alerta);
}

function onSubmitUpdate(){
    let dat = new Data();
        updateTracer(dat, alerta);
}

function onSubmitDelete(){
    let dat = new Data();
        deleteTracer(document.getElementById("id").value, alerta)
}


function getJSON(url, callback) {
    var xhr = new XMLHttpRequest();
    xhr.open('GET', url, true);
    xhr.responseType = 'json';
    xhr.onload = function () {
        var status = xhr.status;
        if (status === 200) {
            console.log('DEU BOM!');
        } else {
            console.log('DEU RUIM!' + status);
        }
        callback(status, xhr.response);
    }
    xhr.send();
}

function deleteTracer(id, callback) {
    let deleteURL = BASE_URL;
    var dat = new Data();
    var xhr = new XMLHttpRequest();
    xhr.open('DELETE', deleteURL, true);
    xhr.responseType = 'json';
    xhr.setRequestHeader('Content-Type', 'application/json');
    xhr.onload = function () {
        var status = xhr.status;
        if (status === 200) {
            console.log('DEU BOM!');
            callback(status, xhr.response);
        } else {
            console.log('DEU RUIM!' + status);
        }
    }
    xhr.send(JSON.stringify(dat));
}

function updateTracer(tracer, callback) {
    let deleteURL = BASE_URL;

    var xhr = new XMLHttpRequest();
    xhr.open('PUT', deleteURL, true);
    xhr.responseType = 'json';
    xhr.setRequestHeader('Content-Type', 'application/json');
    xhr.onload = function () {
        var status = xhr.status;
        if (status === 200) {
            console.log('DEU BOM!');
            callback(status, xhr.response);
        } else {
            console.log('DEU RUIM!' + status);
        }
    }
    xhr.send(JSON.stringify(tracer));
}

function createTracer(tracer, callback) {
    let deleteURL = BASE_URL;

    var xhr = new XMLHttpRequest();
    xhr.open('POST', deleteURL, true);
    xhr.responseType = 'json';
    xhr.setRequestHeader('Content-Type', 'application/json');
    xhr.onload = function () {
        var status = xhr.status;
        if (status === 200) {
            console.log('DEU BOM!');
            callback(status, xhr.response);
        } else {
            console.log('DEU RUIM!' + status);
        }
    }
    xhr.send(JSON.stringify(tracer));
}