let firstName = document.getElementById('firstName');
let lastName = document.getElementById('lastName');
let email = document.getElementById('email');
let phone = document.getElementById('phone');
let actionbutton = document.getElementById('action-button'); 
let msform = document.getElementById('msform');

function checkFristName(){
    let name = " ";
    name = firstName.value;
    if(name.length < 3){
        firstName.style.border = "2px red solid";
        return false;
    }else{
        firstName.style.border = "none";
        return true;
    }
}
function checkLastName(){
    let name = " ";
    name = lastName.value;
    if(name.length < 3){
        lastName.style.border = "2px red solid";
        return false;
    }else{
        lastName.style.border = "none";
        return true;
    }
}
function checkEmail(){
    let mail = " ";
    mail = email.value;
    if(mail.includes('@') && mail.includes('.')){
        email.style.border = "none";
        return true;
    }else{
        email.style.border = "2px red solid";
        return false;
    }
}
function checkPhone(){
    let numb = " ";
    numb = phone.value;
    
    if(numb.length > 10){
        phone.style.border = "none";
        return true;
    }else{
        phone.style.border = "2px red solid";
        return false;
    }
}

phone.addEventListener('change', () => {
    checkPhone();
})
email.addEventListener('change', () => {
    checkEmail();
})
lastName.addEventListener('change', () => {
    checkLastName();
})
firstName.addEventListener('change', () => {
    checkFristName();
})
actionbutton.addEventListener('click', () => {
    if(checkFristName() & checkLastName() & checkEmail() & checkPhone()){
        localStorage['firstName'] = firstName.value;
        localStorage['lastName'] = lastName.value;
        localStorage['email'] = email.value;
        localStorage['phonenumb'] = phone.value;
        msform.innerHTML = "<h1>Thank you for registration</h1>";
    }
})