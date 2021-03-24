
console.log("123123123123");
var button = document.querySelector('.submit-btn-area');
//var loginInput = document.querySelector('#exampleInputEmail1');
//var passwordInput = document.querySelector('#exampleInputPassword1');

button.addEventListener('click', signIn);

function signIn() {
    let login =  document.querySelector('#exampleInputEmail1');
    let password = document.querySelector('#exampleInputPassword1');

    let xhr = new XMLHttpRequest();
    let url = "http://localhost:8080/api/v1/auth/login";
    xhr.open("POST", url, true);
    xhr.setRequestHeader("Content-Type", "application/json");
    xhr.setRequestHeader("Access-Control-Allow-Origin", "*");
    xhr.setRequestHeader("Access-Control-Allow-Methods", "GET, PUT, POST, DELETE, OPTIONS");
    xhr.setRequestHeader("Access-Control-Allow-Headers", "DNT,X-CustomHeader,Keep-Alive,User-Agent,X-Requested-With,If-Modified-Since,Cache-Control,Content-Type,Content-Range,Range")

    xhr.onreadystatechange = function () {
        if (xhr.status === 200) {
            let json = JSON.parse(xhr.responseText);
            console.log(json)
            //var stocks;
            //stocks = JSON.parse(xhr.responseText)
            sessionStorage.setItem("user_id", json.id);
            sessionStorage.setItem("username", json.username);
            console.log("saved ->" + sessionStorage.getItem("user_id") + " " + sessionStorage.getItem("id"))
            // personal()
        }
    };
    console.log(login.value + "   " +password.value);

    let data = JSON.stringify({"username": login.value, "password": password.value});
    console.log(data);
    xhr.send(data);
    console.log("end");
}

