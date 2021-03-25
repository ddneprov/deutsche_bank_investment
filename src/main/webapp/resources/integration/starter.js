var name = document.querySelector('.user-name');

starter()

function starter(){
    console.log(name)
    //common(name)
}

function common() {
    let userName = document.getElementsByClassName("user-name");
    let firstName = sessionStorage.getItem("username");
    userName[0].innerText = firstName;
}

