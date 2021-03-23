
console.log("123123123123");
var button = document.querySelector('.submit-btn-area');
//var loginInput = document.querySelector('#exampleInputEmail1');
//var passwordInput = document.querySelector('#exampleInputPassword1');

button.addEventListener('click', signIn);

function signIn() {
    let login =  document.querySelector('#exampleInputEmail1');
    let password = document.querySelector('#exampleInputPassword1');

    let xhr = new XMLHttpRequest();
    let url = URL + "auth/login";
    xhr.open("POST", url, true);
    xhr.setRequestHeader("Content-Type", "application/json");
    // xhr.onreadystatechange = function () {
    //     if (xhr.readyState === 4 && xhr.status === 200) {
    //         let json = JSON.parse(xhr.responseText);
    //         sessionStorage.setItem("token", json.token);
    //         sessionStorage.setItem("first_name", json.user.firstName);
    //         sessionStorage.setItem("last_name", json.user.lastName);
    //         personal()
    //     }
    // };
    console.log(login.value + password.value);

    let data = JSON.stringify({"username": login.value, "password": password.value});
    xhr.send(data);
}

