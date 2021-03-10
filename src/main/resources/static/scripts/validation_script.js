let validateName = () => {
    let fullName = document.getElementById('fullName');
    let name_div = document.getElementById('name_div');
    let name_error1 = document.getElementById('name_error1');
    let name_error2 = document.getElementById('name_error2');

    let nameRegex = /^[A-Za-z\s]+$/;
    if (nameRegex.test(fullName.value)) {
        if (fullName.value.length >= 5) {
            name_error1.style.display = 'none';
            name_error2.style.display = 'none';
            name_div.className = 'five wide field';
        } else {
            name_error1.style.display = 'none';
            name_error2.style.display = 'block';
            name_div.className = 'five wide field error';
        }
    } else {
        name_error1.style.display = 'block';
        name_error2.style.display = 'none';
        name_div.className = 'five wide field error';
    }
}

let validatePhone = () => {
    let phone = document.getElementById('phone');
    let phone_div = document.getElementById('phone_div');
    let phone_error1 = document.getElementById('phone_error1');
    let phone_error2 = document.getElementById('phone_error2');

    let phoneRegex = /^[0-9+]+$/;

    if (phoneRegex.test(phone.value)) {
        if (phone.value.length >= 11 && phone.value.length <= 18) {
            phone_error1.style.display = 'none';
            phone_error2.style.display = 'none';
            phone_div.className = 'three wide field';
        } else {
            phone_error1.style.display = 'none';
            phone_error2.style.display = 'block';
            phone_div.className = 'three wide field error';
        }
    } else {
        phone_error1.style.display = 'block';
        phone_error2.style.display = 'none';
        phone_div.className = 'three wide field error';
    }
}

let validateEmail = () => {
    let email = document.getElementById('email');
    let email_div = document.getElementById('email_div');
    let email_error = document.getElementById('email_error');

    let emailRegex = /^[\w-.]+@([\w-]+\.)+[\w-]{2,4}$/;
    if (emailRegex.test(email.value)) {
        email_error.style.display = 'none';
        email_div.className = 'five wide field';
    } else {
        email_error.style.display = 'block';
        email_div.className = 'five wide field error';
    }
}

let validateAddress = () => {
    let address = document.getElementById('address');
    let address_div = document.getElementById('address_div');
    let address_error = document.getElementById('address_error');

    if (address.value.length >= 5) {
        address_error.style.display = 'none';
        address_div.className = 'six wide field';
    } else {
        address_error.style.display = 'block';
        address_div.className = 'six wide field error';
    }
}